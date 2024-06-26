package bitcamp.myapp.app.submenu;

import java.util.ArrayList;
import bitcamp.myapp.app.util.SubMenu;
import bitcamp.myapp.app.vo.Board;

public class BoardMenu extends SubMenu {

  private Board board = Board.getInstance();
  private ArrayList<Board> boardList = new ArrayList<Board>();



  /********************************************************/

  Format boradrForm = new Format(3, 20);

  /********************************************************/



  ///////////////////////////////////////////////////////////
  ////////////////// private Instance User //////////////////
  ///////////////////////////////////////////////////////////
  private static BoardMenu boardMenu;

  // setup User Instance
  public static BoardMenu getInstance() {

    if (boardMenu == null) {
      boardMenu = new BoardMenu();
    }

    return boardMenu;
  }// Method getInstance END

  // reset User Instance
  public static void freeInstance() {
    boardMenu = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  ///////////////////// Project Menu ////////////////////////
  ///////////////////////////////////////////////////////////
  public void menu(int menuNo) {
    menuBoard(menuNo, BOARD, board, boardList);
  }


  public void menuBoard(int menuNo, int titleNo, Board borad, ArrayList<Board> BoardList) {

    switch (menuNo) {
      case 1: // 등록
        add(titleNo, new Board(), BoardList);
        break;
      case 2: // 목록
        printList(titleNo, borad, BoardList, boradrForm);
        break;
      case 3: // 조회
        print(titleNo, borad, BoardList);
        break;
      case 4: // 변경
        edit(titleNo, borad, BoardList);
        break;
      case 5: // 삭제
        delete(titleNo, BoardList);
        break;
      default:
        break;
    }
  }// Method menuProject END



  ///////////////////////////////////////////////////////////
  ///////////////////////// 1. 등록 /////////////////////////
  ///////////////////////////////////////////////////////////
  protected void add(int objNo, Board obj, ArrayList<Board> objList) {

    addObject(objNo, obj, objList, 1, 2);
    objList.add(obj);
    obj.setSeqNo(objList.size());

  }// Method Board Add END



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

  // 게시판 가져오기
  public Board getBoard(int boardNo) {
    if (boardNo > 0) {
      for (int listNo = 0; listNo < boardList.size(); listNo++) {
        if (boardList.get(listNo).getSeqNo() == boardNo) {
          return boardList.get(listNo);
        }
      }
    }
    return null;
  }// Method getPro END


  public void add(Board board) {
    boardList.add(board);
  }

  public ArrayList<Board> getBoardList() {
    return boardList;
  }

  public void setProjectList(ArrayList<Board> BoardList) {
    this.boardList = BoardList;
  }


}
