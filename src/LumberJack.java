import java.awt.Color;
import java.awt.Point;


public class LumberJack implements Item{


	Point currentLocation = new Point(-1,-1);
	public LumberJack(Point p) {
		// TODO Auto-generated constructor stub
		currentLocation = p;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return currentLocation;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

}
