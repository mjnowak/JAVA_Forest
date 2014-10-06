import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Driver extends JFrame implements ActionListener{
    

    /**
	 * Eclipse needs this or it gets mad at me.
	 */
	private static final long serialVersionUID = 1L;

	final int N=10;
	Item allItems[][] = new Item[N][N];
	Random r = new Random();

	JFrame frame = new JFrame();
	myPanel panel = new myPanel();
	
	public Driver() {
        initComponents();
        // a timer called every 1/10 second

        Timer timer = new Timer(1000, this);

        timer.start();
    }
       
    private void initComponents() {
    	panel.setBounds(0, 0, 500, 500);
    	this.add(panel);
    	this.setBounds(0,0,750,750);
    	panel.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Driver().setVisible(true);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
        	panel.runSimulation();
        	try {
        	    Thread.sleep(100);                 //1000 milliseconds is one second.
        	} catch(InterruptedException ex) {
        	    Thread.currentThread().interrupt();
        	}
        	System.out.println("Stop and check");
        }
}
