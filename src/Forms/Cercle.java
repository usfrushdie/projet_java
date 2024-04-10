package Forms;

public class Cercle {
	
	private double Xc;
	private double Yc;
	private double rayon;
	
	
	public Cercle(double xc, double yc, double rayon) {
		super();
		Xc = xc;
		Yc = yc;
		this.rayon = rayon;
	}

	public double getXc() {
		return Xc;
	}

	public void setXc(double xc) {
		Xc = xc;
	}

	public double getYc() {
		return Yc;
	}

	public void setYc(double yc) {
		Yc = yc;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public void deplacerRect(int dx, int dy) {
		this.Xc += dx;
		this.Yc += dy;
	}
	
	public boolean appartientPoint(int x, int y) {
		return (Math.pow(Xc-x,2)+Math.pow(Yc-y,2))<=this.rayon*this.rayon;
	}
	
	public void redimensionner(double k) {
		this.rayon *= k;
	}

	public static void main(String[] args) {
		Cercle c = new Cercle(0,0,3);
		System.out.println(c.appartientPoint(2,3));
		c.redimensionner(2.5);
		System.out.println(c.appartientPoint(2,3));
	}

}