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
        
        ArrayList<Map<String, String>> storyList = new ArrayList<Map<String, String>>();

        AssetManager assets = this.getAssets();
        try
        {
            String[] storyFiles = assets.list("");
            for (int i = 0; i < storyFiles.length; i++)
            {
                InputStream inputStream = assets.open(storyFiles[i]);
                lib.importStory(new Import(inputStream));
            }

        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        titles = new String[lib.size()];

        for(int i = 0; i < lib.size(); i++)
        {
            Map<String, String> storyInfo = new HashMap<String, String>();
            storyInfo.put("Title", lib.getStory(i).getTitle());
            storyInfo.put("Description", lib.getStory(i).getDescription());
            storyList.add(storyInfo);
        }

        library = new ListView<String>(this);
        
        SimpleAdapter adapter = new SimpleAdapter(this, storyList,
                android.R.layout.simple_list_item_2,
                new String[] {"Title", "Description"},
                new int[] {android.R.id.text1,
                           android.R.id.text2});

//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
//            android.R.layout.simple_list_item_1, titles);
        library.setAdapter(adapter);

        library.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
                presentScreen(PlayScreen.class, lib.getStory(position));
            }
        });

        setContentView(library);
    }
}
