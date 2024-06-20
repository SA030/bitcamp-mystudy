package bitcamp.myapp.app.util;

import java.util.ArrayList;

public class Title {


  /********************************************************/

  private ArrayList<AccessTitle> setUserTitle() {

    ArrayList<AccessTitle> userTitle = new ArrayList<AccessTitle>();

    userTitle.add(new AccessTitle("No", 1)); // 0
    userTitle.add(new AccessTitle("Name", 1)); // 1
    userTitle.add(new AccessTitle("Email", 1)); // 2
    userTitle.add(new AccessTitle("PW", 0)); // 3
    userTitle.add(new AccessTitle("Tel", 1)); // 4

    return userTitle;
  }// Method setUserTitle END


  private ArrayList<AccessTitle> setTeamTitle() {

    ArrayList<AccessTitle> teamTitle = new ArrayList<AccessTitle>();

    teamTitle.add(new AccessTitle("Team_Name", 1)); // 0
    teamTitle.add(new AccessTitle("User", 0)); // 1

    return teamTitle;
  }// Method setTeamTitle END


  private ArrayList<AccessTitle> setProjectTitle() {

    ArrayList<AccessTitle> projectTitle = new ArrayList<AccessTitle>();

    projectTitle.add(new AccessTitle("No", 1)); // 0
    projectTitle.add(new AccessTitle("Project_Name", 1)); // 1
    projectTitle.add(new AccessTitle("Description", 1)); // 2
    projectTitle.add(new AccessTitle("Start(YYYY-MM-DD)", 1)); // 3
    projectTitle.add(new AccessTitle("End(YYYY-MM-DD)", 1)); // 4
    projectTitle.add(new AccessTitle("User", 0)); // 5

    return projectTitle;
  }// Method setProjectTitle END

  /********************************************************/



  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  /////////////////////// Class Title ///////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////// ---------- ///////////////////////
  ////////////////////////// ------ /////////////////////////
  //////////////////////////// -- ///////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////



  ArrayList<AccessTitle> titleArr;
  private final int titleArrSize;

  public Title(int menuNo) {

    switch (menuNo) {
      case 1:
        this.titleArr = setUserTitle();
        break;
      case 2:
        this.titleArr = setTeamTitle();
        break;
      case 3:
        this.titleArr = setProjectTitle();
        break;
      default:
        this.titleArr = new ArrayList<AccessTitle>();
        break;
    }

    this.titleArrSize = titleArr.size();
  }


  ///////////////////////////////////////////////////////////
  ////////////////// private Instance ///////////////////////
  ///////////////////////////////////////////////////////////

  private static Title title;

  public static Title getInstance(int menuNo) {

    if (title == null) {
      title = new Title(menuNo);
    }

    return title;
  }

  public static void freeInstance() {
    title = null;
  }



  ///////////////////////////////////////////////////////////
  ///////////////// accessTitle Constructor /////////////////
  ///////////////////////////////////////////////////////////
  public class AccessTitle {
    String title = "";
    int access = 0;

    private AccessTitle(String title, int access) {
      this.title = title;
      this.access = access;
    }

    public String getTitle() {
      return title;
    }

    public int getAccess() {
      return access;
    }

  }// Class accessTitle END



  ///////////////////////////////////////////////////////////
  /////////////////////// Item getter ///////////////////////
  ///////////////////////////////////////////////////////////

  // get Title (Int->String)
  public String getTitleString(int itemNo) {

    if (itemNo >= 0) {
      return titleArr.get(itemNo).getTitle();
    }
    return null;
  }// Method getItemString END

  // get Title (String->Int)
  public int getTitleInt(String item) {

    for (int size = 0; size < titleArrSize; size++) {
      if (getTitleString(size).equals(item)) {
        return size;
      }
    }
    return -1;
  }// Method getItemInt END



  ///////////////////////////////////////////////////////////
  /////////////////// public Item getter ////////////////////
  ///////////////////////////////////////////////////////////
  // get public Title
  public ArrayList<String> getPublicTitle() {

    ArrayList<String> publicTitle = new ArrayList<String>();

    for (int itemNo = 0; itemNo < titleArrSize; itemNo++) {
      if (titleArr.get(itemNo).getAccess() != 0) {
        publicTitle.add(getTitleString(itemNo));
      }
    }

    return publicTitle;
  }// Method getPublicTitle END



  // get public Item
  public ArrayList<Integer> getPublicTitleNo() {

    ArrayList<Integer> publicItem = new ArrayList<Integer>();

    for (int itemNo = 0; itemNo < titleArrSize; itemNo++) {
      if (titleArr.get(itemNo).getAccess() != 0) {
        publicItem.add(getTitleInt(getTitleString(itemNo)));
      }
    }

    return publicItem;
  }// Method getPublicItem END

  public ArrayList<AccessTitle> getTitleArr() {
    return titleArr;
  }

  public int getTitleArrSize() {
    return titleArrSize;
  }



}
