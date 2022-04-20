package Test1;
public class Test1 {
    public static void main(String[] args) {
        // インスタンスの生成
        TestSuper ts1 = new TestSuper("A");
        TestSub ts2 = new TestSub("B","ぎょうざ");

        // インスタンスの表示
        ts1.showName();
        System.out.println();
        ts2.showName();
    }
}