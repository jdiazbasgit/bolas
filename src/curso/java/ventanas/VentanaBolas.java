package curso.java.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Optional;

import curso.java.bolas.Bola;
import curso.java.eventos.ElQueSabeLoQueHayQueHacerCopnElRaton;

public class VentanaBolas extends Frame implements WindowListener {

	private Image imagen;
	private Graphics externo;
	private List<Optional<Bola>> bolas;

	public VentanaBolas() {
		setSize(500, 500);

		this.addWindowListener(this);
		this.addMouseListener(new ElQueSabeLoQueHayQueHacerCopnElRaton(this));
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		if (getExterno() == null) {
			setImagen(createImage(2000, 2000));
			setExterno(getImagen().getGraphics());
		}

		getExterno().clearRect(0, 0, getWidth(), getHeight());
		Font fuente = new Font("helvetica", Font.BOLD, 20);
		getExterno().setFont(fuente);
		// for (Bola bola : getBolas())
		getBolas().forEach((bola) ->{
			getExterno().setColor(Color.BLACK);
			bola.ifPresent((bola1)-> getExterno().fillOval(bola1.getPosicionx(), bola1.getPosiciony(), bola1.getDimension(), bola1.getDimension())) ;
			bola.ifPresent((bola1)->getExterno().setColor(Color.WHITE)); 
			bola.ifPresent((bola1)->getExterno().drawString(String.valueOf(bola1.getImpactos()), bola1.getPosicionx() + (bola1.getDimension() / 2),
					bola1.getPosiciony() + (bola1.getDimension() / 2))); 
		});

		g.drawImage(getImagen(), 0, 0, this);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public Graphics getExterno() {
		return externo;
	}

	public void setExterno(Graphics externo) {
		this.externo = externo;
	}

	public List<Optional<Bola>> getBolas() {
		return bolas;
	}

	public void setBolas(List<Optional<Bola>> bolas) {
		this.bolas = bolas;
	}

	

}
