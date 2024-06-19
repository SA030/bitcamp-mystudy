package bitcamp.myapp.app.submenu;

import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.util.Menu;
import bitcamp.myapp.app.vo.Team;

public class BoardMenu {

  DataEdit data = DataEdit.getInstance();
  UserMenu user = UserMenu.getInstance();

  Team team = Team.getInstance();


  ///////////////////////////////////////////////////////////
  ////////////////////// Team Menu //////////////////////////
  ///////////////////////////////////////////////////////////

  public void menuTeam(int menuNo) {

    Menu menu = Menu.getInstance();

    if (menuNo < menu.getMenuArr().length - 1) {
      System.out.printf("[%s]\n", menu.getMenuArr()[menuNo - 1]);
    }


    switch (menuNo) {
      case 1: // 등록
        add();
        break;
      case 2: // 목록
        printList(0);
        break;
      case 3: // 조회
        print(user.inputUserNo());
        break;
      case 4: // 변경
        edit(user.inputUserNo());
        break;
      case 5: // 삭제
        delete(user.inputUserNo());
        break;
      default:
        break;
    }
  }


  // 1. 등록
  private void add() {

  }

  // 1-1. 팀원 등록
  private void addUser(Team addTeam) {

  }

  // 2. 목록
  private void printList(int... num) {

  }

  // 3. 조회
  private void print(int teamNo) {

  }

  // 3-1. 팀원 이름 조회
  private void printUserName(int teamNo, int userNo) {

  }

  // 4. 변경
  private void edit(int teamNo) {


  }

  // 5. 삭제
  private void delete(int teamNo) {


  }

  // 5-1. 팀원 삭제
  private void deleteUser(int teamNo, int userNo) {

  }



}
