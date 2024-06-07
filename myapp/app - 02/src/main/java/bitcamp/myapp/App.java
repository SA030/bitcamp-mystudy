package bitcamp.myapp;

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

        Scanner sc = new Scanner(System.in);

        System.out.println(line);
        System.out.println(appTitle);
        for (int i = 0; i < mn.length; i++) {
            if (i == 5) {
                System.out.println(redAnsi + (i + 1) + ". " + mn[i] + resetAnsi);
            } else {
                System.out.println((i + 1) + ". " + mn[i]);
            }
        }
        System.out.println(line);

        while (true) {
            System.out.print("> ");
            answer = sc.next();

            ans = Integer.parseInt(answer);

            if (0 < ans && ans < mn.length+1) {
                if (ans == 6){
                    System.out.println("종료합니다.");
                    return;
                }
                System.out.println(mn[ans-1]);
            } else {
                System.out.println("[ERROR] 올바른 번호를 입력해주세요.");
            }
        }
    }
}