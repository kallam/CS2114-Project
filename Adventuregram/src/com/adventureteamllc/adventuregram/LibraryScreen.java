package com.adventureteamllc.adventuregram;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import sofia.app.Screen;
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
	
	private Library lib;
	private String[] titles;
	private ListView<String> library;

	// ----------------------------------------------------------
	/**
	 * Shows the library
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
				presentScreen(PlayScreen.class, lib.getStory(position));
				finish();
			}
		});

		setContentView(library);
	}
}
