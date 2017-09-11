//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm

// Lab 2 CISC 275-010 Fall 2017
// Worked on by:
// Daniel Schmidt
// Kaeini Ekong
// Mark Seda

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
	BufferedImage[][] pics;
	int xloc = 0;
	int yloc = 0;
	final int xIncr = 8;
	final int yIncr = 2;
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	int test;
	orcAction currentDirection = orcAction.FORWARD_SOUTHEAST;
    
    public enum orcAction {
    	FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST, FORWARD_NORTH, FORWARD_SOUTH, FORWARD_EAST, FORWARD_WEST
    }

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	/*CARDINAL DIRECTION TO FRAME ORIENTATION
    	 * North = Top of the frame
    	 * South = Bottom of the frame
    	 * East = Right of the frame
    	 * West = Left of the frame
    	 */
   
    	if(xloc >= (frameWidth - imgWidth)){// East boundary switching direction
    		g.drawImage(pics[currentDirection.ordinal()][picNum], xloc, yloc, Color.gray, this);
    		
    		switch(currentDirection){// Redirection
	    		case FORWARD_EAST:
	    			currentDirection = orcAction.FORWARD_WEST;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			currentDirection = orcAction.FORWARD_NORTHWEST;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			currentDirection = orcAction.FORWARD_SOUTHWEST;
	    			break;
    		}
    	}
    	else if (xloc < 0){//West boundary switching direction
    		g.drawImage(pics[currentDirection.ordinal()][picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case FORWARD_WEST:
	    			currentDirection = orcAction.FORWARD_EAST;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			currentDirection = orcAction.FORWARD_NORTHEAST;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			currentDirection = orcAction.FORWARD_SOUTHEAST;
	    			break;
	    	}
    	}
    	else if (yloc >= (frameHeight - imgHeight)){// South boundary switching direction
    		g.drawImage(pics[currentDirection.ordinal()][picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case FORWARD_SOUTH:
	    			currentDirection = orcAction.FORWARD_NORTH;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			currentDirection = orcAction.FORWARD_NORTHEAST;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			currentDirection = orcAction.FORWARD_NORTHWEST;
	    			break;
	    	}
    	}
    	else if (yloc < 0){// North boundary switching direction
    		g.drawImage(pics[currentDirection.ordinal()][picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case FORWARD_NORTH:
	    			currentDirection = orcAction.FORWARD_SOUTH;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			currentDirection = orcAction.FORWARD_SOUTHEAST;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			currentDirection = orcAction.FORWARD_SOUTHWEST;
	    			break;
	    			}
    }
    	picNum = (picNum + 1) % frameCount;
    	
    	 switch(currentDirection){// Increments coordinates by direction
	 		case FORWARD_NORTH:
	 			g.drawImage(pics[orcAction.FORWARD_NORTH.ordinal()][picNum], xloc, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTH:
	 			g.drawImage(pics[orcAction.FORWARD_SOUTH.ordinal()][picNum], xloc, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_EAST:
	 			g.drawImage(pics[orcAction.FORWARD_EAST.ordinal()][picNum], xloc+=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_WEST:
	 			g.drawImage(pics[orcAction.FORWARD_WEST.ordinal()][picNum], xloc-=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHEAST:
	 			g.drawImage(pics[orcAction.FORWARD_NORTHEAST.ordinal()][picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHWEST:
	 			g.drawImage(pics[orcAction.FORWARD_NORTHWEST.ordinal()][picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHEAST:
	 			g.drawImage(pics[orcAction.FORWARD_SOUTHEAST.ordinal()][picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHWEST:
	 			g.drawImage(pics[orcAction.FORWARD_SOUTHWEST.ordinal()][picNum], xloc-=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 	}
    }

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

	//Each different png is contained in pics in its instance of Animation
	
	//Constructor: get image, segment and store in array
	public Animation(){
		BufferedImage img;
		pics = new BufferedImage[orcAction.values().length][frameCount];
		for (orcAction a : orcAction.values()) {
			for (int i = 0; i < frameCount; i++) {
				img = createImage(a);
				pics[a.ordinal()][i] = img.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			}
		}
	}
    
    //Read image from file and return 
    private BufferedImage createImage(orcAction specifiedAction){ //orcAction is an enum
    	BufferedImage bufferedImage;
    	String file = "";
    	switch(specifiedAction){
    	case FORWARD_NORTHEAST: 
    		file = "images/orc/orc_forward_northeast.png";
    		break;
    	case FORWARD_NORTHWEST:
    		file = "images/orc/orc_forward_northwest.png";
    		break;
    	case FORWARD_SOUTHEAST:
    		file = "images/orc/orc_forward_southeast.png";
    		break;
    	case FORWARD_SOUTHWEST:
    		file = "images/orc/orc_forward_southwest.png";
    		break;
    	case FORWARD_NORTH:
    		file = "images/orc/orc_forward_north.png";
    		break;
    	case FORWARD_SOUTH:
    		file = "images/orc/orc_forward_south.png";
    		break;
    	case FORWARD_EAST:
    		file = "images/orc/orc_forward_east.png";
    		break;
    	case FORWARD_WEST:
    		file = "images/orc/orc_forward_west.png";
    		break;
    	}
    	try {
    		bufferedImage = ImageIO.read(new File(file));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}
