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


  /////////////////////// Data Edit ////////////////////////
  public int objectSize() {

    switch (menu.getCurrent()) {
      case 1:
        return user.getSize();
      case 2:
        return team.getMemberSize();
      case 3:
        return pro.getMemberSize();
      default:
        return 0;
    }
  }

  public int getArrSize() {
    return getListArr().size();
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
