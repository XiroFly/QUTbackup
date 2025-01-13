package org.chess;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/*
 * “Ù¿÷≤•∑≈∆˜
 * ≈”“Âø°
 * */
public class musicStuff {
	public void playMusic(String musicLocation)
	{
		try
		{
			File musicPath = new File(musicLocation);
			if(musicPath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else
			{
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}