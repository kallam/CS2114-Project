package com.adventureteamllc.adventuregram;


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
     * @param file
     */
    public Import(String file)
    {
      storyOfEvents = null;
      title = "";
      description = "";
      author = "";
      story = "";
      try
      {
          Scanner in = new Scanner(new File(file));
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
        //TODO:
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
