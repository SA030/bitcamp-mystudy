package ex05;

//# 증감 연산자 : 전위(pre-fix) 증감 연산자 응용 II
//
public class Exam0682 {
  public static void main(String[] args) {
    // 주의!
    // 1) pre-fix 연산자나 post-fix 연산자를 리터럴에 적용할 수 없다.
    // int x = ++100; // 컴파일 오류!
    // x = 100++; // 컴파일 오류!

    // 2) 변수에 동시에 적용할 수 없다.
    // - 실행된 값에 대해 전위/후위 연산자를 적용할 수 없기 때문이다.
    int y = 100;

    // ++y++; // 컴파일 오류!
    // 1) y = y + 1
    // 2) 101++ <=== 값에 대해 ++ 연산을 사용할 수 없다.

    // (++y)++; // 컴파일 오류!
    // 1) y = y + 1
    // 2) (101)++ <=== ++y 연산을 수행한 후 그 자리에는 결과 값이 놓인다.
    //                 값에 대해 ++ 연산을 수행할 수 없다.

    //    ++(y++); // 컴파일 오류!
    // 1) ++(100)
    // 2) y = y + 1
  }
}
