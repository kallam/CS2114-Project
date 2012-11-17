package com.adventureteamllc.adventuregram;

public interface Story
{

    public String getText();

    public String getCommands();

    public String getNextText(String command);

}
