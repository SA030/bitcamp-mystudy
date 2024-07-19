package bitcamp.myapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    String boldAnsi = "\033[1m";
    String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";

    String appTitle = boldAnsi + "[팀 프로젝트 관리 시스템]" + resetAnsi;
    String[] mn = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
    String line = boldAnsi + "---------------------" + resetAnsi;

    String answer = "";
    int ans = 0;
    int mnlen = mn.length;

    Scanner sc = new Scanner(System.in);

    System.out.println(line);
    System.out.println(appTitle);
    for (int i = 0; i < mnlen; i++) {
      if (i == (mnlen - 1)) {
        // System.out.println(redAnsi + (i + 1) + ". " + mn[i] + resetAnsi);
        System.out.printf("%s%d. %s%s\n", redAnsi, (i + 1), mn[i], resetAnsi);
      } else {
        // System.out.println((i + 1) + ". " + mn[i]);
        System.out.printf("%d. %s\n", (i + 1), mn[i]);
      }
    }
    System.out.println(line);

    while (true) {
      try {
        System.out.print("> ");
        ans = sc.nextInt();

        if (0 < ans && ans < mn.length + 1) {
          if (ans == mnlen) {
            break;
          }
          System.out.println(mn[ans - 1]);
        } else {
          System.out.println("[ERROR] 유효한 메뉴 번호가 아닙니다.");
        }
      } catch (InputMismatchException e) {
        System.out.println("[ERROR] 숫자로 메뉴 번호를 입력하세요.");
        sc.next();
      }

    }

    System.out.println("종료합니다.");
    sc.close();

  }
}
