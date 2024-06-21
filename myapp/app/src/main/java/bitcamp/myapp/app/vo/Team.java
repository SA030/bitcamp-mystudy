package bitcamp.myapp.app.vo;

import java.util.ArrayList;
import java.util.HashMap;
import bitcamp.myapp.app.util.Title;

public class Team {

  public Title title = new Title(2);

  private int seqNo = 0;
  private String name;
  HashMap<Integer, User> members = new HashMap<Integer, User>();
  private int memberSize = 0;



  ///////////////////////////////////////////////////////////
  ////////////////// Team Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // default
  public Team() {
    seqNo += seqNo;
  }

  // name
  public Team(String name) {
    this.name = name;

    seqNo += seqNo;

  }

  // name+user
  public Team(String name, int num, User members) {
    this.name = name;

    HashMap<Integer, User> newMembers = new HashMap<Integer, User>();
    newMembers.put(num, members);

    this.memberSize += 1;
    seqNo += seqNo;
  }

  // name+HashUser
  public Team(String name, HashMap<Integer, User> members) {
    this.name = name;

    this.members.putAll(members);

    this.memberSize += 1;
    seqNo += seqNo;
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
        return String.format("%d", getSeqNo());
      case 1:
        return getName();
      default:
        return null;
    }
  }// Method getItem END


  public void setItem(int itemNo, String userItem) {
    switch (itemNo) {
      case 0:
        setSeqNo(Integer.parseInt(userItem));
        break;
      case 1:
        setName(userItem);
        break;
      default:
        return;
    }
  }// Method setItem END


  public int getSeqNo() {
    return seqNo;
  }

  public void setSeqNo(int seqNo) {
    this.seqNo = seqNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HashMap<Integer, User> getMembers() {
    return members;
  }

  public User getMembers(int userNo) {
    return members.get(userNo);
  }

  public void setMembers(HashMap<Integer, User> members) {
    this.members.putAll(members);;
  }

  public void setMembers(int members, User user) {
    this.members.put(members, user);
    this.memberSize += 1;
  }

  public int getMemberSize() {
    return memberSize;
  }

  public void setMemberSize(int memberSize) {
    this.memberSize = memberSize;
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
