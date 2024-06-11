package bitcamp.myapp;

import java.util.Scanner;

public class App2 {


  static Scanner sc = new Scanner(System.in);

  static String[] mn = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};


  public static void main(String[] args) {

    int ans = 0;
    int mnlen = mn.length;
    String command, menuTitle;

    printMenu();

    while (true) {
      try {
        // answer == "menu" (x)
        // answer에 "menu"의 주소값이 입력되어있음
        command = prompt();
        if (command.equals("menu")) {
          printMenu();
        } else {
          ans = Integer.parseInt(command);
          menuTitle = getMenuTitle(ans);
          if (menuTitle == null) {
            System.out.println("[ERROR] 유효한 메뉴 번호가 아닙니다.");
          } else if (menuTitle.equals("종료")) {
            break;
          } else {
            System.out.println(menuTitle);
          }
        }
        // } catch (InputMismatchException e) { //숫자로 못 바꾸는 경우 에러메세지 출력
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자로 메뉴 번호를 입력하세요.");
        // sc.next();
      }

    }

    System.out.println("종료합니다.");
    sc.close();

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

  static String prompt() {
    System.out.print("> ");
    return sc.nextLine();
  }

  static boolean isValidateMenu(int menuNo) {
    return menuNo > 0 && menuNo <= mn.length;
  }

  static String getMenuTitle(int menuNo) {
    // if (isValidateMenu(menuNo)) {
    // return menus[menuNo - 1];
    // }
    // return null;

    return isValidateMenu(menuNo) ? mn[menuNo - 1] : null;
  }

}
