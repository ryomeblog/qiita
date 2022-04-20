package Test1;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        // ArrayListの作成
        ArrayList<Hello> hello = new ArrayList<Hello>();
        ArrayList<Hello> subhello = new ArrayList<Hello>();

        // ArrayListに値の追加
        hello.add(new Hello("A"));
        hello.add(new Hello("B"));
        hello.add(new Hello("C"));

        // ArrayListにリストの追加
        subhello.addAll(hello);

        // ArrayListの値を変更
        hello.set(0, new Hello("D"));

        // ArrayListの要素数
        System.out.println("helloの要素数："+hello.size());

        // ArrayList同士の一致する要素番号
        System.out.println("subhello(2)と一致するhelloの要素番号："+hello.indexOf(subhello.get(2)));

        // ArrayListに値が含まれるか判定する
        System.out.println("helloに値が含まれるか："+hello.contains(subhello.get(2)));

        // ArrayListから指定すた要素番号の値を削除する
        hello.remove(2);

        // ArrayListの重複する値を削除する。
        subhello.stream().distinct().collect(Collectors.toList());

        // ArrayListをコピーする。
        ArrayList<Hello> clonehello = (ArrayList<Hello>) hello.clone();

        // ArrayListの表示
        for(Hello h : hello) {
            h.showGreeting();
        }
        System.out.println();
        for(Hello sub : subhello) {
            sub.showGreeting();
        }
        System.out.println();
        for(Hello clone : clonehello) {
            clone.showGreeting();
        }
    }
}