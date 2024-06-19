package bitcamp.myapp.app.vo;

import java.util.ArrayList;
import bitcamp.myapp.app.util.Title;

public class User {

  public Title title = Title.getInstance();

  private String name;
  private String email;
  private String password;
  private String tel;



  ///////////////////////////////////////////////////////////
  ////////////////// User Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // default
  public User() {

  }

  // name+info
  public User(String name, String email, String password, String tel) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.tel = tel;
  }

  // item
  public User(String[] item) {
    this.name = item[0];
    this.email = item[1];
    this.password = item[2];
    this.tel = item[3];
  }


  ///////////////////////////////////////////////////////////
  ////////////////// private Instance ///////////////////////
  ///////////////////////////////////////////////////////////

  private static User user;

  public static User getInstance() {

    if (user == null) {
      user = new User();
    }

    return user;
  }

  public static void freeInstance() {
    user = null;
  }

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

  ///////////////////////////////////////////////////////////
  ///////////////// Item getter, setter /////////////////////
  ///////////////////////////////////////////////////////////

  public String getItem(int itemNo) {
    switch (itemNo) {
      case 0:
        return getName();
      case 1:
        return getEmail();
      case 2:
        return getPassword();
      case 3:
        return getTel();
      default:
        return null;
    }
  }// Method getItem END


  public void setItem(int itemNo, String userItem) {
    switch (itemNo) {
      case 0:
        setName(userItem);
      case 1:
        setEmail(userItem);
      case 2:
        setPassword(userItem);
      case 3:
        setTel(userItem);
    }
  }// Method setItem END

  ///////////////////////////////////////////////////////////


  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  ///////////////////////////////////////////////////////////

  public int getSize() {
    return title.getUserTitleSize();
  }

  public String getUserItemString(int userItem) {
    return title.getItemString(userItem);
  }

  public ArrayList<String> getPublicUserTitle() {
    return title.getPublicTitle();
  }

  public ArrayList<String> getPublicUserItem() {
    return title.getPublicItem(getName());
  }


}// Class User END
