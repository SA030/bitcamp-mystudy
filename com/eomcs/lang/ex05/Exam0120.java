package ex05;

//# 산술 연산자 : 우선 순위 
//
public class Exam0120 {
  public static void main(String[] args) {
    // *, /, % 는 +, - 보다 먼저 계산된다.
    System.out.println(2 + 3 * 7); // 3 * 7을 먼저 수행한다.
    System.out.println(3 * 7 + 2); // 3 * 7을 먼저 수행한다.

    // 같은 우선순위에서는 먼저 나온 것을 먼저 계산한다.
    System.out.println(3 * 8 / 2); // 3 * 8을 먼저 계산
    System.out.println(8 / 2 * 3); // 8 / 2를 먼저 계산 
    // 같은 우선순위의 연산자는 실행 순서가 바뀌더라도 상관없다.

    // 강제로 실행 순서를 바꾸고 싶다면 
    // 괄호()를 묶어라!
    System.out.println((2 + 3) * 7); // = 35
  }
}

/* 
# 연산자 우선 순위
괄호: ()
후위 연산자: a++, a--
전위 연산자: ++a, --a, 단항 연산자(+, -)
*, /, %
+, -
비트이동 연산자: <<, >>, >>>
관계 연산자: <, >, <=, >=, instanceof
등위 연산자: ==, !=
&
^
|
논리 연산자 AND: &&
논리 연산자 OR: ||
삼항 연산자: (조건) ? 값 : 값
할당 연산자: =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
 */