package bitcamp.myapp.app.vo;

import java.util.HashMap;

public class Team {
  private String name;
  HashMap<Integer, User> user = new HashMap<Integer, User>();
  // private User[] user;
  private int size = 0;

  // public Team(String name, User... user) {
  // this.Name = name;
  // this.user = user;
  // this.size = this.user.length;
  // }

  // default
  public Team() {

  }

  // name
  public Team(String name) {
    this.name = name;
  }

  // name+user
  public Team(String name, int num, User users) {
    this.name = name;

    HashMap<Integer, User> user1 = new HashMap<Integer, User>();
    user1.put(num, users);

    this.size += 1;
  }

  // name+HashUser
  public Team(String name, HashMap<Integer, User> users) {
    this.name = name;

    user.putAll(users);

    this.size += 1;
  }



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


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
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


}
