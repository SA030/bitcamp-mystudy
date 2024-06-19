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

  private ArrayList<User> UserList = new ArrayList<User>();
  private ArrayList<Team> TeamList = new ArrayList<Team>();
  private ArrayList<Project> ProjectList = new ArrayList<Project>();



  ///////////////////////////////////////////////////////////
  //////////////// private Instance DataEdit ////////////////
  ///////////////////////////////////////////////////////////
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



  ///////////////////////////////////////////////////////////
  ///////////////////// Get Update List /////////////////////
  ///////////////////////////////////////////////////////////
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



  ///////////////////////////////////////////////////////////
  ///////////////////////// Scanner /////////////////////////
  ///////////////////////////////////////////////////////////
  public String Scanner() {
    String ans = sc.nextLine();

    return ans;
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
        return pro.getMemberSize();
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



  public int userSize() {
    return UserList.size();
  }

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
        pro.setTitle(Scanner());
        pro.setDiscription(Scanner());
        pro.setStartDate(Scanner());
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
