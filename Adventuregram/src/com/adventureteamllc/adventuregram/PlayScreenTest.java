package com.adventureteamllc.adventuregram;


import android.view.View;
import android.widget.TextView;
import android.widget.Button;


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
        //EMPTY
    }

    /**
     * Test that fields are properly populated.
     */
    public void testStart()
    {
        assertEquals(exitLibrary.getText(), "Library");
        assertEquals(storyTitle.getText(), "Something");
        assertEquals(eventDescription.getText(), "Some text.");
        assertEquals(choice1.getText(), "NEXT");
        assertEquals(choice2.getText(), "END");
        assertEquals(choice3.getText(), "");
        assertEquals(choice4.getText(), "");
        assertEquals(choice3.getVisibility(), View.INVISIBLE);
        assertEquals(choice4.getVisibility(), View.INVISIBLE);
    }

    /**
     * Test clicking the different options
     */
    public void testChoices()
    {
        click(choice1);
        assertEquals(storyTitle.getText(), "Something");
        assertEquals(eventDescription.getText(), "Some other text.");
        assertEquals(choice1.getText(), "OVER");
        assertEquals(choice2.getText(), "END");
        assertEquals(choice3.getText(), "DONE");
        assertEquals(choice4.getText(), "COMPLETE");

        click(choice3);
        assertNotNull(getView(where.textIs("Thanks for playing Test's game! Now go play another.")));
        assertEquals(storyTitle.getText(), "Something");
        assertEquals(eventDescription.getText(), "fin");
        assertEquals(choice1.getVisibility(), View.INVISIBLE);
        assertEquals(choice2.getVisibility(), View.INVISIBLE);
        assertEquals(choice3.getVisibility(), View.INVISIBLE);
        assertEquals(choice4.getVisibility(), View.INVISIBLE);
    }

    /**
     * Test clicking the other buttons
     */
    public void testChoices2()
    {
        click(choice2);
        assertNotNull(getView(where.textIs("Thanks for playing Test's game! Now go play another.")));
        assertEquals(storyTitle.getText(), "Something");
        assertEquals(eventDescription.getText(), "fin");
        assertEquals(choice1.getVisibility(), View.INVISIBLE);
        assertEquals(choice2.getVisibility(), View.INVISIBLE);
        assertEquals(choice3.getVisibility(), View.INVISIBLE);
        assertEquals(choice4.getVisibility(), View.INVISIBLE);
    }

    /**
     * Test clicking the other buttons
     */
    public void testChoices3()
    {
        click(choice1);
        click(choice4);
        assertNotNull(getView(where.textIs("Thanks for playing Test's game! Now go play another.")));
        assertEquals(storyTitle.getText(), "Something");
        assertEquals(eventDescription.getText(), "fin");
        assertEquals(choice1.getVisibility(), View.INVISIBLE);
        assertEquals(choice2.getVisibility(), View.INVISIBLE);
        assertEquals(choice3.getVisibility(), View.INVISIBLE);
        assertEquals(choice4.getVisibility(), View.INVISIBLE);
    }

}
