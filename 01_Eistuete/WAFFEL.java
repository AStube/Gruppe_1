
public class WAFFEL
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Dreieck d1;

    public WAFFEL()
    {
        // Instanzvariable initialisieren
        d1 = new Dreieck();
    }

    public void farbeAendern(String s){
        d1.farbeAendern(s);
    }
    
    public void groesseAendern(int x, int y){
        d1.groesseAendern(x,y);
    }
    
    public void vertikalVerschieben(int x){
        d1.vertikalBewegen(x);
    }
    
    public void horizontalVerschieben(int y){
        d1.horizontalBewegen(y);
    }
}
