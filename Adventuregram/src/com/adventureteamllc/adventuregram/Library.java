package com.adventureteamllc.adventuregram;

import java.io.IOException;
import android.content.Context;
import android.content.res.AssetManager;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Contains the stories so that they can be presented by the library screen
 *
 *  @author Alex
 *  @version Dec 1, 2012
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
     * Uses the Import class to create a story object and then save it in the
     * library
     * @param file Path of the file to be parsed
     */
    public void importStory(String file)
    {
        Import temp = new Import(file);
        lib.add(temp.getStory());
    }

 // ----------------------------------------------------------
    /**
     * Adds a story object to the library
     * @param story object to Import
     */
    public void importStory(Story story) {
        lib.add(story);
    }

    // ----------------------------------------------------------
    /**
     * Imports all the default stories in the assets folder
     * @param myContext Context of the android application
     */
    public void importStoriesFromAssets(Context myContext) {
        //Find all of the text files that presumably hold stories
        AssetManager assets = myContext.getAssets();
        String[] storyFiles = null;
        try
        {
            storyFiles = assets.list(""); //Change this if stories are put into a sub folder
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        for (int i = 0; i < storyFiles.length; i++) {
            importStory(storyFiles[i]);
        }
    }

    // ----------------------------------------------------------
    /**
     * Returns a list of stories that have been parsed
     * @return An ArrayList of stories
     */
    public ArrayList<Story> getLibrary()
    {
        return lib;
    }

    // ----------------------------------------------------------
    /**
     * Removes a story from the list
     * @param index Position of the story in the list
     */
    public void removeStory(int index)
    {
        lib.remove(index);
    }

    // ----------------------------------------------------------
    /**
     * Returns the number of stories in the Library
     * @return Number of stories in the story list
     */
    public int getSize() {
        return lib.size();
    }


}
