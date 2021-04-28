package curso.java.hilos;

import curso.java.ventanas.VentanaBolas;
import curso.java.ventanas.VentanaBolasApplet;

public class PintorApplet extends Thread
{
	
	private VentanaBolasApplet ventanaBolas;
	
	
	public PintorApplet(VentanaBolasApplet ventanaBolas)
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

	public VentanaBolasApplet getVentanaBolas()
	{
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolasApplet ventanaBolas)
	{
		this.ventanaBolas = ventanaBolas;
	}

}
