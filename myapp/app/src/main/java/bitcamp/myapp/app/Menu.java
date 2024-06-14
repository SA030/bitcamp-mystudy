package bitcamp.myapp.app;


public class Menu {
  ///////////////////////////////////////////////////////////
  ////////////////////// input Menu /////////////////////////
  ///////////////////////////////////////////////////////////
  private static Menu m;

  int current = 0;


  // setup Menu Instance
  public static Menu getInstance() {

    if (m == null) {
      m = new Menu();
    }

    return m;
  }

  // reset Menu Instance
  public static void freeInstance() {
    m = null;
  }



  public void processMenu(String command) {

    if (command.equals("menu")) {
      this.current = 0;
    } else {
      this.current = processMenuInt(command);
    }
  }


  private int processMenuInt(String command) {
    Menu mn = new Menu();

    int ans = Integer.parseInt(command);
    String menuTitle = mn.getMenuTitle(ans);


    if (menuTitle == null) {
      System.out.println("[ERROR] 유효한 메뉴 번호가 아닙니다.");
      return this.current;
    } else {
      printSubMenu(ans);
      return changeLocation(ans);
    }
  }

  // 현재 위치 변경
  private int changeLocation(int ans) {
    DataList data = DataList.getInstance();

    String menuTitle = getMenuTitle(ans);

    if (this.current == 0) {
      if (ans < data.mainMenu.length) {
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
  }

  // sub_menu 이동
  private void printSubMenu(int menuNo) {



    switch (this.current) {
      case 0: // 메인
        break;
      case 1: // 회원
        User u = new User();
        u.menuUser(menuNo);
        break;
      case 2: // 팀
        Team t = new Team();
        t.menuTeam(menuNo);
        break;
      case 3: // 프로젝트
        break;
      case 4: // 게시판
        break;
      case 5: // 도움말
        break;
      default:
        break;
    }
  }

  ///////////////////////////////////////////////////////////

  ///////////////////////////////////////////////////////////
  ///////////////////// Check Menu //////////////////////////
  ///////////////////////////////////////////////////////////

  // 메뉴 이름 반환
  private String getMenuTitle(int menuNo) {
    int locationNo = getCurrentArr().length;

    if (menuNo == locationNo) {
      menuNo = 0;
    } else if (menuNo == 9) {
      menuNo = locationNo;
    }
    return isValidateMenu(menuNo) ? getCurrentArrItem(menuNo - 1) : null;

  }

  // 메뉴 번호 유효 검사
  private boolean isValidateMenu(int menuNo) {
    return menuNo > 0 && menuNo <= getCurrentArr().length;
  }
  ///////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////////
  ///////////////////// Location Array///////////////////////
  ///////////////////////////////////////////////////////////

  // 현재 메뉴 위치의 배열 반환
  protected String[] getCurrentArr() {

    DataList data = DataList.getInstance();

    if (this.current == 0) {
      return data.mainMenu;
    } else if (this.current > 0) {
      return data.subMenu[this.current - 1];
    } else {
      return null;
    }
  }

  // 현재 메뉴 위치의 요소 반환
  protected String getCurrentArrItem(int menuNo) {
    String[] menu = getCurrentArr();
    if (menuNo == menu.length) {
      return null;
    }
    return menu != null ? menu[menuNo] : null;
  }

  ///////////////////////////////////////////////////////////

}
