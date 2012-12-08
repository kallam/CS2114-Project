package com.adventureteamllc.adventuregram;

import android.view.View;
import android.graphics.Color;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
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
    private Story adventure;

    /**
     * Initialize screen elements
     * @param story
     */
    public void initialize(Story story)
    {
        if (story != null)
        {
            exitLibrary.setText("Library");
            adventure = story;
            choices = new Button[4];
            choices[0] = choice1;
            choices[1] = choice2;
            choices[2] = choice3;
            choices[3] = choice4;
            currentEvent = story.getEvent("start");
            storyTitle.setText(story.getTitle());
            eventDescription.setText(currentEvent.getDescription());

            //initialize buttons
            for (int i = 0; i < 4; i++)
            {
                if (currentEvent.getCommand(i) != null  && !currentEvent.getCommand(i).getName().equals(""))
                {
                    choices[i].setClickable(true);
                    choices[i].setText(currentEvent.getCommand(i).getName());
                    choices[i].setVisibility(View.VISIBLE);
                }
                else
                {
                    choices[i].setText("");
                    choices[i].setClickable(false);
                    choices[i].setVisibility(View.INVISIBLE);
                }
            }
        }

    }


    /**
     * Advance story with this choice
     * choice1 should always be an option
     */
    public void choice1Clicked()
    {
        changeEvent(0);

    }
    /**
     * Advance choice 2
     */
    public void choice2Clicked()
    {
        changeEvent(1);

    }
    /**
     * Advance choice 3
     */
    public void choice3Clicked()
    {
        changeEvent(2);

    }
    /**
     * Advance choice 4
     */
    public void choice4Clicked()
    {
        changeEvent(3);
    }
    /**
     * Change Event on screen
     */
    public void changeEvent(int numEvent)
    {
        String nextEvent = currentEvent.getCommand(numEvent).getTarget();
        //test if last event in story
        if (!nextEvent.equals("end"))
        {
            currentEvent = adventure.getEvent(nextEvent);
            eventDescription.setText(currentEvent.getDescription());

            choices = new Button[4];
            choices[0] = choice1;
            choices[1] = choice2;
            choices[2] = choice3;
            choices[3] = choice4;

            for (int i = 0; i < 4; i++)
            {
                if (currentEvent.getCommand(i) != null && !currentEvent.getCommand(i).getName().equals("") )
                {
                    choices[i].setClickable(true);
                    choices[i].setText(currentEvent.getCommand(i).getName());
                    choices[i].setVisibility(View.VISIBLE);


                }
                else
                {
                    choices[i].setText("");
                    choices[i].setClickable(false);
                    choices[i].setVisibility(View.INVISIBLE);
                }
            }
        }
        else
        {
            //end case display ending message
            currentEvent = adventure.getEvent("end");
            eventDescription.setText(currentEvent.getDescription());

            Toast.makeText(this, "Thanks for playing "+ adventure.getAuthor()
                +"'s game! Now go play another.", Toast.LENGTH_LONG).show();
            choices[0].setText("Thank you");
            choices[1].setText("for");
            choices[2].setText("playing");
            choices[3].setText("this adventure!");
            for (int i = 0; i < 4; i++)
            {
                choices[i].setClickable(false);
                choices[i].setVisibility(View.INVISIBLE);
            }
            //finish();
        }

    }
    /**
     * Open window to prompt exit, then exit if yes
     */
    public void exitLibraryClicked()
    {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    finish();
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
                }
            }
        };


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();




    }

}
