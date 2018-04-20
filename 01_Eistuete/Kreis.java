import java.awt.geom.Ellipse2D;

// Die Klasse Kreis
public class Kreis {

    // Attribute
	private int radius;
	private int xPosition;
	private int yPosition;
	private String farbe;
	private boolean istSichtbar;

	// Konstruktor
	public Kreis(int r , int x, int y) {
		radius = r;
		xPosition = x;
		yPosition = y;
		farbe = "blau";
		istSichtbar = false;
	}

	// Weitere Methoden
	public void sichtbarMachen() {
		istSichtbar = true;
		zeichnen();
	}

	public void unsichtbarMachen()	{
		loeschen();
		istSichtbar = false;
	}

	public void nachRechtsBewegen()	{
		horizontalBewegen(20);
	}

	
	public void nachLinksBewegen()	{
		horizontalBewegen(-20);
	}

	public void nachObenBewegen()	{
		vertikalBewegen(-20);
	}

	public void nachUntenBewegen() {
		vertikalBewegen(20);
	}


	public void horizontalBewegen(int entfernung)	{
		loeschen();
		xPosition = xPosition + entfernung;
		zeichnen();
	}

	public void vertikalBewegen(int entfernung)	{
		loeschen();
		yPosition = yPosition + entfernung;
		zeichnen();
	}

	public void langsamHorizontalBewegen(int entfernung){
		int delta;

		if (entfernung < 0) {
			delta = -1;
			entfernung = -entfernung;
		}
		else {
			delta = 1;
		}

		for (int i = 0; i < entfernung; i++) {
			xPosition = xPosition + delta;
			zeichnen();
		}
	}

	public void langsamVertikalBewegen(int entfernung) {
		int delta;

		if (entfernung < 0) {
			delta = -1;
			entfernung = -entfernung;
		}
		else {
			delta = 1;
		}

		for (int i = 0; i < entfernung; i++) {
			yPosition = yPosition + delta;
			zeichnen();
		}
	}

	
	public void groesseAendern(int neuerRadius)	{
		loeschen();
		radius = neuerRadius;
		zeichnen();
	}

	// Gültige Angaben sind "rot", "gelb", "blau", "gruen",
	// "lila" und "schwarz".
	public void farbeAendern(String neueFarbe)	{
		farbe = neueFarbe;
		zeichnen();
	}

	// Zeichnet den Kreis auf die Leinwand
	private void zeichnen()	{
		if (istSichtbar)		{
			Leinwand leinwand = Leinwand.gibLeinwand();
			leinwand.zeichne(
					this,
					farbe,
					new Ellipse2D.Double(xPosition, yPosition, 2*radius, 2*radius));
			leinwand.warte(10);
		}
	}

	// Entfernt en Kreis von der Leinwand
	private void loeschen()	{
		if (istSichtbar)		{
			Leinwand leinwand = Leinwand.gibLeinwand();
			leinwand.entferne(this);
		}
	}

} // Ende der Klasse Kreis