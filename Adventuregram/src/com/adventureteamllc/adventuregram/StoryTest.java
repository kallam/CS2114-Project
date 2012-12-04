package com.adventureteamllc.adventuregram;
//import static org.junit.Assert.*;
import junit.framework.TestCase;
//import org.junit.Test;

/**
 * // -------------------------------------------------------------------------
/**
 * Tests Story Class.
 *
 *  @author Brian
 *  @version Nov 30, 2012
 */
public class StoryTest
extends TestCase
{

private Story story;
private Event event;


/**
 * Initialize test fixtures
 */
public void setUp()
{
   story = new Story("theStory");
   event = new Event("title", "descrip");
}

/**
 * Tests story methods
 */
public void testStory()
{
   story.addEvent("title", event);
   assertEquals(event, story.getEvent("title"));
   //assertEquals(1, story.getNumEvents());
   story.setTitle("different");
   assertEquals("different", story.getTitle());
}


}