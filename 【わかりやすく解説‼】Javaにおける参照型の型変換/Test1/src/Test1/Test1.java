package Test1;
public class Test1 {
    public static void main(String[] args) {
        // インスタンスの生成
        GoodEvening ge1 = new GoodEvening("A");
        ge1.showGoodMorning();

        // アップキャスト
        Hello hello = ge1;
        hello.showHello();

        // ダウンキャスト
        GoodEvening ge2 = (GoodEvening) hello;
        ge2.showGoodEvening();
        //((GoodEvening) hello).showGoodEvening();
    }
}