package bitcamp.myapp.app.command;

import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.util.Menu;

public class Printer {
  Menu menu = Menu.getInstance();

  ///////////////////////////////////////////////////////////
  /////////////////////// Print Menu ////////////////////////
  ///////////////////////////////////////////////////////////

  public void printMenu() {

    String boldAnsi = "\033[1m";
    // String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";

    String appTitle = boldAnsi + "[";
    String appTitleTail = "]" + resetAnsi;
    String line = boldAnsi + "---------------------" + resetAnsi;


    System.out.println(line);
    System.out.println(appTitle + currentMenu(menu.getCurrent()) + appTitleTail);

    // 메뉴 출력
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

  public void printPrompt() {
    menu.processMenu(prompt(menu.getCurrent()));
  }


  private String prompt(int current) {
    DataEdit p = new DataEdit();

    System.out.print("메인");
    addPrompt(current);
    System.out.print("> ");

    return p.Scanner();
  }

  // 메뉴 이동시 Prompt 추가
  private void addPrompt(int current) {
    if (current > 0) {
      System.out.printf("/%s", currentMenu(current));
    }
  }

  // 메뉴 현재 위치 출력
  private String currentMenu(int current) {

    if (current == 0) {
      return "메인";
    } else {
      return menu.getMenuArr()[current - 1];
    }
  }

  ///////////////////////////////////////////////////////////
  //////////////////////// Current //////////////////////////
  ///////////////////////////////////////////////////////////

  public int getCurrent() {
    return menu.getCurrent();
  }

}
