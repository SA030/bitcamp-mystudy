package bitcamp.myapp;

import java.util.Scanner;

public class App4 {


  static Scanner sc = new Scanner(System.in);

  static String[] mainMenu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
  static String[] member = {"등록", "목록", "조회", "변경", "삭제", "이전"};
  static String[] tim = {"등록", "목록", "조회", "변경", "삭제", "이전"};
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
  ///////////////////////////////////////////////////////////



  ///////////////////////////////////////////////////////////
  ///////////////////// Location Array///////////////////////
  ///////////////////////////////////////////////////////////

  static String[] locationMenu() {
    switch (location) {
      case 0:
        return mainMenu;
      case 1:
        return member;
      case 2:
        return tim;
      default:
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
