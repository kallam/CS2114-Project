package com.adventureteamllc.adventuregram;

import java.io.IOException;
import android.content.Context;
import android.content.res.AssetManager;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Contains the Import objects that hold the stories so that
 *  they can be presented by the library screen
 *
 *  @author Alex
 *  @version Dec 1, 2012
 */
public class Library
{
    private ArrayList<Import> library;

    // ----------------------------------------------------------
    /**
     * Create a new Library object.
     */
    public Library()
    {
        library = new ArrayList<Import>();
    }

    // ----------------------------------------------------------
    /**
     * Uses the Import class to create a story object and then save it in the
     * library
     * @param file Path of the file to be parsed
     */
    public void importStory(String file)
    {
        Import story = new Import(file);
        library.add(story);
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
    public ArrayList<Import> getLibrary()
    {
        return library;
    }

    // ----------------------------------------------------------
    /**
     * Removes a story from the list
     * @param index Position of the story in the list
     */
    public void removeStory(int index)
    {
        library.remove(index);
    }

    // ----------------------------------------------------------
    /**
     * Returns the number of Import in the Library
     * @return Number of stories in the Import list
     */
    public int size() {
        return library.size();
    }

    /**
     * Returns an Import from the library
     * @param index of the import object in the library
     * @return Story from the library
     */
    public Import getStory(int index) {
    	return library.get(index);
    }


}
