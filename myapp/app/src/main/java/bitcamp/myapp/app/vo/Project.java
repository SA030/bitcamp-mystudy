package bitcamp.myapp.app.vo;

import java.util.HashMap;

public class Project {

  private String name;
  private String account;
  private String start;
  private String end;
  HashMap<Integer, User> user = new HashMap<Integer, User>();
  private int size = 0;

  public Project() {

  }

  public Project(String name) {
    this.name = name;
  }

  public Project(String name, String account, String start, String end) {
    this.name = name;
    this.account = account;
    this.start = start;
    this.end = end;
  }

  public Project(String[] item) {
    this.name = item[0];
    this.account = item[1];
    this.start = item[2];
    this.end = item[3];
  }


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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public HashMap<Integer, User> getUser() {
    return user;
  }

  public void setUser(HashMap<Integer, User> user) {
    this.user.putAll(user);;
  }

  public void setUser(int num, User user) {
    this.user.put(num, user);
    this.size += 1;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

}
