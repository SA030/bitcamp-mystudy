package bitcamp.myapp.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {

  Scanner sc = new Scanner(System.in);
  DataEdit team = new DataEdit();

  /** 1. 팀원 추가할 때 숫자가 아니면 error 표시 */
  /** 2. 팀원 추가할 때 없는 사람은 없다고 표시 후 저장x */
  /** 3. User에서 중복되는 코드 정리 */


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
        print(inputNo());
        break;
      case 4: // 변경
        edit(inputNo());
        break;
      case 5: // 삭제
        delete(inputNo());
        break;
      default:
        break;
    }
  }


  // 번호 입력
  private int inputNo() {
    String ans;
    int num;

    System.out.printf("%s 번호? ", team.MenuName());
    ans = sc.nextLine();
    num = Integer.parseInt(ans);

    return checkUser(num) ? num : 0;
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
      item = sc.nextLine();
      if (item.equals("0")) {
        break;
      }
      team.add(teamNo, item);
    }

  }

  // 2. 목록
  private void printList(int... num) {
    // Title Copy //////////////////////////////////////////////
    ArrayList<String> TeamItem = new ArrayList<String>();
    String str = "";

    for (int i : num) {
      TeamItem.add(team.getTeamItemString(i));
    }
    ////////////////////////////////////////////////////////////


    // Print Title
    str += String.format("%-3s ", "번호");
    for (int i : num) {
      str += String.format("%-10s ", TeamItem.get(i));
    }
    str += String.format("\n");

    // Print list
    for (int TeamNo = 1; TeamNo <= team.size(); TeamNo++) {
      str += String.format("%-3s ", TeamNo);

      for (int i : num) {
        str += String.format("%-10s ", team.getItem(TeamNo, TeamItem.get(i)));
      }
      str += String.format("\n");
    }

    // Print Total
    System.out.print(str);
  }

  // 3. 조회
  private void print(int TeamNo) {
    if (TeamNo > 0) {
      // Print Team name
      System.out.printf("%s: %s \n", team.getTeamItemString(0), team.getItem(TeamNo, 0));

      // Print Team user
      System.out.printf("%s \n", team.getTeamItemString(1));
      for (int TeamItem = 1; TeamItem < team.size(TeamNo); TeamItem++) {
        System.out.printf("- %s\n", printUser(TeamNo, TeamItem));
      }

    }
  }

  // 3-1. 팀원 조회
  private String printUser(int TeamNo, int TeamItem) {
    String userNo = team.getItem(TeamNo, TeamItem);
    String user = team.getUserItem(userNo, 0);

    return team.getUserItem(user, 0);
  }

  // 4. 변경
  private void edit(int TeamNo) {

    if (TeamNo > 0) {
      // Edit Team name
      System.out.printf("%s(%s) ", //
          team.getTeamItemString(0), // 수정할 정보 메뉴
          team.getItem(TeamNo, 0) // 현재 저장된 정보
      );
      team.set(TeamNo, 0); // 수정

      // Delete Team user
      for (int TeamItem = 1; TeamItem < team.size(TeamNo);) {
        TeamItem = deleteUser(TeamNo, TeamItem);
      }

      // Add Team user
      addUser(TeamNo - 1);

      // Edit End
      System.out.println("변경했습니다.");

    }

  }

  // 5. 삭제
  private void delete(int TeamNo) {
    if (TeamNo > 0) {
      team.remove(TeamNo);
      System.out.println("삭제하였습니다.");
    }
  }

  // 5-1. 유저 삭제
  private int deleteUser(int TeamNo, int TeamItem) {
    String ans;
    String user = printUser(TeamNo, TeamItem);

    System.out.printf("%s 삭제(y/n)? ", user);
    ans = sc.nextLine();

    switch (ans) {
      case "y":
        System.out.printf("'%s' 팀원을 삭제합니다.\n", user);
        team.remove(TeamNo, TeamItem);
        return TeamItem--;
      case "n":
        System.out.printf("'%s' 팀원를 유지합니다.\n", user);
        return TeamItem++;
      default:
        System.out.printf("다시 입력해주세요.\n", user);
        return TeamItem;
    }
  }



  // 번호 유효 검사
  private boolean isValidateUser(int TeamNo) {
    return TeamNo > 0 && TeamNo <= team.size();
  }

  // 번호 있는지 확인
  private boolean checkUser(int TeamNo) {
    if (isValidateUser(TeamNo)) {
      return true;
    } else {
      System.out.printf("없는 %s입니다.\n", team.MenuName());
      return false;
    }
  }
  ///////////////////////////////////////////////////////////

}
