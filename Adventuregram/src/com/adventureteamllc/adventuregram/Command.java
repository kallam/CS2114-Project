package com.adventureteamllc.adventuregram;

// -------------------------------------------------------------------------
/**
 *  Command object that points to the next event
 *
 *  @author Brian
 *  @version Dec 3, 2012
 */
public class Command
{
    private String name;
    private String target;

    // ----------------------------------------------------------
    /**
     * Create a new Command object.
     * @param name name of the command
     * @param target Next event to trigger
     */
    public Command(String name, String target){
        this.name = name;
        this.target = target;
    }

    // ----------------------------------------------------------
    /**
     * Returns the name of the command
     * @return Name of command
     */
    public String getName() {
        return name;
    }

    // ----------------------------------------------------------
    /**
     * Returns the target of the command
     * @return Target of command
     */
    public String getTarget() {
        return target;
    }

}
