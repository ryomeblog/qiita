package Test1;
public class Test1 {
    public static void main(String[] args) {
        // インスタンスの生成
    	Greeting[] greeting = {
    			new GoodMorning("A"),new GoodMorning("B"),new GoodMorning("C"),
    			new Hello("A"),new Hello("B"),new Hello("C"),
    			new GoodEvening("A"),new GoodEvening("B"),new GoodEvening("C")
    			};

    	// 挨拶表示
    	for(int i = 0;i < greeting.length;i++) {
    		greeting[i].showGreeting();
    	}
    }
}