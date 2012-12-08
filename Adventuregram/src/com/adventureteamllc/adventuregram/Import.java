package com.adventureteamllc.adventuregram;


import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
// -------------------------------------------------------------------------
/**
 *  Imports data from a text file and gets title, description, author and story.
 *
 *  @author Chris
 *  @version Nov 25, 2012
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
     * @param filename
     */
    public Import(String filename)
    {
        this(new File(filename));
    }

    // ----------------------------------------------------------
    /**
     * Create a new Import object.
     * @param file
     */
    public Import(File file)
    {
        storyOfEvents = null;
        title = "";
        description = "";
        author = "";
        story = "";
        try
        {
            Scanner in = new Scanner(file);
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            title = in.next();
            title = title.substring(1, title.length() - 2);

            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            author = in.next();
            author = author.substring(1, author.length() - 2);

            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            description = in.next();
            description = description.substring(1, description.length() - 4);


            while (in.hasNextLine())
            {
                story = story + in.nextLine();
            }

            in.close();
        }
        catch (FileNotFoundException e)
        {
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

            Scanner in = new Scanner(input);
            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            title = in.next();
            title = title.substring(1, title.length() - 2);

            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            author = in.next();
            author = author.substring(1, author.length() - 2);

            in.useDelimiter("\\]");
            in.next();
            in.useDelimiter("\\[");
            description = in.next();
            description = description.substring(1, description.length() - 4);


            while (in.hasNextLine())
            {
                story = story + in.nextLine();
            }

            in.close();


    }

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    // ----------------------------------------------------------
    /**
     * Returns a story object comprised of the parsed text file
     * @return Story object
     */
    public String getStoryChunks()
    {
        return story;
    }

    public Story getStory()
    {
        if (storyOfEvents == null)
        {
            this.constructStory();
        }
        return storyOfEvents;
    }

    private void constructStory()
    {
        storyOfEvents = new Story(this.getTitle());
        storyOfEvents.setAuthor(this.getAuthor());
        storyOfEvents.setDescription(this.getDescription());
        buildEvents(story);
    }

    private void buildEvents(String input)
    {
        if (input.length() > 0)
        {
            Scanner in = new Scanner(input);

            in.useDelimiter("\\]");
            String ref = in.next();
            ref = ref.substring(1, ref.length());

//            System.out.println(ref);

            if (!ref.equals("end"))
            {
                in.next();
                in.useDelimiter("\\*");
                String text = in.next();
                text = text.substring(1, text.length());

//                System.out.println(text);

                Event event = new Event(ref, text);

                //Command 1
                String comm = in.next().trim();
//                System.out.println(comm);

                in.useDelimiter("\\]");
                String commref = in.next();
                commref = commref.substring(2, commref.length()).trim();
//                System.out.println(commref);

                if(!comm.equals("") && !commref.equals(""))
                {
                    event.addCommand(new Command(comm, commref));
                }

                //Command 2
                for (int i = 0; i < 3; i++)
                {
                    in.useDelimiter("\\*");
                    in.next();
                    comm = in.next().trim();
//                    System.out.println(comm);

                    in.useDelimiter("\\]");
                    commref = in.next();
                    commref = commref.substring(2, commref.length()).trim();
//                    System.out.println(commref);
                    if(!comm.equals("") && !commref.equals(""))
                    {
                        event.addCommand(new Command(comm, commref));
                    }
                }
                storyOfEvents.addEvent(event.getTitle(), event);
                String rest = in.nextLine();
                in.close();
                buildEvents(rest);
            }
            else
            {
                String text = in.nextLine();
                text = text.substring(7, text.length() - 8);
//                System.out.println(text);
                Event event = new Event(ref, text);
                storyOfEvents.addEvent(event.getTitle(), event);
            }
        }
    }


}
//Old Import Constructor
//title = "";
//description = "";
//author = "";
//story = "";
//try
//{
//  Scanner in = new Scanner(new File(file));
//
//  Pattern pat = Pattern.compile("(\\[\\/title\\])");
//  in.useDelimiter(pat);
//  title = in.next();
//  title = title.substring(7, title.length());
//
//  in.useDelimiter("\\]");
//  in.next();
//
//  pat = Pattern.compile("(\\[\\/author\\])");
//  in.useDelimiter(pat);
//  author = in.next();
//  author = author.substring(11, author.length());
//
//  in.useDelimiter("\\]");
//  in.next();
//
//  pat = Pattern.compile("(\\[\\/description\\])");
//  in.useDelimiter(pat);
//  description = in.next();
//  description = description.substring(16, description.length());
//
//  in.useDelimiter("\\[");
//  in.next();
//  while (in.hasNextLine())
//  {
//      story = story + in.nextLine();
//  }
//
//  in.close();
//}
//catch (FileNotFoundException e)
//{
//  System.out.println("File not found");
//
//}
