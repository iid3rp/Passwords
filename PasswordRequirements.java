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
                case 0: // Must have at least 20 characters minimum.
                {
                    if(passwordHolder.length() >= 20)
                    {
                        nextBoolean[toggler] = true;
                        return;
                    }
                    break;
                }
                case 1: // Must include a space
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
                case 2: // Needs to contain a fruit, but spelled backward.
                {
                    for(int i = 0; i < arrays.reversedFruits.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.reversedFruits[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 3: // "Your password must reference an animal that's commonly kept as a pet.
                {
                    for(int i = 0; i < arrays.pets.length; i++)
                    {
                        if(passwordHolder.contains(arrays.pets[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 4: // Should have a type of bread embedded in it.
                {
                    for(int i = 0; i < arrays.breads.length; i++)
                    {
                        if(passwordHolder.contains(arrays.breads[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 5: // Must include a Capital letter
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
                case 6: // Must contain the name of a primary color
                {
                    if(passwordHolder.contains("red") ||
                       passwordHolder.contains("yellow") ||
                       passwordHolder.contains("blue"))
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 7: // Password should reference a common household appliance
                {
                    for(int i = 0; i < arrays.appliances.length; i++)
                    {
                        if(passwordHolder.contains(arrays.appliances[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 8: // Must have an even number of letters
                {
                    if((passwordHolder.length() % 2) == 0)
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 9: // Password should start with a consonant and end with a vowel.
                {
                    String consonant = "bcdfghjklmnpqrstvwxyz";
                    String vowel = "aeiou";
                    for(int i = 0; i < consonant.length(); i++)
                    {
                        if(passwordHolder.charAt(0) == consonant.charAt(i))
                        {
                            for(int j = 0; j < vowel.length(); j++)
                            {
                                if(passwordHolder.charAt(passwordHolder.length() - 1) == vowel.charAt(j)) // Fix here
                                {
                                    nextBoolean[toggler] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                case 10: // Must mention any footwear
                {
                    for(int i = 0; i < arrays.footwear.length; i++)
                    {
                       if(passwordHolder.contains(arrays.footwear[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 11: // nclude the name of a thing that typically comes in pairs
                {
                    for(int i = 0; i < arrays.pairedItems.length; i++)
                    {
                       if(passwordHolder.contains(arrays.pairedItems[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 12: // Password must contain the word of a human organ
                {
                    for(int i = 0; i < arrays.humanOrganArray.length; i++)
                    {
                       if(passwordHolder.contains(arrays.humanOrganArray[i]))
                       {
                           nextBoolean[toggler] = true;
                           break;
                       }
                    }
                }
                case 13: // Must include a number divisible by 2
                {
                    for (int i = 0; i < passwordHolder.length(); i++)
                    {
                        char currentChar = passwordHolder.charAt(i);
                        if (Character.isDigit(currentChar))
                        {
                            int digit = Character.getNumericValue(currentChar);
                            if (digit % 2 == 0)
                            {
                                nextBoolean[toggler] = true;
                                break;
                            }
                        }
                    }
                }
                case 14: // Password should include a two-digit square number.
                {
                    for (int i = 0; i < passwordHolder.length() - 1; i++)
                    {
                        int twoDigit = Integer.parseInt("" + passwordHolder.charAt(i) + passwordHolder.charAt(i + 1));
                        int sqrt = (int) Math.sqrt(twoDigit);

                        if (sqrt * sqrt == twoDigit)
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 15: // Needs to have a single-digit prime number.
                {
                    String primeDigits = "2357";

                    for (int i = 0; i < primeDigits.length(); i++)
                    {
                        if (passwordHolder.contains(String.valueOf(primeDigits.charAt(i))))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 16: // Must contain an arithmetic operator
                {
                    String operators = "+-*x/\u00F7";
                    for(int i = 0; i < passwordLowerCase.length(); i++)
                    {
                        for(int j = 0; j < operators.length(); j++)
                        {
                            if(passwordLowerCase.charAt(i) == operators.charAt(j))
                            {
                                nextBoolean[toggler] = true;
                                break;
                            }
                        }
                    }
                }
                case 17: // Password should include a common fraction
                {
                    for(int i = 0; i < passwordLowerCase.length(); i++)
                    {
                        if(Character.isDigit(passwordLowerCase.charAt(i)))
                        {
                            if(passwordLowerCase.charAt(i + 1) == '/')
                            {
                                if(Character.isDigit(passwordLowerCase.charAt(i + 2)) && 
                                   passwordLowerCase.charAt(i + 2) != '0')
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
                    passwordLowerCase = passwordLowerCase.toLowerCase();
                    if(randomPlacedVowel == 0)
                    {
                        randomPlacedVowel = rand.nextInt(passwordLowerCase.length());
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
                case 19: // Must include at least one punctuation mark.
                {
                    for(int i = 0; i < arrays.punctuation.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.punctuation[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 20: // Must start with a consonant
                {
                    String consonant = "bcdfghjklmnpqrstvwxyz";
                    for(int i = 0; i < vowel.length(); i++)
                    {
                        if(passwordLowerCase.charAt(0) == vowel.charAt(i))
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
                        if(passwordLowerCase.contains(arrays.femalePopArtists[i]))
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
                        if(passwordLowerCase.contains(arrays.pastaTypes[i]))
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
                        if(passwordLowerCase.contains(arrays.berryTypes[i]))
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
                        if(passwordLowerCase.contains(threeLetters))
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
                        if(passwordLowerCase.contains(arrays.cloudTypes[i]))
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
                       if(passwordLowerCase.contains(arrays.kitchenSpices[i]))
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
                       if(passwordLowerCase.contains(arrays.recreationalSports[i]))
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
                       if(passwordLowerCase.contains(arrays.dessertRelatedWords[i]))
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
                        if(passwordLowerCase.contains(arrays.classicalComposers[i]))
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
                        if(passwordLowerCase.contains(arrays.bodiesOfWater[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 32: // Must contain a color and its opposite from the color wheel
                {
                    for (String colorPair : arrays.colorPairs)
                    {
                        String[] colors = colorPair.split(":");
                        String color1 = colors[0];
                        String color2 = colors[1];

                        if (passwordLowerCase.contains(color1) && passwordLowerCase.contains(color2))
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
                        if(passwordLowerCase.contains(arrays.bodiesOfLand[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 34:
                {
                    for(int i = 0; i < arrays.philippineVolcanoes.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.philippineVolcanoes[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 35:
                {
                    for(int i = 0; i < arrays.philippineIslands.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.philippineIslands[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 36:
                {
                    for(int i = 0; i < arrays.countries.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.countries[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;  // No need to continue checking if we found a match.
                        }
                    }
                }
                case 37:
                {
                    if(passwordLowerCase.contains('\221A'))
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 38:
                {
                    String trimmed = passwordLowerCase.trim();
                    if(trimmed.contains("a+b") ||
                       trimmed.contains("a-b") ||
                       trimmed.contains("a*b") ||
                       trimmed.contains("a/b") ||
                       trimmed.contains("a(b)") ||
                       trimmed.contains("a=b"))
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 39:
                {
                    for(int i = 0; i < arrays.constantWords.length; i++)
                    {
                        if(passwordLowerCase.contains(constantWords[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }  
                case 40:
                {
                    if(passwordLowerCase.contains('1') ||
                       passwordLowerCase.contains('2') ||
                       passwordLowerCase.contains('3') ||
                       passwordLowerCase.contains('4') ||
                       passwordLowerCase.contains('6') ||
                       passwordLowerCase.contains('12'))
                    {
                        nextBoolean[toggler] = true;
                    }
                }
                case 41:
                {
                    for(int i = 0; i < 100; i++)
                    {
                        if(passwordLowerCase.contains("" + 
                                                      i + "" +
                                                     (i + 1) + "" +
                                                     (i + 2))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 42:
                {
                    if(passwordLowerCase.contains("31415") ||
                       passwordLowerCase.contains("27182"))
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 43:
                {
                    for(int i = 0; i < arrays..length; i++)
                    {
                        if(passwordLowerCase.contains(i))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 44:
                {
                    if(passwordHolder % 2 == 0)
                    {
                        nextBoolean[toggler] = true;\
                        break;
                    }
                }
                case 45:
                {
                    for(char c : passwordHolder.toCharArray())
                    {
                        if(Character.isUpperCase(c) && Character.isLowerCase(c))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 46:
                {
                    String symbols = "!@#$";
                    for(int i = 0; i < symbols.length(); i++)
                    {
                        for(int j = 0; j < symbols.length(); i++)
                        {
                            if(passwordLowerCase.contains("" + 
                                                          symbols.charAt(i) +
                                                          symbold.charAt(j))
                            {
                                nextBoolean[toggler] = true;
                                break;
                            }
                        }
                    }
                }
                case 47:
                {
                    int totalSum = 0;
                    for(int i = 0; i < passwordHolder.length(); i++)
                    {
                        totalSum += passwordHolder.codePointAt(i);
                    }

                    if(totalSum == 8000)
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 48:
                {
                    for(int i = 0; i < passwordHolder.length(); i++)
                    {
                        if(passwordHolder.codePointAt(i) == 1000)
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 49:
                {
                    if(passwordLowerCase.contains("nile"))
                    {
                        nextBoolean[true] = true;
                        break;
                    }
                }
                case 50:
                {
                    for(int i = 0; i < arrays.breakfast.length; i++)
                    {
                        if(passwordLowerCase.contains(breakfast[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 52:
                {
                    for(int i = 0; i < arrays.italianDishes.length; i++)
                    {
                        if(passwordLowerCase.contains(italianDishes[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 53:
                {
                    if(passwordLowerCase.contains("st") ||
                       passwordLowerCase.contains("vill") ||
                       passwordLowerCase.contains("city") ||
                       passwordLowerCase.contains("brgy") ||
                       passwordLowerCase.contains("barrio"))
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 55:
                {
                    for(int i = 0; i < arrays.fictionalDetetctive.length; i++)
                    {
                        if(passwordLowerCase.contains(fictionalDetetctive[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 56:
                {
                    for(int i = 0; i < passwordLowerCase.length(); i++)
                    {
                        if(passwordLowerCase.contains(fictionalDetetctive[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 57:
                {
                    for (char c : inputString.toCharArray()) 
                    {
                        if (Character.isLetter(c) && !((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 58:
                {
                    for (int i = 0; i < arrays.historicalEvent.length; i++) 
                    {
                        if (passwordLowerCase.contains(historicalEvent[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 58: // continue fixing here derp :3
                // dont stress yourself okay? you love some1 right?
                {
                    for (int i = 0; i < arrays.shakespearePlay.length; i++) 
                    {
                        if (passwordLowerCase.contains(shakespearePlay[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 59:
                {
                    for (int i = 0; i < arrays.naturalPhenomenon.length; i++) 
                    {
                        if (passwordLowerCase.contains(naturalPhenomenon[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 60:
                {
                    for (int i = 0; i < arrays.geometricShape.length; i++) 
                    {
                        if (passwordLowerCase.contains(geometricShape[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 61:
                {
                    for (int i = 0; i < arrays.scientist.length; i++) 
                    {
                        if (passwordLowerCase.contains(scientist[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 62:
                {
                    for (int i = 0; i < arrays.gemstone.length; i++) 
                    {
                        if (passwordLowerCase.contains(gemstone[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 63:
                {
                    for (int i = 0; i < arrays.prime20to100.length; i++) 
                    {
                        if (passwordLowerCase.contains(prime20to100[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 64:
                {
                    for (int i = 0; i < arrays.mathSeries.length; i++) 
                    {
                        if (passwordLowerCase.contains(mathSeries[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 65:
                {
                    for (int i = 0; i < passwordLowerCase.length(); i++) 
                    {
                        if (passwordLowerCase(i) == '-') 
                        {
                            if (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) 
                            {
                                nextBoolean[toggler] = true;
                                break;
                            }
                        }
                    }
                }
                case 66:
                {
                    if(passwordLowerCase.contains('\u222B') ||
                       passwordLowerCase.contains('\u2202'))
                    {
                        nextBoolean = true;
                    }
                }
                case 66:
                {
                    for(int i = 0; i < arrays.linearAlgebra.length; i++)
                    {
                        if(passwordLowerCase.contains(linearAlgebra[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 67:
                {
                    if(passwordLowerCase.contains('<') ||
                       passwordLowerCase.contains('>') ||
                       passwordLowerCase.contains('\u2265') ||
                       passwordLowerCase.contains('\u2264') ||
                       passwordLowerCase.contains('\u2260') ||)
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 68:
                {
                    if(Character.isLetter(passwordLowerCase.charAt(0)))
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 69:
                {
                    for(int i = 0; i < 23; i++)
                    {
                        if(passwordLowerCase.contains("" + alphabet.charAt(i) +
                                                      alphabet.charAt(i + 1) +
                                                      alphabet.charAt(i + 2))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 70:
                {
                    if(passwordLowerCase.contains('?') ||
                       passwordLowerCase.contains('!'))
                    {
                        if(!(passwordLowerCase.contains('?') &&
                             passwordLowerCase.contains('!')))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 71:
                {
                    int vowelLetters = 0, consonantLetters = 0
                    for(int i = 0; i < passwordHolder.length(); i++)
                    {
                        if(passwordHolder.charAt(i) == 'a' ||
                           passwordHolder.charAt(i) == 'e' ||
                           passwordHolder.charAt(i) == 'i' ||
                           passwordHolder.charAt(i) == 'o' ||
                           passwordHolder.charAt(i) == 'u')
                        {
                            vowelLetters++;
                        }
                        else consonantLetters++;
                    }
                    if(passwordLowerCase.contains("" + wowelLetters +
                                                  "" + consonantLetters))
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }                                                            
                }    
                case 72:
                {
                    String equationRegex = ".*[0-9]+[\\+\\-\\*/]+[0-9]+.*";
                    Pattern pattern = Pattern.compile(equationRegex);
                    Matcher matcher = pattern.matcher(passwordHolder);

                    if (matcher.find()) 
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 73:
                {
                    for(int i = 0; i < arrays.spicyCuisine.length; i++)
                    {
                        if(passwordLowerCase.contains(spicyCuisine[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 74:
                {
                    String oldTypeChar = "¶¢£¥½¼¾ƒæœ¶¡¿";
                    for (int i = 0; i < oldTypeChar.length(); i++) 
                    {
                        if(passwordLowerCase.contains(String.valueOf(oldTypeChar.charAt(i)))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 75:
                {
                    for(int i = 0; i < arrays.fibonacci.length; i++)
                    {
                        if(passwordLowerCase.contains(fibonacci[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 76:
                {
                    if (passwordHolder.charAt(0) == 'a' ||
                        passwordHolder.charAt(0) == 'e' ||
                        passwordHolder.charAt(0) == 'i' ||
                        passwordHolder.charAt(0) == 'o' ||
                        passwordHolder.charAt(0) == 'u')
                    {
                        if (!(passwordHolder.charAt(passwordHolder.length() - 1) == 'a' ||
                              passwordHolder.charAt(passwordHolder.length() - 1) == 'e' ||
                              passwordHolder.charAt(passwordHolder.length() - 1) == 'i' ||
                              passwordHolder.charAt(passwordHolder.length() - 1) == 'o' ||
                              passwordHolder.charAt(passwordHolder.length() - 1) == 'u'))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 77:
                {
                    for(int i = 0; i < arrays.famousArtists.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.famousArtists[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 78:
                {
                    for(int i = 0; i < arrays.ancientMythWords.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.ancientMythWords[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 79:
                {
                    for(int i = 0; i < arrays.javaWords.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.javaWords[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 80:
                {
                    for(int i = 0; i < arrays.planets.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.planets[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 81:
                {
                    for(int i = 0; i < arrays.novelsNoVowels.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.novelsNoVowels[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 82:
                {
                    for(int i = 0; i < arrays.famousBuildings.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.famousBuildings[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 83:
                {
                    for(int i = 0; i < arrays.famousPopCulture.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.famousPopCulture[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 84:
                {
                    for(int i = 0; i < arrays.songHot100.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.songHot100[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 85:
                {
                    for(int i = 0; i < arrays.famousActors.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.famousActors[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 86:
                {
                    for(int i = 0; i < arrays.internetTrend2018.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.internetTrend2018[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 87:
                {
                    for(int i = 0; i < arrays.sportingEvent.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.sportingEvent[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 88:
                {
                    for(int i = 0; i < arrays.famousTV.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.famousTV[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 89:
                {
                    for(int i = 0; i < arrays.mathTheorem.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.mathTheorem[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 90:
                {
                    for(int i = 0; i < arrays.famousMathematicians.length; i++)
                    {
                        if(passwordLowerCase.contains(arrays.famousMathematicians[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 91:
                {
                    if(passwordHolder.contains(":3"))
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 92:
                {
                    for (int i = 0; i < arrays.calculusPrinciple.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.calculusPrinciple[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 93:
                {
                    for (int i = 0; i < arrays.highMath.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.highMath[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 94:
                {
                    for (int i = 0; i < arrays.complexGeom.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.complexGeom[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 95:
                {
                    for (int i = 0; i < arrays.greekLetter.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.greekLetter[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 96:
                {
                    for (int i = 0; i < arrays.commonAbbrev.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.commonAbbrev[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 97:
                {
                    for (int i = 0; i < arrays.punctuation.length; i++)
                    {
                        if (passwordLowerCase.contains(punctuation[i])
                        {
                            for(int j = 0; j < arrays.punctuation.length; j++)
                            {
                                if(j == i)
                                {
                                    continue;
                                }
                                else if(passwordLowerCase.contains(arrays.punctuation[i])
                                {
                                    nextBoolean[toggler] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                case 98:
                {
                    if(passwordHolder.charAt(0) == passwordUpperCase.charAt(0))
                    {
                        if(!(passwordHolder.charAt(passwordHolder.length() - 1) ==
                             passwordUpperCase.charAt(passwordHolder.length() - 1)))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 99:
                {
                    for(int i = 0; i < passwordHolder.length() - 3; i++)
                    {
                        if(Character.isLetter(passwordHolder.charAt(i)) &&
                           Character.isDigit(passwordHolder.charAt(i + 1)) &&
                           !(Character.isLetter(passwordHolder.charAt(i + 2))) &&
                           passwordHolder.charAt(i + 3) == ' ')
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 100:
                {
                    for (int i = 0; i < arrays.femalePopArtistsBack.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.femalePopArtistsBack[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 101:
                {
                    String pi = "3141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067";
                    for (int i = 0; i < pi.length() - 10; i++)
                    {
                        if (passwordLowerCase.contains("" + pi.charAt(i) +
                                                       "" + pi.charAt(i + 1) +
                                                       "" + pi.charAt(i + 2) +
                                                       "" + pi.charAt(i + 3) +
                                                       "" + pi.charAt(i + 4) +
                                                       "" + pi.charAt(i + 5) +
                                                       "" + pi.charAt(i + 6) +
                                                       "" + pi.charAt(i + 7) +
                                                       "" + pi.charAt(i + 8) +
                                                       "" + pi.charAt(i + 9)))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 102:
                {
                    for (int i = 0; i < arrays.urlWords.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.urlWords[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 103:
                {
                    for (int i = 0; i < arrays.chocolateNoVowel.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.chocolateNoVowel[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 104:
                {
                    for (int i = 0; i < arrays.boardBackwards.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.boardBackwards[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 105:
                {
                    if(passwordLowerCase.contains("f=ma"))
                    {
                        nextBoolean[toggler] = true;
                        break;
                    }
                }
                case 106:
                {
                    for (int i = 0; i < arrays..quarantine.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.quarantine[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 107:
                {
                    for (int i = 0; i < arrays.astrophysicsWords.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.astrophysicsWords[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 108:
                {
                    for (int i = 0; i < arrays.quantumMechWords.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.quantumMechWords[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 109:
                {
                    for (int i = 0; i < arrays.renownedMath.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.renownedMath[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 110:
                {
                    for (int i = 0; i < arrays.cultureTraditionSEA.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.cultureTraditionSEA[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 111:
                {
                    for (int i = 0; i < arrays.filoIndigenous.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.filoIndigenous[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 112:
                {
                    for (int i = 0; i < arrays.periodicBack.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.periodicBack[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 113:
                {
                    for (int i = 0; i < arrays.operationWords.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.operationWords[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 114:
                {
                    for (int i = 0; i < arrays.abstractAlgebra.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.abstractAlgebra[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 115:
                {
                    for (int i = 0; i < arrays.unsolvedMath.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.unsolvedMath[i]))
                        {
                            nextBoolean[toggler] = true;
                            break;
                        }
                    }
                }
                case 116:
                {
                    for (int i = 0; i < arrays.topology.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.topology[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 117:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays.[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 118:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 119:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 120:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 121:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 122:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 123:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 124:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 125:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 126:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 127:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 128:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 129:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 130:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 131:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 132:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 133:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 134:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 135:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 136:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 137:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 138:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 139:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 140:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 141:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 142:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 143:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 144:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 145:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 146:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 147:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 148:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 149:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }
                case 150:
                {
                    for (int i = 0; i < arrays.length; i++)
                    {
                        if (passwordLowerCase.contains(arrays[i]))
                        {
                            nextBoolean[toggler] = true;
                        }
                    }
                }

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
