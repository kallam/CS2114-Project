package com.adventureteamllc.adventuregram;

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
     * Adds an import object to the library
     * @param importedStory Import object to be added
     */
    public void importStory(Import importedStory)
    {
        library.add(importedStory);
    }

    // ----------------------------------------------------------
    /**
     * Returns a list of Import objects that have been parsed
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
     * Returns an Story from the library
     * @param index of the import object in the library that contains the story
     * @return Story from the library
     */
    public Story getStory(int index) {
        return library.get(index).getStory();
    }


}
