package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import bitcamp.myapp.app.util.DataEdit;
import bitcamp.myapp.app.vo.Project;
import bitcamp.myapp.app.vo.User;

public class ProjectMenu {
  DataEdit data = DataEdit.getInstance();
  UserMenu user = UserMenu.getInstance();
  Project pro = Project.getInstance();

  public void menuProject(int menuNo) {

    switch (menuNo) {
      case 1: // 등록
        add();
        break;
      case 2: // 목록
        printList(0, 1, 2, 3);
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
    String item[] = new String[4];
    // 프로젝트 등록
    for (int ProItem = 0; ProItem < 4; ProItem++) {
      System.out.printf("%s? ", data.getProItemString(ProItem));
      item[ProItem] = data.Scanner();
    }
    Project newPro = new Project(item);
    data.add(newPro);
    addUser(newPro);

  }

  // 1-1. 팀원 등록
  private void addUser(Project addPro) {

    String item;
    int no;
    HashMap<Integer, User> addUser;

    for (;;) {
      System.out.printf("추가할 팀원 번호?(종료: 0) ");

      item = data.Scanner();
      if (item.equals("0")) {
        break;
      }

      if (user.checkUser(Integer.parseInt(item))) {
        no = Integer.parseInt(item);
        addUser = addPro.getMembers();

        if (addUser.containsKey(no)) {
          System.out.printf("'%s'은 현재 팀원입니다.\n", addUser.get(no).getName());
        } else {
          addPro.setMembers(no, data.getUser(no));
          System.out.printf("'%s'을 추가했습니다.\n", addUser.get(no).getName());
        }
      }

    }
  }

  // 2. 목록
  private void printList(int... num) {
    // Title Copy //////////////////////////////////////////////
    ArrayList<String> proItem = new ArrayList<String>();
    String str = "";

    for (int i : num) {
      proItem.add(data.getProItemString(i));
    }
    ////////////////////////////////////////////////////////////


    // Print Title
    str += String.format("%-3s ", "N");
    for (int i : num) {
      str += String.format("%-15s ", proItem.get(i));
    }
    str += String.format("\n");

    for (int proNo = 1; proNo <= data.arrSize(); proNo++) {
      str += String.format("%-3s ", proNo);
      str += String.format("%-15s ", data.getPro(proNo).getTitle());
      str += String.format("%-15s ", data.getPro(proNo).getDiscription());
      str += String.format("%-15s ", data.getPro(proNo).getStartDate());
      str += String.format("%-15s \n", data.getPro(proNo).getEndDate());
    }


    // Print Total
    System.out.print(str);
  }

  // 3. 조회
  private void print(int proNo) {
    String proName = data.getPro(proNo).getTitle();
    String proAccount = data.getPro(proNo).getDiscription();
    String proStart = data.getPro(proNo).getStartDate();
    String proEnd = data.getPro(proNo).getEndDate();
    Set<Integer> userName = data.getPro(proNo).getMembers().keySet();


    if (proNo > 0) {
      // Print Project name
      System.out.printf("%s: %s \n", data.getProItemString(0), proName);

      // Print Account
      System.out.printf("%s: %s \n", data.getProItemString(0), proAccount);

      // Print Start~End
      System.out.printf("%s: %s-%s \n", data.getProItemString(0), proStart, proEnd);

      // Print User
      System.out.printf("%s \n", data.getProItemString(-1));
      for (Integer userNo : userName) {
        System.out.printf("- %s\n", printUserName(proNo, userNo));
      }

    }
  }

  // 3-1. 팀원 이름 조회
  private String printUserName(int proNo, int userNo) {

    return data.getPro(proNo).getMembers().get(userNo).getName();
  }


  // 4. 변경
  private void edit(int proNo) {

    // if (teamNo > 0) {
    // // Edit Team name
    // System.out.printf("%s(%s) ", //
    // data.getTeamItemString(0), // 수정할 정보 메뉴
    // data.getItem(teamNo, 0) // 현재 저장된 정보
    // );
    // data.set(teamNo, 0); // 수정
    //
    // // Delete Team user
    // for (int TeamItem = 1; (TeamItem > 0) && (TeamItem < data.size(teamNo));) {
    // TeamItem = deleteUser(teamNo, TeamItem);
    // }
    //
    // // Add Team user
    // addUser(teamNo - 1);
    //
    // // Edit End
    // System.out.println("변경했습니다.");
    //
    // }

    if (proNo > 0) {
      /*************************************************************/
      // Edit Project name
      System.out.printf("%s(%s) ", //
          data.getProItemString(0), // 수정할 정보 메뉴
          data.getPro(proNo).getTitle() // 현재 저장된 정보
      );
      data.getPro(proNo).setTitle(data.Scanner()); // 수정

      // Edit Account
      System.out.printf("%s(%s) ", //
          data.getProItemString(1), // 수정할 정보 메뉴
          data.getPro(proNo).getDiscription() // 현재 저장된 정보
      );
      data.getPro(proNo).setDiscription(data.Scanner()); // 수정

      // Edit Start
      System.out.printf("%s(%s) ", //
          data.getProItemString(2), // 수정할 정보 메뉴
          data.getPro(proNo).getStartDate() // 현재 저장된 정보
      );
      data.getPro(proNo).setStartDate(data.Scanner()); // 수정

      // Edit End
      System.out.printf("%s(%s) ", //
          data.getProItemString(3), // 수정할 정보 메뉴
          data.getPro(proNo).getEndDate() // 현재 저장된 정보
      );
      data.getPro(proNo).setEnd(data.Scanner()); // 수정
      /*************************************************************/

      // Delete Team user
      HashMap<Integer, User> editUser = data.getPro(proNo).getMembers();
      ArrayList<Integer> editUserNo = new ArrayList<Integer>();
      int num;

      for (Entry<Integer, User> userItem : editUser.entrySet()) {
        // System.out.println("key = " + userItem.getKey());
        num = deleteUser(proNo, userItem.getKey());
        if (num > 0) {
          editUserNo.add(num);
        }
      }

      for (int userNo : editUserNo) {
        data.getTeam(proNo).getUser().remove(userNo);
      }

      // Add Team user
      addUser(data.getPro(proNo));

      // Edit End
      System.out.println("변경했습니다.");
    }

  }

  // 5. 삭제
  private void delete(int proNo) {
    if (proNo > 0) {
      data.remove(proNo);
      System.out.println("삭제하였습니다.");
    }
  }

  // 5-1. 팀원 삭제
  private int deleteUser(int proNo, int userNo) {

    String ans;
    String userName = printUserName(proNo, userNo);

    while (true) {

      System.out.printf("%s 삭제(y/n)? ", userName);
      ans = data.Scanner();

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
  }

}
