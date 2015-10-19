package com.example.zhu91.learningjapanese;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CheckResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Show the first word
        CardStack stack = CardStack.getInstance(true);
        TextView textView = (TextView)findViewById(R.id.show_message);
        textView.setText(stack.getRandomCard().getWord());
    }

    public void inputText(View view) {
        CardStack stack = CardStack.getInstance(false);
        // Input the pounce of the word
        EditText editText = (EditText)findViewById(R.id.input_content);
        String input = editText.getText().toString();
        editText.setText("");
        // Check if the pounce is right and show result
        TextView showResult = (TextView)findViewById(R.id.show_result);
        showResult.setText(stack.compareResult(input));
        // Show next word card
        TextView textView = (TextView)findViewById(R.id.show_message);
        Card newCard = stack.getRandomCard();
        if (newCard == null) {
            textView.setText("Done");
        } else {
            textView.setText(newCard.getWord());
        }
    }
}
