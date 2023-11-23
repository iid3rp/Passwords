import java.util.*;
public class PasswordRequirements
{
    public static boolean[] nextBoolean = {false, false}; 
    public static void check(String passwordHolder)
    {
        String passwordLowerCase = passwordHolder.toLowerCase();
        String passwordUpperCase = passwordHolder.toUpperCase();
        String integerPassword = passwordHolder.replaceAll("[^0-9]", "");
        
        for(int i = 0; i < passwordsGame.requirement + 1; i++)
        {
            if(i == rogue.rogueRequriements)
            {
                break;
            }
            switch(i)
            {
                case 0:
                {
                    if(passwordHolder.length() >= 20)
                    {
                        nextBoolean[toggler] = true;
                        return;
                    }
                    break; // example
                }
                case 1:
                {
                    for(int i = 0; i < passwordHolder.length(); i++)
                    {
                        if(passwordHolder.charAt(i) == ' ')
                        {
                            nextBoolean[toggler] = true;
                            return;
                        }
                    }
                }
                case 2:
                {
                    for(int i = 0; i < arrays.reversedFruits.length; i++)
                    {
                        if(passwordLowerCase.contains(reversedFruits[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 3:
                {
                    for(int i = 0; i < arrays.pets.length; i++)
                    {
                        if(passwordHolder.contains(pets[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 4:
                {
                    for(int i = 0; i < arrays.breads.length; i++)
                    {
                        if(passwordHolder.contains(breads[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 5:
                {
                    for(int i = 0; i < passwordHolder.length(); i++)
                    {
                        if(passwordHolder.charAt(i) == passwordUpperCase.charAt(i))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 6:
                {
                    if(passwordHolder.contains("red") ||
                       passwordHolder.contains("yellow") ||
                       passwordHolder.contains("blue"))
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 7:
                {
                    for(int i = 0; i < arrays.appliances.length; i++)
                    {
                        if(passwordHolder.contains(appliances[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 8:
                {
                    if((passwordHolder.length() % 2) == 0)
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 9:
                {
                    String consonant = "bcdfghjklmnpqrstvwxyz",
                           vowel = "aeiou";
                    for(int i = 0; i < consonant.length(); i++)
                    {
                        if(passwordHolder.charAt(0) == consonant.charAt(i))
                        {
                            for(int j = 0; j < vowel.length(); j++)
                            {
                                if(passwordHolder.charAt(passwordHolder.length()-1) == vowel.charAt(i))
                                {
                                    nextBoolean[toggler] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                case 10:
                {
                    for(int i = 0; i < arrays.footwear.length; i++)
                    {
                       if(passwordHolder.contains(footwear[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 11:
                {
                    for(int i = 0; i < arrays.pairedItems.length; i++)
                    {
                       if(passwordHolder.contains(pairedItems[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 12:
                {
                    for(int i = 0; i < humanOrganArray.length; i++)
                    {
                       if(passwordHolder.contains(humanOrganArray[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 13:
                {
                    int graspNum = Integer.parseInt(passwordHolder.replaceAll("[^0-9]", ""));
                    // haha get it? jGRASP? haha
                    // didnt even know i put this variable in september
                    if(graspNum % 2 == 0)
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 14:
                {
                    for(int i = 0; i < passwordHolder.length() - 1; i++)
                    {
                        int twoDigit = Integer.parseInt("" + passwordHolder.charAt(i) + passwordHolder.charAt(i + 1));
                        if((int) Math.sqrt(twoDigit) * (int)Math.sqrt(twoDigit) == twoDigit)
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 15:
                {
                    for(int i = 0; i < text.length(); i++)
                    {
                        if(Character.getNumericValue(integerPassword.charAt(i)) == 2 ||
                           Character.getNumericValue(integerPassword.charAt(i)) == 3 ||
                           Character.getNumericValue(integerPassword.charAt(i)) == 5 ||
                           Character.getNumericValue(integerPassword.charAt(i)) == 7)
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 16:
                {
                    String operators = "+-*x/\u00F7";
                    for(int i = 0; i < text.length(); i++)
                    {
                        for(int j = 0; j < operators.length(); j++)
                        {
                            if(text.charAt(i) == operators.charAt(j))
                            {
                                nextBoolean[toggler] = true;
                                break;
                            }
                        }
                    }
                }
                case 17:
                {
                    for(int i = 0; i < text.length(); i++)
                    {
                        if(Character.isDigit(text.charAt(i)))
                        {
                            if(text.charAt(i + 1) == '/')
                            {
                                if(Character.isDigit(text.charAt(i + 2)) && 
                                   text.charAt(i + 2) != 0)
                                {
                                    nextBoolean[toggler] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                case 18: // rogue random vowel placement (might recheck this issue later)
                {
                    int randomPlacedVowel = 0;
                    passwordLowerCase = text.toLowerCase();
                    if(randomPlacedVowel == 0)
                    {
                        randomPlacedVowel = rand.nextInt(text.length());
                        return;
                    }
                    else
                    {
                        String vowel = "aeiou";
                        for(int i = 0; i < vowel.length(); i++)
                        {
                            if(passwordLowerCase.charAt(randomPlacedVowel) == vowel.charAt(i))
                            {
                                nextBoolean[toggler] = true;
                                break;
                            }
                        }
                    }
                }
                case 19:
                {
                    for(int i = 0; i < arrays.punctuation.length; i++)
                    {
                        if(text.contains(punctuation[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 20:
                {
                    String vowel = "aeiou";
                    for(int i = 0; i < vowel.length(); i++)
                    {
                        if(text.charAt(0) == vowel.charAt(i))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }    
                case 21:
                {
                    for(int i = 0; i < arrays.femalePopArtists.length; i++)
                    {
                        if(passwordLowerCase.contains(femalePopArtists[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 22:
                {
                    for(int i = 0; i < arrays.pastaTypes.length; i++)
                    {
                        if(passwordLowerCase.contains(pastaTypes[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 23:
                {
                    for(int i = 0; i < arrays.berryTypes.length; i++)
                    {
                        if(passwordLowerCase.contains(berryTypes[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 24:
                {
                    String alphabet = "abcdefghijklmnopqrstuvwxyz";
                    for(int i = 0; i < alphabet.length() - 2; i++)
                    {
                        String threeLetters = alphabet.charAt(i) + "" +
                                              alphabet.charAt(i + 1) + "" +
                                              alphabet.charAt(i + 2);
                        if(text.contains(threeLetters))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 25:
                {
                    for(int i = 0; i < arrays.cloudTypes.length; i++)
                    {
                        if(passwordLowerCase.contains(cloudTypes[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 26:
                {
                    for(int i = 0; i < arrays.kitchenSpices.length; i++)
                    {
                       if(passwordLowerCase.contains(kitchenSpices[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 27:
                {
                    for(int i = 0; i < arrays.recreationalSports.length; i++)
                    {
                       if(passwordLowerCase.contains(recreationalSports[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 28:
                {
                    for(int i = 0; i < arrays.dessertWords.length; i++)
                    {
                       if(passwordLowerCase.contains(dessertRelatedWords[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 29:
                {
                    if (passwordLowerCase.contains("spring") || 
                        passwordLowerCase.contains("summer") || 
                        passwordLowerCase.contains("autumn") || 
                        passwordLowerCase.contains("winter") || 
                        passwordLowerCase.contains("fall"))  // Some people refer to "autumn" as "fall"
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 30:
                {
                    for(int i = 0; i < arrays.classicalComposers.length; i++)
                    {
                        if(passwordLowerCase.contains(classicalComposers[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 31:
                {
                    for(int i = 0; i < arrays.bodiesOfWater.length; i++)
                    {
                        if(passwordLowerCase.contains(bodiesOfWater[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 32:
                {
                    for(int i = 0; i < arrays.bodiesOfWater.length; i++)
                    {
                        if(passwordLowerCase.contains(bodiesOfWater[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 33:
                {
                    for(int i = 0; i < arrays.bodiesOfLand.length; i++)
                    {
                        if(passwordLowerCase.contains(bodiesOfLand[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 34:
                {
                    for(int i = 0; i < arrays.philippineVolcanoes.length; i++)
                    {
                        if(passwordLowerCase.contains(philippineVolcanoes[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 35:
                {
                    for(int i = 0; i < arrays.philippineIslands.length; i++)
                    {
                        if(passwordLowerCase.contains(philippineIslands[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 36:
                {
                    for(int i = 0; i < arrays.countries.length; i++)
                    {
                        if(passwordLowerCase.contains(countries[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;  // No need to continue checking if we found a match.
                        }
                    }
                }
                case 37:
                {
                    break;
                }
                case 38:
                {
                    break;
                } // more cases in the next sessions :3
                    
                default:
            }
            if()
            
        }
    }
    // no using of functions on this file, this time :>
    
    public static void main(String[] args)
    {
        // must run at FinalProject.java
    }
}
