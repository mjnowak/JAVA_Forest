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
	     * adds all starting trees, bears, and lumberjacks to the array
	     */
	    private void addItems(){
	    	int totalSize =N*N;
	    	allItems.add(new LumberJack(getNewPoint()));
	    	boolean newItem=false;
	    	Point p;
	    	//Add LumberJacks -> 10% of map. 10 is hardcoded for now.
	    	for(int i=0;i<10;i++){
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
	    	System.out.println("Stop");
	    }
	private static final long serialVersionUID = 1L;
	   @Override
	   protected void paintComponent(Graphics g) {
		   super.paintComponent(g);
	      	for(Item i: allItems){
	      		g.setColor(i.getColor());
	      		g.drawRect(i.getLocation().x, i.getLocation().y, 10,10);
	      	}
	      }
	   }


