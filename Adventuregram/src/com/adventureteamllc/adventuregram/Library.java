package com.adventureteamllc.adventuregram;

import java.util.ArrayList;
import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 *  Contains the stories so that they can be presented by the library screen
 *
 *  @author Alex
 *  @version Dec 3, 2012
 */
public class Library
{
    private ArrayList<Story> lib;

    // ----------------------------------------------------------
    /**
     * Create a new Library object.
     */
    public Library()
    {
        lib = new ArrayList<Story>();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param file
     */
    public void importStory(String file)
    {
        Import temp = new Import(file);
        //lib.add(temp.)
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void importStoriesFromAssets() {
        //Find all text files in assets folder
        //import each file individually
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return An ArrayList of stories
     */
    public ArrayList<Story> getLibrary()
    {
        return lib;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param index Position of the story in the list
     */
    public void removeStory(int index)
    {
        lib.remove(index);
    }


}
