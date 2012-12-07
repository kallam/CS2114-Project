package com.adventureteamllc.adventuregram;

import sofia.app.Screen;
import android.widget.TextView;
import android.widget.Button;

/**
 * // -------------------------------------------------------------------------
/**
 *  Play Screen to operate on stories
 *
 *  @author Brian Wright
 *  @version Dec 6, 2012
 */
public class PlayScreen extends Screen
{
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;

    //opens are you sure? progress won't be saved?
    private Button exitLibrary;

    private TextView storyTitle;
    private TextView eventDescription;

    public void initialize(Story story)
    {
        //set storyTitle text and eventDescrip from text file
        //initialize buttons and their text
        //if buttons have no reference then hide or disable them
    }

    //must advance to next event
    //check if event is the last
    /**
     * Advance story with this choice
     * choice1 should always be an option
     */
    public void choice1Clicked()
    {

    }
    public void choice2Clicked()
    {

    }
    public void choice3Clicked()
    {

    }
    public void choice4Clicked()
    {

    }
    /**
     * Open window to prompt exit, then exit if yes
     */
    public void exitLibraryClicked()
    {

    }

}
