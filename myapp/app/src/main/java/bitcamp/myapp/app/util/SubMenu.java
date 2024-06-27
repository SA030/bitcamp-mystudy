package bitcamp.myapp.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import bitcamp.myapp.app.submenu.BoardMenu;
import bitcamp.myapp.app.submenu.ProjectMenu;
import bitcamp.myapp.app.submenu.TeamMenu;
import bitcamp.myapp.app.submenu.UserMenu;
import bitcamp.myapp.app.vo.Board;
import bitcamp.myapp.app.vo.Project;
import bitcamp.myapp.app.vo.Team;
import bitcamp.myapp.app.vo.User;

public class SubMenu {



  // protected ArrayList<Object> list = new ArrayList<Object>();
  /********************************************************/

  protected static final int USER = 1;
  protected static final int TEAM = 2;
  protected static final int PROJECT = 3;
  protected static final int BOARD = 4;

  /********************************************************/

  // Member contents ////////////////////////////////////
  private boolean isValidateMenu(int objNo) {
    return objNo == TEAM || objNo == PROJECT ? true : false;
  }


  // Format /////////////////////////////////////////////
  protected class Format {

    private int numWidth, titleWidth;

    public Format(int numWidth, int titleWidth) {
      this.numWidth = numWidth;
      this.titleWidth = titleWidth;
    }


    public int getNumWidth() {
      return this.numWidth;
    }

    public int getTitleWidth() {
      return this.titleWidth;
    }
  }


  // List /////////////////////////////////////////////
  protected class List {
    private int priKey;
    private Object obj;
    private ArrayList<Object> list = new ArrayList<Object>();

    public List(int priKey, Object obj) {
      this.priKey = priKey;
      this.obj = obj;
    }

    public int getPriKey() {
      return priKey;
    }

    public Object getObj() {
      return obj;
    }

    public ArrayList<Object> getList() {
      return list;
    }


  }

  ///////////////////////////////////////////////////////////
  ///////////////////////// Scanner /////////////////////////
  ///////////////////////////////////////////////////////////
  public String Scanner() {
    Scanner sc = new Scanner(System.in);

    String ans = sc.nextLine();

    return ans;
  }



  ///////////////////////////////////////////////////////////
  /////////////////////// Title form ////////////////////////
  ///////////////////////////////////////////////////////////
  // Title 간격 조정
  private String formString(int width, String text) {
    return String.format("%-" + width + "s", text);
  }// Method formString END

  @SuppressWarnings("unused")
  private String formString(int width, int text) {
    return String.format("%-" + width + "d", text);
  }// Method formString END



  ///////////////////////////////////////////////////////////
  ////////////////////////// Menu ///////////////////////////
  ///////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. ADD //////////////////////////
  ///////////////////////////////////////////////////////////

  // Add Object /////////////////////////////////////////////
  protected int addObject(int objNo, Object obj, ArrayList<?> objList) {
    return addObject(objNo, obj, objList, 0);
  }

  protected int addObject(int objNo, Object obj, ArrayList<?> objList, int start) {
    Title title = Title.getInstance(objNo);

    return addObject(objNo, obj, objList, start, title.getTitleArrSize() - 1);
  }

  protected int addObject(int objNo, Object obj, ArrayList<?> objList, int start, int end) {
    Title title = Title.getInstance(objNo);
    int newSeqNo = objList.size() + 1;

    for (int itemNo = start; itemNo < end + 1; itemNo++) {
      System.out.printf("%s? ", title.getTitleString(itemNo));
      setItem(objNo, obj, itemNo, Scanner());
      setSeqNo(objNo, obj, newSeqNo);
    }
    return newSeqNo;
  }// Method addObject END //////////////////////////////////



  // Add Object's User ///////////////////////////////////
  // New Object's User
  protected void addMember(int objNo, Object obj) {
    // 멤버 등록
    for (;;) {
      if (getUserSeqNo().equals("0")) {
        return;
      }
      isValidateMember(objNo, indexOf(objNo, obj), Scanner());
    }
  }

  // Old Object's User
  protected void addMember(int objNo, int seqNo) {
    String ans = "";

    // 멤버 등록
    for (;;) {
      ans = getUserSeqNo();
      if (ans.equals("0")) {
        return;
      }
      isValidateMember(objNo, seqNo, ans);
    }
  }// Method addUser END ////////////////////////////////////


