package com.adventureteamllc.adventuregram;

import android.graphics.RectF;
import sofia.graphics.ImageShape;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 *  This will be the first screen seen when opening the program.
 *  Will display title, authors, and will move to a different screen on click.
 *
 *  @author ADVENTURETEAMLLC
 *  @version Nov 6, 2012
 */
public class MainTitleScreen extends ShapeScreen {

    private ImageShape image;

    /**
     * Shows the opening image and credits as an image.
     */
    public void initialize()
    {
        image = new ImageShape("bad_drawing", new RectF(0, 0, getWidth(),
            getHeight()));
        add(image);
    }

    /**
     * Present the LibraryScreen to the user then end the MainTitleScreen.
     */
    public void button1Clicked()
    {
        presentScreen(LibraryScreen.class);
        finish();
    }

}
