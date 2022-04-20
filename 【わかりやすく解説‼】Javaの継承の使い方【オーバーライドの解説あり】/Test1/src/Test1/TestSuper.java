package Test1;
public class TestSuper {
    // インスタンス変数の定義
    private String name;

    // コンストラクタ（インスタンス生成時に実行される）
    public TestSuper(String name) {
        this.name = name;
    }
    // setter
    public void setName(String name) {
        this.name = name;
    }
    // getter
    public String getName() {
        return name;
    }
    public void showName() {
        System.out.println("名前:"+name);
    }
}