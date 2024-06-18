package bitcamp.myapp.app;

import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.util.Menu;

public class DummyData {
  DataEdit data = DataEdit.getInstance();
  Menu menu = Menu.getInstance();


  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////

  public void addDummy() {
    menu.setCurrent(1);
    addUserDummy();
    menu.setCurrent(2);
    addTeamDummy();
    menu.setCurrent(0);
  }

  // 미리 회원 추가(5명 A~F)
  private void addUserDummy() {
    for (int userNo = 0; userNo < 6; userNo++) {
      data.add();
      for (int userItem = 0; userItem < 4; userItem++) {
        data.add(userNo, String.format("%c", 'A' + userNo));
      }
    }
  }

  // 미리 팀 추가(2팀 ABC/DEF)
  private void addTeamDummy() {
    for (int teamNo = 0; teamNo < 2; teamNo++) {
      data.add();
      for (int teamItem = 0; teamItem <= 3; teamItem++) {
        if (teamItem == 0) {
          data.add(teamNo,
              String.format("%c%c%c", 'A' + (3 * teamNo), 'B' + (3 * teamNo), 'C' + (3 * teamNo)));
          continue;
        }

        data.add(teamNo, String.format("%d", teamItem + (3 * teamNo)));
      }
    }
  }
}
