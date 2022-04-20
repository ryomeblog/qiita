package Test1;
public class GoodEvening extends Greeting {
	// コンストラクタ
	public GoodEvening(String name) {
		super(name);
	}
	// 挨拶の表示
	@Override
	void showGreeting() {
		System.out.println(getName()+"さん、こんばんは。");
	}
}