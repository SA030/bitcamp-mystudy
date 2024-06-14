package bitcamp.myapp;

import java.util.ArrayList;
import java.util.Scanner;

public class App3 {


  static Scanner sc = new Scanner(System.in);

  static String[] mainMenu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
  static String[][] subMenu = { //
      {"등록1", "목록", "조회", "변경", "삭제", "이전"}, // 1. 회원
      {"등록2", "목록", "조회", "변경", "삭제", "이전"}, // 2. 팀
      {"등록3", "목록", "조회", "변경", "삭제", "이전"}, // 3.프로젝트
      {"등록4", "목록", "조회", "변경", "삭제", "이전"}, // 4. 게시판
      {"등록5", "목록", "조회", "변경", "삭제", "이전"} // 5. 도움말
  };
  static ArrayList<ArrayList<String>> UserList = new ArrayList<ArrayList<String>>();
  static int location = 0;


  public static void main(String[] args) {

    while (location >= 0) {
      printMenu();

      try {
        inputMenu(prompt());
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자로 메뉴 번호를 입력하세요.");
      }
    }

    System.out.println("종료합니다.");
    sc.close();
  }

  ///////////////////////////////////////////////////////////
  /////////////////////// Print Menu ////////////////////////
  ///////////////////////////////////////////////////////////

  static void printMenu() {

    String boldAnsi = "\033[1m";
    // String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";

    String appTitle = boldAnsi + "[";
    String appTitleTail = "]" + resetAnsi;
    String line = boldAnsi + "---------------------" + resetAnsi;


    System.out.println(line);
    System.out.println(appTitle + PrintLocation() + appTitleTail);

    // 메뉴 출력
    for (int i = 0; i < locationMenu().length; i++) {
      if (i == (locationMenu().length - 1)) {
        System.out.printf("%d. %s\n", //
            9, // 9. 종료|이전
            locationMenuItem(i));
      } else {
        System.out.printf("%d. %s\n", (i + 1), locationMenuItem(i));
      }
    }

    System.out.println(line);
  }

  ///////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////////
  ///////////////////////// Prompt //////////////////////////
  ///////////////////////////////////////////////////////////

  static String prompt() {
    System.out.print("메인");
    addPrompt();
    System.out.print("> ");

    return sc.nextLine();
  }

  // 메뉴 이동시 Prompt 추가
  static void addPrompt() {
    if (location > 0) {
      System.out.printf("/%s", PrintLocation());
    }
  }

  // 메뉴 현재 위치 출력
  static String PrintLocation() {
    if (location == 0) {
      return "메인";
    } else {
      return mainMenu[location - 1];
    }
  }
  ///////////////////////////////////////////////////////////



  ///////////////////////////////////////////////////////////
  ////////////////////// input Menu /////////////////////////
  ///////////////////////////////////////////////////////////

  static void inputMenu(String command) {

    if (command.equals("menu")) {
      location = 0;
    } else {
      inputMenuInt(command);
    }
  }


  static void inputMenuInt(String command) {
    int ans = 0;
    String menuTitle;

    ans = Integer.parseInt(command);
    menuTitle = getMenuTitle(ans);

    if (menuTitle == null) {
      System.out.println("[ERROR] 유효한 메뉴 번호가 아닙니다.");
    } else {
      inputMenuRun(ans);
      location = locationChange(ans);
      // System.out.println(menuTitle); ////////////////// check용///////////////////////
    }
  }

  // 현재 위치 변경
  static int locationChange(int ans) {

    String menuTitle;

    if (location == 0) {
      if (ans < mainMenu.length) {
        return ans;
      }
    }

    menuTitle = getMenuTitle(ans);
    return locationChange(menuTitle);
  }

  // 현재 위치 변경(String)
  static int locationChange(String menuTitle) {

    switch (menuTitle) {
      case "이전":
        return 0;
      case "종료":
        return -1;
      default:
        return location;
    }
  }

  // sub_menu 출력
  static void inputMenuRun(int menuNo) {
    switch (location) {
      case 0: // 메인
        break;
      case 1: // 회원
        menuUser(menuNo);
        break;
      case 2: // 팀
        break;
      case 3: // 프로젝트
        break;
      case 4: // 게시판
        break;
      case 5: // 도움말
        break;
      default:
        break;
    }
  }

  ///////////////////////////////////////////////////////////



  ///////////////////////////////////////////////////////////
  ////////////////////// User Menu ////////////////////////
  ///////////////////////////////////////////////////////////

