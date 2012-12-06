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
        imp = new Import("assets\\TestStoryBeta.txt");
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
                "[Text]You are standing in a room*RUN*[1] *REPEAT*[start] " +
                "*FAIL*[end] *NOTHING*[2][1][Text]You run.*RUN*[1] *FAIL*" +
                "[end] *TIMETRAVEL*[start] **[][2][Text]Start over.*START*[start] " +
                "*FAIL*[end] *TIMETRAVEL*[1] *THIS*[2][end][Text]This " +
                "is the end.[/story]");

        Story story = imp.getStory();
        assertEquals(story.getEvent("start").getTitle(), "start");
        assertEquals(story.getEvent("1").getTitle(), "1");
        assertEquals(story.getEvent("2").getTitle(), "2");
        assertEquals(story.getEvent("end").getTitle(), "end");

        assertEquals(story.getEvent("start").getDescription(),
            "You are standing in a room");
        assertEquals(story.getEvent("1").getDescription(), "You run.");
        assertEquals(story.getEvent("2").getDescription(), "Start over.");
        assertEquals(story.getEvent("end").getDescription(),
            "This is the end.");

        assertEquals(story.getEvent("start").getNumConnections(), 4);
        assertEquals(story.getEvent("1").getNumConnections(), 3);
        assertEquals(story.getEvent("2").getNumConnections(), 4);
        assertEquals(story.getEvent("end").getNumConnections(), 0);
    }

}
