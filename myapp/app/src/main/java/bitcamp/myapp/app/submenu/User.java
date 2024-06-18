package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.util.Menu;

public class User {

  DataEdit data = DataEdit.getInstance();


  ///////////////////////////////////////////////////////////
  ////////////////////// static User ////////////////////////
  ///////////////////////////////////////////////////////////
  private static User user;

  // setup User Instance
  public static User getInstance() {

    if (user == null) {
      user = new User();
    }

    return user;
  }

  // reset User Instance
  public static void freeInstance() {
    user = null;
  }

  ///////////////////////////////////////////////////////////
  //////////////////////// User Menu ////////////////////////
  ///////////////////////////////////////////////////////////

  public void menuUser(int menuNo) {

    Menu menu = Menu.getInstance();

    if (menuNo < menu.getMenuArr().length - 1) {
      System.out.printf("[%s]\n", menu.getMenuArr()[menuNo - 1]);
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
  protected int inputNo() {

    Menu menu = Menu.getInstance();
    String ans;
    int num;

    System.out.printf("%s 번호? ", menu.MenuName());

    ans = data.Scanner();
    num = Integer.parseInt(ans);

    return checkUser(num) ? num : 0;
  }

  // 1. 등록
  private void add() {

    int UserNo = data.size();
    // User 번호 등록
    data.add();

    // User 정보 등록
    for (int UserInfo = 0; UserInfo < 4; UserInfo++) {
      System.out.printf("%s? ", data.getUserItemString(UserInfo));
      data.add(UserNo);
    }
  }

  // 2. 목록
  private void printList(int... num) {
    // Title Copy //////////////////////////////////////////////
    ArrayList<String> UserInfo = new ArrayList<String>();
    String str = "";

    for (int i : num) {
      UserInfo.add(data.getUserItemString(i));
    }
    ////////////////////////////////////////////////////////////


    // Print Title
    str += String.format("%-3s ", "N");
    for (int i : num) {
      str += String.format("%-10s ", UserInfo.get(i));
    }
    str += String.format("\n");


    // Print List
    for (int UserNo = 1; UserNo <= data.size(); UserNo++) {
      str += String.format("%-3s ", UserNo);
      for (int i : num) {
        str += String.format("%-10s ", data.getItem(UserNo, UserInfo.get(i)));
      }
      str += String.format("\n");
    }

    // Print Total
    System.out.print(str);
  }

  // 3. 조회
  private void print(int UserNo) {
    if (UserNo > 0) {
      for (int UserInfo = 0; UserInfo < data.size(UserNo); UserInfo++) {
        if (UserInfo == 2) {
          continue;
        }
        System.out.printf("%s: %s \n", data.getUserItemString(UserInfo),
            data.getItem(UserNo, UserInfo));
      }
    }
  }

  // 4. 변경
  private void edit(int UserNo) {
    if (UserNo > 0) {
      for (int UserInfo = 0; UserInfo < data.size(UserNo); UserInfo++) {
        System.out.printf("%s(%s)? ", //
            data.getUserItemString(UserInfo), // 수정할 정보 메뉴
            data.getItem(UserNo, UserInfo) // 현재 저장된 정보
        );
        data.set(UserNo, UserInfo); // 수정
      }
    }

  }

  // 5. 삭제
  private void delete(int UserNo) {
    if (UserNo > 0) {
      data.remove(UserNo);
      System.out.println("삭제하였습니다.");
    }
  }

  // 회원 번호 유효 검사
  private boolean isValidateUser(int UserNo) {
    return UserNo > 0 && UserNo <= data.userSize();
  }

  // 회원 번호 있는지 확인
  protected boolean checkUser(int UserNo) {
    if (isValidateUser(UserNo)) {
      return true;
    } else {
      System.out.printf("없는 회원입니다.\n");
      return false;
    }
  }
  ///////////////////////////////////////////////////////////

}
