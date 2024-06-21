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
  Scanner sc = new Scanner(System.in);



  /********************************************************/

  protected static final int USER = 1;
  protected static final int TEAM = 2;
  protected static final int PROJECT = 3;
  protected static final int BOARD = 4;

  /********************************************************/



  // protected ArrayList<Object> list = new ArrayList<Object>();



  ///////////////////////////////////////////////////////////
  ///////////////////////// Scanner /////////////////////////
  ///////////////////////////////////////////////////////////
  public String Scanner() {
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


  // Add New Object's User ///////////////////////////////////
  protected void addUser(int objNo, Object obj) {
    String ans = "";

    // 팀원 등록
    for (;;) {
      System.out.printf("추가할 팀원 번호?(종료: 0) ");
      ans = Scanner();
      if (ans.equals("0")) {
        return;
      }
      addMemberHashMap(objNo, getSeqNo(objNo, obj), Scanner());
    }

  }

  // Add Old Object's User ///////////////////////////////////
  protected void addUser(int objNo, int seqNo) {
    String ans = "";

    // 팀원 등록
    for (;;) {
      System.out.printf("추가할 팀원 번호?(종료: 0) ");
      ans = Scanner();
      if (ans.equals("0")) {
        return;
      }

      addMemberHashMap(objNo, seqNo, ans);
    }

  }// Method addUser END ////////////////////////////////////


  private void addMemberHashMap(int objNo, int seqNo, String ans) {
    UserMenu userMenu = UserMenu.getInstance();

    if (checkObject(USER, userMenu.getUserList(), Integer.parseInt(ans))) {
      int userNo = Integer.parseInt(ans);

      addMember(objNo, seqNo, userNo, userMenu.getUser(userNo));

    }
  }

  // 멤버 추가
  private void addMember(int objNo, int seqNo, int userNo, User user) {

    if (!isDuplicateMember(objNo, seqNo, userNo)) {
      setMembers(objNo, seqNo, user);
    }
    System.out.printf(printAddMember(objNo, seqNo, userNo, user.getName()));
  }


  // 멤버 중복 메세지 출력
  private String printAddMember(int objNo, int seqNo, int userNo, String userName) {
    return !isDuplicateMember(objNo, seqNo, userNo) ? //
        String.format("'%s'을 추가했습니다.\n", userName) : // true: 신규
        String.format("'%s'은 현재 팀원입니다.\n", userName); // false: 중복
  }

  // 멤버 중복 확인
  private boolean isDuplicateMember(int objNo, int seqNo, int userNo) {
    HashMap<Integer, User> userHash = getMembers(objNo, seqNo);

    return userHash.containsKey(userNo) ? true : false;
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. List /////////////////////////
  ///////////////////////////////////////////////////////////
  protected void printList(int objNo, Object obj, ArrayList<?> objList, int numWidth,
      int titleWidth) {

    String str = "";
    str += printTitle(objNo, obj, numWidth, titleWidth);
    str += printInformation(objNo, obj, objList, numWidth, titleWidth);

    System.out.print(str);

  }// Method printList END



  // Print Title
  private String printTitle(int objNo, Object obj, int numWidth, int titleWidth) {

    // Copy Title List
    ArrayList<String> publicTitle = getPublicTitle(objNo, obj);
    String str = "";

    // Print Copy Title List
    for (int i = 0; i < publicTitle.size(); i++) {
      if (i == 0) {
        str += formString(numWidth, publicTitle.get(i));
        continue;
      }
      str += formString(titleWidth, publicTitle.get(i));
    }
    str += String.format("\n");

    return str;

  }// Method printTitle END


  // Print Information
  private String printInformation(int objNo, Object obj, ArrayList<?> objList, int numWidth,
      int titleWidth) {
    ArrayList<String> publicTitle = getPublicTitle(objNo, obj);
    ArrayList<String> publicInfo;
    String str = "";

    for (Object objs : objList) {
      for (int titleNo = 0; titleNo < publicTitle.size(); titleNo++) {
        publicInfo = getPublicItem(objNo, getSeqNo(objNo, objs));

        if (titleNo == 0) {
          str += formString(numWidth, publicInfo.get(titleNo));
          continue;
        }
        str += formString(titleWidth, publicInfo.get(titleNo));
      }
      str += String.format("\n");
    }
    return str;
  }// Method printInformation END



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
      if (objNo == TEAM || objNo == PROJECT) {
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

    // Edit Project Info
    int seqNo = editObject(objNo, objList);

    // Delete Project user
    if (objNo == TEAM || objNo == PROJECT) {
      editUser(objNo, seqNo, objList);
    }

  }

  private void editUser(int objNo, int seqNo, ArrayList<?> objList) {
    HashMap<Integer, User> editUser = getMembers(objNo, seqNo);
    ArrayList<Integer> editUserNo = new ArrayList<Integer>();
    int num;

    for (Entry<Integer, User> userItem : editUser.entrySet()) {
      num = deleteUser(objNo, seqNo, userItem.getKey());
      if (num > 0) {
        editUserNo.add(num);
      }
    }

    for (int userNo : editUserNo) {
      getMembers(objNo, seqNo).remove(userNo);
    }

    // Add Project user
    addUser(objNo, seqNo);

    // Edit End
    System.out.println("변경했습니다.");
  }

  private int editObject(int objNo, ArrayList<?> objList) {
    Title title = Title.getInstance(objNo);
    int seqNo = inputSeqNo(objNo, objList);
    Object obj = getObject(objNo, seqNo);


    if (obj != null) {
      for (int itemNo = 1; itemNo < title.getTitleArrSize(); itemNo++) {
        System.out.printf("%s(%s)? ", //
            title.getTitleString(itemNo), // 수정할 정보 메뉴

            //////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////
            getItem(objNo, seqNo, itemNo) // 현재 저장된 정보?
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        );
        setItem(objNo, obj, itemNo, Scanner()); // 수정


        // User Menu 외 작동(Member 프린트x) ////////////////////
        if ((objNo != 1) && (itemNo == title.getTitleArrSize() - 2)) {
          break;
        }
        /////////////////////////////////////////////////////////

      }
    } else {
      return 0;
    }
    return seqNo;
  }// Method editUser END



  ///////////////////////////////////////////////////////////
  /////////////////////// 5. Delete /////////////////////////
  ///////////////////////////////////////////////////////////
  // Delete Object
  protected void delete(int objNo, ArrayList<?> objList) {
    int seqNo = inputSeqNo(objNo, objList);
    if (getObject(objNo, seqNo) != null) {

      for (int listNo = 0; listNo < objList.size(); listNo++) {
        if (getSeqNo(objNo, objList.get(listNo)) == seqNo) {

          objList.remove(listNo);
          System.out.println("삭제하였습니다.");
          return;
        }
      }
    }
  }// Method delete END

  // Delete Object's User
  private int deleteUser(int objNo, int seqNo, int userNo) {

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
        if (getSeqNo(objNo, objList.get(listNo)) == seqNo) {
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
  private ArrayList<String> getPublicItem(int objNo, int sepNo) {
    // System.out.println(objNo + ":" + sepNo);
    if (getObject(objNo, sepNo) != null) {
      ArrayList<Integer> publicProItemNo = getPublicItemList(objNo, sepNo);
      ArrayList<String> publicProItem = new ArrayList<String>();

      for (int itemNo = 0; itemNo < publicProItemNo.size(); itemNo++) {
        publicProItem.add(getItem(objNo, sepNo, publicProItemNo.get(itemNo)));
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



  // Class get SeqNo /////////////////////////////////////////
  private int getSeqNo(int objNo, Object obj) {
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
  private void setMembers(int objNo, int seqNo, User members) {

    Object obj = getObject(objNo, seqNo);

    switch (objNo) {
      case TEAM:
        ((Team) obj).setMembers(seqNo, members);
        // return ((Team) getObject(objNo, seqNo)).getMembers();
        break;
      case PROJECT:
        ((Project) obj).setMembers(seqNo, members);
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



  public interface Commmand {

    void setUserItem(int item, String str);

    String getItem(int objNo, int seqNo, int item);

    int getSeqNo(int objNo, Object obj);

    void setMembers(int objNo, int seqNo, User members);

    HashMap<Integer, User> getMembers(int objNo, int seqNo);
  }

}
// Class MenuExtends END
