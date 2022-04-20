// 出欠確認を取るシステム
package Test1;
public class Test1 {
    public static void main(String[] args) {
        // インスタンスの生成
        TestOverload to1 = new TestOverload("A");
        TestOverload to2 = new TestOverload("B",1);
        TestOverload to3 = new TestOverload("C",2);

        System.out.println("-----4月1日-----");
        //インスタンスの中身を表示
        to1.showAttendance();
        to2.showAttendance();
        to3.showAttendance();
    }
}