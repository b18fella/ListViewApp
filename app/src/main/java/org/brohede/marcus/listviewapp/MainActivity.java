package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData=new ArrayList<>(Arrays.asList(mountainNames));





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // The onCreate method is run when the app is created.
        // Before you can implement this you need to create the layout xml files that
        // will hold/show your data created here. You need three create things:
        // * my_listview - the ID to the actual layout element that is our ListView.
        //                 This my_listview element is created in the activity_main.xml file
        // * list_item_textview - This is a new layout xml file that holds the layout for an
        //                        individual item in the ListView we are creating
        // * my_item_textview - This is the ID to the actual TextView that will contain the text for
        //                      an individual item in the ListView we are creating.
        // Here you should enter your code that fills the ListView
        // 1. Create an array
        // 2. Create a List object with your array from step 1 as in-data
        // 3. Create an ArrayAdapter object that connects
        //    * list_item_textview
        //    * my_item_textview
        //    * List object created in step 2
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.list_item_textview, R.id.list_item_textview, listData);
        // 4. Find the ListView layout element "my_listview" and create an object instance
        ListView my_listview=(ListView) findViewById(R.id.my_listview);
        // 5. Connect the ArrayAdapter from step 3 with ListView object created in step 4
        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Enter your text here", Toast.LENGTH_SHORT).show();
            }
        });
        // 6. Style the ListView items according to Material Design
        //    See: https://material.io/guidelines/components/lists.html#lists-specs
        //    Look for "singel line specs" for "text only" lists and modify the list_item_textview
        //    accordingly
    }
}
