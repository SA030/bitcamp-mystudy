package study.lang.operator;

public class Test04 {
  public static void main(String[] args) {
    System.out.println(3 + 5 * 2);
    System.out.println(5 * 2 + 3);
    System.out.println((3 + 5) * 2);

    // 암시적 형변환 + 연산자 우선순위
    System.out.println(3.2f + 5 / 2L);

    // 명시적 형변환 + 연산자 우선순위
    System.out.println(3.2f + (float) 5 / 2L);
  }
}
