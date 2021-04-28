package curso.java.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import curso.java.bolas.Bola;
import curso.java.hilos.BolaHilo;
import curso.java.ventanas.VentanaBolas;

public class ElQueSabeLoQueHayQueHacerCopnElRaton implements MouseListener
{
	private VentanaBolas ventanaBolas;

	public ElQueSabeLoQueHayQueHacerCopnElRaton(VentanaBolas ventanaBolas)
	{
		this.ventanaBolas=ventanaBolas;
	}
	
	public int getSentido()
	{
		int salida=1;
		double aleatorio=Math.random();
		if(aleatorio<0.5)
			salida=-1;
		
		return salida;
	}
	
	public int getIncremento()
	{
		int salida=1;
		double aleatorio=Math.random();
		if(aleatorio<0.5)
			salida=2;
		
		return salida;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		Bola bola= new Bola();
		bola.setPosicionx(e.getX());
		bola.setPosiciony(e.getY());
		bola.setIncrementox(getIncremento());
		bola.setIncrementoy(getIncremento());
		bola.setSentidox(getSentido());
		bola.setSentidoy(getSentido());
		bola.setDimension(50);
		
		BolaHilo bolaHilo= new BolaHilo(bola, getVentanaBolas());
		bolaHilo.start();
		getVentanaBolas().getBolas().add(bola);

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

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
