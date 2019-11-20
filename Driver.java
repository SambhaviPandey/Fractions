import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * The purpose of class Driver is to count the 
 * number of fractions read from the text file. 
 * This class consists of:
 * try-catch blocks
 * while loop
 * for loop
 * if, else-if, else statements
 * Usage of the Scanner class to take user input
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 12,2018)
 */
public class Driver
{
    /**
     * The main method is void. The purpose of this
     * method is to ensure that the program executes. 
     * The main method does this by reading in the file
     * that the user specifies and utilizing a while
     * loop to check if there are more lines that need
     * to be read in the file. In addition, the main 
     * method reduces the fractions that are read in and 
     * checks to see if the fractions are equal.
     * 
     * @param args
     */
    public static void main (String[] args)
    {
        Scanner readFile = null;
        System.out.println("Please enter a file name: ");
        //To take user input
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        try 
        { 
            //To read file
            readFile = new Scanner(new File(file)); 
        } 
        catch (FileNotFoundException e) 
        {
            //If there is an error reading the file
            System.out.println("File could not be found or opened."); 
            System.exit(0);
        } 
        
        //Creating an object
        ObjectList frac = new ObjectList();
        //Loop to check if there are more lines that 
        //need to be read in the file
        while (readFile.hasNextLine())
        {
            //Reduces the fraction that is read in
            Fraction f = fractionReduction(readFile.nextLine());
            //If the list does not contain anything
            if (frac.lengthOfArray() == 0)
            {
                //Adds to the list
                frac.add(new FractionCounter(f));
            }
            else
            {
                //length of the array
                int l = frac.lengthOfArray();
                //for loop used to go through the 
                //list of fractions
                for (int i = 0; i < l; i++)
                {
                    //Checks to see if the fractions are equal
                    boolean findEqualFraction = frac.getFraction(i).
                                                compareAndIncrement(f);
                    //If an equal fraction is found
                    if (findEqualFraction)
                    {
                        break;
                    }
                    //If an equal fraction is not found
                    else if(!findEqualFraction && i == l - 1)
                    {
                       //adds to the output list
                       frac.add(new FractionCounter(f));
                       //new length of the array
                       l = frac.lengthOfArray();
                       break; 
                    }
                }
            }
        }
        
        //Goes through the list of fractions 
        for (int i = 0; i < frac.lengthOfArray(); i++)
        {
            //prints FractionCounter value
            System.out.println(frac.getFraction(i));
        }
    }

    /**
     * The method determineGCD is a method that 
     * returns an int value. This method also 
     * takes two integer values as arguments, 
     * corresponding to the numerator and denominator
     * of the fraction. The purpose of this method is 
     * to utilize Euclid's GCD theorem to find the 
     * GCD.
     * 
     * @param numerator 
     * @param denominator
     */
    public static int determineGCD (int numerator, int denominator)
    {
        if (denominator == 0)
        {
            return numerator;
        }
        return determineGCD(denominator, numerator % denominator);
    }
    
    /**
     * The method fractionReduction returns a 
     * Fraction value.This method also takes
     * a String argument corresponding to the 
     * fraction. The purpose of this method is 
     * to reduce the fraction.
     * 
     * @param f
     */
    public static Fraction fractionReduction (String f)
    {
        //Numerator of fraction is converted to an integer
        int numerator = Integer.parseInt(f.substring(0, f.indexOf("/")));
        //Denominator of fraction is converted to an integer
        int denominator = Integer.parseInt(f.substring(f.indexOf("/") + 1));
        //Stores the gcd value
        int gcd = determineGCD(numerator,denominator);
        //The new Fraction object contains the reduced fraction
        return new Fraction(numerator/gcd, denominator/gcd);
    }
}