package com.adventureteamllc.adventuregram;

import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.app.ListActivity;

//import sofia.widget.ListView;
//import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 *  This screen will display the titles of each story that have been imported.
 *  Clicking on any of the titles should then begin playing that story.
 *
 *  @author Uncle Jemima
 *  @version Dec 3, 2012
 */
public class LibraryScreen extends ListActivity {
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

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        lib.importStoriesFromAssets(null);
        titles = new ArrayList<String>();
        // Create array list of all titles from stories imported from assets
        for(Story n : lib.getLibrary())
        {
            titles.add(n.getTitle());
        }
        // Tells the listView to use titles as its reference String ArrayList
        setListAdapter(new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, titles));
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        // Index position of the title in titles will correspond with the
        // index position of the correct story in lib.getLibrary().
        //
        // Play the story: lib.getLibrary().get(position);
        // Move to play screen
    }
}
