package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1 Hello World, just text
        // setContentView(R.layout.activity_main);

        // 2 Widgets
        setContentView(R.layout.activity_widgets);


        //EditText
        final EditText text = (EditText) findViewById(R.id.editText);
        //Implement the onClickListener callback
        text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //We only want to handle ACTION_UP events, when user releases a key
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    return false;

                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    Toast.makeText(getBaseContext(), text.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                } else
                    return false;
            }
        });



        //Checkbox
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked())
                    Toast.makeText(getBaseContext(), "is checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "is not checked", Toast.LENGTH_SHORT).show();
            }
        });




        //ToggleButton
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getBaseContext(), "toggle is enabled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "toggle is disabled", Toast.LENGTH_SHORT).show();
                }

            }
        });


        //Rating Bar
        final RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getBaseContext(), "New Rating: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void  onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    Toast.makeText(getBaseContext(), "radio1 is checked", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioButton2:
                if (checked)
                    Toast.makeText(getBaseContext(), "radio2 is checked", Toast.LENGTH_SHORT).show();
                    break;
        }

    }

    public void onButtonClick(View v)
    {
        Toast.makeText(getBaseContext(),  ((EditText)findViewById(R.id.editText)).getText(), Toast.LENGTH_SHORT).show();
    }

}
