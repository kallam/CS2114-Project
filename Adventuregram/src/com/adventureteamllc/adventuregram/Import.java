package com.adventureteamllc.adventuregram;


import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
// -------------------------------------------------------------------------
/**
 *  Imports data from a text file and gets title, description, author and story.
 *  Then can build a story from the associated text.
 *
 *  @author Chris Hoffman
 *  @author Alex Kallam
 *  @author Brian Wright
 *  @author Jake Sperlazza
 *  @version Dec 8, 2012
 */
public class Import
{
    private String title;
    private String description;
    private String author;
    private String story;

    private Story storyOfEvents;


    // ----------------------------------------------------------
    /**
     * Create a new Import object.
     * @param filename String location of the File.
     *
     * Used for testing purposes.
     */
    public Import(String filename)
    {
        this(new File(filename));
    }

    // ----------------------------------------------------------
    /**
     * Create a new Import object.
     * @param file The text file that is being imported.
     *
     * Also used for testing purposes
     */
    public Import(File file)
    {
        storyOfEvents = null;
        title = "";
        description = "";
        author = "";
        story = "";

        //Starts reading the file by creating a scanner
        try
        {
            //Read title
            Scanner in = new Scanner(file);
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            title = in.next();
            title = title.substring(1, title.length() - 2);

            //Read description
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            author = in.next();
            author = author.substring(1, author.length() - 2);

            //Read description
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            description = in.next();
            description = description.substring(1, description.length() - 4);

            //Gets the text for the remainder of the file that is the story
            // after first getting the Title, Author and Description
            while (in.hasNextLine())
            {
                story = story + in.nextLine();
            }

            in.close();
        }
        catch (FileNotFoundException e)
        {
            //if the file is not found then it outputs:
            System.out.println("File not found");
        }

    }
    /**
     * Create a new Import object.
     * @param input
     */
    public Import(InputStream input)
    {
        storyOfEvents = null;
        title = "";
        description = "";
        author = "";
        story = "";

        //Starts reading the file by creating a scanner

            //Read title
            Scanner in = new Scanner(input);
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            title = in.next();
            title = title.substring(1, title.length() - 2);

            //Read Author
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            author = in.next();
            author = author.substring(1, author.length() - 2);

            //Read description
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            description = in.next();
            description = description.substring(1, description.length() - 4);

            //Gets the text for the remainder of the file that is the story
            // after first getting the Title, Author and Description
            while (in.hasNextLine())
            {
                story = story + in.nextLine();
            }

            in.close();


    }

    // ----------------------------------------------------------
    /**
     * Returns the name of the person who wrote the story.
     * @return author The author's name
     */
    public String getAuthor()
    {
        return author;
    }

    // ----------------------------------------------------------
    /**
     * Returns the title of the story
     * @return title The story's title
     */
    public String getTitle()
    {
        return title;
    }

    // ----------------------------------------------------------
    /**
     * Returns the Description of the story.
     * @return description The story's short description
     */
    public String getDescription()
    {
        return description;
    }

    // ----------------------------------------------------------
    /**
     * Returns the String representation of the remaining text file that can be
     * parsed into a Story object
     * @return story The story in String form.
     */
    public String getStoryChunks()
    {
        return story;
    }

    // ----------------------------------------------------------
    /**
     * Returns the story object that has been created by parsing the text file
     * And if the story is null, it will parse the file and create the story
     * object from the file.
     * @return storyOfEvents The Story Object
     */
    public Story getStory()
    {
        if (storyOfEvents == null)
        {
            this.constructStory();
        }
        return storyOfEvents;
    }

    /**
     * Creates the Story object.
     */
    private void constructStory()
    {
        storyOfEvents = new Story(this.getTitle());
        storyOfEvents.setAuthor(this.getAuthor());
        storyOfEvents.setDescription(this.getDescription());
        buildEvents(story);
    }

    /**
     * Builds the event objects to create the story from the text file
     * The method is called recursively until the end Event is built
     */
    private void buildEvents(String input)
    {
        if (input.length() > 0)
        {
            //Creates a scanner from the text
            Scanner in = new Scanner(input);

            //Gets the first event reference
            in.useDelimiter("\\]");
            String ref = in.next();
            ref = ref.substring(1, ref.length());

            //checks if it is not the end
            if (!ref.equals("end"))
            {
                //Gets text
                in.next();
                in.useDelimiter("\\*");
                String text = in.next();
                text = text.substring(1, text.length());

                //Builds event
                Event event = new Event(ref, text);

                //Command 1
                String comm = in.next().trim();
                in.useDelimiter("\\]");

                //Command event reference 1
                String commref = in.next();
                commref = commref.substring(2, commref.length()).trim();

                //If the command is not blank make it and add it to the Event.
                if(!comm.equals("") && !commref.equals(""))
                {
                    event.addCommand(new Command(comm, commref));
                }

                //Commands 2,3,4 if they exist
                for (int i = 0; i < 3; i++)
                {
                    //Gets Command
                    in.useDelimiter("\\*");
                    in.next();
                    comm = in.next().trim();

                    //Gets Command event reference
                    in.useDelimiter("\\]");
                    commref = in.next();
                    commref = commref.substring(2, commref.length()).trim();


                    //Builds Command if it is not black and adds it to Event.
                    if(!comm.equals("") && !commref.equals(""))
                    {
                        event.addCommand(new Command(comm, commref));
                    }
                }
                //Adds the Event to the story
                storyOfEvents.addEvent(event.getTitle(), event);
                //Gets remaining text
                String rest = in.nextLine();
                in.close();
                //Builds more events based on the remaining text.
                buildEvents(rest);
            }
            else
            {
                //The Event is the end, so the the ending text
                String text = in.nextLine();
                text = text.substring(7, text.length() - 8);

                //Create and add the end Event
                Event event = new Event(ref, text);
                storyOfEvents.addEvent(event.getTitle(), event);
            }
        }
    }


}
