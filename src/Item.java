import java.awt.Color;
import java.awt.Point;


public interface Item {
	

	public void move();
	public Point getLocation();
	public void setLocation(Point p);
	public Color getColor();
}
