package bitcamp.myapp.app.vo;

import java.util.ArrayList;
import java.util.HashMap;
import bitcamp.myapp.app.util.Title;

public class Team {

  public Title title = new Title(2);

  private String name;
  HashMap<Integer, User> user = new HashMap<Integer, User>();
  private int memberSize = 0;



  ///////////////////////////////////////////////////////////
  ////////////////// Team Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // default
  public Team() {

  }

  // name
  public Team(String name) {
    this.name = name;

  }

  // name+user
  public Team(String name, int num, User users) {
    this.name = name;

    HashMap<Integer, User> user1 = new HashMap<Integer, User>();
    user1.put(num, users);

    this.memberSize += 1;
  }

  // name+HashUser
  public Team(String name, HashMap<Integer, User> users) {
    this.name = name;

    user.putAll(users);

    this.memberSize += 1;
  }


  ///////////////////////////////////////////////////////////
  ////////////////// private Instance ///////////////////////
  ///////////////////////////////////////////////////////////

  private static Team team;

  public static Team getInstance() {

    if (team == null) {
      team = new Team();
    }

    return team;
  }

  public static void freeInstance() {
    team = null;
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
      default:
        return null;
    }
  }// Method getItem END


  public void setItem(int itemNo, String userItem) {
    switch (itemNo) {
      case 0:
        setName(userItem);
    }
  }// Method setItem END

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMemberSize() {
    return memberSize;
  }

  public void setMemberSize(int size) {
    this.memberSize = size;
  }

  public HashMap<Integer, User> getUser() {
    return user;
  }

  public void setUser(HashMap<Integer, User> user) {
    this.user.putAll(user);;
  }

  public void setUser(int num, User user) {
    this.user.put(num, user);
    this.memberSize += 1;
  }
  ///////////////// title /////////////////////

  // public int getSize() {
  // return title.getUserTitleSize();
  // }

  public String getTeamTitleString(int teamItem) {
    return title.getTitleString(teamItem);
  }

  public ArrayList<String> getPublicTeamTitle() {
    return title.getPublicTitle();
  }

  public ArrayList<Integer> getPublicTeamItem() {
    return title.getPublicTitleNo();
  }

}
