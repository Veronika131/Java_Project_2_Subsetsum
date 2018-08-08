package subsetsum;
import java.io.*;
import java.util.*;

/**
 * Class GroceriesFileReader reads the input file that
 * contains the prices of the different items.
 *
 * @author Foothill College, Veronika Cabalova Joseph
 */

public class GroceriesFileReader
{
    /**
     * readFile reads CSV files of groceries and creates a
     * specified ArrayList of grocery prices.
     * @param filePath the JSON file to parse
     * @return price of groceries list
     */
    public ArrayList<Double> readFile(String filePath)
    {
        ArrayList<Double> priceOfGroceries = new ArrayList<>();
        Scanner inputScanner;
        // attempt to parse the input file
        try
        {
            inputScanner = new Scanner(new File(filePath));
            while (inputScanner.hasNext())
            {
                String foodItem = inputScanner.next();
                String delimiter = "[,]";
                String [] tokens = foodItem.split(delimiter);
                priceOfGroceries.add(Double.parseDouble(tokens[1]));
            }
            inputScanner.close();
        }
        //catch displays error message if input file is not fount
        catch(FileNotFoundException e)
        {
            System.out.println("\n*** ALERT: File was not found ***\n");
            // For more info we can include Stack Trace
            // e.printStackTrace();
        }
        return priceOfGroceries;
    }
}

