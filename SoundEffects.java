import javax.sound.sampled.*;
import java.io.*;
public class SoundEffects
{
    public static Clip backgroundAudio;
    
    public static void backgroundMusic()
    {
        // using dawn of the doors by LSPLASH (non copyright :3)
        // uhm i dont have one :<
        // maybe itll be implemented for reference
        try
        {
            File soundFile = new File("Properties\\Audio\\Dawn_of_the_Doors.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            backgroundAudio = AudioSystem.getClip();
            backgroundAudio.open(audioInputStream);
    
            // Loop the sound
            backgroundAudio.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        // void calls for reference | must run FinalProject.java
        backgroundMusic();
        stopSound();
    }
    
    public static void stopSound() 
    {
        if (backgroundAudio.isRunning()) 
        {
            backgroundAudio.stop();
        }
        backgroundAudio.close();
    }
}