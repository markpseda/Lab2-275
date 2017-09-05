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
    public enum OrcAction {
    	NORTH,SOUTH,EAST,WEST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST
    	}
    OrcAction currentDirection = OrcAction.SOUTHEAST; //Initialized direction
   

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
    		
    		switch(currentDirection){// Redirection
	    		case EAST:
	    			currentDirection = OrcAction.WEST;
	    			break;
	    		case NORTHEAST:
	    			currentDirection = OrcAction.NORTHWEST;
	    			break;
	    		case SOUTHEAST:
	    			currentDirection = OrcAction.SOUTHWEST;
	    			break;
    		}
    	}
    	else if (xloc < 0){//West boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case WEST:
	    			currentDirection = OrcAction.EAST;
	    			break;
	    		case NORTHWEST:
	    			currentDirection = OrcAction.NORTHEAST;
	    			break;
	    		case SOUTHWEST:
	    			currentDirection = OrcAction.SOUTHEAST;
	    			break;
	    	}
    	}
    	else if (yloc >= (frameHeight - imgHeight)){// South boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case SOUTH:
	    			currentDirection = OrcAction.NORTH;
	    			break;
	    		case SOUTHEAST:
	    			currentDirection = OrcAction.NORTHEAST;
	    			break;
	    		case SOUTHWEST:
	    			currentDirection = OrcAction.NORTHWEST;
	    			break;
	    	}
    	}
    	else if (yloc < 0){// North boundary switching direction
    		g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
    		switch(currentDirection){
	    		case NORTH:
	    			currentDirection = OrcAction.SOUTH;
	    			break;
	    		case NORTHEAST:
	    			currentDirection = OrcAction.SOUTHEAST;
	    			break;
	    		case NORTHWEST:
	    			currentDirection = OrcAction.SOUTHWEST;
	    			break;
	    	}
    	}
    	picNum = (picNum + 1) % frameCount;
    	
    	 switch(currentDirection){// Increments coordinates by direction
	 		case NORTH:
	 			g.drawImage(pics[picNum], xloc, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case SOUTH:
	 			g.drawImage(pics[picNum], xloc, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case EAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc, Color.gray, this);
	 			break;
	 		case WEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc, Color.gray, this);
	 			break;
	 		case NORTHEAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case NORTHWEST:
	 			g.drawImage(pics[picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
	 			break;
	 		case SOUTHEAST:
	 			g.drawImage(pics[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	 			break;
	 		case SOUTHWEST:
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
    	BufferedImage img = createImage();
    	pics = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		pics[i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    }  
    
    //Read image from file and return
    private BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc/orc_forward_southeast.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
}
