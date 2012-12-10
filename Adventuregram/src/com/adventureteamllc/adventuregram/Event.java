package com.adventureteamllc.adventuregram;

/**
 *  Event holds the list of commands for it, the id (title) of the Event and
 *  the text that is presented with each event. It also keeps track of how many
 *  commands it has, with a max of 4 commands.
 *
 *  @author Brian Wright
 *  @author Alex Kallam
 *  @author Chris Hoffman
 *  @author Jake Sperlazza
 *  @version Dec 8, 2012
 */
public class Event
{
	private Command[] commands;

	private String title;
	private String description;
	private int connections;

	/**
	 * Initialize Event
	 * @param newTitle title of String
	 * @param newDescription description to show user
	 */
	public Event(String newTitle, String newDescription)
	{
		title = newTitle;
		description = newDescription;
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
	 * Gets a command from the commands array and returns null, if no Command
	 * exists in the array.
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
}
