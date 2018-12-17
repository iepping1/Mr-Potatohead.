package epping.ian.mrpotatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // creates an array for all the image IDs
    public int imageIdentity[] = new int[]{R.id.Body, R.id.Arms, R.id.Shoes, R.id.Eyes, R.id.Ears,
            R.id.Nose, R.id.Mouth, R.id.Eyebrows, R.id.Mustache, R.id.Glasses, R.id.Hat};

    // creates an array for the image names
    public String [] names = {"Body", "Arms", "Shoes", "Eyes", "Ears", "Nose",
            "Mouth", "Eyebrows", "Mustache", "Glasses", "Hat"};

    // variable for the total number of images
    public int length = names.length;

    // starts the main window
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // restores the main window after reload
        if(savedInstanceState != null) {
            for (int i = 0; i < length; i++) {
                ImageView bodyPart = findViewById(imageIdentity[i]);
                if(bodyPart != null) {
                    bodyPart.setVisibility(savedInstanceState.getInt(names[i]));
                }
            }
        }
    }

    // saves the state of images/checkboxex when window reloads
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i < length; i++){
            ImageView bodyPart = findViewById(imageIdentity[i]);
            outState.putInt(names[i], bodyPart.getVisibility());
        }
    }

    // sets the proper visibility of all images
    public void checkBox(View v){

        // distinguishes between checkboxes
        CheckBox check = (CheckBox) v;
        String checkPart = check.getText().toString();

        for (int i = 0; i < length; i++) {

            ImageView bodyPart = findViewById(imageIdentity[i]);

            if (checkPart.equals(names[i])) {
                if (bodyPart.isShown())
                    bodyPart.setVisibility(View.INVISIBLE);
                else
                    bodyPart.setVisibility(View.VISIBLE);
            }
        }
    }
}
