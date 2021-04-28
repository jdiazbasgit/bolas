package curso.java.trabajos;

import java.util.ArrayList;

import curso.java.bolas.Bola;
import curso.java.hilos.BolaHilo;
import curso.java.hilos.Pintor;
import curso.java.ventanas.VentanaBolas;

public class VerVentanaBolas
{

	public static void main(String[] args)
	{
		VentanaBolas ventanaBolas= new VentanaBolas();
		ventanaBolas.setVisible(true);
		ventanaBolas.setBolas(new ArrayList<>());
		try
		{
			Thread.sleep(50);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pintor pintor= new Pintor(ventanaBolas);
		pintor.start();
		

	}

}
