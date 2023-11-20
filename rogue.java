import java.awt.*;
import java.util.*;

public class rogue
{
    public static final Random rand = new Random();
    public static int[] requirements;

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
        int rogueRequirements = (rand.nextInt(4) + 4);
        HashSet<Integer> requirementsHash = new HashSet<Integer>();
        
        for(int i = 0; i < rogueRequirements; i++)
        {
            int rogueNumber = rand.nextInt(req.stuff.length);
            requirementsHash.add(rogueNumber);
        }

        int[] requirements = new int[requirementsHash.size()];
        
        int index = 0;
        for(int i : requirementsHash)
        {
            requirements[index++] = i;
        }
        
        System.out.println("Generated Password Requirements:");
        for (int requirement : requirements) {
            System.out.println(req.stuff[requirement]);
        }
    }
    
    public static void main(String[] args)
    {
        // roguelike stuff goes in this class :3
        newPasswordAlgorithm();
    }
}