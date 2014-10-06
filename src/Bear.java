import java.awt.Color;
import java.awt.Point;


public class Bear implements Item{


	Point currentLocation = new Point(-1,-1);
	public Bear(Point p) {
		currentLocation=p;
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
		return Color.red;
	}



	@Override
	public void setLocation(Point p) {
		// TODO Auto-generated method stub
		currentLocation = p;
	}

}
