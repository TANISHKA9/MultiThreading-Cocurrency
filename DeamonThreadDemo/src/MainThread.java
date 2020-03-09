
public class MainThread {

	public static void main(String[] args) {
		DeamonThread1 d = new DeamonThread1();
		d.setDaemon(true);  //Creating child thread as daemon thread
		d.start();
		int counter = 0;
		while(counter<5)
		{
		counter++;
		System.out.println("I am Main Thread");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
