package graphics;

import java.util.*;
import java.awt.*;

public class Sprite extends ImageAdj
{
	public ArrayList<Image> pics1, pics2, pics3;
	public int curPic;
	public long initial;
	public long timePassed;
	public int updateTime;
	public long ang;
	public long size;
	
	public Sprite()
	{
		updateTime=15;
		initial = System.currentTimeMillis();
		updateSprite();
	}
	public Image getImage()
	{
		timePassed= System.currentTimeMillis()-initial;
		curPic= (int)(timePassed/updateTime)%pics1.size();
		return pics1.get(curPic);
	}
	public void addImage(Image newPic)
	{
		pics1.add(newPic);
		updateSprite();
	}
	public void setImage(int index, Image newPic)
	{
		pics1.set(index,newPic);
		updateSprite();
	}
	public void updateSprite()
	{
		
	}
	
}
	

