package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.util.Menu;
import bitcamp.myapp.app.vo.User;

public class UserMenu {

  DataEdit data = DataEdit.getInstance();
  User user = User.getInstance();


  ///////////////////////////////////////////////////////////
  ////////////////////// static User ////////////////////////
  ///////////////////////////////////////////////////////////
  private static UserMenu userMenu;

  // setup User Instance
  public static UserMenu getInstance() {

    if (userMenu == null) {
      userMenu = new UserMenu();
    }

    return userMenu;
  }

  // reset User Instance
  public static void freeInstance() {
    userMenu = null;
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

    String[] item = new String[4];
    // int UserNo = data.size();
    //
    // // User 번호 등록
    // data.add();
    //
    // // User 정보 등록
    // for (int UserInfo = 0; UserInfo < 4; UserInfo++) {
    // System.out.printf("%s? ", data.getUserItemString(UserInfo));
    // data.add(UserNo);
    // }

    // User 정보 등록
    for (int UserItem = 0; UserItem < 4; UserItem++) {
      System.out.printf("%s? ", data.getUserItemString(UserItem));
      item[UserItem] = data.Scanner();
    }
    data.add(new User(item));
  }

  // 2. 목록
  private void printList(int... num) {

    String name, email, tel;

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
    // for (int UserNo = 1; UserNo <= data.size(); UserNo++) {
    // str += String.format("%-3s ", UserNo);
    // for (int i : num) {
    // str += String.format("%-10s ", data.getItem(UserNo, UserInfo.get(i)));
    // }
    // str += String.format("\n");
    // }
    for (int UserNo = 1; UserNo <= data.arrSize(); UserNo++) {

      name = data.getUser(UserNo).getName();
      email = data.getUser(UserNo).getEmail();
      tel = data.getUser(UserNo).getTel();

      str += String.format("%-3s ", UserNo);
      str += String.format("%-10s %-10s %-10s \n", name, email, tel);
    }

    // Print Total
    System.out.print(str);
  }

  // 3. 조회
  private void print(int UserNo) {
    String name, email, tel;

    if (UserNo > 0) {
      name = data.getUser(UserNo).getName();
      email = data.getUser(UserNo).getEmail();
      tel = data.getUser(UserNo).getTel();

      System.out.printf("%s: %s \n", data.getUser(0), name);
      System.out.printf("%s: %s \n", data.getUser(1), email);
      System.out.printf("%s: %s \n", data.getUser(2), tel);

    }
  }

  // 4. 변경
  private void edit(int UserNo) {
    // if (UserNo > 0) {
    // for (int UserInfo = 0; UserInfo < data.size(UserNo); UserInfo++) {
    // System.out.printf("%s(%s)? ", //
    // data.getUserItemString(UserInfo), // 수정할 정보 메뉴
    // data.getItem(UserNo, UserInfo) // 현재 저장된 정보
    // );
    // data.set(UserNo, UserInfo); // 수정
    // }
    // }

    if (UserNo > 0) {
      System.out.printf("%s(%s)? ", data.getUserItemString(0), data.getUser(UserNo).getName()); // 이름
      data.getUser(UserNo).setName(data.Scanner());;
      System.out.printf("%s(%s)? ", data.getUserItemString(1), data.getUser(UserNo).getEmail()); // 이메일
      data.getUser(UserNo).setEmail(data.Scanner());;
      System.out.printf("%s(%s)? ", data.getUserItemString(2), data.getUser(UserNo).getPassword()); // 비밀번호
      data.getUser(UserNo).setPassword(data.Scanner());;
      System.out.printf("%s(%s)? ", data.getUserItemString(3), data.getUser(UserNo).getTel()); // 전화번호
      data.getUser(UserNo).setTel(data.Scanner());;
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
