package com.adventureteamllc.adventuregram;

import java.util.HashMap;
//import java.util.ArrayList;

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
    //private ArrayList<Event> events;
    private HashMap<String, Event> map;
    private String title;

    /**
     *Initializes story
     *@param title is Title of story
     */
    public Story(String title)
    {
        //events = new ArrayList<Event>();
        map = new HashMap<String, Event>();


    }

    /**
     * sets the title,   may be unnecessary
     * @param newTitle is the title of story
     */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    /**
     * Gets the String
     * @return String title to return
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * Add an event to the map
     * @param id String id of event
     * @param event to place in map
     */
    public void addEvent(String id, Event event)
    {
        //events.add(ev);
        map.put(id, event);

    }

//    public int getNumEvents()
  //  {
       // return events.size();
    //}

    /**
     * get an Event
     * @param id of event to get
     * @return Event to return from map
     */
    public Event getEvent(String id)
    {
       return map.get(id);
    }



}
