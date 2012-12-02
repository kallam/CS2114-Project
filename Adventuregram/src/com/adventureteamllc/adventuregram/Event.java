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
 *Testing if I can pushasf testagain
 *  @author Brian Wright
 *  @version Nov 19, 2012
 */
public class Event
{
    /**
     * // -------------------------------------------------------------------------
    /**
     * Connection to link events together with a string along with it to
     * describe their choice
     *
     *  @author Brian
     *  @version Nov 30, 2012
     */
    public static class Connection
    {
        public String descrip;
        public int index;
        /**
         * Initialize a connection
         * @param s is new description
         * @param i is index of the Event in the story arraylist
         */
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


    /**
     * Initialize Event
     * @param newTitle title of String
     * @param newDescription description to show user
     */
    public Event(String newTitle, String newDescription)
    {
        title = newTitle;
        description = newDescription;
       // start = false;
        end = false;
        eventsAhead = new ArrayList<Connection>();

    }
    /**
     * Returns description
     * @return String description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Num of connections so user has to enter a correct number
     * @int num of connections to choose
     */
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
