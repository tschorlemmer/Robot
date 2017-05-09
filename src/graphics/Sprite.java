package graphics;

import java.util.*;
import java.awt.*;

public class Sprite
{
	public ArrayList<Image> pics1, pics2;
	public ArrayList<Boolean> transformed;
	public int curPic;
	public long initial;
	public long timePassed;
	public int updateTime;
	public double size;
	public double ang;
	public ImageAdj adj;
	
	public Sprite()
	{
		updateTime=15;
		initial = System.currentTimeMillis();
		adj= new ImageAdj();
		size = 1;
		ang=0;
		pics1=new ArrayList<Image>();
		pics2=new ArrayList<Image>();
		transformed = new ArrayList<Boolean>();
	}
	public Image getImage()
	{
		System.out.println(ang);
		timePassed= System.currentTimeMillis()-initial;
		curPic= (int)(timePassed/updateTime)%pics1.size();
		return pics2.get(curPic);
	}
	public void addImage(Image newPic)
	{
		pics1.add(newPic);
		pics2.add(newPic);
		transformed.add(false);
		updateSprite();
	}
	public void setImage(int index, Image newPic)
	{
		pics1.set(index,newPic);
		pics2.set(index,newPic);
		transformed.set(index,false);
		updateSprite();
	}
	public double getSize()
	{
		return size;
	}
	public double getAngle()
	{
		return ang;
	}
	public void setSize(double s)
	{
		size=s;
		setFalse();
		updateSprite();
	}
	public void setAngle(double a)
	{
		ang=a;
		setFalse();
		updateSprite();
	}
	public void updateSprite()
	{
		for(int x = 0; x < pics2.size(); x++)
		{
			if(!transformed.get(x))
			{
				System.out.println(x);
				pics2.set(x,adj.rotate(pics1.get(x),ang));
				pics2.set(x,adj.resize(pics1.get(x),size));
			}
		}
	}	
	public void setFalse()
	{
		for(int x = 0; x<transformed.size(); x++)
		{
			transformed.set(x, false);
		}
	}	
}
	

	

