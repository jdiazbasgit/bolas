package curso.java.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.Optional;

import curso.java.bolas.Bola;
import curso.java.hilos.BolaHilo;
import curso.java.ventanas.VentanaBolas;

public class ElQueSabeLoQueHayQueHacerCopnElRaton implements MouseListener {
	private VentanaBolas ventanaBolas;

	public ElQueSabeLoQueHayQueHacerCopnElRaton(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

	public int getSentido() {
		int salida = 1;
		double aleatorio = Math.random();
		if (aleatorio < 0.5)
			salida = -1;

		return salida;
	}

	public int getIncremento() {
		int salida = 1;
		double aleatorio = Math.random();
		if (aleatorio < 0.5)
			salida = 2;

		return salida;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Bola bola = new Bola();
		bola.setPosicionx(e.getX());
		bola.setPosiciony(e.getY());
		bola.setIncrementox(getIncremento());
		bola.setIncrementoy(getIncremento());
		bola.setSentidox(getSentido());
		bola.setSentidoy(getSentido());
		bola.setDimension(50);

		/*
		 * BolaHilo bolaHilo= new BolaHilo(bola, getVentanaBolas()); bolaHilo.start();
		 */
		getVentanaBolas().getBolas().add(bola);

		Runnable bolaHilo = () -> {
			while (true) {

			if (bola.getPosicionx() <= 0
						|| bola.getPosicionx() + bola.getDimension() >= getVentanaBolas().getWidth()) {
					bola.setSentidox(bola.getSentidox() * -1);
				}

				if (bola.getPosiciony() <= 0
						|| bola.getPosiciony() + bola.getDimension() >= getVentanaBolas().getHeight()) {
					bola.setSentidoy(bola.getSentidoy() * -1);
				}

				// for (Bola otra : getVentanaBolas().getBolas())
				getVentanaBolas().getBolas().stream().filter((otra) -> !bola.equals(otra)).filter(otra -> {
					Rectangle2D miRectangulo = new Rectangle2D.Double(bola.getPosicionx(), bola.getPosiciony(),
							bola.getDimension(), bola.getDimension());
					Rectangle2D otroRectangulo = new Rectangle2D.Double(otra.ifPresent((otra1)->otra1.getPosicionx()), 
							otra.ifPresent((otra1)->getPosiciony(),otra1.getDimension(), otra1.getDimension()));
							
					return miRectangulo.intersects(otroRectangulo);
				}).forEach((otra) -> {
					Optional<Optional<Bola>> otra1=Optional.of(otra);
					bola.setSentidox(bola.getSentidox() * -1);
					otra1.ifPresent((otra2)->otra2.setSentidox(otra2.get().getSentidox() * -1));;
					bola.setSentidoy(bola.getSentidoy() * -1);
					otra1.ifPresent((otra2)->otra2.setSentidoy(otra2.getSentidoy() * -1));;
					bola.setImpactos(bola.getImpactos() + 1);
					otra1.ifPresent((otra2)->otra2.setImpactos( otra2.getImpactos() + 1));
				});

				bola.setPosicionx(bola.getPosicionx() + bola.getSentidox() * bola.getIncrementox());
				bola.setPosiciony(bola.getPosiciony() + bola.getSentidoy() * bola.getIncrementoy());

				try {
					Thread.sleep(5);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (bola.getImpactos() > 500) {
					getVentanaBolas().getBolas().remove(bola);
					break;
				}

			}

		};
		new Thread(bolaHilo).start();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public VentanaBolas getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

}
