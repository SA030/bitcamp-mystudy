package bitcamp.myapp.app;

import java.util.ArrayList;
import java.util.Scanner;

public class DataList {
  private static DataList data;
  Scanner sc = new Scanner(System.in);

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


  public static DataList getInstance() {

    if (data == null) {
      data = new DataList();
    }

    return data;
  }

  public static void freeInstance() {
    data = null;
  }

}
