package curso.java.hilos;

import curso.java.ventanas.VentanaBolas;

public class Pintor extends Thread
{
	
	private VentanaBolas ventanaBolas;
	
	
	public Pintor(VentanaBolas ventanaBolas)
	{
		this.ventanaBolas=ventanaBolas;
	}
	
	
	@Override
	public void run()
	{
		while(true)
		{
			getVentanaBolas().repaint();
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public VentanaBolas getVentanaBolas()
	{
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolas ventanaBolas)
	{
		this.ventanaBolas = ventanaBolas;
	}

}
