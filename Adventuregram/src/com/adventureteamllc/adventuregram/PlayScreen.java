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
public class PlayScreen extends Screen {

    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;

    private Button[] choices;

    //opens are you sure? progress won't be saved?
    private Button exitLibrary;

    private TextView storyTitle;
    private TextView eventDescription;

    private Event currentEvent;

    public void initialize(Story story)
    {
        if (story != null)
        {
            choices = new Button[4];
            choices[0] = choice1;
            choices[1] = choice2;
            choices[2] = choice3;
            choices[3] = choice4;
            currentEvent = story.getEvent("start");
            storyTitle.setText(story.getTitle());
            eventDescription.setText(currentEvent.getDescription());
            for (int i = 0; i < 4; i++)
            {
                if (!currentEvent.getCommand(i).getName().equals(""))
                {
                    choices[i].setText(currentEvent.getCommand(i).getName());
                }
                else
                {
                    choices[i].setClickable(false);
                }
            }
        }

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
