package bitcamp.myapp.app.vo;


public class Board {



  public Board() {

  }



  ///////////////////////////////////////////////////////////
  ////////////////// private Instance ///////////////////////
  ///////////////////////////////////////////////////////////

  private static Board board;

  public static Board getInstance() {

    if (board == null) {
      board = new Board();
    }

    return board;
  }

  public static void freeInstance() {
    board = null;
  }

}
