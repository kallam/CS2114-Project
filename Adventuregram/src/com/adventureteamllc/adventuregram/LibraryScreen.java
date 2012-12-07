package com.adventureteamllc.adventuregram;

import java.util.ArrayList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import sofia.graphics.TextShape;
import sofia.app.Screen;
import sofia.graphics.Color;
import sofia.widget.ListView;
import sofia.view.*;

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
	private String[] titles;
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
		lib.importStory(story);
		story = new Story ("jurassic");
		lib.importStory(story);

		titles = new String[lib.size()];

		for(int i = 0; i < lib.size(); i++)
		{
			titles[i] = lib.getStory(i).getTitle();
		}	

		library = new ListView<String>(this);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
		library.setAdapter(adapter);

		library.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
			}
		});

		setContentView(library);
	}
	
	public void startStory(int position) {
		presentScreen(PlayScreen.class, lib.getStory(position));
		finish();
	}
}
