package curso.java.trabajos;

public class EjemploHilos {
	
	public static void main(String[] args) {

		Runnable hilo=()->{
			for(int i=1;i<=5;i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		try {
			new Thread(hilo).start();
			Thread.sleep(1100);
			new Thread(hilo).start();
			Thread.sleep(1100);
			
			new Thread(hilo).start();
			Thread.sleep(1100);
			new Thread(hilo).start();
			Thread.sleep(1100);
			new Thread(hilo).start();
			Thread.sleep(1100);
			new Thread(hilo).start();
			Thread.sleep(1100);
			new Thread(hilo).start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
