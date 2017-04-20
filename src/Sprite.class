import java.util.*;								
import static java.lang.System.*;
import java.awt.*;

public class Sprite
{
	public ArrayList<Image> pics;
	public int curPic;
	public long initial;
	public long timePassed;
	public int updateTime;
	
	public Sprite()
	{
		updateTime=15;
		initial = System.currentTimeMillis();
	}
	public Image getImage()
	{
		timePassed= System.currentTimeMillis()-initial;
		curPic= (int)(timePassed/updateTime)%pics.size();
		return pics.get(curPic);
	}
	public void addImage(Image newPic)
	{
		pics.add(newPic);
	}
	public void setImage(int index, Image newPic)
	{
		pics.set(index,newPic);
	}
	
}
