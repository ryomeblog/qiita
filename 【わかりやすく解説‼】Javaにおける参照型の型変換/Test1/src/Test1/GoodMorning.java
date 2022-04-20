package Test1;
public class GoodMorning extends Hello {
    // コンストラクタ
    public GoodMorning(String name) {
        super(name);
    }

    // 挨拶の表示
    void showGoodMorning() {
        System.out.println(name + "さん、おはようございます。");
    }
}