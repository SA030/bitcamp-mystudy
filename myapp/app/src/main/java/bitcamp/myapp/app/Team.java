package bitcamp.myapp.app;

import java.util.ArrayList;

public class Team {

  DataEdit team = new DataEdit();
  User user = new User();


  ///////////////////////////////////////////////////////////
  ////////////////////// Team Menu //////////////////////////
  ///////////////////////////////////////////////////////////

  public void menuTeam(int menuNo) {
    if (menuNo < team.getMenuArr().length - 1) {
      System.out.printf("[%s]\n", team.getMenuArr()[menuNo - 1]);
    }


    switch (menuNo) {
      case 1: // 등록
        add();
        break;
      case 2: // 목록
        printList(0);
        break;
      case 3: // 조회
        print(user.inputNo());
        break;
      case 4: // 변경
        edit(user.inputNo());
        break;
      case 5: // 삭제
        delete(user.inputNo());
        break;
      default:
        break;
    }
  }


  // 1. 등록
  private void add() {

    int teamNo = team.size();

    // 팀 번호 등록
    team.add();

    // 팀 등록
    System.out.printf("%s? ", team.getTeamItemString(0));
    team.add(teamNo);

    // 팀원 등록
    addUser(teamNo);

  }

  // 1-1. 팀원 등록
  private void addUser(int teamNo) {

    String item = "";

    for (;;) {
      System.out.printf("추가할 팀원 번호?(종료: 0) ");

      item = team.Scanner();
      if (item.equals("0")) {
        break;
      }
      if (user.checkUser(Integer.parseInt(item))) {
        if (team.getListArr().get(teamNo).indexOf(item) != -1) {
          System.out.printf("'%s'은 현재 팀원입니다.\n", team.getUserItem(item, 0));
        } else {
          team.add(teamNo, item);
          System.out.printf("'%s'을 추가했습니다.\n", team.getUserItem(item, 0));
        }
      }

    }

  }

  // 2. 목록
  private void printList(int... num) {
    // Title Copy //////////////////////////////////////////////
    ArrayList<String> teamItem = new ArrayList<String>();
    String str = "";

    for (int i : num) {
      teamItem.add(team.getTeamItemString(i));
    }
    ////////////////////////////////////////////////////////////


    // Print Title
    str += String.format("%-3s ", "N");
    for (int i : num) {
      str += String.format("%-10s ", teamItem.get(i));
    }
    str += String.format("\n");

    // Print list
    for (int teamNo = 1; teamNo <= team.size(); teamNo++) {
      str += String.format("%-3s ", teamNo);

      for (int i : num) {
        str += String.format("%-10s ", team.getItem(teamNo, teamItem.get(i)));
      }
      str += String.format("\n");
    }

    // Print Total
    System.out.print(str);
  }

  // 3. 조회
  private void print(int teamNo) {
    if (teamNo > 0) {
      // Print Team name
      System.out.printf("%s: %s \n", team.getTeamItemString(0), team.getItem(teamNo, 0));

      // Print Team user
      System.out.printf("%s \n", team.getTeamItemString(1));
      for (int teamItem = 1; teamItem < team.size(teamNo); teamItem++) {
        System.out.printf("- %s\n", team.getUserItem(team.getItem(teamNo, teamItem), 0));
      }

    }
  }

  // 3-1. 팀원 이름 조회
  private String printUserName(int teamNo, int teamItem) {
    String userNo = team.getItem(teamNo, teamItem);

    return team.getUserItem(userNo, 0);
  }

  // 4. 변경
  private void edit(int teamNo) {

    if (teamNo > 0) {
      // Edit Team name
      System.out.printf("%s(%s) ", //
          team.getTeamItemString(0), // 수정할 정보 메뉴
          team.getItem(teamNo, 0) // 현재 저장된 정보
      );
      team.set(teamNo, 0); // 수정

      // Delete Team user
      for (int TeamItem = 1; (TeamItem > 0) && (TeamItem < team.size(teamNo));) {
        TeamItem = deleteUser(teamNo, TeamItem);
      }

      // Add Team user
      addUser(teamNo - 1);

      // Edit End
      System.out.println("변경했습니다.");

    }

  }

  // 5. 삭제
  private void delete(int teamNo) {
    if (teamNo > 0) {
      team.remove(teamNo);
      System.out.println("삭제하였습니다.");
    }
  }

  // 5-1. 팀원 삭제
  private int deleteUser(int teamNo, int teamItem) {

    String ans;
    String user = printUserName(teamNo, teamItem);

    System.out.printf("%s 삭제(y/n)? ", user);

    ans = team.Scanner();

    // System.out.println(TeamItem);

    switch (ans) {
      case "y":
        System.out.printf("'%s' 팀원을 삭제합니다.\n", user);
        team.remove(teamNo, teamItem);
        return teamItem;
      case "n":
        System.out.printf("'%s' 팀원를 유지합니다.\n", user);
        return ++teamItem;
      default:
        System.out.printf("다시 입력해주세요.\n", user);
        return teamItem;
    }
  }



}
