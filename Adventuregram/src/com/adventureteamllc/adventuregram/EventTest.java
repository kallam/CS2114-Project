package com.adventureteamllc.adventuregram;

import junit.framework.TestCase;
/**
 *  Test Event Class.
 *
 *  @author Brian Wright
 *  @author Alex Kallam
 *  @author Chris Hoffman
 *  @author Jake Sperlazza
 *  @version Dec 8, 2012
 */
public class EventTest extends TestCase
{

	private Event event;
	private Command command;

	/**
	 * Initialize test fixtures
	 */
	public void setUp()
	{
		event = new Event("title", "description");
		command = new Command("this way", "0");
	}

	/**
	 * Tests the Event class
	 */
	public void testEvent()
	{
		assertEquals("description", event.getDescription());
		assertEquals("title", event.getTitle());
		event.addCommand(command);
		assertEquals(1, event.getNumConnections());
		assertEquals(command, event.getCommand(0));
		assertNull(event.getCommand(5));
	}
}

