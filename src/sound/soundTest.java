package sound;

public class soundTest extends Sound{
	public static void main(String[] args)
	{
		Sound newSound= new Sound(1);
		Thread t = new Thread(newSound);
		t.start();
		loopSound("/Users/BrandtSwanson/Documents/bell.wav",3);
		System.out.println("2 easy");
	}
}
