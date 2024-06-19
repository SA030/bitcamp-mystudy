package study.lang.oop.clazz;



// 중첩 클래스를 포함하지 않는다.(클래스 파일이 별도로 만들어진다)
// class 단위로 class 파일 생성
// [Top-level class]$[class name][...][class name].class
// ------------------*Object class: 순서대로 번호 부여(1~...)



// Test03.class
public class Test03 {

  // --------------- nested class --------------- //


  // non-static nested class
  // Test03$B.class
  class B {
  };


  // static nested class
  // Test03$C.class
  static class C {
  };


  // anonymous class
  // Test03$1.class
  Object obj1 = new Object() {};



  void m1() {
    // local class
    // Test03$1D.class
    class D {
    };


    // anonymous class
    // Test03$2.class
    Object obj2 = new Object() {};
  }


  // --------------------------------------------- //
}


// package member class
// A.class
class A {
}
