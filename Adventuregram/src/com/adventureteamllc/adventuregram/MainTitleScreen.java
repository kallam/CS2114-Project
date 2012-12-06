package com.adventureteamllc.adventuregram;

import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 *  This will be the first screen seen when opening the program.
 *  Will display title, authors, and will move to a different screen on click.
 *
 *  @author ADVENTURETEAMLLC
 *  @version Nov 6, 2012
 */
public class MainTitleScreen extends Screen {

   /**
     * Present the LibraryScreen to the user then end the MainTitleScreen.
     */
    public void onTouchDown()
    {
        presentScreen(LibraryScreen.class);
        finish();
    }

}
