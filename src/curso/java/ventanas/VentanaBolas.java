package curso.java.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import curso.java.bolas.Bola;
import curso.java.eventos.ElQueSabeLoQueHayQueHacerCopnElRaton;

public class VentanaBolas extends Frame implements WindowListener
{
	
	private Image imagen;
	private Graphics externo;
	private List<Bola> bolas;
	
	public VentanaBolas()
	{
		setSize(500, 500);
		
		this.addWindowListener(this);
		this.addMouseListener(new ElQueSabeLoQueHayQueHacerCopnElRaton(this));
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

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

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
