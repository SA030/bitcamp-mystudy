package bitcamp.myapp.app;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

  Scanner sc = new Scanner(System.in);
  DataEdit user = new DataEdit();


  ///////////////////////////////////////////////////////////
  ////////////////////// User Menu ////////////////////////
  ///////////////////////////////////////////////////////////

  public void menuUser(int menuNo) {
    if (menuNo < user.getMenuArr().length - 1) {
      System.out.printf("[%s]\n", user.getMenuArr()[menuNo - 1]);
    }


    switch (menuNo) {
      case 1: // 등록
        add();
        break;
      case 2: // 목록
        printList(0, 1);
        break;
      case 3: // 조회
        print(inputNo());
        break;
      case 4: // 변경
        edit(inputNo());
        break;
      case 5: // 삭제
        delete(inputNo());
        break;
      default:
        break;
    }
  }


  // 번호 입력
  private int inputNo() {
    String ans;
    int num;

    System.out.printf("%s 번호? ", user.MenuName());
    ans = sc.nextLine();
    num = Integer.parseInt(ans);

    return checkUser(num) ? num : 0;
  }

  // 1. 등록
  private void add() {

    int UserNo = user.size();

    // User 번호 등록
    user.add();

    // User 정보 등록
    for (int UserInfo = 0; UserInfo < 4; UserInfo++) {
      System.out.printf("%s? ", user.getUserItemString(UserInfo));
      user.add(UserNo);
    }
  }

  // 2. 목록
  private void printList(int... num) {
    // Title Copy //////////////////////////////////////////////
    ArrayList<String> UserInfo = new ArrayList<String>();
    String str = "";

    for (int i : num) {
      UserInfo.add(user.getUserItemString(i));
    }
    ////////////////////////////////////////////////////////////


    // Print Title
    str += String.format("%-3s ", "번호");
    for (int i : num) {
      str += String.format("%-10s ", UserInfo.get(i));
    }
    str += String.format("\n");


    // Print List
    for (int UserNo = 1; UserNo <= user.size(); UserNo++) {
      str += String.format("%-3s ", UserNo);
      for (int i : num) {
        str += String.format("%-10s ", user.getItem(UserNo, UserInfo.get(i)));
      }
      str += String.format("\n");
    }

    // Print Total
    System.out.print(str);
  }

  // 3. 조회
  private void print(int UserNo) {
    if (UserNo > 0) {
      for (int UserInfo = 0; UserInfo < user.size(UserNo); UserInfo++) {
        if (UserInfo == 2) {
          continue;
        }
        System.out.printf("%s: %s \n", user.getUserItemString(UserInfo),
            user.getItem(UserNo, UserInfo));
      }
    }
  }


  // 4. 변경
  private void edit(int UserNo) {
    if (UserNo > 0) {
      for (int UserInfo = 0; UserInfo < user.size(UserNo); UserInfo++) {
        System.out.printf("%s(%s)? ", //
            user.getUserItemString(UserInfo), // 수정할 정보 메뉴
            user.getItem(UserNo, UserInfo) // 현재 저장된 정보
        );
        user.set(UserNo, UserInfo); // 수정
      }
    }

  }

  // 5. 삭제
  private void delete(int UserNo) {
    if (UserNo > 0) {
      user.remove(UserNo);
      System.out.println("삭제하였습니다.");
    }
  }

  // 회원 번호 유효 검사
  private boolean isValidateUser(int UserNo) {
    return UserNo > 0 && UserNo <= user.size();
  }

  // 회원 번호 있는지 확인
  private boolean checkUser(int UserNo) {
    if (isValidateUser(UserNo)) {
      return true;
    } else {
      System.out.printf("없는 %s입니다.\n", user.MenuName());
      return false;
    }
  }
  ///////////////////////////////////////////////////////////

}
