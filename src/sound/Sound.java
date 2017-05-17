package sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Sound implements Runnable {
	//To start a new thread, must put the start method in the class using sound
	Thread t;
	private int var;
	static int operation, num;
	static String name;
	public Sound()
	{
		this.var=1;
	}
	public Sound(int var)
	{
		this.var=var;
	}
	public static void doSound(String filename)
	{
		String strFilename = filename;
        final int BUFFER_SIZE = 128000;
        File soundFile = null;
        AudioInputStream audioStream = null;
        AudioFormat audioFormat;
        SourceDataLine sourceLine = null;
        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        sourceLine.start();
        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }
        sourceLine.drain();
        sourceLine.close();
	}
    public static void playSound(String filename){
        operation=1;
        name=filename;
    }
	public static void loopSound(String sound, int time)
	{
		operation=2;
		name=sound;
		num=time;
	}
	public void run()
	{
	      
	      try {
	         while(true) {
	            System.out.println("Thread");
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
	            System.out.println("Running"+var);
		  	      if(operation==1)
		  	      {
		  	    	  doSound(name);
		  	    	  operation=0;
		  	      }
		  	      if(operation==2)
		  	      {
		  	    	  for(int x =0; x<num; x++)
		  	  			doSound(name);
		  	    	  operation=0;
		  	      }
	         }
	      }catch (InterruptedException e) {
	         System.out.println("Thread interrupted.");
	      }
	      System.out.println("Thread exiting.");
	}
	public void start()
	{
		System.out.println("Starting sound");
	      if (t == null) {
	         t = new Thread (this, "sound");
	         t.start ();
	}
	}
}