package com.adventureteamllc.adventuregram;

import junit.framework.TestCase;

/**
 * Tests Story Class.
 *
 *  @author Brian Wright
 *  @author Alex Kallam
 *  @author Chris Hoffman
 *  @author Jake Sperlazza
 *  @version Dec 8, 2012
 */
public class StoryTest extends TestCase
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
        story.setTitle("different");
        assertEquals("different", story.getTitle());
    }


}