package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import bitcamp.myapp.app.vo.Team;
import bitcamp.myapp.app.vo.User;

public class TeamMenu extends MenuExtends {

  private UserMenu user = UserMenu.getInstance();

  private Team team = Team.getInstance();

  private ArrayList<Team> TeamList = new ArrayList<Team>();

  ///////////////////////////////////////////////////////////
  ////////////////// private Instance User //////////////////
  ///////////////////////////////////////////////////////////
  private static TeamMenu TeamMenu;

  // setup User Instance
  public static TeamMenu getInstance() {

    if (TeamMenu == null) {
      TeamMenu = new TeamMenu();
    }

    return TeamMenu;
  }// Method getInstance END

  // reset User Instance
  public static void freeInstance() {
    TeamMenu = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  ////////////////////// Team Menu //////////////////////////
  ///////////////////////////////////////////////////////////
  public void menuTeam(int menuNo) {

    // switch (menuNo) {
    // case 1: // 등록
    // add();
    // break;
    // case 2: // 목록
    // printList();
    // break;
    // case 3: // 조회
    // print(user.inputSeqNo());
    // break;
    // case 4: // 변경
    // edit(user.inputSeqNo());
    // break;
    // case 5: // 삭제
    // delete(user.inputSeqNo());
    // break;
    // default:
    // break;
    // }

  }// Method menuTeam END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. 등록 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void add() {

    System.out.printf("%s? ", team.getTeamTitleString(0));
    Team newTeam = new Team(Scanner());
    TeamList.add(newTeam);
    addUser(newTeam);
  }// Method add END

  // 팀원 등록
  private void addUser(Team addTeam) {

    String ans;
    int userNo;
    HashMap<Integer, User> addUser;

    for (;;) {
      System.out.printf("추가할 팀원 번호?(종료: 0) ");
      ans = Scanner();

      // 0 입력 시 팀원 등록 종료
      if (ans.equals("0")) {
        break;
      }
      // 팀원 등록
      if (user.checkObject(Integer.parseInt(ans))) {
        userNo = Integer.parseInt(ans);
        addUser = addTeam.getUser();

        if (addUser.containsKey(userNo)) {
          // userNo 팀원 중복, 등록X
          System.out.printf("'%s'은 현재 팀원입니다.\n", addUser.get(userNo).getName());
        } else {
          // userNo 팀원 등록
          addTeam.setUser(userNo, user.getUser(userNo));
          System.out.printf("'%s'을 추가했습니다.\n", addUser.get(userNo).getName());
        }
      }

    }
  }// Method addUser END

  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. 목록 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void printList() {
    ArrayList<String> teamPublicTitle = getPublicTitle();
    ArrayList<String> teamPublicInfo;

    int numWidth = 3;
    int titleWidth = 10;
    String str = "";

    // 팀 정보 제목 출력
    str += printTitle(numWidth, titleWidth);

    // 팀 정보 출력
    for (int proNo = 1; proNo <= TeamList.size(); proNo++) {

      // 팀 번호
      str += formString(numWidth, proNo);
      // 팀 공개 정보
      for (int titleNo = 0; titleNo < teamPublicTitle.size(); titleNo++) {
        teamPublicInfo = getPublicItem(proNo);
        str += formString(titleWidth, teamPublicInfo.get(titleNo));
      }
      str += String.format("\n");

    }


    // Print Total
    System.out.print(str);
  }// Method printList END
   ///////////////////////////////////////////////////////////



  // Print Title
  private String printTitle(int numWidth, int titleWidth) {

    String str = "";

    // Title Copy
    ArrayList<String> teamItem = new ArrayList<String>();
    ArrayList<String> teamPublicTitle = getPublicTitle();

    for (int i = 0; i < teamPublicTitle.size(); i++) {
      teamItem.add(team.getTeamTitleString(i));
    }


    // N
    str += formString(numWidth, "N");
    // 팀 공개 정보
    for (int i = 0; i < teamItem.size(); i++) {
      str += formString(titleWidth, teamItem.get(i));
    }
    str += String.format("\n");

    return str;
  }// Method printTitle END


  ///////////////////////////////////////////////////////////
  ///////////////////////// 3. 조회 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void print(int teamNo) {
    String teamName = getTeam(teamNo).getName();
    Set<Integer> userName = getTeam(teamNo).getUser().keySet();


