package study.lang.variable;

public class Test01 {
  public static void main(String[] args) {
    // 실습
    // -문자 코드를 저장하는 방법을 확인하라

    char c1 = 0xAC00; // 변수에 '가'문자의 코드를 정수 값으로 저장하라.
    char c2 = '\uAC00'; // 변수에 '가'문자의 코드를 \ u 000 형태의 유니코드 표현법으로 저장하라.
    char c3 = 44032; // 변수에 '가'문자의 코드를 가장 쉬운 방법으로 저장하라.
    char c4 = '가';

    System.out.println("c1:" + c1);
    System.out.println("c2:" + c2);
    System.out.println("c3:" + c3);
    System.out.println("c4:" + c4);

  }
}
