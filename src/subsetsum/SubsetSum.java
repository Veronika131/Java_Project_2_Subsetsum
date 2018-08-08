package subsetsum;

import cs1c.MillionSongDataSubset;
import cs1c.SongEntry;

import java.util.*;

/**
 * SubsetSum is an algorithm that can form collection of subsets, of a specified
 * type, from an input set.  This new collection is then checked so that
 * user receives the best matched subset, from the collection, to user's input value
 * such as shopping budget or playlist duration or similar.
 *
 * @author Foothill College, Veronika Cabalova Joseph
 */
public class SubsetSum implements Cloneable
{
    //class constant
    private static final int FIRST_INDEX = 0;

    private static ArrayList<Sublist> col = new ArrayList<>();

    /**
     * finding the sublist with the closest target value sum out of all subsets in the collection
     * @param groceryList array list of grocery prices
     * @param budget target budget value provided by user
     * @return sublist with the closest target match to budget
     */
    public static ArrayList<Double> findSubset(ArrayList<Double> groceryList, double budget)
    {
        //first initializing collection "col" with one empty sublist
        Sublist newSublist = new Sublist(groceryList);
        //add new sublist to collection
        col.add(newSublist);

        //testing if users budget is higher than total sum of grocery list prices
        if(budget >= sumOfOriginalElements(groceryList))
        {
            System.out.println("\nYour budget is high enough to buy everything on the grocery list!");
            return groceryList;
        }
        //testing if budget is 0 or less
        else if(budget <= 0)
        {
            System.out.println("\nYour budget is too low to afford anything on the grocery list!");
        }
        //try to find the closest match of grocery list to our target value,
        //if no match found - keep adding new sublist to collection
        else
        {
            findClosestTargetMatch(groceryList, budget);
        }
        //returns list of groceries that matches our budget closest
        return findLargestSubset(col);
    }

    /**
     * finding the sublist with the closest target value sum out of all subsets in the collection
     * @param songList array list of songs
     * @param duration target duration value provided by user
     * @return sublist with the closest target match to duration
     */
    public static ArrayList<SongEntry> findSubsetOfSongs(ArrayList<SongEntry> songList, double duration)
    {
        //first initialize collection "col" with one empty sublist
        Sublist newSublist = new Sublist(songList);
        //add new sublist to collection
        col.add(newSublist);

        //check if target duration is larger than he sum of all songs in master set
        //total duration in the master list is 248201.36 min (14892082 sec)
        if(duration > sumOfOriginalElements(playlistDurationList(songList)))
        {
            System.out.println("\nTime duration you selected is long enough for the whole playlist!\n"
                    + "Playlist contains over 59600 songs, enjoy! :)");
            return songList;
        }
        //testing if duration is 0 or less
        else if(duration <= 0)
        {
            System.out.println("\nYour time duration is too short for any playlist to be created.");
        }
        // try to find the closest match of play list to our target value,
        // if no match found - keep adding new sublist to collection
        else
        {
            findClosestTargetMatch(playlistDurationList(songList), duration);
        }
        //returns play list that matches our budget closest
        return findLargestSubset(col);
    }


    // --------------- helper methods ---------------------------------------------
    /**
     * sumOfOriginalElements sums up all elements in original list
     * @param originalList original master set
     * @return sum of all elements in the set
     */
    private static double sumOfOriginalElements(ArrayList<Double> originalList)
    {
        double sum = 0;
        for ( int i = 0; i < originalList.size(); i++)
        {
            sum += originalList.get(i);
        }
        return sum;
    }

    /**
     * playlistDurationList creates array list from original playlist that only
     * contains duration of time of each song
     * @param songList array list of original song list
     * @return array list of doubles with only duration of each song
     */
    private static ArrayList<Double> playlistDurationList(ArrayList<SongEntry> songList)
    {
        ArrayList<Double> songDurationArray = new ArrayList<>();

        for (int i = 0; i < songList.size(); i++)
        {
            double songDuration = songList.get(i).getDuration();
            songDurationArray.add(songDuration);
        }
        return songDurationArray;
    }

    /**
     * findClosestTargetMatch loops over all elements in provided list to help find closest sum to target
     * @param listForClosestMatch array list that's used to find match for target value
     * @param targetValue target value that we want to reach
     * @param <T> generic method
     */
    private static <T> void findClosestTargetMatch(ArrayList<T> listForClosestMatch, double targetValue)
    {
        //looping over all elements in our groceryList
        //label for the outer loop
        outerloop:
        for (int i = 0; i < listForClosestMatch.size(); i++)
        {
            //looping over all member subsets of col
            for (int j = 0; j < col.size() - j; j++)
            {
                Sublist newSublist = col.get(j);
                //try to add to sublist or exit loops if target budget is met
                //total sum update
                double sum = newSublist.getSum() + (Double) listForClosestMatch.get(i);

                //check sum against target value, if less add sublist to collection
                if (sum <= targetValue)
                {
                    try
                    {
                        Sublist newClonedSublist = (Sublist) newSublist.clone();
                        col.add(newClonedSublist.addItem(i));
                    }
                    catch (CloneNotSupportedException e)
                    {
                        e.printStackTrace();
                    }
                }
                //if sum matches target value exit both loops
                if (sum == targetValue)
                {
                    break outerloop;
                }
            }
        }
    }

    /**
     * findLargestSubset helps to find largest subset from whole collection subsets
     * @param col ArrayList of collection of subsets
     * @return ArrayList of specified type with largest subset
     */
    private static <T> ArrayList<T> findLargestSubset(ArrayList<Sublist> col)
    {
        double largestSum = col.get(FIRST_INDEX).getSum();
        int largestIndex = 0;
        ArrayList<T> largestSubset;

        //loop to check for largest sum
        for (int i = 0; i < col.size(); i++)
        {
            //value of current subset in collection
            double currentValue = col.get(i).getSum();
            //if current value is greater then largest sum so far, assign it to largestSum
            if (currentValue > largestSum)
            {
                largestSum = currentValue;
                largestIndex = i;
            }
        }
        largestSubset = col.get(largestIndex).getSubset();
        return largestSubset;
    }
}