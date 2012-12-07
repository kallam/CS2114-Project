package com.adventureteamllc.adventuregram;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.app.ListActivity;

//import sofia.widget.ListView;
//import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 *  This screen will display the titles of each story that have been imported.
 *  Clicking on any of the titles should then begin playing that story.
 *
 *  @author Uncle Jemima and Alex
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


//    Stopped using sofia and got a little further.
    private Library lib;
    private ArrayList<String> titles;

    // ----------------------------------------------------------
    /**
     * Initializes the Library view
     */
    public void initialize()
    {
        ListView listView = (ListView) findViewById(R.id.library);
        lib.importStoriesFromAssets(getApplicationContext());
        titles = new ArrayList<String>();

        // Create array list of all titles from stories imported from assets
        for(Story n : lib.getLibrary())
        {
            titles.add(n.getTitle());
        }

        // Tells the listView to use titles as its reference String ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, titles);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Start story
                System.out.println("yay");
            }
        });

    }
}
