package bitcamp.myapp.app.util;

import java.util.ArrayList;
import java.util.Scanner;

public class DataEdit {
  Scanner sc = new Scanner(System.in);

  private ArrayList<ArrayList<String>> UserList = new ArrayList<ArrayList<String>>();
  // [A][B]
  // A: User Number(0~...)
  // B0: User Name
  // B1: Email
  // B2: PassWord
  // B3: Phone number
  private ArrayList<ArrayList<String>> TeamList = new ArrayList<ArrayList<String>>();
  // [A][B]
  // A: Team Number(0~...)
  // B0: Team Name
  // B1...: User number(1~...)

  private static DataEdit data;

  public static DataEdit getInstance() {

    if (data == null) {
      data = new DataEdit();
    }

    return data;
  }

  public static void freeInstance() {
    data = null;
  }



  public ArrayList<ArrayList<String>> getListArr() {
    Menu menu = Menu.getInstance();
    int current = menu.getCurrent();

    switch (current) {
      case 1:
        return this.UserList;
      case 2:
        return this.TeamList;
      default:
        return null;
    }
  }



  ////////////////////////////////////// USER ///////////////////////////////////////
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



  ////////////////////////////////////// Team ///////////////////////////////////////
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


  ///////////////////////////// Data Edit ///////////////////////////////////////
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
    Menu menu = Menu.getInstance();
    int current = menu.getCurrent();

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
      return this.UserList.get(no - 1).get(item);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public String getUserItem(String no, int item) {
    try {
      return this.UserList.get(Integer.parseInt(no) - 1).get(item);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public int userSize() {
    return this.UserList.size();
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
