package bitcamp.myapp.app.command;

import bitcamp.myapp.app.util.Menu;
import bitcamp.myapp.app.util.SubMenu;

public class Printer {
  Menu menu = Menu.getInstance();

  ///////////////////////////////////////////////////////////
  /////////////////////// Print Menu ////////////////////////
  ///////////////////////////////////////////////////////////
  // 현재 메뉴 출력
  public void printMenu() {

    String boldAnsi = "\033[1m";
    // String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";

    String appTitle = boldAnsi + "[";
    String appTitleTail = "]" + resetAnsi;
    String line = boldAnsi + "---------------------" + resetAnsi;


    System.out.println(line);
    System.out.println(appTitle + menu.getMenuName() + appTitleTail);

    // 메뉴 출력
    // ---------------------
    // [메인]
    // 1. 회원
    // 2. 팀
    // 3. 프로젝트
    // 4. 게시판
    // 5. 도움말
    // 9. 종료
    // ---------------------
    for (int i = 0; i < menu.getMenuArr().length; i++) {
      if (i == (menu.getMenuArr().length - 1)) {
        System.out.printf("%d. %s\n", //
            9, // 9. 종료|이전
            menu.getMenuArrItem(i));
      } else {
        System.out.printf("%d. %s\n", (i + 1), menu.getMenuArrItem(i));
      }
    }

    System.out.println(line);
  }

  ///////////////////////////////////////////////////////////
  ///////////////////////// Prompt //////////////////////////
  ///////////////////////////////////////////////////////////
  // User Prompt 출력
  public void printPrompt() {
    menu.processMenu(printMenuPrompt(menu.getCurrent()));
  }

  // User Prompt 위치 출력
  private String printMenuPrompt(int current) {
    SubMenu p = new SubMenu();

    // 메인/회원>__
    System.out.print("메인");
    addMenuPrompt(current);
    System.out.print("> ");

    return p.Scanner();
  }

  // 메뉴 이동시 Prompt 추가
  private void addMenuPrompt(int current) {
    if (current > 0) {
      // 회원>__
      System.out.printf("/%s", menu.getMenuName());
    }
  }


  ///////////////////////////////////////////////////////////
  /////////////////////// isValidate ////////////////////////
  ///////////////////////////////////////////////////////////
  // printer 동작 가능한지 여부 확인
  public boolean isValidatePrinter() {
    return menu.getCurrent() >= 0 ? true : false;
  }
}
