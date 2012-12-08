package com.adventureteamllc.adventuregram;

// -------------------------------------------------------------------------
/**
 *  Tests various functions of the library
 *  Kind of hard to test it, so this mostly tests the Library class
 *
 *  @author Brian Wright
 *  @author Alex Kallam
 *  @author Chris Hoffman
 *  @author Jake Sperlazza
 *  @version Dec 4, 2012
 */
public class LibraryScreenTests extends student.AndroidTestCase<LibraryScreen>
{

    private Library library;

    // ----------------------------------------------------------
    /**
     * Create a new LibraryScreenTest object.
     */
    public LibraryScreenTests()
    {
        super(LibraryScreen.class);
    }

    public void setUp()
    {
        library = getScreen().getLibraryList();
    }

    // ----------------------------------------------------------
    /**
     * Tests removing stories to the library
     */
    public void testRemoveStory()
    {
        int size = library.size();
        if (size > 0) {
            library.removeStory(0);
        }
        assertEquals(size - 1, library.size());
    }

    // ----------------------------------------------------------
    /**
     * Tests getting the library as a list
     */
    public void testGetLibrary() {
        Story quest = new Story("A New Hope");
//        library.importStory(quest);
        assertEquals(quest, library.getLibrary().get(1));
    }

}
