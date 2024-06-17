package bitcamp.myapp.app;

public class Printer {


  ///////////////////////////////////////////////////////////
  /////////////////////// Print Menu ////////////////////////
  ///////////////////////////////////////////////////////////

  public void Menu(int current) {

    String boldAnsi = "\033[1m";
    // String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";

    String appTitle = boldAnsi + "[";
    String appTitleTail = "]" + resetAnsi;
    String line = boldAnsi + "---------------------" + resetAnsi;

    Menu m = Menu.getInstance();

    System.out.println(line);
    System.out.println(appTitle + currentMenu(current) + appTitleTail);

    // 메뉴 출력
    for (int i = 0; i < m.menu.getMenuArr().length; i++) {
      if (i == (m.menu.getMenuArr().length - 1)) {
        System.out.printf("%d. %s\n", //
            9, // 9. 종료|이전
            m.getMenuArrItem(i));
      } else {
        System.out.printf("%d. %s\n", (i + 1), m.getMenuArrItem(i));
      }
    }

    System.out.println(line);
  }
  ///////////////////////////////////////////////////////////
  ///////////////////////// Prompt //////////////////////////
  ///////////////////////////////////////////////////////////

  public String prompt(int current) {
    DataEdit p = new DataEdit();
    System.out.print("메인");
    addPrompt(current);
    System.out.print("> ");

    return p.Scanner();
  }

  // 메뉴 이동시 Prompt 추가
  public void addPrompt(int current) {
    if (current > 0) {
      System.out.printf("/%s", currentMenu(current));
    }
  }

  // 메뉴 현재 위치 출력
  public String currentMenu(int current) {
    Data data = Data.getInstance();

    if (current == 0) {
      return "메인";
    } else {
      return data.mainMenu[current - 1];
    }
  }
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
}
