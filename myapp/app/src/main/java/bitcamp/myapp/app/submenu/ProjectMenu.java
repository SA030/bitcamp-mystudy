package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import bitcamp.myapp.app.util.Menu;
import bitcamp.myapp.app.vo.Project;
import bitcamp.myapp.app.vo.User;

public class ProjectMenu {
  private MenuExtends data = MenuExtends.getInstance();
  private UserMenu user = UserMenu.getInstance();

  private Project pro = Project.getInstance();



  ///////////////////////////////////////////////////////////
  ///////////////////// Project Menu ////////////////////////
  ///////////////////////////////////////////////////////////
  public void menuProject(int menuNo) {

    switch (menuNo) {
      case 1: // 등록
        add();
        break;
      case 2: // 목록
        printList();
        break;
      case 3: // 조회
        print();
        break;
      case 4: // 변경
        edit(user.inputUserNo());
        break;
      case 5: // 삭제
        delete(user.inputUserNo());
        break;
      default:
        break;
    }
  }// Method menuProject END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. 등록 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void add() {
    String item[] = new String[4];
    // 프로젝트 등록
    for (int ProItem = 0; ProItem < 4; ProItem++) {
      System.out.printf("%s? ", pro.getProTitleString(ProItem));
      item[ProItem] = data.Scanner();
    }
    Project newPro = new Project(item);
    data.add(newPro);

