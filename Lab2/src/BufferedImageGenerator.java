import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageGenerator {
	// All of the below attributes do not change once inizialized
    final int imgWidth; //image width
    final int imgHeight; //image height
    final int frameCount; // number of frames contained in the image
    final String imagePath;
    BufferedImage[] test = new BufferedImage[10];
    
    public BufferedImageGenerator(int imgWidth, int imgHeight, int frameCount, String imagePath){
    	this.imgWidth = imgWidth;
    	this.imgHeight = imgHeight;
    	this.frameCount = frameCount;
    	this.imagePath = imagePath;
    }
    
    /**
     * This method is called after the BufferedImageGenerator in created to return an array of images that can be properly painted.
     * This method is called once for each animation that a given Animation object may have to perform. 
     * @return
     */
    public BufferedImage[] getBufferedImageArray(){
    	BufferedImage EntireBufferedImage = createImage(this.imagePath); //Long image, not parsed into the correct array
    	BufferedImage[] bufferedImageArray = new BufferedImage[frameCount];
    	for(int i = 0; i < frameCount; i++)
    		bufferedImageArray[i] = EntireBufferedImage.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	return bufferedImageArray;
    }

    private BufferedImage createImage(String imagePath){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(imagePath));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}
