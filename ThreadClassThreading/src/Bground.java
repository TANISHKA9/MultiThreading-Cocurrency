		public class Bground extends Thread{
			public static void main(String argv[])
			{
						Bground b = new Bground();
						b.start();
					}

			@Override
			public void run() {
				System.out.println("I am run method of Thread class");
			}					
			}


