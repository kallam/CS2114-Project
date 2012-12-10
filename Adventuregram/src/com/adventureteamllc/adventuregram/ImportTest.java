package com.adventureteamllc.adventuregram;

// -------------------------------------------------------------------------
/**
 *  Tests Import.
 *
 *  @author Chris Hoffman
 *  @author Alex Kallam
 *  @author Brian Wright
 *  @author Jake Sperlazza
 *  @version Dec 8, 2012
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
	 * Tests all elements from constructor.
	 */
	public void testImport()
	{
		//Tests Construction
		assertEquals(imp.getTitle(), "Test Story");
		assertEquals(imp.getAuthor(), "Some Person");
		assertEquals(imp.getDescription(), "This is the description.");
		assertEquals(imp.getStoryChunks(), "[start]" +
				"[Text]You are standing in a room*RUN*[1] *REPEAT*[start] " +
				"*FAIL*[end] *NOTHING*[2][1][Text]You run.*RUN*[1] *FAIL*" +
				"[end] *TIMETRAVEL*[start] **[][2][Text]Start over." +
				"*START*[start] *FAIL*[end] *TIMETRAVEL*[1] *THIS*[2][end]" +
				"[Text]This is the end.[/story]");
	}

	// ----------------------------------------------------------
	/**
	 * Tests the Story Object generated by the text file
	 */
	public void testImportStory()
	{
		Story story = imp.getStory();

		//Test Event ids
		assertEquals(story.getEvent("start").getTitle(), "start");
		assertEquals(story.getEvent("1").getTitle(), "1");
		assertEquals(story.getEvent("2").getTitle(), "2");
		assertEquals(story.getEvent("end").getTitle(), "end");

		//Tests Event text
		assertEquals(story.getEvent("start").getDescription(),
				"You are standing in a room");
		assertEquals(story.getEvent("1").getDescription(), "You run.");
		assertEquals(story.getEvent("2").getDescription(), "Start over.");
		assertEquals(story.getEvent("end").getDescription(),
				"This is the end.");

		//Tests the number of connections for each Event
		assertEquals(story.getEvent("start").getNumConnections(), 4);
		assertEquals(story.getEvent("1").getNumConnections(), 3);
		assertEquals(story.getEvent("2").getNumConnections(), 4);
		assertEquals(story.getEvent("end").getNumConnections(), 0);

		//Tests Command names for start event.
		assertEquals(story.getEvent("start").getCommand(0).getName(), "RUN");
		assertEquals(story.getEvent("start").getCommand(1).getName(),
				"REPEAT");
		assertEquals(story.getEvent("start").getCommand(2).getName(), "FAIL");
		assertEquals(story.getEvent("start").getCommand(3).getName(),
				"NOTHING");

		//Tests Command references for start event.
		assertEquals(story.getEvent("start").getCommand(0).getTarget(), "1");
		assertEquals(story.getEvent("start").getCommand(1).getTarget(),
				"start");
		assertEquals(story.getEvent("start").getCommand(2).getTarget(), "end");
		assertEquals(story.getEvent("start").getCommand(3).getTarget(), "2");

		//Tests Commands for an Event with less than 4 Commands
		assertEquals(story.getEvent("1").getCommand(0).getName(), "RUN");
		assertEquals(story.getEvent("1").getCommand(1).getName(), "FAIL");
		assertEquals(story.getEvent("1").getCommand(2).getName(),
				"TIMETRAVEL");
		assertNull(story.getEvent("1").getCommand(4));

		//Tests that the end event has no Commands.
		assertNull(story.getEvent("end").getCommand(0));
		assertNull(story.getEvent("end").getCommand(1));
		assertNull(story.getEvent("end").getCommand(2));
		assertNull(story.getEvent("end").getCommand(3));
	}

}
