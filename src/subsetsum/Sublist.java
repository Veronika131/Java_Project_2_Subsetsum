package subsetsum;

import cs1c.SongEntry;

import java.util.ArrayList;

/**
 * Sublist class can represents any subset of given set, S,
 * and it can generate new subset from existing subsets.
 * Sublist stores indices references from master set, from which
 * are formed subsets.
 *
 * @author Foothill College, Veronika Cabalova Joseph
 */
class Sublist <T> implements Cloneable
{
    //sum of elements inside sublist
    private double sum = 0;
    //original list
    private ArrayList<T> originalObjects;
    //indicies list
    private ArrayList<Integer> indices;

    /**
     * constructor creates an empty Sublist (no indices)
     * @param orig master list that we are using to create sublists
     */
    public Sublist(ArrayList<T> orig)
    {
        sum = 0;
        originalObjects = orig;
        indices = new ArrayList<>();
    }

    /**
     * sum getter of elements in sublist
     * @return sum value of sublist elements
     */
    double getSum()
    {
        return sum;
    }

    /**
     * Cloning of sublist and its indicies
     * @return deep clone copy of sublist
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException
    {
        // shallow copy
        Sublist newObject = (Sublist)super.clone();
        // deep copy
        newObject.indices = (ArrayList<Integer>)indices.clone();

        return newObject;
    }

    /**
     * addItem takes index of master set as parameter and adds it to current sublist
     * @param indexOfItemToAdd integer index, from master set, that needs to be added to sublist
     * @return new sublist
     * @throws CloneNotSupportedException
     */
    public <T> Sublist addItem(int indexOfItemToAdd)
            throws CloneNotSupportedException
    {
        //cloning sublist
        Sublist newSublist = (Sublist)this.clone();
        //adds indexed element as a new element
        newSublist.indices.add(indexOfItemToAdd);

        //total sum update
        if (originalObjects.get(indexOfItemToAdd) instanceof Double)
        {
            newSublist.sum += (Double) originalObjects.get(indexOfItemToAdd);
        }
        else if (originalObjects.get(indexOfItemToAdd) instanceof SongEntry)
        {
            newSublist.sum += ((SongEntry) originalObjects.get(indexOfItemToAdd)).getDuration();
        }
        return newSublist;
    }

    /**
     * showSublist displays elements of sublist
     */
    void showSublist()
    {
        System.out.println("Sublist:");

        //iterating through each element of sublist
        for(int i = 0; i < indices.size(); i++)
        {
            System.out.println(" array[" + indices.get(i)
                    + "] = " + originalObjects.get(indices.get(i)));
        }
    }

    /**
     * getter for a specific subset
     * @return full subset
     */
    public ArrayList<T> getSubset()
    {
        ArrayList<T> subset = new ArrayList<>();

        //loop to obtain whole subset
        for (Integer indice : indices)
        {
            subset.add(originalObjects.get(indice));
        }
        return subset;
    }
}