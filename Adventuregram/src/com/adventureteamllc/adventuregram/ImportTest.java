package com.adventureteamllc.adventuregram;

// -------------------------------------------------------------------------
/**
 *  Tests Import
 *
 *  @author Chris
 *  @version Nov 25, 2012
 */
public class ImportTest extends junit.framework.TestCase
{
    private Import imp;
    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ImportTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Starting conditions for all tests in this class.
     */
    public void setUp()
    {
        imp = new Import("TestStoryBeta");
    }

    // ----------------------------------------------------------
    /**
     * Tests all elements.
     */
    public void testImport()
    {
        assertEquals(imp.getTitle(), "Test Story");
        assertEquals(imp.getAuthor(), "Some Person");
        assertEquals(imp.getDescription(), "This is the description.");
        assertEquals(imp.getStoryChunks(), "[start]" +
                "[Text] You are standing in a room*RUN*[1] *REPEAT*[start] " +
                "*FAIL*[end][1][Text] You run.*RUN*[1] *FAIL*" +
                "[end] *TIMETRAVEL*[start][end][Text] This is the end." +
                "[/story]");
    }

}
