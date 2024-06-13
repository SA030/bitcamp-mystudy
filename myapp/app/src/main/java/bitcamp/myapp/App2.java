package bitcamp.myapp;

import java.util.Scanner;

public class App2 {


  static Scanner sc = new Scanner(System.in);

  static String[] mn = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
  static String[] member = {"등록", "목록", "조회", "변경", "삭제", "이전"};
  static int sel = 0;


  public static void main(String[] args) {

    while (sel >= 0) {
      try {
        SelectMenu(printMain());
        // } catch (InputMismatchException e) { //숫자로 못 바꾸는 경우 에러메세지 출력
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자로 메뉴 번호를 입력하세요.");
      }
    }

    System.out.println("종료합니다.");
    sc.close();
  }


  static String printMain() {
    switch (sel) {
      case 0:
        printMenu();
        break;
      case 1:
        printMemberMenu();
        break;
      default:
        break;
    }

    return prompt();
  }

  static void printMenu() {

    String boldAnsi = "\033[1m";
    String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";

    String appTitle = boldAnsi + "[팀 프로젝트 관리 시스템]" + resetAnsi;
    String line = boldAnsi + "---------------------" + resetAnsi;


    System.out.println(line);
    System.out.println(appTitle);

    for (int i = 0; i < mn.length; i++) {
      if (i == (mn.length)) {
        System.out.printf("%s%d. %s%s\n", redAnsi, (i + 1), mn[i], resetAnsi);
      } else {
        System.out.printf("%d. %s\n", (i + 1), mn[i]);
      }
    }
    System.out.println(line);
  }



  static void printMemberMenu() {
    String boldAnsi = "\033[1m";
    String resetAnsi = "\033[0m";

    String appTitle = boldAnsi + "[회원]" + resetAnsi;
    String line = boldAnsi + "---------------------" + resetAnsi;


    System.out.println(line);
    System.out.println(appTitle);

    for (int i = 0; i < member.length; i++) {
      if (i == (member.length - 1)) {
        System.out.printf("%d. %s\n", 9, member[i]);
      } else {
        System.out.printf("%d. %s\n", (i + 1), member[i]);
      }
    }
    System.out.println(line);
  }

  static void SelectMenu(String command) {

    int ans = 0;
    String menuTitle;

    if (command.equals("menu")) {
      sel = 0;
    } else {
      ans = Integer.parseInt(command);
      menuTitle = getMenuTitle(ans);
      if (menuTitle == null) {
        System.out.println("[ERROR] 유효한 메뉴 번호가 아닙니다.");
      } else if (menuTitle.equals("회원")) {
        sel = 1;
      } else if (menuTitle.equals("이전")) {
        sel--;
      } else if (menuTitle.equals("종료")) {
        sel = -1;
      }
      System.out.println(menuTitle);
    }
  }

  static String prompt() {
    System.out.print("메인");
    addPrompt();
    System.out.print("> ");

    return sc.nextLine();
  }



  static void addPrompt() {
    switch (sel) {
      case 0:
        break;
      case 1:
        System.out.print("/회원");
        break;
      default:
        break;
    }
  }



  static boolean isValidateMenu(int menuNo) {
    return menuNo > 0 && menuNo <= mn.length;
  }



  static String getMenuTitle(int menuNo) {

    switch (sel) {
      case 0:
        return isValidateMenu(menuNo) ? mn[menuNo - 1] : null;
      case 1:
        if (menuNo == 9) {
          menuNo = member.length;
        }
        return isValidateMenu(menuNo) ? member[menuNo - 1] : null;
      default:
        return null;
    }

  }
}
