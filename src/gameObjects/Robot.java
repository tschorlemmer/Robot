package gameObjects;

import java.awt.Image;
import java.util.ArrayList;

public class Robot extends MovingEntity{

	public Robot(Image image) {
		super(image);
	}
	public Robot(double x, double y, Image image){
		super(x,y,image);
	}
}
