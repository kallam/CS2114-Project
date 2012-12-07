package com.adventureteamllc.adventuregram;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Alex
 *  @version Dec 4, 2012
 */
public class LibraryTest extends student.TestCase
{

    private Library library;

    public void setUp() {
        library = new Library();
        Story quest = new Story("Attack of the Clones");
        library.importStory(quest);
    }

    // ----------------------------------------------------------
    /**
     * Tests adding and removing stories to the library
     */
    public void testAddRemove() {
        Story quest = new Story("A New Hope");
        library.importStory(quest);
        library.removeStory(1);
        assertEquals(1, library.size());
    }

    // ----------------------------------------------------------
    /**
     * Tests getting the library as a list
     */
    public void testGetLibrary() {
        Story quest = new Story("A New Hope");
        library.importStory(quest);
        assertEquals(quest, library.getLibrary().get(1));
    }

}
