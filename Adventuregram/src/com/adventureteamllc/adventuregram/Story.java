package com.adventureteamllc.adventuregram;

import java.util.HashMap;

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
    private HashMap<String, Event> map;
    private String title;
    private String author;
    private String description;

    /**
     *Initializes story
     *@param title is Title of story
     */
    public Story(String title)
    {
        map = new HashMap<String, Event>();
        this.title = title;
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

    // ----------------------------------------------------------
    /**
     * Sets the author of the story
     * @param author Name of the story's author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    // ----------------------------------------------------------
    /**
     * Sets the description of the story
     * @param description of the story
     */
    public void setDescription(String description) {
        this.description = description;
    }

    // ----------------------------------------------------------
    /**
     * Gets the author's name
     * @return Author's name
     */
    public String getAuthor() {
        return author;
    }

    // ----------------------------------------------------------
    /**
     * Gets the description of the story
     * @return Description of the story
     */
    public String getDescription() {
        return description;
    }

//    public int getNumEvents()
//      {
//     return map.size();
//    }

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
