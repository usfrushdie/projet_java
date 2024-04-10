package Forms;

public interface Forme {
	
	public void deplacerRect(int dx, int dy);
	
	public boolean appartientPoint(int x, int y);
	
	public void redimensionner(int k);

}