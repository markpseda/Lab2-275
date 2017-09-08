//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {

    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[] pics;
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 20;
    final int yIncr = 20;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    public enum OrcAction {
    	FORWARD_NORTH,FORWARD_SOUTH,FORWARD_EAST,FORWARD_WEST, FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST
    	}
    OrcAction currentAction = OrcAction.FORWARD_SOUTHWEST; //initialized in constructor, specifies which images to display and which direction to move.
   

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	/*CARDINAL DIRECTION TO FRAME ORIENTATION
    	 * North = Top of the frame
    	 * South = Bottom of the frame
    	 * East = Right of the frame
    	 * West = Left of the frame
    	 */
   
    	if(xloc >= (frameWidth - imgWidth)){// East boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		
    		switch(currentAction){// Redirection
	    		case FORWARD_EAST:
	    			currentAction = OrcAction.FORWARD_WEST;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    			break;
    		}
    	}
    	else if (xloc < 0){//West boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			currentAction = OrcAction.FORWARD_SOUTHEAST;
	    			break;
	    	}
    	}
    	else if (yloc >= (frameHeight - imgHeight)){// South boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentAction){
	    		case FORWARD_SOUTH:
	    			currentAction = OrcAction.FORWARD_NORTH;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    			break;
	    	}
    	}
    	else if (yloc < 0){// North boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentAction){
	    		case FORWARD_NORTH:
	    			currentAction = OrcAction.FORWARD_SOUTH;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHEAST;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    			break;
	    	}
    	}
    	picNum = (picNum + 1) % frameCount;
    	
    	 switch(currentAction){// Increments coordinates by direction
	 		case FORWARD_NORTH:
	 			g.drawImage(pics[picNum], xloc, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTH:
	 			g.drawImage(pics[picNum], xloc, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_EAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_WEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHEAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHWEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHEAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHWEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 	}
    }
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
	//Be sure that animation picture direction matches what is happening on screen.
    
    


    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(new Animation());
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }

    //Constructor: get image, segment and store in array
    public Animation(){
    	//this.currentAction =  OrcAction;
    	BufferedImageGenerator forward_southeast = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_southeast.png");
    	
    	pics = forward_southeast.getBufferedImageArray();
    	
    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    }  
    
}
