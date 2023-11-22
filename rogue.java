import java.awt.*;
import java.util.*;

public class rogue
{
    public static final Random rand = new Random();
    public static int[] requirements;
    public static int rogueRequirements;

    public static final Point[][] roguePoints =
    {
        { // scene #0  |  where the background is changing at any moment
            new Point(0, 0) // example
        },
        {
            // new items will be in the future sessions
        }
        // scenes will be in the fuutre sessions.
    };
    
    public static void newPasswordAlgorithm()
    {
        rogueRequirements = (rand.nextInt(4) + 3);
        HashSet<Integer> requirementsHash = new HashSet<Integer>();
        
        for(int i = 0; i < rogueRequirements; i++)
        {
            int rogueNumber = rand.nextInt(req.stuff.length);
            requirementsHash.add(rogueNumber);
        }

        requirements = new int[requirementsHash.size() + 1];
        
        int index = 0;
        for(int i : requirementsHash)
        {
            requirements[index++] = i;
        }
        requirements[rogueRequirements] = 0;
        
        System.out.println("rogue in progress:");
        
        PasswordsGame.isNewPassword = false;
    }
    
    public static void questionChamber()
    {
        int random = rand.nextInt(5);
        int randomText = rand.nextInt(5);
        
        if(random == 0)
        {
            switch(randomText)
            {
                case 0:
                    PasswordsGame.chamberLabel.setText("??????");
                case 1:
                    PasswordsGame.chamberLabel.setText("Chamber # ???");
                case 2:
                    PasswordsGame.chamberLabel.setText("ERWFASBFSFJ");
                case 3:
                    PasswordsGame.chamberLabel.setText("idk what's the chamber.");
                case 4:
                    PasswordsGame.chamberLabel.setText("........");
            }
        }
        else
        {
            PasswordsGame.chamberLabel.setText("Chamber # " + PasswordsGame.chamber);
        }
    }
    
    public static void main(String[] args)
    {
        // roguelike stuff goes in this class :3
        newPasswordAlgorithm();
    }
}