    // 팀원 등록
    addUser(newPro);
  }// Method add END

  // 팀원 등록
  private void addUser(Project addPro) {

    String ans;
    int userNo;
    HashMap<Integer, User> addUser;

    for (;;) {
      System.out.printf("추가할 팀원 번호?(종료: 0) ");
      ans = data.Scanner();

      // 0 입력 시 팀원 등록 종료
      if (ans.equals("0")) {
        break;
      }

      // 팀원 등록
      if (user.checkUser(Integer.parseInt(ans))) {
        userNo = Integer.parseInt(ans);
        addUser = addPro.getMembers();

        if (addUser.containsKey(userNo)) {
          // userNo 팀원 중복, 등록X
          System.out.printf("'%s'은 현재 팀원입니다.\n", addUser.get(userNo).getName());
        } else {
          // userNo 팀원 등록
          addPro.setMembers(userNo, data.getUser(userNo));
          System.out.printf("'%s'을 추가했습니다.\n", addUser.get(userNo).getName());
        }
      }

    }
  }// Method addUser END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. 목록 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void printList() {
    ArrayList<String> proPublicTitle = getPublicTitle();
    ArrayList<String> proPublicInfo;

    int numWidth = 3;
    int titleWidth = 20;
    String str = "";

    // 프로젝트 정보 제목 출력
    str += printTitle(numWidth, titleWidth);

    // 프로젝트 정보 출력
    for (int proNo = 1; proNo <= data.getArrSize(); proNo++) {

      // 프로젝트 번호
      str += formString(numWidth, proNo);
      // 프로젝트 공개 정보
      for (int titleNo = 0; titleNo < proPublicTitle.size(); titleNo++) {
        proPublicInfo = getPublicItem(proNo);
        str += formString(titleWidth, proPublicInfo.get(titleNo));
      }
      str += String.format("\n");

    }


    // Print Total
    System.out.print(str);
  }// Method printList END
   ///////////////////////////////////////////////////////////

  // Print Title
  private String printTitle(int numWidth, int titleWidth) {

    String str = "";

    // Title Copy
    ArrayList<String> proItem = new ArrayList<String>();
    ArrayList<String> proPublicTitle = getPublicTitle();

    for (int i = 0; i < proPublicTitle.size(); i++) {
      proItem.add(pro.getProTitleString(i));
    }


    // N
    str += formString(numWidth, "N");
    // 프로젝트 공개 정보
    for (int i = 0; i < proItem.size(); i++) {
      str += formString(titleWidth, proItem.get(i));
    }
    str += String.format("\n");

    return str;
  }// Method printTitle END



  // Title 간격 조정
  private String formString(int width, String text) {
    return String.format("%-" + width + "s", text);
  }// Method formString END

  private String formString(int width, int text) {
    return String.format("%-" + width + "d", text);
  }// Method formString END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 3. 조회 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void print() {
    String str = "";
    int itemNo = 0;
    int proNo = inputUserNo();
    if (proNo != 0) {
      Set<Integer> userName = getPro(proNo).getMembers().keySet();
      // Print Project name
      for (; itemNo < pro.getSize() - 1; itemNo++) {
        str += String.format("%s: %s \n", pro.getProTitleString(itemNo),
            getPro(proNo).getItem(itemNo));
      }


      // Print User
      str += String.format("%s \n", pro.getProTitleString(4));
      for (Integer userNo : userName) {
        str += String.format("- %s\n", printUserName(proNo, userNo));
      }

      // Print Total
      System.out.print(str);
    }
  }

  // 팀원 이름 조회
  private String printUserName(int proNo, int userNo) {
    return getPro(proNo).getMembers().get(userNo).getName();
  }


  // 팀 공개 정보 Tile
  private ArrayList<String> getPublicTitle() {

    if (pro != null) {
      return pro.getPublicProTitle();
    }
    return null;
  }// Method getPublicTitle END

  // 팀 공개 정보
  private ArrayList<String> getPublicItem(int proNo) {
    if (getPro(proNo) != null) {
      ArrayList<Integer> publicProItemNo = getPro(proNo).getPublicProItem();
      ArrayList<String> publicProItem = new ArrayList<String>();

      for (int itemNo = 0; itemNo < publicProItemNo.size(); itemNo++) {
        publicProItem.add(getPro(proNo).getItem(publicProItemNo.get(itemNo)));
      }

      return publicProItem;
    }
    return null;
  }// Method getPublicInfo END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 4. 변경 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void edit(int proNo) {

    // Edit Project Info
    if (proNo > 0) {
      for (int itemNo = 0; itemNo < pro.getSize() - 1; itemNo++) {
        System.out.printf("%s(%s) ", //
            pro.getProTitleString(itemNo), // 수정할 정보 메뉴
            getPro(proNo).getItem(itemNo) // 현재 저장된 정보
        );
        getPro(proNo).setItem(itemNo, data.Scanner()); // 수정
      }

      // Delete Project user
      HashMap<Integer, User> editUser = getPro(proNo).getMembers();
      ArrayList<Integer> editUserNo = new ArrayList<Integer>();
      int num;

      for (Entry<Integer, User> userItem : editUser.entrySet()) {
        num = deleteUser(proNo, userItem.getKey());
        if (num > 0) {
          editUserNo.add(num);
        }
      }

      for (int userNo : editUserNo) {
        getPro(proNo).getMembers().remove(userNo);
      }

      // Add Project user
      addUser(getPro(proNo));

      // Edit End
      System.out.println("변경했습니다.");
    }

  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 5. 삭제 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void delete(int proNo) {
    if (proNo > 0) {
      data.remove(proNo);
      System.out.println("삭제하였습니다.");
    }
  }// Method delete END

  // 팀원 삭제
  private int deleteUser(int proNo, int userNo) {

    String ans;
    String userName = printUserName(proNo, userNo);

    while (true) {

      System.out.printf("%s 삭제(y/n)? ", userName);
      ans = data.Scanner();

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



  // 프로젝트 번호 유효 검사
  private boolean isValidatePro(int proNo) {
    return proNo > 0 && proNo <= data.getArrSize();
  }// Method isValidateUser END

  // 프로젝트 번호 있는지 확인
  boolean checkPro(int proNo) {

    if (isValidatePro(proNo)) {
      return true;
    } else {
      System.out.printf("없는 프로젝트 입니다.\n");
      return false;
    }
  }// Method checkUser END

  // 회원 번호 입력
  int inputUserNo() {

    Menu menu = Menu.getInstance();
    String ans;
    int num;

    System.out.printf("%s 번호? ", menu.getMenuName());

    ans = data.Scanner();
    num = Integer.parseInt(ans);

    return checkPro(num) ? num : 0;
  }// Method inputUserNo END


  // 프로젝트 가져오기
  Project getPro(int proNo) {

    if (proNo > 0) {
      return data.getPro(proNo);
    }
    return null;
  }// Method getPro END


}// Class ProjectMenu END

