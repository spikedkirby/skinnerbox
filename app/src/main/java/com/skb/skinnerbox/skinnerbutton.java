package com.skb.skinnerbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class skinnerbutton extends AppCompatActivity {


    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_skinnerbutton);
        final String[] message = {"Keep going","Good", "Again","Once more", "You are doing it!","Great","Number keeps growing",
                "Awesome","Get more"};

        final MediaPlayer coinPlay = MediaPlayer.create(this, R.raw.coin1);
        final TextView txtEncourage = (TextView) findViewById(R.id.tv_encourage);
        final TextView txtValue = (TextView) findViewById(R.id.tv);

        final ImageButton Img =(ImageButton) findViewById(R.id.imageButton);

        Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNum = (int) (Math.random() * message.length);



                coinPlay.seekTo(0);

                coinPlay.start();
                addNumber();
                txtEncourage.setText(message[randomNum]);


                txtValue.setText(Integer.toString(number));




            }
        });
    }


    private void  addNumber(){

        number=number+1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_skinnerbutton, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