  static void menuUser(int menuNo) {
    if (isValidateMenu(menuNo)) {
      System.out.printf("[%s]\n", subMenu[0][menuNo - 1]);
    }

    switch (menuNo) {
      case 1: // 등록
        addUser();
        break;
      case 2: // 목록
        printListUser();
        break;
      case 3: // 조회
        printUser(inputUserNo());
        break;
      case 4: // 변경
        editUser(inputUserNo());
        break;
      case 5: // 삭제
        deleteUser(inputUserNo());
        break;
      default:
        break;
    }
  }


  // 회원 번호 입력
  static int inputUserNo() {
    String ans;
    int num;

    System.out.print("회원 번호? ");
    ans = sc.nextLine();
    num = Integer.parseInt(ans);

    return checkUser(num) ? num : 0;
  }

  // 1. 등록
  static void addUser() {

    int UserNo = UserList.size();

    UserList.add(new ArrayList<String>());

    for (int UserInfo = 0; UserInfo < 4; UserInfo++) {
      System.out.printf("%s? ", UserInfo(UserInfo));
      UserList.get(UserNo).add(sc.nextLine());
    }
  }

  // 2. 목록
  static void printListUser() {
    System.out.printf("%-3s %-5s %-15s\n", //
        "번호", // 번호
        UserInfo(0), // 이름
        UserInfo(1)); // 이메일
    for (int UserNo = 1; UserNo <= UserList.size(); UserNo++) {
      System.out.printf("%-3d %-5s %-15s\n", //
          UserNo, // 번호
          printUser(UserNo, 0), // 이름
          printUser(UserNo, 1) // 이메일
      );
    }
  }

  // 3. 조회
  static void printUser(int UserNo) {
    if (UserNo > 0) {
      for (int UserInfo = 0; UserInfo < UserList.get(UserNo - 1).size(); UserInfo++) {
        if (UserInfo == 2) {
          continue;
        }
        System.out.printf("%s: %s \n", UserInfo(UserInfo), printUser(UserNo, UserInfo));
      }
    }
  }


  // 4. 변경
  static void editUser(int UserNo) {
    if (UserNo > 0) {
      for (int UserInfo = 0; UserInfo < UserList.get(UserNo).size(); UserInfo++) {
        System.out.printf("%s(%s)? ", //
            UserInfo(UserInfo), // 수정할 정보 메뉴
            printUser(UserNo, UserInfo) // 현재 저장된 정보
        );

        UserList.get(UserNo - 1).set(UserInfo, sc.nextLine()); // 수정
      }
    }

  }

  // 5. 삭제
  static void deleteUser(int UserNo) {
    if (UserNo > 0) {
      UserList.remove(UserNo - 1);
      System.out.println("삭제하였습니다.");
    }
  }

  // 멤버 정보 UserInfo->String
  static String UserInfo(int UserInfo) {
    switch (UserInfo) {
      case 0:
        return "이름";
      case 1:
        return "이메일";
      case 2:
        return "암호";
      case 3:
        return "연락처";
      default:
        return null;
    }
  }


  // 멤버 정보 출력
  static String printUser(int UserNo, int UserInfo) {
    return UserList.get(UserNo - 1).get(UserInfo);
  }

  // 회원 번호 유효 검사
  static boolean isValidateUser(int UserNo) {
    return UserNo > 0 && UserNo <= UserList.size();
  }

  // 회원 번호 있는지 확인
  static boolean checkUser(int UserNo) {
    if (isValidateUser(UserNo)) {
      return true;
    } else {
      System.out.println("없는 회원입니다");
      return false;
    }
  }
  ///////////////////////////////////////////////////////////



  ///////////////////////////////////////////////////////////
  ///////////////////// Location Array///////////////////////
  ///////////////////////////////////////////////////////////

  // 현재 메뉴 위치의 배열 반환
  static String[] locationMenu() {
    if (location == 0) {
      return mainMenu;
    } else if (location > 0) {
      return subMenu[location - 1];
    } else {
      return null;
    }
  }

  // 현재 메뉴 위치의 요소 반환
  static String locationMenuItem(int menuNo) {
    String[] menu = locationMenu();
    if (menuNo == menu.length) {
      return null;
    }
    return menu != null ? menu[menuNo] : null;
  }

  ///////////////////////////////////////////////////////////



  ///////////////////////////////////////////////////////////
  ///////////////////// Check Menu //////////////////////////
  ///////////////////////////////////////////////////////////

  // 메뉴 번호 유효 검사
  static boolean isValidateMenu(int menuNo) {
    return menuNo > 0 && menuNo <= locationMenu().length;
  }

  // 메뉴 이름 반환
  static String getMenuTitle(int menuNo) {
    int locationNo = locationMenu().length;

    if (menuNo == locationNo) {
      menuNo = 0;
    } else if (menuNo == 9) {
      menuNo = locationNo;
    }
    return isValidateMenu(menuNo) ? locationMenuItem(menuNo - 1) : null;

  }

  ///////////////////////////////////////////////////////////
}
