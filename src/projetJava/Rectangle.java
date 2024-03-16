package projetJava;

public class Rectangle implements Forme {
	
	private double x1, x2, y1, y2;

	public Rectangle(double x1, double y1,double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}
	
	public void deplacerRect(double dx, double dy) {
		this.x1 += dx;
		this.x2 += dx;
		this.y1 += dy;
		this.y2 += dy;
	}
	
	public boolean appartientPoint(double x, double y) {
		return (x>=x1)&&(x<=x2)&&(y>=y1)&&(y<=y2);
	}
	
	public void redimensionner(double k) {
		this.x2 *= k;
		this.y2 *= k;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(1,1,3,3);
		System.out.println(r.appartientPoint(2,3));
		r.redimensionner(0.5);
		System.out.println(r.appartientPoint(2,3));
	}

}
