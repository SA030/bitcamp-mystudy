package bitcamp.myapp.app.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import bitcamp.myapp.app.util.SubMenu.VoList;
import bitcamp.myapp.app.util.Title;

public class Board implements VoList {


  public Title boardTitle = new Title(4);

  private int seqNo = 0;
  private String title;
  private String discription;
  private Date today;
  private int cnt;



  ///////////////////////////////////////////////////////////
  ///////////////// Project Constructor /////////////////////
  ///////////////////////////////////////////////////////////
  public Board() {
    this.today = new Date();
    this.cnt = 0;
    seqNo += seqNo;
  }

  public Board(String title) {
    this.title = title;

    this.today = new Date();
    this.cnt = 0;
    seqNo += seqNo;
  }

  public Board(String title, String discription) {
    this.title = title;
    this.discription = discription;

    this.today = new Date();
    this.cnt = 0;
    seqNo += seqNo;
  }

  public Board(String[] item) {
    this.title = item[0];
    this.discription = item[1];

    this.today = new Date();
    this.cnt = 0;
    seqNo += seqNo;
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

  ///////////////////////////////////////////////////////////
  ///////////////// Item getter, setter /////////////////////
  ///////////////////////////////////////////////////////////

  @Override
  public String getItem(int itemNo) {

    switch (itemNo) {
      case 0:
        return String.format("%d", getSeqNo());
      case 1:
        return getTitle();
      case 2:
        return getDiscription();
      case 3:
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("%s", simpleDateFormat.format(getToday()));
      case 4:
        return String.format("%d", getCnt());
      default:
        return null;
    }
  }// Method getItem END


  @Override
  public void setItem(int itemNo, String userItem) {
    switch (itemNo) {
      case 0:
        setSeqNo(Integer.parseInt(userItem));
        break;
      case 1:
        setTitle(userItem);
        break;
      case 2:
        setDiscription(userItem);
        break;
      case 3:
        setToday(new Date());
        break;
      case 4:
        setCnt(0);
        break;
    }
  }// Method setItem END



  ///////////////// title /////////////////////

  @Override
  public int getSeqNo() {
    return seqNo;
  }

  @Override
  public void setSeqNo(int seqNo) {
    this.seqNo = seqNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDiscription() {
    return discription;
  }

  public void setDiscription(String discription) {
    this.discription = discription;
  }

  public Date getToday() {
    return today;
  }

  public void setToday(Date today) {
    this.today = today;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public int getSize() {
    return boardTitle.getTitleArrSize();
  }

  public String getBoardTitleString(int userItem) {
    return boardTitle.getTitleString(userItem);
  }

  public ArrayList<String> getPublicBoardTitle() {
    return boardTitle.getPublicTitle();
  }

  public ArrayList<Integer> getPublicBoardItem() {
    return boardTitle.getPublicTitleNo();
  }

  @Override
  public void setMembers(int seqNo, User members) {
    // TODO Auto-generated method stub

  }

  @Override
  public HashMap<Integer, User> getMembers() {
    // TODO Auto-generated method stub
    return null;
  }

}
