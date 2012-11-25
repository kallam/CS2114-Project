package com.adventureteamllc.adventuregram;

import java.util.regex.Pattern;
import java.util.*;
// -------------------------------------------------------------------------
/**
 *  Imports data from a text file and gets title, description, author and story.
 *
 *  @author Chris
 *  @version Nov 25, 2012
 */
public class Import implements Importer
{
    private String title;
    private String description;
    private String author;
    private String story;

    // ----------------------------------------------------------
    /**
     * Create a new Import object.
     * @param file
     */
    public Import(String file)
    {
        Scanner in = new Scanner(file);
        Pattern pat = Pattern.compile("[title]*[/title]");
        title = in.next(pat);
        title = title.substring(7, title.length() - 8);

        pat = Pattern.compile("[author]*[/author]");
        author = in.next(pat);
        author = author.substring(8, author.length() - 9);

        pat = Pattern.compile("[description]*[/description]");
        description = in.next(pat);
        description = description.substring(12, description.length() - 13);

        story = in.next();
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

    public String getStoryChunks()
    {
        return story;
    }

}
