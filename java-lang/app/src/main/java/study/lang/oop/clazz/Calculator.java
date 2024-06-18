package study.lang.oop.clazz;

// 계산 기능과 관련된 메서드를 별도의 블록으로 분리할 때 사용하는 문법이 "클래스"이다.
// 메서드를 분류해 놓으면 좋은 점?
// - 관련된 메서드가 한 클래스에 묶여 있기 때문에 소스 코드를 유지보수하기 쉬워진다.
// - 다른 프로젝트에서 메서드를 재사용 하기가 쉽다.
//

public class Calculator {

  private int result = 0;

  public void plus(int b) {
    this.result += b;
  }

  public void minus(int b) {
    this.result -= b;
  }

  public void multiple(int b) {
    this.result *= b;
  }

  public void divide(int b) {
    this.result /= b;
  }

  public int getResult() {
    return this.result;
  }

  public void clear() {
    this.result = 0;
  }

  public void abs(int a) {
    //
    // if (a >= 0)
    // return a;
    // else
    // return a * -1;
    //
    this.result = a >= 0 ? a : a * -1;
  }
}
