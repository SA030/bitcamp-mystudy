package study.lang.method;

import java.util.Scanner;

public class Test07 {
  public static void main(String[] args) {
    new Scanner(System.in).nextInt();
  }

  static int sum(int n) {
    if (n == 1) {
      return 1;
    }
    return n + sum(n - 1);
  }
}
