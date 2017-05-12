package graphics;

import java.util.*;					
import java.awt.Image;
import java.awt.geom.*;
import java.awt.image.*;
//Rotates and resizes images
public class ImageAdj
{
	//rotate(image,angle)
	public static Image rotate(Image img, double angle)
	{
		BufferedImage image = toBufferedImage(img);
		double rotationRequired = Math.toRadians(angle);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return(op.filter(image,null));
	}
	
	public static Image resize(Image img, int width, int height)
	{
		return img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}
	
	public static Image resize(Image img, double percent)
	{
		BufferedImage image = toBufferedImage(img);
		double width= image.getWidth()*percent;
		double height= image.getHeight()*percent;
		return img.getScaledInstance((int)width, (int)height, Image.SCALE_DEFAULT);
	}
	
	public static ArrayList<Image> rotateAll(ArrayList<Image> imgs, double angle)
	{
		ArrayList<Image> newImgs=new ArrayList<Image>();
		for(int x =0; x<imgs.size();x++)
		{
			BufferedImage image = toBufferedImage(imgs.get(x));
			double rotationRequired = Math.toRadians(angle);
			double locationX = image.getWidth() / 2;
			double locationY = image.getHeight() / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			newImgs.add(op.filter(image,null));
		}
		return(newImgs);
	}
	
	public static BufferedImage toBufferedImage(Image img)
	{
	  	return (BufferedImage) img;
	}
	
}