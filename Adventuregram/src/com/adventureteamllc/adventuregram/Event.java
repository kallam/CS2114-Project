package com.adventureteamllc.adventuregram;



import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
/**
 * Event out of the total story
 *
 *  <Event>
 *      <title>title</title>
 *      <description>description</description>
 *
 *      <Event0>pointToEvent</Event0>
 *      <Event1>nextEventToPointTo</Event1>
 *      <Event2 and so on>
 *
 *
 *      <Start>only use if start</Start>
 *      <End>only use if end </End>
 * </Event>
 *
 *previous is stored temporarily when moving
 *
 *  construction of event in parser needs methods
 *  Event event = new Event(title, description)
 *
 *  if (parser finds start)
 *  {
 *      event.setStart();
 *  }
 *
 *  event.add(event0);
 *
 *Testing if I can pushasf
 *  @author Brian Wright
 *  @version Nov 19, 2012
 */
public class Event
{
    public static class Connection
    {
        public String descrip;
        public int index;
        public Connection(String s, int i)
        {
            descrip = s;
            index = i;
        }

    }
    //needs to point to other events, use events arraylist to store them

    private ArrayList<Connection> eventsAhead;
   // private Event previous;

    private String title;
    private String description;

   // private String imageLink;

    //true if beginning event or end event
  //  private Boolean start;
    private Boolean end;



    public Event(String newTitle, String newDescription)
    {
        title = newTitle;
        description = newDescription;
       // start = false;
        end = false;
        eventsAhead = new ArrayList<Connection>();

    }
    public String getDescription()
    {
        return description;
    }
    public int getNumConnections()
    {
        return eventsAhead.size();
    }

    public Connection getConnection(int choice)
    {
        if (choice >= 0 && choice < getNumConnections())
        {
            return eventsAhead.get(choice);
        }
        else
        {
            System.out.println("errorerrorintthesas");
            return null;
        }
    }



    public void addConnection(Connection con)
    {
        eventsAhead.add(con);
    }

    public void setEnd()
    {
        end = true;
    }

    public Boolean isEnd()
    {
        if (end == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}
