package com.adventureteamllc.adventuregram;
//import static org.junit.Assert.*;
//import org.junit.Test;


import junit.framework.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  Test Event Class
 *
 *  @author Brian
 *  @version Nov 30, 2012
 */
public class EventTest
    extends TestCase
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
      //  assertFalse(event.isEnd());
       // event.setEnd();
      //  assertTrue(event.isEnd());
        assertEquals(command, event.getCommand(0));
        assertNull(event.getCommand(5));
    }


}

