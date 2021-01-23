package com.example.to_dolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class Pop extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Creating a new alert Dialog named "builder"
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Setting a tag and message to "builder"
        builder.setTitle("Task").setMessage("Do you want to add a task?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // What happens when the "yes" button is clicked
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // What happens when the "No" button is clicked
                    }
                });

        return builder.create();
        // Return the created Dialog
    }

}

