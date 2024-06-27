package bitcamp.myapp.app.vo;

import java.util.ArrayList;
import java.util.HashMap;
import bitcamp.myapp.app.util.SubMenu.VoList;
import bitcamp.myapp.app.util.Title;

public class User implements VoList {

  public Title title = new Title(1);

  private int seqNo = 0;
  private String name;
  private String email;
  private String password;
  private String tel;



  ///////////////////////////////////////////////////////////
  ////////////////// User Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // default
  public User() {
    seqNo += seqNo;
  }

  // name+info
  public User(String name, String email, String password, String tel) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.tel = tel;

    seqNo += seqNo;
  }

  // item
  public User(String[] item) {
    this.name = item[0];
    this.email = item[1];
    this.password = item[2];
    this.tel = item[3];

    seqNo += seqNo;
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

  @Override
  public String getItem(int itemNo) {
    switch (itemNo) {
      case 0:
        return String.format("%d", getSeqNo());
      case 1:
        return getName();
      case 2:
        return getEmail();
      case 3:
        return getPassword();
      case 4:
        return getTel();
      default:
        return null;
    }
  }// Method getItem END


  @Override
  public void setItem(int itemNo, String userItem) {
    switch (itemNo) {
      case 0:
        setSeqNo(Integer.parseInt(userItem));
        break;
      case 1:
        setName(userItem);
        break;
      case 2:
        setEmail(userItem);
        break;
      case 3:
        setPassword(userItem);
        break;
      case 4:
        setTel(userItem);
        break;
    }
  }// Method setItem END

  ///////////////////////////////////////////////////////////

  @Override
  public int getSeqNo() {
    return this.seqNo;
  }

  @Override
  public void setSeqNo(int seqNo) {
    this.seqNo = seqNo;
  }

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


  ///////////////// title /////////////////////

  public int getSize() {
    return title.getTitleArrSize();
  }

  public String getUserTitleString(int userItem) {
    return title.getTitleString(userItem);
  }

  public ArrayList<String> getPublicUserTitle() {
    return title.getPublicTitle();
  }

  public ArrayList<Integer> getPublicUserItem() {
    return title.getPublicTitleNo();
  }

  @Override
  public void setMembers(int seqNo, User members) {
    // TODO Auto-generated method stub

  }

  @Override
  public HashMap<Integer, User> getMembers() {
    // TODO Auto-generated method stub
    return null;
  }

}// Class User END
