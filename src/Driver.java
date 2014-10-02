import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class Driver extends javax.swing.JFrame {
    

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
    }
    

   
    private void initComponents() {
    	panel.setBounds(0, 0, 500, 500);
    	this.add(panel);
    	this.setBounds(0,0,500,500);
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
}
