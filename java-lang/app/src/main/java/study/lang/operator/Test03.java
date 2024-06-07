package study.lang.operator;

public class Test03 {
  public static void main(String[] args) {
    byte b = 1;
    char c = 2;
    short s = 3;

    // short r = b + c + s;
    int r = b + c + s; // 암묵적 형변환

    int i = 4;
    long l = 5;
    float f = 6.0f;
    double d = 7.0;

    long r2 = i + l; // (int + long)

    // long r3 = f;
    float r4 = l; // error는 아니지만, 값이 잘릴 수 있다.
  }
}
