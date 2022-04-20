package Test1;
public class Hello {
    // インスタンス変数
    String name;

    // コンストラクタ
    public Hello(String name) {
        this.name = name;
    }
    // 挨拶の表示
    void showGreeting() {
        System.out.println(name+"さん、こんにちは。");
    }
}