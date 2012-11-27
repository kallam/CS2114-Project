package com.adventureteamllc.adventuregram;

import java.util.HashMap;

public interface Library
{

    public Importer importStory(String file);

    public HashMap<String, Importer> getlibrary();

    public void removeStory();

    public void playStory();


}
