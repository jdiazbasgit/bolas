package curso.java.hilos;

import java.awt.geom.Rectangle2D;

import curso.java.bolas.Bola;
import curso.java.ventanas.VentanaBolas;

public class BolaHilo extends Thread
{
	private Bola bola;
	private VentanaBolas ventanaBolas;
	
	public BolaHilo(Bola bola,VentanaBolas ventanaBolas)
	{
		this.bola=bola;
		this.ventanaBolas=ventanaBolas;
		
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			
			if(getBola().getPosicionx()<=0 ||
					getBola().getPosicionx()+
					getBola().getDimension()>=getVentanaBolas().getWidth())
			{
				getBola().setSentidox(getBola().getSentidox()*-1);
			}
			
			if(getBola().getPosiciony()<=0 ||
					getBola().getPosiciony()+
					getBola().getDimension()>=getVentanaBolas().getHeight())
			{
				getBola().setSentidoy(getBola().getSentidoy()*-1);
			}
			
			
			try
			{
				for (Bola otra : getVentanaBolas().getBolas())
				{
					if (!getBola().equals(otra))
					{
						Rectangle2D miRectangulo = new Rectangle2D.Double(getBola().getPosicionx(),
								getBola().getPosiciony(), getBola().getDimension(), getBola().getDimension());
						Rectangle2D otroRectangulo = new Rectangle2D.Double(otra.getPosicionx(), otra.getPosiciony(),
								otra.getDimension(), otra.getDimension());
						if (miRectangulo.intersects(otroRectangulo))
						{
							getBola().setSentidox(getBola().getSentidox() * -1);
							otra.setSentidox(otra.getSentidox() * -1);
							getBola().setSentidoy(getBola().getSentidoy() * -1);
							otra.setSentidoy(otra.getSentidoy() * -1);
							getBola().setImpactos(getBola().getImpactos()+1);
							otra.setImpactos(otra.getImpactos()+1);
						} 
					}
					
				}
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		
			
			
			getBola().setPosicionx(getBola().getPosicionx()+
					getBola().getSentidox()*getBola().getIncrementox());
			getBola().setPosiciony(getBola().getPosiciony()+
					getBola().getSentidoy()*getBola().getIncrementoy());
			
			
			
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(getBola().getImpactos()>500)
			{
				getVentanaBolas().getBolas().remove(getBola());
				break;
			}
				
			
			
			
		}
		
		
	}

	public Bola getBola()
	{
		return bola;
	}

	public void setBola(Bola bola)
	{
		this.bola = bola;
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
