package com.adventureteamllc.adventuregram;


import android.widget.TextView;
import android.widget.Button;
import junit.framework.TestCase;


/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the play screen
 *
 *  @author Brian Wright
 *  @version Dec 8, 2012
 */
public class PlayScreenTest
    extends student.AndroidTestCase<PlayScreen>
{
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private Button exitLibrary;

    private TextView storyTitle;
    private TextView eventDescription;

    private PlayScreen play;

    //private Event currentEvent;
    //private Story adventure;
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public PlayScreenTest()
    {
        super(PlayScreen.class);
    }

    /**
     * Initialize test fixtures
     */
    public void setUp()
    {
        //play.initialize(story);
    }
    /**
     * Test that choice buttons travel to events
     */
    public void testChoices()
    {
        click(choice1);
        assertNotSame("start" ,getScreen().getCurrentEvent().getTitle());
    }

}
