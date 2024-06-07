package study.lang.operator;

public class Test02 {
  public static void main(String[] args) {

    byte b1 = 100;
    byte b2 = 20;
    byte b3;

    b3 = 100 + 20;
    b3 = (byte) (b1 + b2);
    System.out.println(b3); // 0

    int r = b1 + b2;

    char c = 20;
    short s = 30;
    // short t2 = c+s;

    int i1 = 21_0000_0000;
    int i2 = 21_0000_0000;
    int i3 = i1 + i2;
    System.out.println(i3); // -94967296

    long i4 = 21_0000_0000;
    long i5 = 21_0000_0000;
    // long i6 = 22_0000_0000L; //int(약 21억) over
    long r3 = i4 + i5;
    System.out.println(r3); // 42_0000_0000
  }
}
