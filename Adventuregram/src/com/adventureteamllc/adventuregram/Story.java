package com.adventureteamllc.adventuregram;

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
/**
 * Collection of Events stored in an arrayList to represent total story
 *
 *  @author Brian Wright
 *  @version Nov 25, 2012
 */
public class Story
{
    private ArrayList<Event> events;
    private String title;

    public Story()
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
