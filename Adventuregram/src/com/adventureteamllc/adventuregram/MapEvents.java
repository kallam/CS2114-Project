package com.adventureteamllc.adventuregram;

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian Wright
 *  @version Nov 25, 2012
 */
public class MapEvents
{
    private ArrayList<Event> events;
    private String title;

    public MapEvents()
    {
        events = new ArrayList<Event>();

    }

    public void addEvent(Event ev)
    {
        events.add(ev);
    }

    public int getNumEvents()
    {
        return events.size();
    }

    public Event getEvent(int i)
    {

        return events.get(i);
    }



}
