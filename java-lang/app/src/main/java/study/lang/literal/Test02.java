package study.lang.literal;

// 실습

// -10진수 literal 100을 지시에 따라 다양한 진수법으로 표현하라.
// -출력
//  100

public class Test02 {
    public static void main(String[] args) {
        // 코드를 완성하라
        System.out.println(100); // 10진수
        System.out.println(0b1100100); // 2진수
        System.out.println(0144); // 8진수
        System.out.println(0x64); // 16진수

        // 2 : 01100100
        // 8 : 01 100 100 -> 144 (3)
        // 16: 0110 0100 -> 64 (4)
    }
}
