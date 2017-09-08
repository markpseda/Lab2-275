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
	final int xIncr = 8;
	final int yIncr = 2;
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	boolean directionHasChanged = false;
    
    public enum orcAction {
    	FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST, FORWARD_NORTH, FORWARD_SOUTH, FORWARD_EAST, FORWARD_WEST
    }
    
    orcAction currentDirection;
    orcAction oldDirection;

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	/*CARDINAL DIRECTION TO FRAME ORIENTATION
    	 * North = Top of the frame
    	 * South = Bottom of the frame
    	 * East = Right of the frame
    	 * West = Left of the frame
    	 */
   
    	if(xloc >= (frameWidth - imgWidth)){// East boundary switching direction
    		oldDirection = currentDirection;
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		
    		switch(currentDirection){// Redirection
	    		case FORWARD_EAST:
	    			currentDirection = orcAction.FORWARD_WEST;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			currentDirection = orcAction.FORWARD_NORTHWEST;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			currentDirection = orcAction.FORWARD_SOUTHWEST;
	    			directionHasChanged = true;
	    			break;
    		}
    	}
    	else if (xloc < 0){//West boundary switching direction
    		oldDirection = currentDirection;
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case FORWARD_WEST:
	    			currentDirection = orcAction.FORWARD_EAST;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			currentDirection = orcAction.FORWARD_NORTHEAST;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			currentDirection = orcAction.FORWARD_SOUTHEAST;
	    			directionHasChanged = true;
	    			break;
	    	}
    	}
    	else if (yloc >= (frameHeight - imgHeight)){// South boundary switching direction
    		oldDirection = currentDirection;
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case FORWARD_SOUTH:
	    			currentDirection = orcAction.FORWARD_NORTH;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			currentDirection = orcAction.FORWARD_NORTHEAST;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			currentDirection = orcAction.FORWARD_NORTHWEST;
	    			directionHasChanged = true;
	    			break;
	    	}
    	}
    	else if (yloc < 0){// North boundary switching direction
    		oldDirection = currentDirection;
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case FORWARD_NORTH:
	    			currentDirection = orcAction.FORWARD_SOUTH;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			currentDirection = orcAction.FORWARD_SOUTHEAST;
	    			directionHasChanged = true;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			currentDirection = orcAction.FORWARD_SOUTHWEST;
	    			directionHasChanged = true;
	    			break;
	    	}
    	}
    	picNum = (picNum + 1) % frameCount;
    	
    	 switch(currentDirection){// Increments coordinates by direction
	 		case FORWARD_NORTH:
	 			g.drawImage(pics[picNum], xloc, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTH:
	 			g.drawImage(pics[picNum], xloc, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_EAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_WEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHEAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHWEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHEAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHWEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 	}
    }
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls. Test
    	//Be sure that animation picture direction matches what is happening on screen.

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
		int currentAnimation = 3;
		frame.getContentPane().add(ans[currentAnimation]);
		
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		for(int i = 0; i < 1000; i++){
			if(ans[currentAnimation].directionHasChanged){
				orcAction newDirection = ans[currentAnimation].currentDirection; //get the newly changed direction from the animation object
				frame.getContentPane().remove(ans[currentAnimation]);
				ans[currentAnimation].currentDirection = ans[currentAnimation].oldDirection;
				int newx = ans[currentAnimation].xloc;
				int newy = ans[currentAnimation].yloc;
				switch(newDirection){
					case FORWARD_EAST:
						currentAnimation = 0;
						break;
					case FORWARD_NORTH:
						currentAnimation = 1;
						break;
					case FORWARD_NORTHEAST:
						currentAnimation = 2;
						break;
					case FORWARD_NORTHWEST:
						currentAnimation = 3;
						break;
					case FORWARD_SOUTH:
						currentAnimation = 4;
						break;
					case FORWARD_SOUTHEAST:
						currentAnimation = 5;
						break;
					case FORWARD_SOUTHWEST:
						currentAnimation = 6;
						break;
					case FORWARD_WEST:
						currentAnimation = 7;
						break;
				}
				ans[currentAnimation].xloc = newx;
				ans[currentAnimation].yloc = newy;
				ans[currentAnimation].directionHasChanged = false;
				
				frame.getContentPane().add(ans[currentAnimation]); //replace with new animation
				frame.setBackground(Color.gray);
			}
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
		this.currentDirection = specifiedAction;
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
    	return null;
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
}
