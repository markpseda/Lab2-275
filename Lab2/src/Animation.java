//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {
    int picNum = 0;
    BufferedImage[] currentPics;
    
    ArrayList<BufferedImage[]> allPics = new ArrayList<BufferedImage[]>(); //ArrayList of arrays of buffered images
    
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 20;
    final int yIncr = 20;
    
    // The below are only constant because the forward_ animations have the same characteristics. 
    final static int frameCount = 10;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    
    public enum OrcAction {
    	FORWARD_NORTH,FORWARD_SOUTH,FORWARD_EAST,FORWARD_WEST, FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST;
    }
    
    
    
    
    OrcAction currentAction = OrcAction.FORWARD_SOUTHEAST; //initialized in constructor, specifies which images to display and which direction to move.
   
    boolean actionHasChanged = false;
    

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	/*CARDINAL DIRECTION TO FRAME ORIENTATION
    	 * North = Top of the frame
    	 * South = Bottom of the frame
    	 * East = Right of the frame
    	 * West = Left of the frame
    	 */
   
    	if(xloc >= (frameWidth - imgWidth)){// East boundary switching direction
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
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
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
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
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		actionHasChanged = true;
    		
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
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		actionHasChanged = true;
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
	 			g.drawImage(currentPics[picNum], xloc, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTH:
	 			g.drawImage(currentPics[picNum], xloc, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_EAST:
	 			g.drawImage(currentPics[picNum], xloc+=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_WEST:
	 			g.drawImage(currentPics[picNum], xloc-=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHEAST:
	 			g.drawImage(currentPics[picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHWEST:
	 			g.drawImage(currentPics[picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHEAST:
	 			g.drawImage(currentPics[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHWEST:
	 			g.drawImage(currentPics[picNum], xloc-=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 	}
    }
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
	//Be sure that animation picture direction matches what is happening on screen.
    
    


    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	Animation Orc = new Animation();
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(Orc);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		if(Orc.actionHasChanged)
    			Orc.changeAnimation(Orc.currentAction);
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }

    //Constructor: get image, segment and store in array
    public Animation(){
        	
    	BufferedImageGenerator forward_north = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_north.png");
    	BufferedImageGenerator forward_south = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_south.png");
    	BufferedImageGenerator forward_east = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_east.png");
    	BufferedImageGenerator forward_west = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_west.png");
    	BufferedImageGenerator forward_northeast = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_northeast.png");
    	BufferedImageGenerator forward_northwest = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_northwest.png");
    	BufferedImageGenerator forward_southeast = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_southeast.png");
    	BufferedImageGenerator forward_southwest = new BufferedImageGenerator(imgWidth, imgHeight, frameCount, "images/orc/orc_forward_southwest.png");
    	
    	allPics.add(forward_north.getBufferedImageArray());
    	allPics.add(forward_south.getBufferedImageArray());
    	allPics.add(forward_east.getBufferedImageArray());
    	allPics.add(forward_west.getBufferedImageArray());
    	allPics.add(forward_northeast.getBufferedImageArray());
    	allPics.add(forward_northwest.getBufferedImageArray());
    	allPics.add(forward_southeast.getBufferedImageArray());
    	allPics.add(forward_southwest.getBufferedImageArray());
    	
    	changeAnimation(this.currentAction);
    	
    }  
    
    
    public void changeAnimation(OrcAction newAction){
    	switch(newAction){
    	case FORWARD_NORTH:
    		currentPics = allPics.get(0); //change to north pics
    		actionHasChanged = false;
    		break;
    	case FORWARD_SOUTH:
    		currentPics = allPics.get(1); //change to south pics
    		actionHasChanged = false;
    		break;	
    	case FORWARD_EAST:
    		currentPics = allPics.get(2); //change to north pics
    		actionHasChanged = false;
    		break;
    	case FORWARD_WEST:
    		currentPics = allPics.get(3); //change to south pics
    		actionHasChanged = false;
    		break;	
    	case FORWARD_NORTHEAST:
    		currentPics = allPics.get(4); //change to north pics
    		actionHasChanged = false;
    		break;
    	case FORWARD_NORTHWEST:
    		currentPics = allPics.get(5); //change to south pics
    		actionHasChanged = false;
    		break;	
    	case FORWARD_SOUTHEAST:
    		currentPics = allPics.get(6); //change to north pics
    		actionHasChanged = false;
    		break;
    	case FORWARD_SOUTHWEST:
    		currentPics = allPics.get(7); //change to south pics
    		actionHasChanged = false;
    		break;	
    	default:
    		break;			
    	}
    	actionHasChanged = false;
    }
    	
}
    

