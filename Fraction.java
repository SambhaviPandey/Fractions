/**
 * class Fraction represents the ratio 
 * of two numbers. This class includes:
 * Constructors
 * equals method
 * toString method
 * accessor and mutator methods 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 12, 2018)
 */
public class Fraction
{
    //Declaring
    int numerator;
    int denominator;

    /**
     * Default/no-argument constructor
     */
    Fraction()
    {
        //Initializing 
        numerator = 0;
        denominator = 0;
    }

    /**
     * Constructor that takes two integer arguments
     * corresponding to the numerator(n) and 
     * denominator(d) of the fraction. The purpose 
     * of this constructor is to put the numerator equal 
     * to the parameter n and the denominator 
     * equal to the parameter d. 
     * 
     * @param n 
     * @param d
     */
    public Fraction(int n, int d)
    {
        numerator = n;
        denominator = d;
    }

    /**
     * The method equals returns a boolean value 
     * and takes an argument corresponding to the 
     * Fraction class.The purpose of this method is
     * to compare this (numerator and denominator) 
     * to the other (numerator and denominator).It
     * returns true if the this.numerator is equal 
     * to other.numerator and if this.denominator is
     * equal to other.denominator, otherwise it returns
     * false. 
     */
    public boolean equals(Fraction other)
    {
        //Compares this to other
        if (this.numerator == other.numerator &&
            this.denominator == other.denominator)
        {
            return true;
        }
        return false;
    }

    /**
     * The method toString returns a String
     * value. The purpose of this method is 
     * to return the numerator and denominator.
     */
    public String toString()
    {
        return numerator + "/" + denominator;
    }

    /**
     * The method getNumerator returns an int value
     * corresponding to the value stored in the numerator.
     */
    public int getNumerator()
    {
        return numerator;
    }

    /**
     * The method setNumerator is a void method that 
     * takes an integer argument corresponding to the
     * numerator (num). The purpose of this method is
     * to set the value of numerator to num.
     * 
     * @param num
     */
    public void setNumerator(int num)
    {
        numerator = num;
    }
    
    /**
     * The method getDenominator returns an int value
     * corresponding to the value stored in the 
     * denominator.
     */
    public int getDenominator()
    {
        return denominator;
    }
    
    /**
     * The method setDenominator is a void method that 
     * takes an integer argument corresponding 
     * to the denominator (den). The purpose 
     * of this method is to set the value of 
     * denominator to den.
     * 
     * @param den
     */
    public void setDenominator(int den)
    {
        denominator = den;
    }
}