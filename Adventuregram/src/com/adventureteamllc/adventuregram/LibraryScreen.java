package com.adventureteamllc.adventuregram;

import java.util.ArrayList;

import android.widget.TextView;
import android.widget.Toast;

import sofia.graphics.TextShape;

import sofia.app.Screen;
import sofia.graphics.Color;
import sofia.widget.ListView;

// -------------------------------------------------------------------------
/**
 *  This screen will display the titles of each story that have been imported.
 *  Clicking on any of the titles should then begin playing that story.
 *
 *  @author Uncle Jemima and Alex
 *  @version Dec 3, 2012
 */
public class LibraryScreen extends Screen {
	//    Somehow display the listView<String>
	//    Having trouble understanding / using sofia.widget.ListView
	//    and using that to display the list view (as seen in this class's xml)
	//
	//    This will add each title of each imported story to the view
	//    for( Story str : Library.getLibrary() )
	//    {
	//        listView.add(str.getTitle());
	//    }
	//
	//    Then need a way to see which item is clicked so that story can be loaded.
	//
	//


	//    Stopped using sofia and got a little further.
	private Library lib;
	private ArrayList<String> titles;
	private ListView<String> library;

	// ----------------------------------------------------------
	/**
	 * Called to initialize the shapes on the screen. This version of the
	 * initialize method takes a String, so it
	 */
	public void initialize()
	{
		lib = new Library();
		Story story = new Story("hey");
		lib.importStory(story);
		story = new Story ("ya");

		   
		library = new ListView<String>(this);
		library.setOnItemClickListener(null);
		
		ArrayList<Story> stories = lib.getLibrary();
		for(int i = 0; i < lib.size(); i++)
		{
			library.add(stories.get(i).getTitle());
		}		
		
		
		setContentView(library);
	}
	
	public void OnItemClick() {
		Toast.makeText(this, "hey", 100);
	}
}
