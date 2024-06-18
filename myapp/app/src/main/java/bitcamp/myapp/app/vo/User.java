package bitcamp.myapp.app.vo;

public class User {

  private String name;
  private String email;
  private String password;
  private String tel;
  private int size = 4;

  public User(String name, String email, String password, String tel) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.tel = tel;
  }

  public User(String[] item) {
    this.name = item[0];
    this.email = item[1];
    this.password = item[2];
    this.tel = item[3];
  }

  public User() {

  }


  private static User user;

  public static User getInstance() {

    if (user == null) {
      user = new User();
    }

    return user;
  }

  public static void freeInstance() {
    user = null;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }



}
