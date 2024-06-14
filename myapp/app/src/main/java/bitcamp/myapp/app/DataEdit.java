package bitcamp.myapp.app;

import java.util.ArrayList;
import java.util.Scanner;

public class DataEdit {
  Scanner sc = new Scanner(System.in);
  DataList data = DataList.getInstance();

  String[] getMenuArr() {
    Menu mn = Menu.getInstance();
    int current = mn.current;

    if (current == 0) {
      return data.mainMenu;
    } else {
      return data.subMenu[current - 1];
    }
  }

  ArrayList<ArrayList<String>> getListArr() {
    Menu mn = Menu.getInstance();
    int current = mn.current;

    switch (current) {
      case 1:
        return data.UserList;
      case 2:
        return data.TeamList;
      default:
        return null;
    }
  }

  String MenuName() {
    Menu mn = Menu.getInstance();
    int current = mn.current;

    return data.mainMenu[current - 1];
  }

  /////////////////////////////////////////////// USER ///////////////////////////////////////
  // public 멤버 정보 Int->String
  public String getUserItemString(int UserInfo) {
    switch (UserInfo) {
      case 0:
        return "이름";
      case 1:
        return "이메일";
      case 2:
        return "암호";
      case 3:
        return "연락처";
      default:
        return null;
    }
  }

  // 멤버 정보 String->Int
  public int getUserItemInt(String UserInfo) {
    switch (UserInfo) {
      case "이름":
        return 0;
      case "이메일":
        return 1;
      case "암호":
        return 2;
      case "연락처":
        return 3;
      default:
        return -1;
    }
  }


  /////////////////////////////////////////////// Team ///////////////////////////////////////
  // public 멤버 정보 Int->String
  public String getTeamItemString(int TeamInfo) {
    switch (TeamInfo) {
      case 0:
        return "팀명";
      default:
        return "팀원";
    }
  }

  // 멤버 정보 String->Int
  public int getTeamItemInt(String TeamInfo) {
    switch (TeamInfo) {
      case "팀명":
        return 0;
      default:
        return 1;
    }
  }


  /////////////////////////////////////////////// Data Edit ///////////////////////////////////////
  public int size() {
    return getListArr().size();
  }

  public int size(int No) {
    return getListArr().get(No - 1).size();
  }

  public String getItem(int No, int Item) {
    return getListArr().get(No - 1).get(Item);
  }

  public String getItem(int No, String Item) {
    Menu mn = Menu.getInstance();
    int current = mn.current;

    switch (current) {
      case 1:
        return getListArr().get(No - 1).get(getUserItemInt(Item));
      case 2:
        return getListArr().get(No - 1).get(getTeamItemInt(Item));
      default:
        return null;
    }
  }

  public String getUserItem(int No, int Item) {
    return data.UserList.get(No - 1).get(Item);
  }

  public String getUserItem(String No, int Item) {
    return data.UserList.get(Integer.parseInt(No) - 1).get(Item);
  }

  public void add() {
    getListArr().add(new ArrayList<String>());
  }

  public void add(int No) {
    getListArr().get(No).add(sc.nextLine());
  }

  public void add(int No, String Item) {
    getListArr().get(No).add(Item);
  }

  public void remove(int No) {
    getListArr().remove(No - 1);
  }

  public void remove(int No, int Item) {
    getListArr().get(No - 1).remove(Item);
  }

  public void set(int No, int Item) {
    getListArr().get(No - 1).set(Item, sc.nextLine());
  }
}
