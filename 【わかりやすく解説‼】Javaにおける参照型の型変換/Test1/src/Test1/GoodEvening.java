package Test1;
public class GoodEvening extends GoodMorning {
    // コンストラクタ
    public GoodEvening(String name) {
        super(name);
    }

    // 挨拶の表示
    void showGoodEvening() {
        System.out.println(name + "さん、こんばんは。");
    }
}