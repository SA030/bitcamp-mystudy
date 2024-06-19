package bitcamp.myapp.app.util;

import java.util.ArrayList;

public class Title {

  /********************************************************/

  private ArrayList<accessTitle> setUserTitle() {

    ArrayList<accessTitle> userTitle = new ArrayList<accessTitle>();

    userTitle.add(new accessTitle("Name", 1));
    userTitle.add(new accessTitle("Email", 1));
    userTitle.add(new accessTitle("PW", 0));
    userTitle.add(new accessTitle("Tel", 1));

    return userTitle;
  }// Method setTitle END

  /********************************************************/

  ///////////////////////////////////////////////////////////
  ////////////////// private Instance ///////////////////////
  ///////////////////////////////////////////////////////////

  private static Title title;

  public static Title getInstance() {

    if (title == null) {
      title = new Title();
    }

    return title;
  }

  public static void freeInstance() {
    title = null;
  }



  ///////////////////////////////////////////////////////////
  //////////////////////// Title ////////////////////////////
  ///////////////////////////////////////////////////////////

  ArrayList<accessTitle> userTitle = setUserTitle();
  private final int userTitleSize = userTitle.size();



  ////////////////// Title Constructor //////////////////////
  public class accessTitle {
    String title = "";
    int access = 0;

    private accessTitle(String title, int access) {
      this.title = title;
      this.access = access;
    }

    public String getTitle() {
      return title;
    }

    public int getAccess() {
      return access;
    }

  }// Class Title END

  //////////////////// Item getter ////////////////////////

  // get Title (Int->String)
  public String getItemString(int userItem) {

    if (userItem >= 0) {
      return userTitle.get(userItem).getTitle();
    }
    return null;
  }// Method getItemString END

  // get Title (String->Int)
  public int getItemInt(String userItem) {

    for (int sz = 0; sz < userTitle.size(); sz++) {
      if (getItemString(sz).equals(userItem)) {
        return sz;
      }
    }
    return -1;
  }// Method getItemInt END



  ///////////////// public Item getter /////////////////////
  // get public Title
  public ArrayList<String> getPublicTitle() {

    ArrayList<String> publicTitle = new ArrayList<String>();

    for (int item = 0; item < userTitle.size(); item++) {
      if (userTitle.get(item).getAccess() != 0) {
        publicTitle.add(getItemString(item));
      }
    }

    return publicTitle;
  }// Method getPublicTitle END

  // get public Item
  public ArrayList<String> getPublicItem(String item) {

    ArrayList<String> publicItem = new ArrayList<String>();

    for (int itemNo = 0; itemNo < userTitle.size(); itemNo++) {
      if (userTitle.get(itemNo).getAccess() != 0) {
        publicItem.add(item);
      }
    }

    return publicItem;
  }// Method getPublicItem END

  public ArrayList<accessTitle> getUserTitle() {
    return userTitle;
  }

  public int getUserTitleSize() {
    return userTitleSize;
  }



}
