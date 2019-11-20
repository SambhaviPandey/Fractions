/**
 * class ObjectList consists of 
 * a program that contains state items
 * (data) and an array of Objects. 
 * The purpose of this program is to store 
 * the list of FractionCounters.This class 
 * contains:
 * toString method
 * add method
 * length method
 * getFraction method
 * resize method
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 12, 2018)
 */
public class ObjectList
{
    //Declaring and initializing
    private int numElements = 0;
    private int maximumLength = 100;
    //Declaring array
    private Object[] myObj = new Object[maximumLength]; 

    /**
     * The method add is void and takes 
     * an argument corresponding to the array 
     * of type Object. The purpose of this method 
     * is to add the object to the list and 
     * add one to numElements.In addition,
     * this method calls the method to resize
     * the array.
     * 
     * @param obj
     */  
    public void add(Object obj)
    {
        resizeArray();
        myObj[numElements] = obj;
        numElements++;
    }
    
    /**
     * The method getFraction is a method 
     * that returns a FractionCounter 
     * value. This method also takes an 
     * int argument corresponding to the index.
     * 
     * @param index
     */
    public FractionCounter getFraction(int index)
    {
        return (FractionCounter)myObj[index];
    }
    
    /**
     * The method toString returns a String
     * value. The purpose of this method is 
     * to iterate through the array, calling 
     * toString and appending the object to 
     * one large String, which is returned. 
     */
    public String toString()
    {
        String retVal = "";
        for (int i = 0; i < numElements; i++)
        {
            retVal += myObj[i] + " ";
        }
        return retVal;
    }
            
    /**
     * The method resizeArray is a void method.
     * The purpose of this method is to determine
     * if the method is full and if it is full, 
     * to resize the array.
     */       
    public void resizeArray()
    {
        if (numElements == maximumLength)
        {
            Object obj[] = new Object[maximumLength * 2];
            for (int i = 0; i < numElements; i++)
            {
                obj[i] = myObj[i];
            }
            myObj = obj;
            maximumLength = maximumLength * 2;
        }
    }
    
    /**
     * The method lengthOfArray returns an 
     * int value. The purpose of this method 
     * is to return the number of elements 
     * of the array, which is the length 
     * of the array. 
     */  
    public int lengthOfArray()
    {
        return numElements;
    }
}