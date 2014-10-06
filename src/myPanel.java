import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


public class myPanel extends JPanel{

	/**
	 * 
	 */
	static int SQUARE_SIDE = 10;
	final int N=450;
	final int N1 = 10;
	ArrayList<Item> allItems = new ArrayList<Item>();
	Random r = new Random();
	public myPanel(){
		addItems();
	}
	  
	/**
	 * Checks to see if the squares starting at p1 and p2 would intersect
	 * @param p1: starting point for current rect
	 * @param p2: starting point for possible rect, pending no collions
	 * @return true if there is no collision, false if there is.
	 */
	public boolean noCollisionCheck(Point p1, Point p2){
		if(p1.x==p2.x && p1.y==p2.y){return false;}
		return true;
	}
	/**
	 * Creates a new point with x and y random cordinates rounded to nearest 10
	 * @return a new point.
	 */
	public Point getNewPoint(){

		return new Point(Math.round(r.nextInt(N)/10)*10,Math.round(r.nextInt(N)/10)*10);
	}
	/**
	 * Gets an item then tries to move it. We compare the incoming item to all items to check for collisions.
	 * If no collisions are found we move 'i' based on a random r
	 * @param i - The incoming item we are compareing
	 * @param c - The spot of the index of the current item
	 */
	public void moveItem(Item i, int c){
		Point newPoint;
		Point oldPoint = i.getLocation();
		Random r = new Random();
		
		//Get coordinates for new point
		switch(r.nextInt(4)){
		case 1://Increase x by square_side
			newPoint = new Point(oldPoint.x+SQUARE_SIDE,oldPoint.y);
			break;
		case 2://Decrease x by squar_side
			newPoint = new Point(oldPoint.x-SQUARE_SIDE,oldPoint.y);
			break;
		case 3://Incrase y by squar_side
			newPoint = new Point(oldPoint.x,oldPoint.y+SQUARE_SIDE);
			break;
		case 4://Decrease y by square_side
			newPoint = new Point(oldPoint.x,oldPoint.y-SQUARE_SIDE);
			break;
		default://Shouldn't ever happen
			newPoint=oldPoint;
			break;
		}
		//Check to see if there will be within the frame
		if(!checkBounds(newPoint)){
			return;
		}
		//Check to see if there are any collisions
		for(Item a:allItems){
			if(!noCollisionCheck(newPoint,a.getLocation())){return;}
		}
		//Since the new point is within the frame and didn't cause a collision with any other points
		//Update the new points and repaint
		allItems.get(c).setLocation(newPoint);
		repaint();
	}
	/**
	 * This makes sure all the squares stay in the frame.
	 * @return True if the bounds are within the frame.
	 * @return False if the bounds are not within the frame.
	 */
	public boolean checkBounds(Point p){
		if(p.getX()<0 || p.getX()>500){return false;}
		if(p.getY()<0 || p.getY()>500){return false;}
		return true;
	}
	public void moveEverything(){
		int count=0;
		for(Item i: allItems){
			if(i instanceof Bear || i instanceof LumberJack){moveItem(i,count);}
			else if(i instanceof Tree){}
			else{System.out.println("This shouldn't happen");}
			count++;
		}
	} 
    /**
     * adds all starting trees, bears, and lumberjacks to the array
     * Calls  noCollisionCheck(),  getNewPoint()
     */
	private void addItems(){
    	allItems.add(new LumberJack(getNewPoint()));
    	boolean newItem=false;
    	Point p;
    	//Add LumberJacks -> 10% of map. 10 is hardcoded for now.
    	for(int i=0;i<90;i++){
    		 p = getNewPoint();
    		for(Item current: allItems){//Compare the 
    			while(newItem==false){//If current point is within an exiting item, create a new point and try again
    				
    				//if(current.getLocation().equals(p)){
    				if(!noCollisionCheck(current.getLocation(), p)){
    					p=getNewPoint();
    				}
    				else{newItem=true;}
    			}
    			newItem=false;
    			allItems.add(new LumberJack(p));
    			break;
    		}
    	}
    	//Add Trees -> 50% of map
    	for(int i=0;i<50;i++){
    		p = getNewPoint();
    		for(Item current: allItems){//Compare the 
    			while(newItem==false){
    				if(current.getLocation().equals(p)){
    				//	if(!noCollisionCheck(current.getLocation(), p)){
    					p=getNewPoint();}
    				else{newItem=true;}
    			}
    			newItem=false;
    			allItems.add(new Tree(p));
    			break;
    		}
    	}
    	//Add bears -> 2% of map
    	for(int i=0;i<2;i++){
    		p = getNewPoint();
    		for(Item current: allItems){//Compare the 
    			while(newItem==false){
    				//if(current.getLocation().equals(p)){
    					if(!noCollisionCheck(current.getLocation(), p)){
    					p=getNewPoint();}
    				else{newItem=true;}
    			}
    			newItem=false;
    			allItems.add(new Bear(p));
    			break;
    		}
    	}
    }
	private static final long serialVersionUID = 1L;
	@Override
	protected void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   for(Item i: allItems){
		   g.setColor(i.getColor());
		   g.drawRect(i.getLocation().x, i.getLocation().y, SQUARE_SIDE,SQUARE_SIDE);
	   }
   }
	public void runSimulation() {
		moveEverything();
	}
}


