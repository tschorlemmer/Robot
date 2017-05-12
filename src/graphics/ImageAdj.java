package graphics;

import java.util.*;
import java.awt.Image;
import java.awt.geom.*;
import java.awt.image.*;
//Rotates and resizes images
public class ImageAdj
{
	public double ang;
	public double size;
	public ImageAdj(){
		ang =0;
		size =1;
	}
	public Image rotate(Image img, double angle)
	{
		ang = angle;
		BufferedImage image = (BufferedImage)img;
		double rotationRequired = Math.toRadians(angle);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return(op.filter(image,null));
	}
	
	public Image resize(Image img, int width, int height)
	{
		return img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}
	
	public Image resize(Image img, double percent)
	{
		size = percent;
		BufferedImage image = (BufferedImage)img;
		double width= image.getWidth()*percent;
		double height= image.getHeight()*percent;
		return img.getScaledInstance((int)width, (int)height, Image.SCALE_DEFAULT);
	}
	public ArrayList<Image> resizeAll(ArrayList<Image> imgs, double percent)
	{
		ArrayList<Image> newImgs=new ArrayList<Image>();
		for(int x =0; x<imgs.size();x++)
		{
			BufferedImage image = (BufferedImage)imgs.get(x);
			double width= image.getWidth()*percent;
			double height= image.getHeight()*percent;
			newImgs.add(imgs.get(x).getScaledInstance((int)width, (int)height, Image.SCALE_DEFAULT));
		}
		return(newImgs);
	}
	
	public ArrayList<Image> rotateAll(ArrayList<Image> imgs, double angle)
	{
		ArrayList<Image> newImgs=new ArrayList<Image>();
		for(int x =0; x<imgs.size();x++)
		{
			BufferedImage image = (BufferedImage)imgs.get(x);
			double rotationRequired = Math.toRadians(angle);
			double locationX = image.getWidth() / 2;
			double locationY = image.getHeight() / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			newImgs.add(op.filter(image,null));
		}
		return(newImgs);
	}
	
}