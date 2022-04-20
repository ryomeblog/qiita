// 変数に格納しないインスタンス
public class Test2 {
    // mainメソッド
    public static void main(String[] args) {
        // インスタンス(オブジェクト)を生成 & メソッド呼び出し
        new Hello2().showHello();
    }
}

// インスタンスのテストクラス
class Hello2 {
  // Hello表示メソッド
  void showHello(){
      // Helloの表示
      System.out.print("Hello");
  }
}