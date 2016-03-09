/*********************************************************************** 
Program Name: SalesTracking.java 
Programmer's Name: Aviram Moran 
Program Description:
	This program will use arrays to store and process monthly sales
	as well as compute average yearly sales, total sales for the year,
	and which month had the highest sales and which month had the lowest sales 
***********************************************************************/

import java.text.NumberFormat; //used to format to Currency
import java.util.Scanner; //used to handle user input
public class SalesTracking 
{
     public static void main(String[] args)
    {
        //Initialize variables
        double totalSales = 0;
        double averageSales = 0;
        double highestSales = 0;
        double lowestSales = 0;
        String highestSalesMonth = "";
        String lowestSalesMonth = "";
 
        //Initialize Arrays
        double[] monthlySales = new double[12];        
        String[] monthArray = {"January", "February", "March", "April", "May", "Jun", "July",
                               "Augst", "September", "October", "November", "Decmber"};
       
        //Initialize methods
        
        getSales(monthlySales, monthArray); //Input

        totalSales = computeTotalSales(monthlySales, totalSales);
 
        averageSales = computeAverageSales(monthlySales, totalSales, averageSales);
 
        highestSales = computeHighestMonth(monthlySales, highestSales);
 
        lowestSales = computeLowestMonth(monthlySales, lowestSales);        
        
        highestSalesMonth = FindHighestMonth(monthlySales, highestSales, monthArray);
        
        lowestSalesMonth = FindLowesttMonth(monthlySales, lowestSales, monthArray);
        
        displayInfo(totalSales, averageSales, highestSales, lowestSales,highestSalesMonth,lowestSalesMonth);
        
    }
 
    public static void getSales(double monthlySales[], String monthArray[])
    {
    	//This method prompt the user for the sales for each month starting with January.    	
    	int i;
    	Scanner input = new Scanner(System.in);
    	try
    	{
    		for (i = 0; i < monthlySales.length; i++)
    		{
                
    			System.out.print("Please enter total sales for " + monthArray[i] + ":");
    			
    			//Checking for proper input    			
    			while (!input.hasNextBigDecimal())
    			{
    				System.out.print("Incorrect data for " + monthArray[i] + " ! Try again: ");
    				input.next();
    			}
    			monthlySales[i] = input.nextInt();
            }
    	}
    	finally
    	{
    		//Close scanner to avoid leak
    		input.close();     
        }            
    }
 
       
    
    public static double computeTotalSales(double monthlySales[], double totalSales)
    {
        //This method receives the monthly sales array as an argument and returns the total sales of the year.
        int i;
        for (i = 0; i < monthlySales.length; i++)
        {
            totalSales = totalSales + monthlySales[i];
        }
        return totalSales;
    }
 
    public static double computeAverageSales(double monthlySales[], double totalSales , double averageSales)
    {
     //This method receives the monthly sales array as an argument and returns the average sales for the year.
        averageSales = totalSales/monthlySales.length;        
        return averageSales;
    }
 
    public static double computeHighestMonth(double monthlySales[],double highestSales)
    {
        //This method receives the monthly sales array as an argument.
    	//it then search and compare the values of the monthly sales array for the highest value.
    	// and return the index(i) of the month with the highest value.
        int i;
        double highvalue = 0;       
        for (i = 0; i < monthlySales.length; i++)
        {
                    if (monthlySales[i] > highvalue)
                    {
                        highvalue = monthlySales[i]; 
                        highestSales = highvalue;
                    }                    
                    highestSales = highvalue;
        }
        return highestSales;
    }
    
    public static String FindHighestMonth(double monthlySales[],double highestSales, String[] monthArray)
    {
        //This method receives the monthly sales array as an argument.
    	//it then search and compare the values of the monthly sales array for the highest value.
    	// and return the name based on the monthArray(i) of the month with the highest value.
        int i;
        double highvalue = 0;
        String highestmonth = "";
        for (i = 0; i < monthlySales.length; i++)
        {
                    if (monthlySales[i] > highvalue)
                    {
                    	highvalue = monthlySales[i];
                    	highestmonth = monthArray[i];                        
                    }                
        }
        return highestmonth;
    }
    
    public static String FindLowesttMonth(double monthlySales[],double lowestSales, String[] monthArray)
    {
        //This method receives the monthly sales array as an argument.
    	//it then search and compare the values of the monthly sales array for the lowest value.
    	// and return the name based on the monthArray(i) of the month with the lowest value.
    	int i;
        double lowvalue = 999999999;
        String lowestmonth = "";
        for (i = 0; i < monthlySales.length; i++)
        	for (i = 0; i < monthlySales.length; i++)
            {
                        if (monthlySales[i] < lowvalue)
                        {
                        	lowvalue = monthlySales[i];
                        	lowestmonth = monthArray[i];
                        }
            }
        return lowestmonth;
    }
 
    public static double computeLowestMonth(double monthlySales[],double lowestSales)
    {
        //This method receives the monthly sales array as an argument.
    	//it then search and compare the values of the monthly sales array for the lowest value.
    	//and return the index(i) of the month with the lowest value.
        int j;
        double lowvalue = 999999999;
        for (j = 0; j < monthlySales.length; j++)
        {
                    if (monthlySales[j] < lowvalue)
                    {
                        lowvalue = monthlySales[j];
                        lowestSales = lowvalue;
                    }   
                    lowestSales = lowvalue;
        }
        return lowestSales;
    }
 
    public static void displayInfo(double totalSales, double averageSales, double highestSales, double lowestSales, String highestSalesMonth, String lowestSalesMonth)
    {
        //This method receives the total yearly sales, average monthly sale,
    	//the month with the highest sales, as well as the sales for that month and
    	//the month with the lowest sales then displays all of the data it received as arguments.
    	NumberFormat formatter = NumberFormat.getCurrencyInstance(); //use NumberFormat class to format double into Currency  	
        System.out.print("Total annual sales: " + formatter.format(totalSales) + "\n");
        System.out.print("Average annual sales: " + formatter.format(averageSales) + "\n");
        System.out.print("The first Month with the Highest annual sales was " + highestSalesMonth + " with " + formatter.format(highestSales) + " in sales" + "\n");
        System.out.print("The first Month with the Lowest annual sales was " + lowestSalesMonth + " with " + formatter.format(lowestSales) + " in sales" + "\n");     
        
    }
}
