package Test1;
public class Hello extends Greeting{
	// コンストラクタ
	public Hello(String name) {
		super(name);
	}
	// 挨拶の表示
	@Override
	void showGreeting() {
		System.out.println(getName()+"さん、こんにちは。");
	}
}