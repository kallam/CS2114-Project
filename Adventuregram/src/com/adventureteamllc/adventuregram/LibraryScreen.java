package com.adventureteamllc.adventuregram;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import sofia.app.Screen;
import sofia.widget.ListView;

// -------------------------------------------------------------------------
/**
 *  This screen will display the titles of each story that have been imported.
 *  Clicking on any of the titles should then begin playing that story.
 *
 *  @author Brian Wright
 *  @author Alex Kallam
 *  @author Chris Hoffman
 *  @author Jake Sperlazza
 *  @version Dec 3, 2012
 */
public class LibraryScreen extends Screen {

    private Library libraryList;
    private ListView<String> libraryView;

    // ----------------------------------------------------------
    /**
     * Shows the library
     */
    public void initialize()
    {
        libraryList = new Library();

        ArrayList<Map<String, String>> storyList = new ArrayList<Map<String, String>>();

        AssetManager assets = this.getAssets();
        try
        {
            String[] storyFiles = assets.list("");
            for (int i = 0; i < storyFiles.length; i++)
            {
                InputStream inputStream = assets.open(storyFiles[i]);
                libraryList.importStory(new Import(inputStream));
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        for(int i = 0; i < libraryList.size(); i++)
        {
            Map<String, String> storyInfo = new HashMap<String, String>();
            storyInfo.put("Title", ("'" + libraryList.getStory(i).getTitle()) + "' by " +
                libraryList.getStory(i).getAuthor());
            storyInfo.put("Description", libraryList.getStory(i).getDescription());
            storyList.add(storyInfo);
        }

        libraryView = new ListView<String>(this);

        //Fill in the library listview
        SimpleAdapter adapter = new SimpleAdapter(this, storyList,
            android.R.layout.simple_list_item_2,
            new String[] {"Title", "Description"},
            new int[] {android.R.id.text1,
            android.R.id.text2});

        libraryView.setAdapter(adapter);

        libraryView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
                presentScreen(PlayScreen.class, libraryList.getStory(position));
            }
        });

        setContentView(libraryView);
    }

    // ----------------------------------------------------------
    /**
     * Gets the Library that holds the list of stories
     * @return libraryList of stories
     */
    public Library getLibraryList() {
        return libraryList;
    }

}
