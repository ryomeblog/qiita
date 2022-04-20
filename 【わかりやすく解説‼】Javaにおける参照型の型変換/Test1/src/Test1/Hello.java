package Test1;
public class Hello{
    // 変数の定義
    String name;

    // コンストラクタ
    public Hello(String name) {
        this.name = name;
    }

    // 挨拶の表示
    void showHello() {
        System.out.println(name + "さん、こんにちは。");
    }
}