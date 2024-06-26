package bitcamp.myapp.app.vo;

import java.util.ArrayList;
import java.util.HashMap;
import bitcamp.myapp.app.util.SubMenu.VoList;
import bitcamp.myapp.app.util.Title;

public class Project implements VoList {

  public Title protitle = new Title(3);

  private int seqNo = 0;
  private String title;
  private String description;
  private String startDate;
  private String endDate;
  HashMap<Integer, User> members = new HashMap<Integer, User>();
  private int memberSize = 0;



  ///////////////////////////////////////////////////////////
  ///////////////// Project Constructor /////////////////////
  ///////////////////////////////////////////////////////////
  public Project() {
    seqNo += seqNo;
  }

  public Project(String title) {
    this.title = title;

    seqNo += seqNo;
  }

  public Project(String title, String description, String startDate, String endDate) {
    this.title = title;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;

    seqNo += seqNo;
  }

  public Project(String[] item) {
    this.title = item[0];
    this.description = item[1];
    this.startDate = item[2];
    this.endDate = item[3];

    seqNo += seqNo;
  }



  ///////////////////////////////////////////////////////////
  ////////////////// private Instance ///////////////////////
  ///////////////////////////////////////////////////////////

  private static Project pro;

  public static Project getInstance() {

    if (pro == null) {
      pro = new Project();
    }

    return pro;
  }

  public static void freeInstance() {
    pro = null;
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
        return getTitle();
      case 2:
        return getDiscription();
      case 3:
        return getStartDate();
      case 4:
        return getEndDate();
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
        setTitle(userItem);
        break;
      case 2:
        setDiscription(userItem);
        break;
      case 3:
        setStartDate(userItem);
        break;
      case 4:
        setEnd(userItem);
        break;
      default:
        return;
    }
  }// Method setItem END


  @Override
  public int getSeqNo() {
    return seqNo;
  }

  @Override
  public void setSeqNo(int seqNo) {
    this.seqNo = seqNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDiscription() {
    return description;
  }

  public void setDiscription(String description) {
    this.description = description;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEnd(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public HashMap<Integer, User> getMembers() {
    return members;
  }

  public User getMembers(int userNo) {
    return members.get(userNo);
  }

  public void setMembers(HashMap<Integer, User> members) {
    this.members.putAll(members);;
  }

  @Override
  public void setMembers(int seqNo, User user) {
    this.members.put(seqNo, user);
    this.memberSize += 1;
    // System.out.println("seqNo:" + seqNo + " user:" + user.getName() + " members:" +
    // this.members);
  }

  public int getMemberSize() {
    return memberSize;
  }

  public void setMemberSize(int memberSize) {
    this.memberSize = memberSize;
  }

  ///////////////// title /////////////////////

  public int getSize() {
    return protitle.getTitleArrSize();
  }

  public String getProTitleString(int userItem) {
    return protitle.getTitleString(userItem);
  }

  public ArrayList<String> getPublicProTitle() {
    return protitle.getPublicTitle();
  }

  public ArrayList<Integer> getPublicProItem() {
    return protitle.getPublicTitleNo();
  }


}
