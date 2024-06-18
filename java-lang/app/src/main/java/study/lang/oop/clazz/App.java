package study.lang.oop.clazz;

public class App {
  static Score[] scores =
      {new Score("홍길동", 80, 90, 100), new Score("홍길동", 80, 90, 100), new Score("홍길동", 80, 90, 100)};

  public static void main(String[] args) {

    printScore();

  }

  private static void printScore() {
    for (Score score : scores) {
      System.out.printf("총합 점수: %d\n", score.sum());
      System.out.printf("평균: %d\n", score.compute());
    }
  }

  private void Caculator() {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 계산 결과를 담을 변수를 준비한다.

    // 클래스 메서드를 호출하여 작업을 수행하고,
    // 리턴 결과는 로컬 변수에 저장한다.
    Calculator c = new Calculator();

    c.plus(2);
    c.plus(3);
    c.minus(1);
    c.multiple(7);
    c.divide(3);

    System.out.printf("result = %d\n", c.getResult());
  }

}
