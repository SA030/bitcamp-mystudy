package bitcamp.myapp.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
  private static Data data;

  Scanner sc = new Scanner(System.in);
  int current = 0;

  String[] mainMenu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
  String[][] subMenu = { //
      {"등록1", "목록", "조회", "변경", "삭제", "이전"}, // 1. 회원
      {"등록2", "목록", "조회", "변경", "삭제", "이전"}, // 2. 팀
      {"등록3", "목록", "조회", "변경", "삭제", "이전"}, // 3.프로젝트
      {"등록4", "목록", "조회", "변경", "삭제", "이전"}, // 4. 게시판
      {"등록5", "목록", "조회", "변경", "삭제", "이전"} // 5. 도움말
  };
  ArrayList<ArrayList<String>> UserList = new ArrayList<ArrayList<String>>();
  ArrayList<ArrayList<String>> TeamList = new ArrayList<ArrayList<String>>();


  public static Data getInstance() {

    if (data == null) {
      data = new Data();
    }

    return data;
  }

  public static void freeInstance() {
    data = null;
  }


  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////

  public void addDummy() {
    addUserDummy();
    addTeamDummy();
  }

  // 미리 회원 추가(5명 A~F)
  private void addUserDummy() {
    for (int userNo = 0; userNo < 6; userNo++) {
      this.UserList.add(new ArrayList<String>());
      for (int userItem = 0; userItem < 4; userItem++) {
        this.UserList.get(userNo).add(String.format("%c", 'A' + userNo));
      }
    }
  }

  // 미리 팀 추가(2팀 ABC/DEF)
  private void addTeamDummy() {
    for (int teamNo = 0; teamNo < 2; teamNo++) {
      this.TeamList.add(new ArrayList<String>());
      for (int teamItem = 0; teamItem <= 3; teamItem++) {
        if (teamItem == 0) {
          this.TeamList.get(teamNo).add(
              String.format("%c%c%c", 'A' + (3 * teamNo), 'B' + (3 * teamNo), 'C' + (3 * teamNo)));
          continue;
        }

        this.TeamList.get(teamNo).add(String.format("%d", teamItem + (3 * teamNo)));
      }
    }
  }



  // //////////////////////////////////////////////////////////////////////////////////////
  // //////////////////////////////////////////////////////////////////////////////////////
  // //////////////////////////////////////////////////////////////////////////////////////
  // //////////////////////////////////////////////////////////////////////////////////////
  //
  //
  //
  // String[] getMenuArr() {
  //
  // if (getCurrent() == 0) {
  // return this.mainMenu;
  // } else {
  // return this.subMenu[getCurrent() - 1];
  // }
  // }
  //
  // ArrayList<ArrayList<String>> getListArr() {
  //
  // switch (getCurrent()) {
  // case 1:
  // return this.UserList;
  // case 2:
  // return this.TeamList;
  // default:
  // return null;
  // }
  // }
  //
  // String MenuName() {
  //
  // return this.mainMenu[getCurrent() - 1];
  // }
  //
  //
  //
  // /////////////////////////////////////////////// USER ///////////////////////////////////////
  // // public 멤버 정보 Int->String
  // public String getUserItemString(int userItem) {
  // switch (userItem) {
  // case 0:
  // return "Name";
  // case 1:
  // return "Email";
  // case 2:
  // return "PW";
  // case 3:
  // return "Phone";
  // default:
  // return null;
  // }
  // }
  //
  // // 멤버 정보 String->Int
  // public int getUserItemInt(String userItem) {
  // switch (userItem) {
  // case "Name":
  // return 0;
  // case "Email":
  // return 1;
  // case "PW":
  // return 2;
  // case "Phone":
  // return 3;
  // default:
  // return -1;
  // }
  // }
  //
  //
  // public String Scanner() {
  // String ans = sc.nextLine();
  //
  // return ans;
  // }
  //
  //
  // ///////////////////////////////////////////// Current ///////////////////////////////////////
  // public int getCurrent() {
  // return this.current;
  // }
  //
  // public void setCurrent(int current) {
  // this.current = current;
  // }
  //
  //
  // /////////////////////////////////////////////// Team ///////////////////////////////////////
  // // public 멤버 정보 Int->String
  // public String getTeamItemString(int teamItem) {
  // switch (teamItem) {
  // case 0:
  // return "Team-Name";
  // default:
  // return "User";
  // }
  // }
  //
  // // 멤버 정보 String->Int
  // public int getTeamItemInt(String teamItem) {
  // switch (teamItem) {
  // case "Team-Name":
  // return 0;
  // default:
  // return 1;
  // }
  // }
  //
  //
  // /////////////////////////////////////////////// Data Edit
  // ///////////////////////////////////////
  // public int size() {
  // return getListArr().size();
  // }
  //
  // public int size(int no) {
  // return getListArr().get(no - 1).size();
  // }
  //
  // public String getItem(int no, int item) {
  // return getListArr().get(no - 1).get(item);
  // }
  //
  // public String getItem(int no, String item) {
  // int current = getCurrent();
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
  //
  // public int userSize() {
  // return this.UserList.size();
  // }
  //
  // public void add() {
  // getListArr().add(new ArrayList<String>());
  // }
  //
  // public void add(int no) {
  // getListArr().get(no).add(Scanner());
  // }
  //
  // public void add(int No, int item) {
  // getListArr().get(No).add(String.format("%d", item));
  // }
  //
  // public void add(int no, String item) {
  // getListArr().get(no).add(item);
  // }
  //
  // public void remove(int no) {
  // getListArr().remove(no - 1);
  // }
  //
  // public void remove(int no, int item) {
  // getListArr().get(no - 1).remove(item);
  // }
  //
  // public void set(int no, int item) {
  // getListArr().get(no - 1).set(item, Scanner());
  // }

}
