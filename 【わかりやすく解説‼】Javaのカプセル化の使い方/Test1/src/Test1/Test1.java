//受験者名と受験者の点数を管理するシステム
package Test1;
public class Test1 {
    public static void main(String[] args) {
        // インスタンスの生成
        TestCapsule tc1 = new TestCapsule("A",50);
        TestCapsule tc2 = new TestCapsule("B",60);

        //予期しない変数の変更
        tc1.setScore(10000);
        tc2.setScore(-100);

        //合否の表示
        tc1.Result();
        tc2.Result();

    }
}