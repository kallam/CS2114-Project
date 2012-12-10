package com.adventureteamllc.adventuregram;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  Tests the Command Class
 *
 *  @author Alex Kallam
 *  @author Brian Wright
 *  @author Chris Hoffman
 *  @author Jake Sperlazza
 *  @version Dec 8, 2012
 */
public class CommandTest extends TestCase
{
	private Command goAway;

	/**
	 * Runs before every Test case.
	 */
	public void setUp()
	{
		goAway = new Command("Tell them to go away", "end");
	}

	// ----------------------------------------------------------
	/**
	 * Tests the values of a command to validate the constructor
	 */
	public void testConstructor() {
		assertEquals("Tell them to go away", goAway.getName());
		assertEquals("end", goAway.getTarget());
	}


}
