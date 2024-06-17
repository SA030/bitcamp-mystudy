package bitcamp.myapp.app;

import java.util.ArrayList;
import java.util.Scanner;

public class DataEdit {
  Data data = Data.getInstance();
  Scanner sc = new Scanner(System.in);



  String[] getMenuArr() {

    if (getCurrent() == 0) {
      return data.mainMenu;
    } else {
      return data.subMenu[getCurrent() - 1];
    }
  }

  ArrayList<ArrayList<String>> getListArr() {

    switch (getCurrent()) {
      case 1:
        return data.UserList;
      case 2:
        return data.TeamList;
      default:
        return null;
    }
  }

  String MenuName() {

    return data.mainMenu[getCurrent() - 1];
  }



  /////////////////////////////////////////////// USER ///////////////////////////////////////
  // public 멤버 정보 Int->String
  public String getUserItemString(int userItem) {
    switch (userItem) {
      case 0:
        return "Name";
      case 1:
        return "Email";
      case 2:
        return "PW";
      case 3:
        return "Phone";
      default:
        return null;
    }
  }

  // 멤버 정보 String->Int
  public int getUserItemInt(String userItem) {
    switch (userItem) {
      case "Name":
        return 0;
      case "Email":
        return 1;
      case "PW":
        return 2;
      case "Phone":
        return 3;
      default:
        return -1;
    }
  }


  public String Scanner() {
    String ans = sc.nextLine();

    return ans;
  }


  ///////////////////////////////////////////// Current ///////////////////////////////////////
  public int getCurrent() {
    return data.current;
  }

  public void setCurrent(int current) {
    data.current = current;
  }


  /////////////////////////////////////////////// Team ///////////////////////////////////////
  // public 멤버 정보 Int->String
  public String getTeamItemString(int teamItem) {
    switch (teamItem) {
      case 0:
        return "Team-Name";
      default:
        return "User";
    }
  }

  // 멤버 정보 String->Int
  public int getTeamItemInt(String teamItem) {
    switch (teamItem) {
      case "Team-Name":
        return 0;
      default:
        return 1;
    }
  }


  /////////////////////////////////////////////// Data Edit ///////////////////////////////////////
  public int size() {
    return getListArr().size();
  }

  public int size(int no) {
    return getListArr().get(no - 1).size();
  }

  public String getItem(int no, int item) {
    return getListArr().get(no - 1).get(item);
  }

  public String getItem(int no, String item) {
    int current = getCurrent();

    switch (current) {
      case 1:
        return getListArr().get(no - 1).get(getUserItemInt(item));
      case 2:
        return getListArr().get(no - 1).get(getTeamItemInt(item));
      default:
        return null;
    }
  }


  public String getUserItem(int no, int item) {
    try {
      return data.UserList.get(no - 1).get(item);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public String getUserItem(String no, int item) {
    try {
      return data.UserList.get(Integer.parseInt(no) - 1).get(item);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public int userSize() {
    return data.UserList.size();
  }

  public void add() {
    getListArr().add(new ArrayList<String>());
  }

  public void add(int no) {
    getListArr().get(no).add(Scanner());
  }

  public void add(int No, int item) {
    getListArr().get(No).add(String.format("%d", item));
  }

  public void add(int no, String item) {
    getListArr().get(no).add(item);
  }

  public void remove(int no) {
    getListArr().remove(no - 1);
  }

  public void remove(int no, int item) {
    getListArr().get(no - 1).remove(item);
  }

  public void set(int no, int item) {
    getListArr().get(no - 1).set(item, Scanner());
  }
}
