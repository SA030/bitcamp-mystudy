package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.util.Menu;
import bitcamp.myapp.app.vo.User;

public class UserMenu {

  private DataEdit data = DataEdit.getInstance();
  private User user = User.getInstance();

  ///////////////////////////////////////////////////////////
  ////////////////// private Instance User //////////////////
  ///////////////////////////////////////////////////////////
  private static UserMenu userMenu;

  // setup User Instance
  public static UserMenu getInstance() {

    if (userMenu == null) {
      userMenu = new UserMenu();
    }

    return userMenu;
  }// Method getInstance END

  // reset User Instance
  public static void freeInstance() {
    userMenu = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  //////////////////////// User Menu ////////////////////////
  ///////////////////////////////////////////////////////////

  public void menuUser(int menuNo) {

    switch (menuNo) {
      case 1: // 등록
        add();
        break;
      case 2: // 목록
        printList();
        break;
      case 3: // 조회
        print(inputUserNo());
        break;
      case 4: // 변경
        edit(inputUserNo());
        break;
      case 5: // 삭제
        delete(inputUserNo());
        break;
      default:
        break;
    }

  }// Method menuUser END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. 등록 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void add() {

    String[] item = new String[4];

    // User 정보 등록
    for (int UserItem = 0; UserItem < user.getSize(); UserItem++) {
      System.out.printf("%s? ", user.getUserItemString(UserItem));
      item[UserItem] = data.Scanner();
    }
    data.add(new User(item));
  }// Method add END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. 목록 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void printList() {

    ArrayList<String> userPublicInfo;

    int numWidth = 3;
    int titleWidth = 10;
    String str = "";

    // N Name Email Phone
    str += printTitle(numWidth);


    // 1 A A A
    // 2 B B B
    // 3 C C C
    for (int UserNo = 1; UserNo <= data.arrSize(); UserNo++) {
      userPublicInfo = getPublicItem(UserNo);

      // 회원 번호
      str += formString(numWidth, UserNo);
      // 회원 공개 정보
      for (int userInfo = 0; userInfo < userPublicInfo.size(); userInfo++) {
        str += formString(titleWidth, userPublicInfo.get(userInfo));
      }
      str += String.format("\n");
    }

    // Print Total
    System.out.print(str);
  }// Method printList END
   ///////////////////////////////////////////////////////////


  // Print Title
  private String printTitle(int numWidth) {

    // Copy Title List
    ArrayList<String> userPublicTitle = getPublicTitle();

    String str = "";

    // N
    str += formString(numWidth, "N");
    // 회원 공개 정보 Title
    for (int i = 0; i < userPublicTitle.size(); i++) {
      str += formString(10, userPublicTitle.get(i));
    }
    str += String.format("\n");

    return str;
  }// Method printTitle END

  // Title 간격 조정
  private String formString(int width, String text) {
    return String.format("%-" + width + "s", text);
  }// Method formString END

  private String formString(int width, int text) {
    return String.format("%-" + width + "d", text);
  }// Method formString END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 3. 조회 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void print(int userNo) {

    String str = "";

    ArrayList<String> userPublicTitle = getPublicTitle();
    ArrayList<String> userPublicInfo = getPublicItem(userNo);

    if (userPublicInfo != null) {
      for (int i = 0; i < userPublicInfo.size(); i++) {
        // 유저 공개 정보 Title
        str += formString(5, userPublicTitle.get(i));
        str += (": ");
        // 유저 공개 정보
        str += formString(5, userPublicInfo.get(i));
        str += String.format("\n");
      }

      System.out.print(str);
    }
  }// Method print END


  // 회원 공개 정보 Tile
  private ArrayList<String> getPublicTitle() {

    if (user != null) {
      return user.getPublicUserTitle();
    }
    return null;
  }// Method getPublicTitle END

  // 회원 공개 정보
  private ArrayList<String> getPublicItem(int UserNo) {
    if (getUser(UserNo) != null) {
      return getUser(UserNo).getPublicUserItem();
    }
    return null;
  }// Method getPublicInfo END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 4. 변경 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void edit(int UserNo) {

    User user = getUser(UserNo);

    if (user != null) {
      for (int itemNo = 0; itemNo < user.getSize(); itemNo++) {
        System.out.printf("%s(%s)? ", user.getUserItemString(itemNo), user.getItem(itemNo));
        user.setItem(itemNo, data.Scanner());
      }
    }
  }// Method edit END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 5. 삭제 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void delete(int UserNo) {

    if (UserNo > 0) {
      data.remove(UserNo);
      System.out.println("삭제하였습니다.");
    }
  }// Method delete END



  ///////////////////////////////////////////////////////////
  //////////////////////// get User /////////////////////////
  ///////////////////////////////////////////////////////////
  // 회원 번호 유효 검사
  private boolean isValidateUser(int UserNo) {
    return UserNo > 0 && UserNo <= data.userSize();
  }// Method isValidateUser END

  // 회원 번호 있는지 확인
  boolean checkUser(int UserNo) {

    if (isValidateUser(UserNo)) {
      return true;
    } else {
      System.out.printf("없는 회원입니다.\n");
      return false;
    }
  }// Method checkUser END

  // 회원 번호 입력
  int inputUserNo() {

    Menu menu = Menu.getInstance();
    String ans;
    int num;

    System.out.printf("%s 번호? ", menu.getMenuName());

    ans = data.Scanner();
    num = Integer.parseInt(ans);

    return checkUser(num) ? num : 0;
  }// Method inputUserNo END

  // 회원 정보 가져오기
  User getUser(int UserNo) {

    if (UserNo > 0) {
      return data.getUser(UserNo);
    }
    return null;
  }// Method getUser END


}// Class UserMenu END
