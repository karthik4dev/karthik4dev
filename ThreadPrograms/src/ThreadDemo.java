import java.util.*;
public class ThreadDemo extends Thread {
	int i =0;

	@Override
	public void run() {
		while(i<22) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("This is the number "+i);
			i=i+2;
			System.out.println(Thread.interrupted());
		}
		
		new Thread() {
			@Override
			public void run() {
				System.out.println("run the anonymous thread");
			}
		}.start();
	}
	public static void main(String[] args) {
		ThreadDemo tDemo = new ThreadDemo();
		tDemo.start();
		
	}
}
