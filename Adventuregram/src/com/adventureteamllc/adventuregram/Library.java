package com.adventureteamllc.adventuregram;

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
    private HashMap<String, Import> lib;

    // ----------------------------------------------------------
    /**
     * Create a new Library object.
     */
    public Library()
    {
        lib = new HashMap<String, Import>();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param file
     */
    public void importStory(String file)
    {
        Import temp = new Import(file);
        lib.put(temp.getTitle(), temp);
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
     * @return
     */
    public HashMap<String, Import> getLibrary()
    {
        return lib;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param title
     */
    public void removeStory(String title)
    {
        lib.remove(title);
    }


}
