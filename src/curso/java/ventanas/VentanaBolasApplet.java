package curso.java.ventanas;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import curso.java.bolas.Bola;
import curso.java.eventos.ElQueSabeLoQueHayQueHacerCopnElRaton;
import curso.java.eventos.ElQueSabeLoQueHayQueHacerCopnElRatonApplet;
import curso.java.hilos.Pintor;
import curso.java.hilos.PintorApplet;

public class VentanaBolasApplet extends Applet 
{
	
	private Image imagen;
	private Graphics externo;
	private List<Bola> bolas;
	
	public VentanaBolasApplet()
	{
		setSize(500, 500);
		
		
		this.addMouseListener(new ElQueSabeLoQueHayQueHacerCopnElRatonApplet(this));
	}
	
	@Override
	public void start()
	{
		
		this.setBolas(new ArrayList<>());
		try
		{
			Thread.sleep(50);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PintorApplet pintor= new PintorApplet(this);
		pintor.start();
		
	}
	
	
	
	
	@Override
	public void update(Graphics g)
	{
		paint(g);
	}
	
	@Override
	public void paint(Graphics g)
	{
		if(getExterno()==null)
		{
			setImagen(createImage(2000,2000));
			setExterno(getImagen().getGraphics());
		}
		
		getExterno().clearRect(0, 0, getWidth(), getHeight());
		Font fuente=new Font("helvetica", Font.BOLD, 20);
		getExterno().setFont(fuente);
		for (Bola bola : getBolas())
		{
			getExterno().setColor(Color.BLACK);
		getExterno().fillOval(bola.getPosicionx(), 
				bola.getPosiciony(), 
				bola.getDimension(), 
				bola.getDimension());	
		getExterno().setColor(Color.WHITE);
		getExterno().drawString(String.valueOf(bola.getImpactos()),
				bola.getPosicionx()+(bola.getDimension()/2),
				bola.getPosiciony()+(bola.getDimension()/2));
		}
		
		
		
			g.drawImage(getImagen(), 0, 0, this);
			
		
	}

	



	public Image getImagen()
	{
		return imagen;
	}



	public void setImagen(Image imagen)
	{
		this.imagen = imagen;
	}



	public Graphics getExterno()
	{
		return externo;
	}



	public void setExterno(Graphics externo)
	{
		this.externo = externo;
	}

	public List<Bola> getBolas()
	{
		return bolas;
	}

	public void setBolas(List<Bola> bolas)
	{
		this.bolas = bolas;
	}

}
