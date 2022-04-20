package Test1;
public class TestSub extends TestSuper {
    // インスタンス変数の定義
    private String food;

 // コンストラクタ（インスタンス生成時に実行される）
    public TestSub(String name,String food) {
        super(name);
        this.food = food;
    }
    // setter
    public void setFood(String food) {
        this.food = food;
    }
    // getter
    public String getFood() {
        return food;
    }
    @Override
    public void showName() {
        super.showName();
        showFood();
    }
    public void showFood() {
        System.out.println("好きな食べ物:"+food);
    }
}