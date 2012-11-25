package com.adventureteamllc.adventuregram;

// -------------------------------------------------------------------------
/**
 *  Tests Import
 *
 *  @author Chris
 *  @version Nov 25, 2012
 */
public class ImportTest extends student.TestCase
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
        imp = new Import("TestStory.txt");
    }

    // ----------------------------------------------------------
    /**
     * Tests all elements.
     */
    public void testImport()
    {
        assertEquals(imp.getTitle(), "Test Story");
        assertEquals(imp.getDescription(), "This is the description.");
        assertEquals(imp.getAuthor(), "Test Story");
        assertEquals(imp.getStoryChunks(), "[story NumberOfEvents = <3>][start]" +
        		"[t] You are standing in a room[/t][c]*RUN* [1]*REPEAT* [start]" +
        		"*FAIL* [end][/c][/start][1][t] You run.[/t][c]*RUN* [1]*FAIL* " +
        		"[end]*TIMETRAVEL* [start][/c][/1][end][t] This is the end.[/t]" +
        		"[/end][/story]");
    }
}
