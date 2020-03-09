
public class DeamonThread1 extends Thread {

	@Override
	public void run() {
		
		//Creating child of daemon thread:
		Thread childOfDaemon = new Thread(()->{
		int childCounter =0;
		while(childCounter<30) {
			System.out.println("I am Child of Daemon!");
		try {
			sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}});
		
		childOfDaemon.start();
		
		//Daemond Thread:
		while(true) {
		try {
			System.out.println("I am Daemon Thread");
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
