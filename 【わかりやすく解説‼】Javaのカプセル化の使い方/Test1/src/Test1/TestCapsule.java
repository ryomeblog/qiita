package Test1;
public class TestCapsule {
    // インスタンス変数の定義
    private String name;
    private int score;

    // setter
    public void setName(String name) {
        this.name = name;
    }
    // getter
    public String getName() {
        return name;
    }
    // setter
    public void setScore(int score) {
        //不正な点数の入力対策
        if(0 <= score && score <= 100) {
            //0以上100以下
            this.score = score;
        }
    }
    // getter
    public int getScore() {
        return score;
    }

    // コンストラクタ（インスタンス生成時に実行される）
    public TestCapsule(String name, int score) {
        this.name = name;
        //不正な点数の入力対策
        if(0 <= score && score <= 100) {
            //0以上100以下
            this.score = score;
        }else {
            //0未満または101以上
            this.score = 0;
        }
    }
    //合否判定メソッド
    void Result() {
        if(60 <= score) {
            //合格
            System.out.println(name+"さんは"+score+"点で合格です。");
        }else {
            //不合格
            System.out.println(name+"さんは"+score+"点で不合格です。");
        }
    }
}