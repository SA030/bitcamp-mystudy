package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import bitcamp.myapp.app.util.SubMenu;
import bitcamp.myapp.app.vo.User;

public class UserMenu extends SubMenu {


  private User user = User.getInstance();
  private ArrayList<User> UserList = new ArrayList<User>();



  /********************************************************/

  Format userForm = new Format(3, 15);

  /********************************************************/



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
  public void menu(int menuNo) {
    menuUser(menuNo, USER, user, UserList);
  }

  public void menuUser(int menuNo, int titleNo, User user, ArrayList<User> UserList) {

    switch (menuNo) {
      case 1: // 등록
        add(titleNo, new User(), UserList);
        break;
      case 2: // 목록
        printList(titleNo, user, UserList, userForm);
        break;
      case 3: // 조회
        print(titleNo, user, UserList);
        break;
      case 4: // 변경
        edit(titleNo, user, UserList);
        break;
      case 5: // 삭제
        delete(titleNo, UserList);
        break;
      default:
        break;
    }

  }// Method menuUser END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. 등록 /////////////////////////
  ///////////////////////////////////////////////////////////
  protected void add(int objNo, User obj, ArrayList<User> objList) {
    addObject(objNo, obj, objList, 1);
    objList.add(obj);
    obj.setSeqNo(objList.size());

  }// Method User Add END



  ///////////////////////////////////////////////////////////
  ///////////////// public getter, setter ///////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////// ---------- ///////////////////////
  ////////////////////////// ------ /////////////////////////
  //////////////////////////// -- ///////////////////////////
  ///////////////////////////////////////////////////////////

  // 회원 가져오기
  public User getUser(int UserNo) {

    if (UserNo > 0) {
      for (int listNo = 0; listNo < UserList.size(); listNo++) {
        if (UserList.get(listNo).getSeqNo() == UserNo) {
          return UserList.get(listNo);
        }
      }
    }
    return null;
  }// Method getUser END

  public int userSize() {
    return UserList.size();
  }

  public void add(User user) {
    UserList.add(user);
  }

  public ArrayList<User> getUserList() {
    return UserList;
  }

  public void setUserList(ArrayList<User> userList) {
    UserList = userList;
  }

}// Class UserMenu END