  // 팀원 번호 입력
  private String getUserSeqNo() {
    System.out.printf("추가할 팀원 번호?(종료: 0) ");
    return Scanner();
  }

  // 유효한 멤버 등록
  private void isValidateMember(int objNo, int seqNo, String ans) {
    UserMenu userMenu = UserMenu.getInstance();
    int userNo = Integer.parseInt(ans);

    if (checkObject(USER, userMenu.getUserList(), userNo)) {
      addMember(objNo, seqNo, userNo, getObject(USER, userNo));
    }
  }

  // 멤버 추가
  private void addMember(int objNo, int seqNo, int userNo, Object user) {
    if (!isDuplicateMember(objNo, seqNo, userNo)) {
      setMembers(objNo, seqNo, userNo, (User) user);
    }
    System.out.printf(printAddMember(objNo, seqNo, userNo, ((User) user).getName()));
  }

  // 멤버 추가/중복 메세지 출력
  private String printAddMember(int objNo, int seqNo, int userNo, String userName) {
    return !isDuplicateMember(objNo, seqNo, userNo) ? //
        String.format("'%s'을 추가했습니다.\n", userName) : // true: 신규
        String.format("'%s'은 현재 팀원입니다.\n", userName); // false: 중복
  }

  // 멤버 중복 확인
  private boolean isDuplicateMember(int objNo, int seqNo, int userNo) {
    return getMembers(objNo, seqNo).containsKey(userNo) ? true : false;
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. List /////////////////////////
  ///////////////////////////////////////////////////////////

  protected void printList(int objNo, Object obj, ArrayList<?> objList, Format form) {

    String str = "";
    str += printTitle(objNo, obj, form);
    str += printInfo(objNo, obj, objList, form);

    System.out.print(str);

  }// Method printList END


  // Print Title
  private String printTitle(int objNo, Object obj, Format form) {
    return printPublicTitle(getPublicTitle(objNo, obj), form);
  }// Method printTitle END

  // Print Public Title
  private String printPublicTitle(ArrayList<String> publicTitle, Format form) {
    String str = "";

    for (int titleNo = 0; titleNo < publicTitle.size(); titleNo++) {
      if (titleNo == 0) {
        str += formString(form.getNumWidth(), publicTitle.get(titleNo));
        continue;
      }
      str += formString(form.getTitleWidth(), publicTitle.get(titleNo));
    }
    str += String.format("\n");

    return str;
  }


  // Print Information
  private String printInfo(int objNo, Object obj, ArrayList<?> objList, Format form) {

    String str = "";

    for (Object objs : objList) {
      str += printPublicInfo(objNo, obj, form, objs);
    }

    return str;
  }// Method printInformation END


  // Print Public Information
  private String printPublicInfo(int objNo, Object obj, Format form, Object objs) {
    ArrayList<String> publicTitle = getPublicTitle(objNo, obj);
    ArrayList<String> publicInfo;
    String str = "";


    for (int titleNo = 0; titleNo < publicTitle.size(); titleNo++) {
      publicInfo = getPublicItem(objNo, indexOf(objNo, objs));

      if (titleNo == 0) {
        str += formString(form.getNumWidth(), publicInfo.get(titleNo));
        continue;
      }
      str += formString(form.getTitleWidth(), publicInfo.get(titleNo));
    }
    str += String.format("\n");

    return str;
  }


  ///////////////////////////////////////////////////////////
  /////////////////////// 3. Search /////////////////////////
  ///////////////////////////////////////////////////////////

  protected void print(int objNo, Object obj, ArrayList<?> objList) {
    int seqNo = inputSeqNo(objNo, objList);
    String str = "";

    // Print Object Information
    if (getObject(objNo, seqNo) != null) {
      str += printObject(objNo, obj, seqNo);
      // Print Object's User Information
      if (isValidateMenu(objNo)) {
        str += printUser(objNo, obj, objList, seqNo);
      }

      System.out.print(str);
    }
  }// Method print END



  // Print Object Information
  private String printObject(int objNo, Object obj, int seqNo) {

    ArrayList<String> publicTitle = getPublicTitle(objNo, obj);
    ArrayList<String> publicInfo = getPublicItem(objNo, seqNo);
    String str = "";

    for (int i = 0; i < publicInfo.size(); i++) {
      // Object's Public Item Title
      str += formString(5, publicTitle.get(i));
      str += (": ");
      // Object's Public Item
      str += formString(5, publicInfo.get(i));
      str += String.format("\n");
    }

    return str;
  }


  // Print Object's User Information
  private String printUser(int objNo, Object obj, ArrayList<?> objList, int seqNo) {
    Set<Integer> userName = getMembers(objNo, seqNo).keySet();
    Title title = Title.getInstance(objNo);
    int tailTitleNum = title.getTitleArrSize() - 1;
    String str = "";

    // Print User
    str += String.format("%s \n", title.getTitleString(tailTitleNum));
    for (Integer userNo : userName) {
      str += String.format("- %s\n", printUserName(objNo, seqNo, userNo));
    }
    return str;
  }


  // Print Object's User Name Information
  private String printUserName(int objNo, int seqNo, int userNo) {
    switch (objNo) {
      case TEAM:
        return ((Team) getObject(objNo, seqNo)).getMembers().get(userNo).getName();
      case PROJECT:
        return ((Project) getObject(objNo, seqNo)).getMembers().get(userNo).getName();
      default:
        return null;
    }
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 4. Edit /////////////////////////
  ///////////////////////////////////////////////////////////

  protected void edit(int objNo, Object obj, ArrayList<?> objList) {

    // Edit Object
    int seqNo = editObject(objNo, objList);

    // Delete Member
    if (isValidateMenu(objNo) && (seqNo != 0)) {
      editMember(objNo, seqNo);
    }
  }


  private int editObject(int objNo, ArrayList<?> objList) {
    Title title = Title.getInstance(objNo);
    int seqNo = inputSeqNo(objNo, objList);

    Object obj = getObject(objNo, seqNo);

    if (obj != null && seqNo != 0) {
      for (int itemNo = 1; itemNo < title.getTitleArrSize(); itemNo++) {

        // print Edit Object
        printEditObject(objNo, objList, itemNo);
        // set Member
        setItem(objNo, obj, itemNo, Scanner());

        // Project, Team =>User print(X)
        if (isValidateMenu(objNo)) {
          if ((itemNo == title.getTitleArrSize() - 2)) {
            break;
          }
        }

      }
    } else {
      return 0;
    }
    return seqNo;
  }// Method editUser END


  private void printEditObject(int objNo, ArrayList<?> objList, int itemNo) {
    Title title = Title.getInstance(objNo);
    int seqNo = inputSeqNo(objNo, objList);

    System.out.printf("%s(%s)? ", //
        title.getTitleString(itemNo), // 수정할 정보 메뉴
        getItem(objNo, seqNo, itemNo) // 현재 저장된 정보?
    );
  }

  private void editMember(int objNo, int seqNo) {
    // delete Member
    deleteMember(objNo, seqNo);

    // Add Member
    addMember(objNo, seqNo);

    // Edit End
    System.out.println("변경했습니다.");
  }

  // delete Member
  private void deleteMember(int objNo, int seqNo) {
    for (int userNo : getDeleteUserNo(objNo, seqNo)) {
      getMembers(objNo, seqNo).remove(userNo);
    }
  }

  // get delete Member UserNo List
  private ArrayList<Integer> getDeleteUserNo(int objNo, int seqNo) {
    ArrayList<Integer> editUserNo = new ArrayList<Integer>();
    int num;

    for (Entry<Integer, User> userItem : getMembers(objNo, seqNo).entrySet()) {
      num = deleteMember(objNo, seqNo, userItem.getKey());
      if (num > 0) {
        editUserNo.add(num);
      }
    }

    return editUserNo;
  }

  ///////////////////////////////////////////////////////////
  /////////////////////// 5. Delete /////////////////////////
  ///////////////////////////////////////////////////////////
  // Delete Object
  protected void delete(int objNo, ArrayList<?> objList) {
    int seqNo = inputSeqNo(objNo, objList);
    if (getObject(objNo, seqNo) != null) {

      for (int listNo = 0; listNo < objList.size(); listNo++) {
        if (indexOf(objNo, objList.get(listNo)) == seqNo) {

          objList.remove(listNo);
          System.out.println("삭제하였습니다.");
          return;
        }
      }
    }
  }// Method delete END

  // Delete Object's User
  private int deleteMember(int objNo, int seqNo, int userNo) {

    String ans;
    String userName = printUserName(objNo, seqNo, userNo);

    for (;;) {

      System.out.printf("%s 삭제(y/n)? ", userName);
      ans = Scanner();

      switch (ans) {
        case "y":
          System.out.printf("'%s' 팀원을 삭제합니다.\n", userName);
          return userNo;
        case "n":
          System.out.printf("'%s' 팀원를 유지합니다.\n", userName);
          return 0;
        default:
          System.out.printf("다시 입력해주세요.\n", userName);
          continue;
      }
    }
  }// Method deleteUser END



  ///////////////////////////////////////////////////////////
  //////////////////////// get Object ///////////////////////
  ///////////////////////////////////////////////////////////
  // Object seqNo 유효 검사
  private boolean isValidateObject(int objNo, ArrayList<?> objList, int seqNo) {
    if (seqNo > 0) {
      for (int listNo = 0; listNo < objList.size(); listNo++) {
        if (indexOf(objNo, objList.get(listNo)) == seqNo) {
          return true;
        }
      }
    }
    return false;

  }// Method isValidateUser END

  // Object seqNo 있는지 확인
  private boolean checkObject(int objNo, ArrayList<?> objList, int seqNo) {

    if (isValidateObject(objNo, objList, seqNo)) {
      return true;
    } else {
      System.out.printf("없는 회원입니다.\n");
      return false;
    }
  }// Method checkUser END

  // Object seqNo 입력
  private int inputSeqNo(int objNo, ArrayList<?> objList) {

    Menu menu = Menu.getInstance();
    String ans;
    int num;

    System.out.printf("%s 번호? ", menu.getMenuName());

    ans = Scanner();
    num = Integer.parseInt(ans);

    return checkObject(objNo, objList, num) ? num : 0;
  }// Method inputUserNo END



  ///////////////////////////////////////////////////////////
  ////////////////////// Public Info ////////////////////////
  ///////////////////////////////////////////////////////////
  // Object's Public Item Tile List
  private ArrayList<String> getPublicTitle(int objNo, Object obj) {
    // System.out.println(objNo + ":" + obj);
    if (obj != null) {
      switch (objNo) {
        case USER:
          return ((User) obj).getPublicUserTitle();
        case TEAM:
          return ((Team) obj).getPublicTeamTitle();
        case PROJECT:
          return ((Project) obj).getPublicProTitle();
        case BOARD:
          return ((Board) obj).getPublicBoardTitle();
        default:
      }
    }
    return null;
  }// Method getPublicTitle END


  // Object's Public Item List
  private ArrayList<String> getPublicItem(int objNo, int seqNo) {
    // System.out.println(objNo + ":" + sepNo);
    if (getObject(objNo, seqNo) != null) {
      ArrayList<Integer> publicProItemNo = getPublicItemList(objNo, seqNo);
      ArrayList<String> publicProItem = new ArrayList<String>();

      for (int itemNo = 0; itemNo < publicProItemNo.size(); itemNo++) {
        publicProItem.add(getItem(objNo, seqNo, publicProItemNo.get(itemNo)));
      }


      return publicProItem;
    }
    return null;
  }// Method getPublicInfo END



  ///////////////////////////////////////////////////////////
  ///////////////// public getter, setter ///////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////// ---------- ///////////////////////
  ////////////////////////// ------ /////////////////////////
  //////////////////////////// -- ///////////////////////////
  ///////////////////////////////////////////////////////////



  // Class set Item /////////////////////////////////////////
  private void setItem(int objNo, Object obj, int item, String str) {
    switch (objNo) {
      case USER:
        setUserItem((User) obj, item, str);
        break;
      case TEAM:
        setTeamItem((Team) obj, item, str);
        break;
      case PROJECT:
        setProItem((Project) obj, item, str);
        break;
      case BOARD:
        setBoardItem((Board) obj, item, str);
        break;
      default:
        break;
    }
  }

  private void setUserItem(User user, int item, String str) {
    user.setItem(item, str);
  }

  private void setTeamItem(Team team, int item, String str) {
    team.setItem(item, str);
  }

  private void setProItem(Project pro, int item, String str) {
    pro.setItem(item, str);
  }

  private void setBoardItem(Board board, int item, String str) {
    board.setItem(item, str);
  }


  // seqNo->Object
  // Class get Item /////////////////////////////////////////
  private String getItem(int objNo, int seqNo, int item) {
    switch (objNo) {
      case USER:
        return ((User) getObject(objNo, seqNo)).getItem(item);
      case TEAM:
        return ((Team) getObject(objNo, seqNo)).getItem(item);
      case PROJECT:
        return ((Project) getObject(objNo, seqNo)).getItem(item);
      case BOARD:
        return ((Board) getObject(objNo, seqNo)).getItem(item);
      default:
        return null;
    }

  }


  // Object->seqNo
  // Class get SeqNo /////////////////////////////////////////
  private int indexOf(int objNo, Object obj) {
    switch (objNo) {
      case USER:
        return ((User) obj).getSeqNo();
      case TEAM:
        return ((Team) obj).getSeqNo();
      case PROJECT:
        return ((Project) obj).getSeqNo();
      case BOARD:
        return ((Board) obj).getSeqNo();
      default:
        return 0;
    }
  }



  // Class set SeqNo /////////////////////////////////////////
  private void setSeqNo(int objNo, Object obj, int newSeqNo) {
    switch (objNo) {
      case TEAM:
        ((Team) obj).setSeqNo(newSeqNo);
        break;
      case PROJECT:
        ((Project) obj).setSeqNo(newSeqNo);
        break;
      default:
        break;
    }
  }


  // Class get Object by seqNo /////////////////////////////////////////
  private Object getObject(int objNo, int seqNo) {
    switch (objNo) {
      case USER:
        UserMenu user = UserMenu.getInstance();
        return user.getUser(seqNo);
      case TEAM:
        TeamMenu team = TeamMenu.getInstance();
        return team.getTeam(seqNo);
      case PROJECT:
        ProjectMenu pro = ProjectMenu.getInstance();
        return pro.getPro(seqNo);
      case BOARD:
        BoardMenu board = BoardMenu.getInstance();
        return board.getBoard(seqNo);
      default:
        return null;
    }
  }

  // Class set Object's User HashMap ///////////////////////////////////////
  private void setMembers(int objNo, int seqNo, int userNo, User members) {

    Object obj = getObject(objNo, seqNo);

    switch (objNo) {
      case TEAM:
        ((Team) obj).setMembers(userNo, members);
        // return ((Team) getObject(objNo, seqNo)).getMembers();
        break;
      case PROJECT:
        ((Project) obj).setMembers(userNo, members);
        break;
      default:
        break;

    }
  }



  // Class get Object's User HashMap ///////////////////////////////////////
  private HashMap<Integer, User> getMembers(int objNo, int seqNo) {
    switch (objNo) {
      case TEAM:
        return ((Team) getObject(objNo, seqNo)).getMembers();
      case PROJECT:
        return ((Project) getObject(objNo, seqNo)).getMembers();
      default:
        return null;
    }
  }



  // Class get Public Item /////////////////////////////////////////
  private ArrayList<Integer> getPublicItemList(int objNo, int seqNo) {
    switch (objNo) {
      case USER:
        return ((User) getObject(objNo, seqNo)).getPublicUserItem();
      case TEAM:
        return ((Team) getObject(objNo, seqNo)).getPublicTeamItem();
      case PROJECT:
        return ((Project) getObject(objNo, seqNo)).getPublicProItem();
      case BOARD:
        return ((Board) getObject(objNo, seqNo)).getPublicBoardItem();
      default:
        break;
    }
    return null;
  }

  // 데이터 목록을 다루는 일을 할 객체의 사용법
  // =>즉 '그 객체에게 일을 시킬 때 다음의 메서드를 호출하여 일을 시켜라."라고 지정하는 문법
  // 메소드를 만들었다~ 라는 추상 의미
  public interface VoList {
    // Set Item
    void setItem(int itemNo, String str);

    // Get Item
    String getItem(int itemNo);

    // Object->seqNo
    int getSeqNo();

    // seqNo->Object
    void setSeqNo(int newSeqNo);

    // set Members(TEAM, PROJECT)
    void setMembers(int seqNo, User members);

    // get Members(TEAM, PROJECT)
    HashMap<Integer, User> getMembers();
  }

}
// Class MenuExtends END
