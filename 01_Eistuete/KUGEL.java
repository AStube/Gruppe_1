

public class KUGEL
{
    private String sorte;
    private int position;
    private Kreis c;

    public KUGEL(String s, int pos)
    {
        // Instanzvariable initialisieren
       sorte=s;
       position=pos;
       c = new Kreis(75,60,75);
       
       c.horizontalBewegen(18);
       c.groesseAendern(75);
       c.vertikalBewegen(40-position*35);
       
       if(s=="Schokolade"){
           c.farbeAendern("braun");
        } else if(s=="Erdbeere") {
            c.farbeAendern("rot");
        } else if(s=="Vanille"){
            c.farbeAendern("gelb");
        }
        c.sichtbarMachen();
    }
}
