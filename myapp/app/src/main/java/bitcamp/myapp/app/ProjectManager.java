package bitcamp.myapp.app;

import bitcamp.myapp.app.command.Printer;

public class ProjectManager {

  public static void main(String[] args) {

    Printer p = new Printer();

    // ************************** 더미데이터 ***************************//
    DummyData data = new DummyData();
    data.addDummy();
    // *****************************************************************//

    while (p.getCurrent() >= 0) {
      p.printMenu();

      try {
        p.printPrompt();
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자로 메뉴 번호를 입력하세요.");
      }
    }

    System.out.println("종료합니다.");
  }
}
