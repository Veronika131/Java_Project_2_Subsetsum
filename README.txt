project folder:
Veronika131-cs1c-project02/

NOTE:  - Part 1 and Part 2 are implemented in this assignment.
       - Part 1 output is in RUN.txt
       - Part 2 output is in RUN2.txt

Brief description of submitted files:


docs/
    - JavaDocs folder based on source code

lib/
    - library folder with json-simple-1.1.1.jar file that's used for parsing JSON file.


src/cs1c/MillionSongDataSubset.java
    - Parses a JSON data set and stores each entry in an array.

src/cs1c/SongEntry.java
    - Stores a simplified version of the genre data set from the Million Song Dataset.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation.


src/subsetsum/FoothillTunesStore.java
    - Prompts the user for a play list duration and generates playlist that best
      matches the given duration.

src/subsetsum/GroceriesFileReader.java
    - Reads the input file that contains the prices of the different items.

src/subsetsum/ShoppingBag.java
    - Prompts user for a budget and finds a best possible grocery shopping list
      within the given budget.

src/subsetsum/Sublist.java
    - Represents any subset of given set, S, and can generate new subset
      from existing subsets. Sublist stores indices references from master set,
      from which are formed subsets.

src/subsetsum/SubsetSum.java
    - An algorithm that can form collection of subsets, of a specified type,
      from an input set.  This new collection is then checked so that user
      receives the best matched subset, from the collection, to user's input value
      such as shopping budget or playlist duration or similar.


resources/groceries.txt
    - Input file that's used by ShoppingBag.java to test SubsetSum algorithm.

resources/groceries2.txt
    - Input file #2 that's used by ShoppingBag.java to test SubsetSum algorithm.

resources/groceries3.txt
    - Input file #3 that's used by ShoppingBag.java to test SubsetSum algorithm.

resources/music_genre_subset.json
    - Input file that's used by FoothillTunesStore.java to test SubsetSum algorithm.

resources/RUN.txt
    - Various test outputs of ShoppingBag class that display different grocery lists
      that user can purchase for the budget that user entered.

resources/RUN2.txt
    - Various test outputs of FoothillTunesStore class that display different play lists
      that user can obtain based on the duration that user entered.


.gitignore
    - .gitignore content tells git to ignore specified things.

README.txt
    - Description of submitted files.