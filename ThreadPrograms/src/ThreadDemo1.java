
public class ThreadDemo1 implements Runnable {
	int i =1;
	@Override
	public void run() {
		while(i<22) {
			System.out.println("This is the number "+i);
			i=i+2;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ThreadDemo tDemo = new ThreadDemo();
		Thread tDemo1 = new Thread(new ThreadDemo1());
		tDemo.start();
		tDemo1.start();
	}	
}
