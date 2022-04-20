package Test1;
public class Test1 {
    public static void main(String[] args) {
        // インスタンスの生成
        TestB b = new TestB();
        b.view();// Bが表示される

        // アップキャスト
        TestA a = (TestA) b;
        a.view();// Bが表示される
    }
}
class TestA {
    public void view() {
        // スーパークラスの表示
        System.out.println("A");
    }
}
class TestB extends TestA{
    public void view() {
        // サブクラスの表示
        System.out.println("B");
    }
}