package bitcamp.myapp.app;

public class ProjectManager {

  public static void main(String[] args) {

    Printer p = new Printer();
    Menu mn = Menu.getInstance();

    //더미데이터
    mn.menu.data.addDummy();


    while (mn.menu.getCurrent() >= 0) {
      p.Menu(mn.menu.getCurrent());

      try {
        mn.processMenu(p.prompt(mn.menu.getCurrent()));
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자로 메뉴 번호를 입력하세요.");
      }
    }

    System.out.println("종료합니다.");
  }
}
