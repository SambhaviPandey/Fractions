/**
 * The purpose of the class FractionCounter is to
 * store a reference to a Fraction object and count
 * how many times the fraction object occurs in the 
 * input file. This class consists of:
 * A constructor
 * equals method
 * toString method
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 12, 2018)
 */
public class FractionCounter
{
    //Declaring the class variable 
    private Fraction fraction;
    //Declaring and initializing the integer 
    //value used to count the number of fractions 
    //in the input file 
    private int counter = 1;

    /**
     * Constructor that takes an argument 
     * corresponding to the Fraction class.
     * The purpose of this constructor is to
     * put the value of fraction as theFraction.
     * 
     * @param theFraction
     */
    FractionCounter(Fraction theFraction)
    {
        fraction = theFraction;
    }
    
    /**
     * The method compareAndIncrement returns a 
     * boolean value and takes an argument 
     * corresponding to the Fraction class.
     * The purpose of this method is to determine 
     * if the newFraction passed into this function 
     * is the same as the Fraction we are storing. If 
     * it is the same, the counter increments and returns
     * true, otherwise it returns false.
     * 
     * @param newFraction
     */
    public boolean compareAndIncrement(Fraction newFraction)
    {
        if (fraction.equals(newFraction))
        {
            counter++;
            return true;
        }
        return false;
    }

    /**
     * The method toString returns a String
     * value. The purpose of this method is 
     * to return the fraction and it's count
     * (number of occurrences).
     */
    public String toString()
    {
        return fraction + " has a count of " + counter;
    }
}