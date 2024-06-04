package study.lang.variable;

public class Test02 {
  public static void main(String[] args) {
    // 실습
    // -primitive type의 변수를 선언하라.
    // -각 변수에 최소값, 최대값을 할당하라.
    // -각 변수에 최소값, 최대값 범위를 벗어나는 값을 넣은 후 오류를 확인하라.
    // -예)
    // byte b1 = -128;
    // byte b2 = 127;


    byte b1 = Byte.MIN_VALUE; // -128
    byte b2 = Byte.MAX_VALUE; // 127

    short s1 = Short.MIN_VALUE; // -32768
    short s2 = Short.MAX_VALUE; // 32767

    int i1 = Integer.MIN_VALUE; // -21_4748_3648
    int i2 = Integer.MAX_VALUE; // 21_4748_3647

    long l1 = Long.MIN_VALUE; // -922_3372_0368_5477_5808L
    long l2 = Long.MAX_VALUE; // 922_3372_0368_5477_5807L

    float f1 = Float.MIN_VALUE; // 1.4E-45
    float f2 = Float.MAX_VALUE; // 3.4028235E38

    double d1 = Double.MIN_VALUE; // 4.9E-324
    double d2 = Double.MAX_VALUE; // 1.7976931348623157E308

    char c1 = Character.MIN_VALUE;
    char c2 = Character.MAX_VALUE;

    boolean bool1 = false;
    boolean bool2 = true;

    System.out.println("b1:" + b1);
    System.out.println("b2:" + b2);

    System.out.println("s1:" + s1);
    System.out.println("s2:" + s2);

    System.out.println("i1:" + i1);
    System.out.println("i2:" + i2);

    System.out.println("l1:" + l1);
    System.out.println("l2:" + l2);

    System.out.println("f1:" + f1);
    System.out.println("f2:" + f2);

    System.out.println("d1:" + d1);
    System.out.println("d2:" + d2);

    System.out.println("c1:" + c1);
    System.out.println("c2:" + c2);

    System.out.println("bool1:" + bool1);
    System.out.println("bool2:" + bool2);

  }
}
