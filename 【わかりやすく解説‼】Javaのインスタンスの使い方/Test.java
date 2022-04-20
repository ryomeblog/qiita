// インスタンスとコンストラクタのテストクラス
public class Test {
    // mainメソッド
    public static void main(String[] args) {
        // インスタンス(オブジェクト)を生成(コンストラクタ呼び出し)
        Hello hello = new Hello();
    }
}

// インスタンスのテストクラス
class Hello {
  // コンストラクタ
  Hello() {
      //Helloの表示
      System.out.print("Hello");
  }
}