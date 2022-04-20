package Test1;
public class TestOverload {
    // インスタンス変数の定義
    private String name;
    private int attend;

    // コンストラクタ1（引数なし）
    TestOverload(){
        this("未入力",0);
    }
    // コンストラクタ2（引数あり）
    TestOverload(String name){
        this(name,0);
    }
    // コンストラクタ3（コンストラクタ2と異なる引数あり）
    TestOverload(int attend){
        this("未入力",attend);
    }
    // コンストラクタ4（引数の数が2つ）
    TestOverload(String name,int attend){
        this.name = name;
        this.attend = attend;
    }

    //表示メソッド
    void showAttendance(){
        String str = "";
        switch(attend) {
        case 0:
            str += "未定";
            break;
        case 1:
            str += "出席";
            break;
        case 2:
            str += "欠席";
            break;
        }
        System.out.println(name+"さんは"+str);
    }
}