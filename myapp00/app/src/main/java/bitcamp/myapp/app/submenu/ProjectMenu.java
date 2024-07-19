package bitcamp.myapp.app.submenu;


import java.util.ArrayList;
import bitcamp.myapp.app.util.SubMenu;
import bitcamp.myapp.app.vo.Project;

public class ProjectMenu extends SubMenu {


  private Project pro = Project.getInstance();
  private ArrayList<Project> ProjectList = new ArrayList<Project>();



  /********************************************************/

  Format projectForm = new Format(3, 20);

  /********************************************************/



  ///////////////////////////////////////////////////////////
  ////////////////// private Instance User //////////////////
  ///////////////////////////////////////////////////////////
  private static ProjectMenu projectMenu;

  // setup User Instance
  public static ProjectMenu getInstance() {

    if (projectMenu == null) {
      projectMenu = new ProjectMenu();
    }

    return projectMenu;
  }// Method getInstance END

  // reset User Instance
  public static void freeInstance() {
    projectMenu = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  ///////////////////// Project Menu ////////////////////////
  ///////////////////////////////////////////////////////////
  public void menu(int menuNo) {
    menuProject(menuNo, PROJECT, pro, ProjectList);
  }


  public void menuProject(int menuNo, int titleNo, Project pro, ArrayList<Project> ProjectList) {

    switch (menuNo) {
      case 1: // 등록
        add(titleNo, new Project(), ProjectList);
        break;
      case 2: // 목록
        printList(titleNo, pro, ProjectList, projectForm);
        break;
      case 3: // 조회
        print(titleNo, pro, ProjectList);
        break;
      case 4: // 변경
        edit(titleNo, pro, ProjectList);
        break;
      case 5: // 삭제
        delete(titleNo, ProjectList);
        break;
      default:
        break;
    }
  }// Method menuProject END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. 등록 /////////////////////////
  ///////////////////////////////////////////////////////////
  protected void add(int objNo, Project obj, ArrayList<Project> objList) {

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

  // 프로젝트 가져오기
  public Project getPro(int proNo) {
    if (proNo > 0) {
      for (int listNo = 0; listNo < ProjectList.size(); listNo++) {
        if (ProjectList.get(listNo).getSeqNo() == proNo) {
          return ProjectList.get(listNo);
        }
      }
    }
    return null;
  }// Method getPro END


  public void add(Project project) {
    ProjectList.add(project);
  }

  public ArrayList<Project> getProjectList() {
    return ProjectList;
  }

  public void setProjectList(ArrayList<Project> projectList) {
    ProjectList = projectList;
  }
}// Class ProjectMenu END

