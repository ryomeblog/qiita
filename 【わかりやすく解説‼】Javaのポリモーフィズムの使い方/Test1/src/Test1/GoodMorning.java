package Test1;
public class GoodMorning extends Greeting {
	// コンストラクタ
	public GoodMorning(String name) {
		super(name);
	}
	// 挨拶の表示
	@Override
	void showGreeting() {
		System.out.println(getName()+"さん、おはようございます。");
	}
}