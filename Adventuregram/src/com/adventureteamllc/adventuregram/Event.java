package com.adventureteamllc.adventuregram;

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
    private Command[] commands;
    // private Event previous;

    private String title;
    private String description;
    private int connections;

    // private String imageLink;

    //true if beginning event or end event
    //  private Boolean start;
   // private Boolean end;


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
      //  end = false;
        commands = new Command[4];
        connections = 0;

    }
    /**
     * Return title/id of event
     * @return title of event
     */
    public String getTitle()
    {
        return title;
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
     * Number of connections so user has to enter a correct number
     * @return Number of connections to choose
     */
    public int getNumConnections()
    {
        return connections;
    }

    // ----------------------------------------------------------
    /**
     * Gets a command from the commands array
     * @param choice Position in the commands array
     * @return Command from the commands array
     */
    public Command getCommand(int choice)
    {
        if (choice >= 0 && choice < getNumConnections())
        {
            return commands[choice];
        }
        else
        {
            System.out.println("errorerrorintthesas");
            return null;
        }
    }



    // ----------------------------------------------------------
    /**
     * Adds command to the commands array
     * @param com
     */
    public void addCommand(Command com)
    {
        if (connections < 4) {
            commands[connections] = com;
            connections++;
        }
    }

    /**
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
    **/



}
