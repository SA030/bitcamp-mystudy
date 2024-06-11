package study.lang.variable;

public class Test05 {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);

    System.out.print("입력1: ");
    String s1 = sc.nextLine();
    System.out.print("입력2: ");
    String s2 = sc.nextLine();

    //주소 비교가 아닌
    System.out.println(s1 == s2);

    //equals을 사용하여 문자열을 비교해야한다.
    System.out.println(s1.equals(s2));

    sc.close();

  }

}
