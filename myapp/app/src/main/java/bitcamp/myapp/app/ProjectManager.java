package bitcamp.myapp.app;

import java.util.Scanner;

public class ProjectManager {

  public static void main(String[] args) {

    DataPrinter p = new DataPrinter();
    Menu mn = Menu.getInstance();
    Scanner sc = new Scanner(System.in);

    while (mn.current >= 0) {
      p.Menu(mn.current);

      try {
        mn.processMenu(p.prompt(mn.current));
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자로 메뉴 번호를 입력하세요.");
      }
    }

    System.out.println("종료합니다.");
    sc.close();
  }
}
