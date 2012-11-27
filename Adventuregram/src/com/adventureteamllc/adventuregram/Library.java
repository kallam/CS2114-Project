package com.adventureteamllc.adventuregram;

import java.util.HashMap;

public class Library
{
    private HashMap<String, Import> lib;
    public Library()
    {
        lib = new HashMap<String, Import>();
    }

    public void importStory(String file)
    {
        Import temp = new Import(file);
        lib.put(temp.getTitle(), temp);
    }

    public HashMap<String, Import> getLibrary()
    {
        return lib;
    }

    public void removeStory(String title)
    {
        lib.remove(title);
    }


}
