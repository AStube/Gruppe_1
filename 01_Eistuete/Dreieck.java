import java.awt.*;

//Die Klasse Dreieck
public class Dreieck
{
    //Attribute
    private int hoehe;
    private int breite;
	private int xPosition;
	private int yPosition;
	private String farbe;
	private boolean istSichtbar;

    //Konstruktor
	public Dreieck()
    {
		hoehe = 30;
		breite = 40;
		xPosition = 50;
		yPosition = 15;
		farbe = "gruen";
		istSichtbar = true;
    }

	//Weitere Methoden
    public void sichtbarMachen()
	{
		istSichtbar = true;
		zeichnen();
	}
	
	public void unsichtbarMachen()
	{
		loeschen();
		istSichtbar = false;
	}
	
    public void nachRechtsBewegen()
    {
		horizontalBewegen(20);
    }

     public void nachLinksBewegen()
    {
		horizontalBewegen(-20);
    }

    public void nachObenBewegen()
    {
		vertikalBewegen(-20);
    }

    public void nachUntenBewegen()
    {
		vertikalBewegen(20);
    }

   public void horizontalBewegen(int abstand)
    {
		loeschen();
		xPosition += abstand;
		zeichnen();
    }

    public void vertikalBewegen(int abstand)
    {
		loeschen();
		yPosition += abstand;
		zeichnen();
    }

    public void langsamHorizontalBewegen(int abstand)
    {
		int delta;

		if(abstand < 0) 
		{
			delta = -1;
			abstand = -abstand;
		}
		else 
		{
			delta = 1;
		}

		for(int i = 0; i < abstand; i++)
		{
			xPosition += delta;
			zeichnen();
		}
    }

    public void langsamVertikalBewegen(int abstand)
    {
		int delta;

		if(abstand < 0) 
		{
			delta = -1;
			abstand = -abstand;
		}
		else 
		{
			delta = 1;
		}

		for(int i = 0; i < abstand; i++)
		{
			yPosition += delta;
			zeichnen();
		}
    }

    public void groesseAendern(int neueHoehe, int neueBreite)
    {
		loeschen();
		hoehe = neueHoehe;
		breite = neueBreite;
		zeichnen();
    }

    // G�ltige Angaben sind "rot", "gelb", "blau", "gruen",
	// "lila" und "schwarz".
    public void farbeAendern(String neueFarbe)
    {
		farbe = neueFarbe;
		zeichnen();
    }

	// Zeichnet das Dreieck auf die Leinwand
    private void zeichnen()
	{
		if(istSichtbar) {
			Leinwand leinwand = Leinwand.gibLeinwand();
			int[] xPunkte = { xPosition, xPosition + (breite/2), xPosition - (breite/2) };
			int[] yPunkte = { yPosition+hoehe, yPosition, yPosition};
			leinwand.zeichne(this, farbe, new Polygon(xPunkte, yPunkte, 3));
			leinwand.warte(10);
		}
	}

	// Entfernt das Dreieck von der Leinwand
	private void loeschen()
	{
		if(istSichtbar) {
			Leinwand leinwand = Leinwand.gibLeinwand();
			leinwand.entferne(this);
		}
	}
} // Ende der Klasse Dreieck