package bitcamp.myapp.app.vo;

import java.util.HashMap;

public class Project {

  private String title;
  private String description;
  private String startDate;
  private String endDate;
  HashMap<Integer, User> members = new HashMap<Integer, User>();
  private int membertSize = 0;

  public Project() {

  }

  public Project(String title) {
    this.title = title;
  }

  public Project(String title, String description, String startDate, String endDate) {
    this.title = title;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Project(String[] item) {
    this.title = item[0];
    this.description = item[1];
    this.startDate = item[2];
    this.endDate = item[3];
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

  public HashMap<Integer, User> getMembers() {
    return members;
  }

  public void setMembers(HashMap<Integer, User> members) {
    this.members.putAll(members);;
  }

  public void setMembers(int members, User user) {
    this.members.put(members, user);
    this.membertSize += 1;
  }

  public int getMemberSize() {
    return membertSize;
  }

  public void setMemberSize(int membertSize) {
    this.membertSize = membertSize;
  }

}
