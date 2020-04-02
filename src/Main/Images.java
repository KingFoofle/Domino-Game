package Main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage dominoSheet;
	public static BufferedImage one, two, three, four, five, six;
	public static BufferedImage twoTilt, threeTilt, sixTilt, back;	


	public BufferedImage crop(BufferedImage image, int x, int y, int width, int height){
		return image.getSubimage(x,y,width,height);
	}
	
	public Images() {
        try {
			dominoSheet = ImageIO.read(getClass().getResourceAsStream("/domino.jpg"));
			
			one = crop(dominoSheet,0,0,35,35);
			two = crop(dominoSheet,36,0,35,35);
			three = crop(dominoSheet,72,0,35,35);
			four = crop(dominoSheet,0,36,35,35);
			five = crop(dominoSheet,36,36,35,35);
			six = crop(dominoSheet,72,36,35,35);
			twoTilt = crop(dominoSheet,108,0,35,35);
			threeTilt = crop(dominoSheet,108,36,35,35);
			sixTilt = crop(dominoSheet,144,0,35,35);
			back = crop(dominoSheet,144,36,35,35);
		} 
        
        catch (IOException e) {e.printStackTrace();}
	}

}