    if (teamNo > 0) {
      // Print Team name
      System.out.printf("%s: %s \n", team.getTeamTitleString(0), teamName);

      // Print Team user
      System.out.printf("%s \n", team.getTeamTitleString(1));
      for (Integer userNo : userName) {
        System.out.printf("- %s\n", printUserName(teamNo, userNo));
      }

    }
  }// Method print END

  // 팀원 이름 조회
  private String printUserName(int teamNo, int userNo) {
    return getTeam(teamNo).getUser().get(userNo).getName();
  }// Method printUserName END


  // 팀 공개 정보 Tile
  private ArrayList<String> getPublicTitle() {

    if (team != null) {
      return team.getPublicTeamTitle();
    }
    return null;
  }// Method getPublicTitle END

  // 팀 공개 정보
  private ArrayList<String> getPublicItem(int teamNo) {
    if (getTeam(teamNo) != null) {
      ArrayList<Integer> publicTeamItemNo = getTeam(teamNo).getPublicTeamItem();
      ArrayList<String> publicTeamItem = new ArrayList<String>();

      for (int itemNo = 0; itemNo < publicTeamItemNo.size(); itemNo++) {
        publicTeamItem.add(getTeam(teamNo).getItem(publicTeamItemNo.get(itemNo)));
      }

      return publicTeamItem;
    }
    return null;
  }// Method getPublicInfo END


  ///////////////////////////////////////////////////////////
  ///////////////////////// 4. 변경 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void edit(int teamNo) {

    if (teamNo > 0) {

      // Edit Team name
      System.out.printf("%s(%s) ", //
          team.getTeamTitleString(0), // 수정할 정보 메뉴
          getTeam(teamNo).getName() // 현재 저장된 정보
      );
      getTeam(teamNo).setName(Scanner()); // 수정

      // Delete Team user
      HashMap<Integer, User> editUser = getTeam(teamNo).getUser();
      ArrayList<Integer> editUserNo = new ArrayList<Integer>();
      int num;

      // 삭제할 팀원 정보
      for (Entry<Integer, User> userItem : editUser.entrySet()) {
        // System.out.println("key = " + userItem.getKey());
        num = deleteUser(teamNo, userItem.getKey());
        if (num > 0) {
          editUserNo.add(num);
        }
      }

      // 팀원 삭제
      for (int userNo : editUserNo) {
        getTeam(teamNo).getUser().remove(userNo);
      }

      // Add Team user
      addUser(getTeam(teamNo));

      // Edit End
      System.out.println("변경했습니다.");
    }

  }// Method edit END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 5. 삭제 /////////////////////////
  ///////////////////////////////////////////////////////////
  private void delete(int teamNo) {
    if (teamNo > 0) {
      removeTeam(teamNo);
      System.out.println("삭제하였습니다.");
    }
  }// Method delete END

  // 팀원 삭제
  private int deleteUser(int teamNo, int userNo) {

    String ans;
    String userName = printUserName(teamNo, userNo);

    while (true) {
      // 삭제 여부?
      System.out.printf("%s 삭제(y/n)? ", userName);
      ans = Scanner();

      switch (ans) {
        case "y":
          System.out.printf("'%s' 팀원을 삭제합니다.\n", userName);
          // data.getTeam(teamNo).getUser().remove(userNo);
          // System.out.printf("'%s' 팀원을 삭제했습니다.\n", userName);
          return userNo;
        case "n":
          System.out.printf("'%s' 팀원를 유지합니다.\n", userName);
          return 0;
        default:
          System.out.printf("다시 입력해주세요.\n", userName);
          continue;
      }
    }
  }// Method deleteUser END



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


  Team getTeam(int teamNo) {

    if (teamNo > 0) {
      return TeamList.get(teamNo - 1);
    }
    return null;
  }// Method getTeam END

  public void add(Team team) {
    TeamList.add(team);
  }

  public void removeTeam(int no) {
    TeamList.remove(no - 1);
  }


  public ArrayList<Team> getTeamList() {
    return TeamList;
  }

  public void setTeamList(ArrayList<Team> teamList) {
    TeamList = teamList;
  }

}// Class TeamMenu END