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

	final int frameCount = 10;
	int picNum = 0;
	BufferedImage[] pics;
	int xloc = 0;
	int yloc = 0;
	final int xIncr = 8;
	final int yIncr = 2;
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	int test;
    
    public enum orcAction {
    	FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST, FORWARD_NORTH, FORWARD_SOUTH, FORWARD_EAST, FORWARD_WEST
    }
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
    		
    		switch(currentDirection){// Redirection
	    		case EAST:
	    			currentDirection = orcAction.FORWARD_WEST;
    		switch(currentAction){// Redirection
	    		case FORWARD_EAST:
	    			currentAction = OrcAction.FORWARD_WEST;
	    			break;
	    		case NORTHEAST:
	    			currentDirection = orcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    		case FORWARD_NORTHEAST:
	    			currentAction = OrcAction.FORWARD_NORTHWEST;
	    			break;
	    		case SOUTHEAST:
	    			currentDirection = orcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    		case FORWARD_SOUTHEAST:
	    			currentAction = OrcAction.FORWARD_SOUTHWEST;
	    			break;
    		}
    	}
    	else if (xloc < 0){//West boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case WEST:
	    			currentDirection = orcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
    		g.drawImage(currentPics[picNum], xloc, yloc, Color.gray, this);
    		
    		actionHasChanged = true;
    		
    		switch(currentAction){
	    		case FORWARD_WEST:
	    			currentAction = OrcAction.FORWARD_EAST;
	    			break;
	    		case NORTHWEST:
	    			currentDirection = orcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    		case FORWARD_NORTHWEST:
	    			currentAction = OrcAction.FORWARD_NORTHEAST;
	    			break;
	    		case SOUTHWEST:
	    			currentDirection = orcAction.FORWARD_SOUTHEAST;
	    			break;
	    	}
    	}
    	else if (yloc >= (frameHeight - imgHeight)){// South boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case SOUTH:
	    			currentDirection = orcAction.FORWARD_NORTH;
	    			break;
	    		case SOUTHEAST:
	    			currentDirection = orcAction.FORWARD_NORTHEAST;
	    			break;
	    		case SOUTHWEST:
	    			currentDirection = orcAction.FORWARD_NORTHWEST;
	    			break;
	    	}
    	}
    	else if (yloc < 0){// North boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case NORTH:
	    			currentDirection = orcAction.FORWARD_SOUTH;
	    			break;
	    		case NORTHEAST:
	    			currentDirection = orcAction.FORWARD_SOUTHEAST;
	    			break;
	    		case NORTHWEST:
	    			currentDirection = orcAction.FORWARD_SOUTHWEST;
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
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls. Test
    	//Be sure that animation picture direction matches what is happening on screen.
    }

	//Make frame, loop on repaint and wait
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Animation[] ans = new Animation[8];
		ans[0] = new Animation(orcAction.FORWARD_EAST);
		ans[1] = new Animation(orcAction.FORWARD_NORTH);
		ans[2] = new Animation(orcAction.FORWARD_NORTHEAST);
		ans[3] = new Animation(orcAction.FORWARD_NORTHWEST);
		ans[4] = new Animation(orcAction.FORWARD_SOUTH);
		ans[5] = new Animation(orcAction.FORWARD_SOUTHEAST);
		ans[6] = new Animation(orcAction.FORWARD_SOUTHWEST);
		ans[7] = new Animation(orcAction.FORWARD_WEST);
		frame.getContentPane().add(ans[1]);
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
	public Animation(orcAction specifiedAction){
		BufferedImage img = createImage(specifiedAction);
		pics = new BufferedImage[frameCount];
		for(int i = 0; i < frameCount; i++)
			pics[i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);

		// TODO: Change this constructor so that at least eight orc animation pngs are loaded
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
    		System.out.println(file);
    		bufferedImage = ImageIO.read(new File(file));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	actionHasChanged = false;
    }
}
    

