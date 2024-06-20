package bitcamp.myapp.app.util;

import bitcamp.myapp.app.submenu.ProjectMenu;
import bitcamp.myapp.app.submenu.TeamMenu;
import bitcamp.myapp.app.submenu.UserMenu;

public class Menu {
  private int current = 0;

  private String[] mainMenu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
  private String[][] subMenu = { //
      {"등록1", "목록", "조회", "변경", "삭제", "이전"}, // 1. 회원
      {"등록2", "목록", "조회", "변경", "삭제", "이전"}, // 2. 팀
      {"등록3", "목록", "조회", "변경", "삭제", "이전"}, // 3.프로젝트
      {"등록4", "목록", "조회", "변경", "삭제", "이전"}, // 4. 게시판
      {"등록5", "목록", "조회", "변경", "삭제", "이전"} // 5. 도움말
  };
  ///////////////////////////////////////////////////////////
  ////////////////////// static Menu ////////////////////////
  ///////////////////////////////////////////////////////////
  private static Menu m;

  // setup Menu Instance
  public static Menu getInstance() {

    if (m == null) {
      m = new Menu();
    }

    return m;
  }// Method getInstance END

  // reset Menu Instance
  public static void freeInstance() {
    m = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  ////////////////////// Process Menu ///////////////////////
  ///////////////////////////////////////////////////////////
  // command: Home(menu)으로 이동
  public void processMenu(String command) {
    switch (command) {
      case "menu":
        this.current = 0;
        break;
      case "exit":
        this.current = -1;
        break;
      default:
        this.current = processMenuInt(command);
        break;
    }
  }// Method processMenu END

  // command: 유효 메뉴 번호 검사
  private int processMenuInt(String command) {

    int ans = Integer.parseInt(command);
    String menuTitle = getMenuTitle(ans);


    if (menuTitle == null) {
      System.out.println("[ERROR] 유효한 메뉴 번호가 아닙니다.");
      return (this.current);
    } else {
      printSubMenu(ans);
      int a = changeCurrent(ans);
      return a;

    }
  }// Method processMenuInt END

  // current 변경
  private int changeCurrent(int ans) {
    String menuTitle = getMenuTitle(ans);


    if (this.current == 0) {
      if (ans < getMenuArr().length) {
        return ans;
      }
    }

    switch (menuTitle) {
      case "이전":
        return 0;
      case "종료":
        return -1;
      default:
        return this.current;
    }
  }// Method changeLocation END

  // sub_menu 동작
  private void printSubMenu(int menuNo) {

    Menu menu = Menu.getInstance();

    if (this.current > 0) {
      if (menuNo < menu.getMenuArr().length - 1) {
        System.out.printf("[%s]\n", menu.getMenuArr()[menuNo - 1]);
      }
    }

    switch (this.current) {
      case 0: // 메인
        break;
      case 1: // 회원
        UserMenu u = new UserMenu();
        u.menuUser(menuNo);
        break;
      case 2: // 팀
        TeamMenu t = new TeamMenu();
        t.menuTeam(menuNo);
        break;
      case 3: // 프로젝트
        ProjectMenu p = new ProjectMenu();
        p.menuProject(menuNo);
        break;
      case 4: // 게시판
        break;
      case 5: // 도움말
        break;
      default:
        break;
    }
  }// Method printSubMenu END



  ///////////////////////////////////////////////////////////
  ///////////////////// Check Menu //////////////////////////
  ///////////////////////////////////////////////////////////
  // 메뉴 이름 반환
  private String getMenuTitle(int menuNo) {
    int locationNo = getMenuArr().length;

    if (menuNo == locationNo) {
      menuNo = 0;
    } else if (menuNo == 9) {
      menuNo = locationNo;
    }
    return isValidateMenu(menuNo) ? getMenuArrItem(menuNo - 1) : null;

  }// Method getMenuTitle END

  // 메뉴 번호 유효 검사
  private boolean isValidateMenu(int menuNo) {
    return menuNo > 0 && menuNo <= getMenuArr().length;
  }// Method isValidateMenu END



  ///////////////////////////////////////////////////////////
  ///////////////////// Location Menu ///////////////////////
  ///////////////////////////////////////////////////////////
  // 현재 위치(current)의 메뉴 배열 반환
  public String[] getMenuArr() {

    if (this.current == 0) {
      return this.mainMenu;
    } else {
      return this.subMenu[this.current - 1];
    }
  }// Method getMenuArr END

  // 현재 위치(current)의 메뉴 배열 요소 반환
  public String getMenuArrItem(int menuNo) {
    String[] menuArr = getMenuArr();
    if (menuNo == menuArr.length) {
      return null;
    }
    return menuArr != null ? menuArr[menuNo] : null;
  }// Method getMenuArrItem END

  // 현재 위치(current)의 메뉴 이름 반환
  public String getMenuName() {
    if (this.current == 0) {
      return "메인";
    } else {
      return this.mainMenu[this.current - 1];
    }
  }// Method MenuName END



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

  public String[] getMainMenu() {
    return mainMenu;
  }

  public void setMainMenu(String[] mainMenu) {
    this.mainMenu = mainMenu;
  }

  public String[][] getSubMenu() {
    return subMenu;
  }

  public void setSubMenu(String[][] subMenu) {
    this.subMenu = subMenu;
  }

  public int getCurrent() {
    return this.current;
  }

  public void setCurrent(int current) {
    this.current = current;
  }



}
