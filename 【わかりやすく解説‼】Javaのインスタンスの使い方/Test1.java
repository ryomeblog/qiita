// コンストラクタ内でのインスタンス生成
public class Test1 {
    // mainメソッド
    public static void main(String[] args) {
        // インスタンス(オブジェクト)を生成(コンストラクタ呼び出し)
        new Hello1();
    }
}

// コンストラクタのテストクラス
class Hello1 {
  // コンストラクタ
  Hello1() {
      // インスタンス(オブジェクト)を生成
      InstanceHello ih = new InstanceHello();
      // インスタンスのメソッドの呼出し
      ih.showHello();
  }
}

// インスタンスのテストクラス
class InstanceHello {
  // Hello表示メソッド
  void showHello(){
      System.out.print("Hello");
  }
}