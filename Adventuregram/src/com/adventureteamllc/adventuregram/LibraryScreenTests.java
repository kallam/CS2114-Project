package com.adventureteamllc.adventuregram;

import java.util.HashMap;
import android.widget.SimpleAdapter;

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

    private SimpleAdapter library;

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
        library = getScreen().getAdapter();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testAdapterSize() {
        assertEquals(5, library.getCount());
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testAdapterContent() {
        //Gets first story from assets - Alex's story
        HashMap<String, String> map = (HashMap<String, String>)library.getItem(0);
        assertEquals("\"Life of a CS Major\" by Alex Kallam", map.get("Title"));
    }

}
