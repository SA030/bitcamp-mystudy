package bitcamp.myapp;

import java.util.ArrayList;
import java.util.Scanner;

public class App3 {


  static Scanner sc = new Scanner(System.in);

  static String[] mainMenu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
  static String[][] subMenu = {{"등록", "목록", "조회", "변경", "삭제", "이전"}, // 회원
      {"등록", "목록", "조회", "변경", "삭제", "이전"}, // 팀
      {"등록", "목록", "조회", "변경", "삭제", "이전"}, // 프로젝트
      {"등록", "목록", "조회", "변경", "삭제", "이전"} // 게시판
  };
  static ArrayList<ArrayList<String>> memberList = new ArrayList<ArrayList<String>>();
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

    for (int i = 0; i < locationMenu().length; i++) {
      if (i == (locationMenu().length - 1)) {
        System.out.printf("%d. %s\n", 9, locationMenuItem(i));
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

  static void addPrompt() {
    if (location > 0) {
      System.out.printf("/%s", PrintLocation());
    }
  }

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
      location = inputMenuChange(menuTitle);
      System.out.println(menuTitle);
    }
  }

  static int inputMenuChange(String menuTitle) {

    switch (menuTitle) {
      case "이전":
        return 0;
      case "회원":
        return 1;
      case "팀":
        return 2;
      case "종료":
        return -1;
      default:
        return location;
    }
  }

  static void inputMenuRun(int menuNo) {
    switch (location) {
      case 0:
        break;
      case 1:
        menuMember(menuNo);
        break;
      case 2:
        break;
      case 3:
        break;
      default:
        break;
    }
  }
  ///////////////////////////////////////////////////////////


  static void menuMember(int menuNo) {
    switch (menuNo) {
      case 1: // 등록
        addMember();
        break;
      case 2: // 목록
        printListMember();
        break;
      case 3: // 조회
        printMember(InputMemberNo());
        break;
      case 4: // 변경
        editMember(InputMemberNo());
        break;
      default:
        break;
    }
  }

  static void addMember() {

    int memberNo = memberList.size();

    memberList.add(new ArrayList<String>());

    System.out.print("이름? ");
    memberList.get(memberNo).add(sc.nextLine());
    System.out.print("이메일? ");
    memberList.get(memberNo).add(sc.nextLine());
    System.out.print("암호? ");
    memberList.get(memberNo).add(sc.nextLine());
    System.out.print("연락처? ");
    memberList.get(memberNo).add(sc.nextLine());
  }

  static void printListMember() {
    System.out.printf("%-4s %-4s %s\n", "번호", "이름", "이메일");
    for (int memberNo = 0; memberNo < memberList.size(); memberNo++) {
      System.out.printf("%-4d %-4s %s\n", memberNo + 1, // 번호
          memberList.get(memberNo).get(0), // 이름
          memberList.get(memberNo).get(1) // 이메일
      );
    }
  }

  static void printMember(int memberNo) {
    System.out.printf("이름: %s \n", memberList.get(memberNo).get(0));
    System.out.printf("이메일: %s \n", memberList.get(memberNo).get(1));
    System.out.printf("연락처: %s \n", memberList.get(memberNo).get(3));
  }

  static int InputMemberNo() {
    String ans;
    int num;

    System.out.print("회원 번호? ");
    ans = sc.nextLine();
    num = Integer.parseInt(ans);

    return isValidateMember(num) ? num : 0;
  }

  static boolean isValidateMember(int memberNo) {
    return memberNo > 0 && memberNo < memberList.size();
  }


  static void editMember(int memberNo) {

    System.out.printf("이름(%s)? ", memberList.get(memberNo).get(0));
    memberList.get(memberNo).set(0, sc.nextLine());
    System.out.printf("이메일(%s)? ", memberList.get(memberNo).get(1));
    memberList.get(memberNo).set(1, sc.nextLine());
    System.out.printf("암호(%s)? ", memberList.get(memberNo).get(2));
    memberList.get(memberNo).set(2, sc.nextLine());
    System.out.printf("연락처(%s)? ", memberList.get(memberNo).get(3));
    memberList.get(memberNo).set(3, sc.nextLine());
  }



  ///////////////////////////////////////////////////////////
  ///////////////////// Location Array///////////////////////
  ///////////////////////////////////////////////////////////

  static String[] locationMenu() {
    if (location == 0) {
      return mainMenu;
    } else if (location > 0) {
      return subMenu[location];
    } else {
      return null;
    }
  }


  static String locationMenuItem(int menuNo) {
    String[] menu = locationMenu();
    if (menuNo == menu.length) {
      return null;
    }
    return menu != null ? menu[menuNo] : null;
  }

  ///////////////////////////////////////////////////////////



  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////

  static boolean isValidateMenu(int menuNo) {
    return menuNo > 0 && menuNo <= locationMenu().length;
  }


  static String getMenuTitle(int menuNo) {
    int locationNo = locationMenu().length;

    if (menuNo == locationNo) {
      menuNo = 9;
    } else if (menuNo == 9) {
      menuNo = locationNo;
    }
    return isValidateMenu(menuNo) ? locationMenuItem(menuNo - 1) : null;

  }

  ///////////////////////////////////////////////////////////
}
