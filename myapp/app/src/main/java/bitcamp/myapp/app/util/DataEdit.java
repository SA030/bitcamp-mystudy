package bitcamp.myapp.app.util;

import java.util.ArrayList;
import java.util.Scanner;
import bitcamp.myapp.app.vo.Project;
import bitcamp.myapp.app.vo.Team;
import bitcamp.myapp.app.vo.User;

public class DataEdit {
  Scanner sc = new Scanner(System.in);
  User user = User.getInstance();
  Team team = Team.getInstance();
  Project pro = Project.getInstance();

  Menu menu = Menu.getInstance();
  int current = menu.getCurrent();

  // private ArrayList<ArrayList<String>> UserList = new ArrayList<ArrayList<String>>();
  // [A][B]
  // A: User Number(0~...)
  // B0: User Name
  // B1: Email
  // B2: PassWord
  // B3: Phone number
  private ArrayList<User> UserList = new ArrayList<User>();

  // private ArrayList<ArrayList<String>> TeamList = new ArrayList<ArrayList<String>>();
  // [A][B]
  // A: Team Number(0~...)
  // B0: Team Name
  // B1...: User number(1~...)
  private ArrayList<Team> TeamList = new ArrayList<Team>();
  private ArrayList<Project> ProjectList = new ArrayList<Project>();



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


  public ArrayList<?> getListArr() {
    switch (menu.getCurrent()) {
      case 1:
        return UserList;
      case 2:
        return TeamList;
      case 3:
        return ProjectList;
      default:
        return null;
    }
  }

  public String Scanner() {
    String ans = sc.nextLine();

    return ans;
  }

  ////////////////////////////////////// USER ///////////////////////////////////////
  // 멤버 정보 Int->String
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


  ////////////////////////////////////// Team ///////////////////////////////////////
  // 팀 정보 Int->String
  public String getTeamItemString(int teamItem) {
    switch (teamItem) {
      case 0:
        return "Team Name";
      default:
        return "User";
    }
  }

  // 팀 정보 String->Int
  public int getTeamItemInt(String teamItem) {
    switch (teamItem) {
      case "Team Name":
        return 0;
      default:
        return -1;
    }
  }

  /////////////////////////////////// PROJECT ////////////////////////////////////
  // 프로젝트 정보 Int->String
  public String getProItemString(int proItem) {
    switch (proItem) {
      case 0:
        return "Project Name";
      case 1:
        return "Account";
      case 2:
        return "Start(YYYY-MM-DD)";
      case 3:
        return "End(YYYY-MM-DD)";
      default:
        return "User";
    }
  }

  // 프로젝트 정보 String->Int
  public int getProItemInt(String proItem) {
    switch (proItem) {
      case "Project Name":
        return 0;
      case "Account":
        return 1;
      case "Start(YYYY-MM-DD)":
        return 2;
      case "End(YYYY-MM-DD)":
        return 3;
      default:
        return -1;
    }
  }

  ///////////////////////////// Data Edit ///////////////////////////////////////
  public int objectSize() {

    switch (menu.getCurrent()) {
      case 1:
        return user.getSize();
      case 2:
        return team.getSize();
      case 3:
        return pro.getSize();
      default:
        return 0;
    }
  }

  public int arrSize() {
    return getListArr().size();
  }

  public User getUser(int no) {
    return UserList.get(no - 1);
  }

  public Team getTeam(int no) {
    return TeamList.get(no - 1);
  }

  public Project getPro(int no) {
    return ProjectList.get(no - 1);
  }
  // public String getItem(int no, int item) {
  // return getListArr().get(no - 1).get(item);
  // }
  //
  // public String getItem(int no, String item) {
  // Menu menu = Menu.getInstance();
  // int current = menu.getCurrent();
  //
  // switch (current) {
  // case 1:
  // return getListArr().get(no - 1).get(getUserItemInt(item));
  // case 2:
  // return getListArr().get(no - 1).get(getTeamItemInt(item));
  // default:
  // return null;
  // }
  // }
  //
  //
  // public String getUserItem(int no, int item) {
  // try {
  // return this.UserList.get(no - 1).get(item);
  // } catch (IndexOutOfBoundsException e) {
  // return null;
  // }
  // }
  //
  // public String getUserItem(String no, int item) {
  // try {
  // return this.UserList.get(Integer.parseInt(no) - 1).get(item);
  // } catch (IndexOutOfBoundsException e) {
  // return null;
  // }
  // }

  public int userSize() {
    return UserList.size();
  }


  // public void add(int no) {
  // getListArr().get(no).add(Scanner());
  // }

  public void add(User user) {
    UserList.add(user);
  }

  public void add(Team team) {
    TeamList.add(team);
  }

  public void add(Project project) {
    ProjectList.add(project);
  }

  public void remove(int no) {
    getListArr().remove(no - 1);
  }

  // public void remove(int no, int item) {
  // getListArr().get(no - 1).remove(item);
  // }

  // public void set(int no, int item) {
  // getListArr().get(no - 1).set(item, Scanner());
  // }

  public void set(int no) {

    switch (menu.getCurrent()) {
      case 1:
        User user = UserList.get(no);
        user.setName(Scanner());
        user.setEmail(Scanner());
        user.setPassword(Scanner());
        user.setTel(Scanner());
        break;
      case 2:
        Team team = TeamList.get(no);
        team.setName(Scanner());
        break;
      case 3:
        Project pro = ProjectList.get(no);
        pro.setName(Scanner());
        pro.setAccount(Scanner());
        pro.setStart(Scanner());
        pro.setEnd(Scanner());
        break;
    }

  }

  public ArrayList<User> getUserList() {
    return UserList;
  }

  public void setUserList(ArrayList<User> userList) {
    UserList = userList;
  }

  public ArrayList<Team> getTeamList() {
    return TeamList;
  }

  public void setTeamList(ArrayList<Team> teamList) {
    TeamList = teamList;
  }



}
