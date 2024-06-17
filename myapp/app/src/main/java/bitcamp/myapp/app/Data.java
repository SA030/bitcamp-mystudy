package bitcamp.myapp.app;

import java.util.ArrayList;

public class Data {
  private static Data data;


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
}
