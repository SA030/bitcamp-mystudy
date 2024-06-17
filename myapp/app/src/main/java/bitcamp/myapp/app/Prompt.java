package bitcamp.myapp.app;

public class Prompt {

  DataEdit data = new DataEdit();



  // 번호 유효 검사
  private boolean isValidateUser(int UserNo) {
    return UserNo > 0 && UserNo <= data.userSize();
  }

  // 번호 있는지 확인
  protected boolean checkUser(int UserNo) {
    if (isValidateUser(UserNo)) {
      return true;
    } else {
      System.out.printf("없는 %s입니다.\n");
      return false;
    }
  }


}
