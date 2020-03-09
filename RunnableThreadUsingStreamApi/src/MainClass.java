
public class MainClass {

	public static void main(String[] args) {
		Runnable r = ()-> System.out.println("I am run method of runnable thread");
		Thread t = new Thread(r);
		t.start();
	}

}
