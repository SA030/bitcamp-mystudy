package study.lang.method;

public class Test04 {
  public static void main(String[] args) {
    String message = m1("홍길동", 20);
    System.out.println(message);
  }

  static String m1(String name, int age) {
    return String.format("%s(%d)님 반가워요", name, age);
  }
}
