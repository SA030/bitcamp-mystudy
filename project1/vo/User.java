package bitcamp.project1.vo;

import java.util.LinkedList;
import bitcamp.project1.Util.AccountCommand;

public class User {
  public AccountCommand ac = AccountCommand.getInstance(this);

  // User-accountList
  static LinkedList<Account> accountList;
  // priKey
  static int seqNo = 0;
  // ID (default OREO)
  String ID = "OREO";
  // PW (default 0000)
  String PW = "0000";


  ///////////////////////////////////////////////////////////
  /////////////////////// Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // set default
  public User() {
    accountList = new LinkedList<Account>();
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
  public int getSeqNo() {
    return seqNo;
  }

  public int setNextSeqNo() {
    return ++seqNo;
  }

  public String getID() {
    return ID;
  }

  public void setID(String iD) {
    ID = iD;
  }

  public String getPW() {
    return PW;
  }

  public void setPW(String pW) {
    PW = pW;
  }


  public static LinkedList<Account> getAccountList() {
    return accountList;
  }

  public static void setAccountList(LinkedList<Account> accountList) {
    User.accountList = accountList;
  }
}// Class User END
