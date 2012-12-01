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
    private Event.Connection connect;

    /**
     * Initialize test fixtures
     */
    public void setUp()
    {
        event = new Event("title", "description");
        connect = new Event.Connection("this way", 0);
    }

    /**
     * Tests the Event class
     */
    public void testEvent()
    {
        assertEquals("description", event.getDescription());
        event.addConnection(connect);
        assertEquals(1, event.getNumConnections());
        assertFalse(event.isEnd());
        event.setEnd();
        assertTrue(event.isEnd());
        assertEquals(connect, event.getConnection(0));
        assertNull(event.getConnection(5));
    }


}
