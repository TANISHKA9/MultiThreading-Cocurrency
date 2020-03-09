
public class MainThread {

	public static void main(String[] args) {
		
		RunnableThread r = new RunnableThread();
		Thread t = new Thread(r);
		t.start();
	}

}
