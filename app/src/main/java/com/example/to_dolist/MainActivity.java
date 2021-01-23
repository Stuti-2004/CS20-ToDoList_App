package com.example.to_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements Dialog.DialogListener {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  ----- Test Code
        //Pop newDialog = new Pop();
        //newDialog.show(getSupportFragmentManager(), "Example");

        lvItems = (ListView) findViewById(R.id.listViewItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        setupListViewListener();
    }

        // Attaches a long click listener to the listview
        private void setupListViewListener () {
            lvItems.setOnItemLongClickListener(
                    new AdapterView.OnItemLongClickListener() {
                        @Override
                        public boolean onItemLongClick(AdapterView<?> adapter,
                                                       View item, int pos, long id) {
                            items.remove(pos); // Remove the item within array at position
                            itemsAdapter.notifyDataSetChanged();  // Refresh the adapter

                            Toast.makeText(getApplicationContext(), "Item removed", Toast.LENGTH_SHORT).show();
                            Log.d("Item deleted", "Item removed");
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }
                    });
        }

        public void onClick (View v){
            // Creates dialog when pressed
            Dialog newDialog = new Dialog();
            newDialog.show(getSupportFragmentManager(), "Example Dialog");
        }

        // Passing Information from dialog
        @Override
        public void applyTexts (String task){
            itemsAdapter.add(task);

        }

    }



