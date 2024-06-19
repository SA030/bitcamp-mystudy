package bitcamp.myapp.app;

import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.util.Menu;
import bitcamp.myapp.app.vo.Project;
import bitcamp.myapp.app.vo.Team;
import bitcamp.myapp.app.vo.User;

public class DummyData {
  DataEdit data = DataEdit.getInstance();
  Menu menu = Menu.getInstance();
  User user = User.getInstance();
  Team team = Team.getInstance();


  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////

  public void addDummy() {
    menu.setCurrent(1);
    addUserDummy();
    menu.setCurrent(2);
    addTeamDummy();
    menu.setCurrent(3);
    addProjectDummy();
    menu.setCurrent(0);
  }

  // 미리 회원 추가(5명 A~F)
  private void addUserDummy() {
    String users;

    for (int userNo = 0; userNo < 6; userNo++) {
      users = String.format("%c", 'A' + userNo);
      data.add(new User(users, users, users, users));
    }
  }

  // 미리 팀 추가(2팀 ABC/DEF)
  private void addTeamDummy() {
    String teamName;

    for (int teamNo = 0; teamNo < 2; teamNo++) {

      Team team = new Team();
      teamName =
          String.format("%c%c%c", 'A' + (3 * teamNo), 'B' + (3 * teamNo), 'C' + (3 * teamNo));

      team.setName(teamName);
      team.setUser(1 + (3 * teamNo), data.getUser(1 + (3 * teamNo)));// A
      team.setUser(2 + (3 * teamNo), data.getUser(2 + (3 * teamNo)));// B
      team.setUser(3 + (3 * teamNo), data.getUser(3 + (3 * teamNo)));// C

      data.add(team); //
    }
  }



  // 미리 프로젝트 추가(2팀 ABC/DEF, 2024-06-18~2024-11-29)
  private void addProjectDummy() {
    String proName;

    for (int proNo = 0; proNo < 2; proNo++) {

      Project pro = new Project();
      proName = String.format("%c%c%c", 'A' + (3 * proNo), 'B' + (3 * proNo), 'C' + (3 * proNo));

      pro.setTitle(proName);
      pro.setDiscription(proName);
      pro.setStartDate("2024-06-18");
      pro.setEnd("2024-11-29");
      pro.setMembers(1 + (3 * proNo), data.getUser(1 + (3 * proNo)));// A
      pro.setMembers(2 + (3 * proNo), data.getUser(2 + (3 * proNo)));// B
      pro.setMembers(3 + (3 * proNo), data.getUser(3 + (3 * proNo)));// C

      data.add(pro); //
    }
  }
}
