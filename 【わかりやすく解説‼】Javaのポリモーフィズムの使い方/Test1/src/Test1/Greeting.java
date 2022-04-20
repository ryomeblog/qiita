package Test1;
public abstract class Greeting {
	// インスタンス変数
	private String name;

	// コンストラクタ
	public Greeting(String name) {
		this.name = name;
	}
	// getter
	public String getName() {
		return name;
	}
	// 挨拶の表示
	abstract void showGreeting();
}