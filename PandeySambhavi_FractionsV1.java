import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * class Fractions consists of:
 * A program whose purpose is to read in 
 * txt files with fractions and determine 
 * the number of occurrences of the fractions. 
 * 
 * This class utilizes a number of methods 
 * (such as the main method, findDuplicate method, 
 * check method, and the countOccur method) in 
 * order to successfully run the program. 
 * 
 * This class also consists of:
 * Instance variables
 * Usage of Scanner class to take user input 
 * try-catch block 
 * Usage of for loops
 * Usage of while loops
 * Usage of if, else-if, and else statements  
 * Usage of arrays 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 5,2018)
 */
public class PandeySambhavi_FractionsV1
{
    //Declaring instance variables 
    private static int currentLength = 0;
    private static int maximumLength = 100; 
    private static String[] fractionsArray = new String[maximumLength];
    /**
     * The main method is void. The purpose of this method is to
     * ensure that the program executes. The main method does this
     * by reading in the file that the user specifies and 
     * utilizing a while loop to check if there are more lines
     * that need to be read in the file. The main method 
     * also determines if the array is full and if it is full, 
     * resizes the array. In addition, the main method
     * calls the countOccur method. 
     * 
     * @param args
     */
    public static void main(String [] args)
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
        
        //Loop to check if there are more lines that 
        //need to be read in the file
        while (readFile.hasNextLine())
        {
            //Determines if the array is full and if 
            //it is full then it resizes the array 
            if (currentLength == maximumLength)
            {
                //If array is full, creates a resized array
                String newFractionsArray[] = new String[maximumLength * 2];
                for (int i = 0; i < currentLength; i++)
                {
                    newFractionsArray[i] = fractionsArray[i];
                }
                fractionsArray = newFractionsArray;
                maximumLength = maximumLength * 2;
            }
            //Every time a line in the file is read, the current
            //length increases 
            fractionsArray[currentLength] = readFile.nextLine();
            currentLength++;
        }
        //To count the number of occurrences of the fractions
        countOccur();
    } 

    /**
     * The method findDuplicate is a void method that takes an 
     * integer argument corresponding to the position of the 
     * fraction that is utilized. The purpose of this method is 
     * to determine if a fraction has already been counted as 
     * an occurrence and if it has, then it is not 
     * read in again. The reason it does so is to 
     * ensure that no fractions are duplicated when being counted. 
     * 
     * @param position
     */
    public static void findDuplicate (int position)
    {
        //Creation of a new array 
        String frac[] = new String[currentLength - 1];
        
        //Creating a boolean value to determine if the fraction 
        //has already been counted 
        boolean findPosition = false;

        //Goes through the txt file and checks if the fraction has 
        //already been counted 
        for (int i = 0; i < currentLength; i++)
        {
            //If the position of the fraction has been found
            if(i == position)
            {
                findPosition = true;
                continue;
            }
            //It is a fraction that has already been counted 
            else if(findPosition)
            {
                frac[i-1] = fractionsArray[i];
            }
            //It is a fraction that has not been counted
            else
            {
                frac[i] = fractionsArray[i];
            }
        }
        fractionsArray = frac;
        //It decrements to signify that one more line has been 
        //examined, to determine if the fraction has already been counted
        currentLength--;
    }

    /**
     * The method multiply is a method that takes four 
     * arguments corresponding to the two numerators and 
     * the two denominators of the fractions that are to be 
     * cross multiplied. This method returns a boolean value.
     * 
     * The purpose of this method is to determine
     * if the first fraction's numerator (firstNumerator) multiplied 
     * by the second fraction's denominator (secondDenominator)
     * is equivalent to the second fraction's numerator 
     * (secondNumerator) multiplied by the first fraction's denominator
     * (firstDenominator).If the numerators and denominators are 
     * equivalent when cross multiplied, then the fractions are equivalent. 
     * This cross multiplication is needed to ensure
     * that the number of occurrences of the fractions are
     * adequately counted for.
     * 
     * This method returns a boolean value.
     * @param firstNumerator
     * @param firstDenominator
     * @param secondNumerator
     * @param secondDenominator 
     */
    public static boolean check(int firstNumerator, int firstDenominator,
                                int secondNumerator, int secondDenominator)
    {
        //If the numerators and denominators cross multiplied are equivalent
        if (firstNumerator * secondDenominator == 
            secondNumerator * firstDenominator)
        {
            return true;
        }
        //Numerators and denominators cross multiplied are not equivalent
        else 
        {
            return false; 
        }
    }

    /**
     * The method countOccur is void and does not take any 
     * arguments. The purpose of this method is to count the 
     * occurrences of the fractions. This is done through
     * going through the String and finding the target 
     * String and then converting the String to an 
     * integer. This method also utilizes two for loops and an 
     * if statement. 
     */
    public static void countOccur()
    {
        //Goes through the txt file
        for (int i = 0; i < currentLength; i++ )
        {
            //tracks the number of occurrences of the fraction
            int count = 1; 
            
            //Numerator of first fraction is converted to an integer
            int firstNumerator = Integer.parseInt(fractionsArray[i]
                                 .substring(0,fractionsArray[i]
                                 .indexOf("/")));
            //Denominator of first fraction is converted to an integer
            int firstDenominator = Integer.parseInt(fractionsArray[i]
                                   .substring(fractionsArray[i]
                                   .indexOf("/")+1));
            
            for (int k = i + 1; k < currentLength - 2; k++)
            {
                //Numerator of second fraction is converted to an integer
                int secondNumerator = Integer.parseInt(fractionsArray[k].
                                      substring(0,fractionsArray[k]
                                      .indexOf("/")));
                //Denominator of second fraction is converted to an integer
                int secondDenominator = Integer.parseInt(fractionsArray[k].
                                        substring(fractionsArray[k]
                                        .indexOf("/")+1));
                //Fractions are cross multiplied
                boolean multiply = check(firstNumerator, firstDenominator,
                                   secondNumerator, secondDenominator);
                
                //If fractions are equal after being cross multiplied
                if(multiply)
                {
                    //Increments to represent another occurrence 
                    //of the fraction
                    count++;
                    //The fraction has already been counted as an occurrence
                    //and is not read in again
                    findDuplicate(k);
                }
            }
            //Prints the output to screen 
            System.out.println(fractionsArray[i] + " has a count of " 
                               + count);
        }
    }

    /*
     * Answer to Questions:
     * 1. You can solve this without using arrays. 
     * Another way to do this would be to use constructors
     * and classes. To do this you would need at 
     * least three variables. For instance, you would 
     * need variables to keep track of the numerator, 
     * a variable to keep track of the denominator, 
     * and a variable that represents the number of 
     * occurrences of a fraction. 
     * 
     * 2. You can use one array to solve this. The array
     * that you would use should be an int array and it 
     * should store the numerators and denominators of 
     * the fractions. However, with this array you would 
     * also need to differentiate between the numerators 
     * and denominators of the fractions(perhaps by 
     * using loops) and also keep track of the number of
     * occurrences of a fraction(which would require a variable).
     * 
     * 3. Yes, you can nest one class within another. 
     *    An example of this:
     *  public class Outer { 
     *    int num;
     *    // inner class 
     *    class Inner {
     *        public void print() {
     *          System.out.println("This is an inner class"); 
     *        }
     *     }   
     *    void display_Inner() {
     *      Inner inner = new Inner(); 
     *      inner.print(); 
     *    }
     *    public static void main(String args[]) {
     *       g O = new g();
     *       O.display_Inner(); 
     *    }
     *  }
     *  If you execute this example then the program will run 
     *  and there will not be an error.
     *  
     *  4. Another solution to the reduction problem is to 
     *  determine the smallest number in the numerator and denominator 
     *  and divide that smallest number by the numerator and
     *  denominator. Then, decrement the number that you are 
     *  dividing by. Keep doing this until you have a value 
     *  that both the numerator and the denominator can be divided by.
     */
}