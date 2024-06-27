package bitcamp.myapp.app.submenu;


import java.util.ArrayList;
import bitcamp.myapp.app.util.SubMenu;
import bitcamp.myapp.app.vo.Team;

public class TeamMenu extends SubMenu {

  private Team team = Team.getInstance();
  private ArrayList<Team> TeamList = new ArrayList<Team>();


  /********************************************************/

  Format teamrForm = new Format(3, 20);

  /********************************************************/

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
  public void menu(int menuNo) {
    menuProject(menuNo, TEAM, team, TeamList);
  }


  public void menuProject(int menuNo, int titleNo, Team team, ArrayList<Team> TeamList) {

    switch (menuNo) {
      case 1: // 등록
        add(titleNo, new Team(), TeamList);
        break;
      case 2: // 목록
        printList(titleNo, team, TeamList, teamrForm);
        break;
      case 3: // 조회
        print(titleNo, team, TeamList);
        break;
      case 4: // 변경
        edit(titleNo, team, TeamList);
        break;
      case 5: // 삭제
        delete(titleNo, TeamList);
        break;
      default:
        break;
    }
  }// Method menuProject END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. 등록 /////////////////////////
  ///////////////////////////////////////////////////////////
  protected void add(int objNo, Team obj, ArrayList<Team> objList) {

    int seqNo = addObject(objNo, obj, objList, 1);
    objList.add(obj);
    obj.setSeqNo(objList.size());

    // 팀원 등록
    if (objNo != 1) {
      addMember(objNo, seqNo);
    }
  }// Method Project Add END

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

  // 팀 가져오기
  public Team getTeam(int teamNo) {
    if (teamNo > 0) {
      for (int listNo = 0; listNo < TeamList.size(); listNo++) {
        if (TeamList.get(listNo).getSeqNo() == teamNo) {
          return TeamList.get(listNo);
        }
      }
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
