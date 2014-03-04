package com.sirsdev.hangman;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity {
	Button startGameButton,optionsButton,helpButton;
	String word;
    Intent intent = new Intent(this,WordInput.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        startGameButton = (Button) findViewById(R.id.startGameButton);
        optionsButton = (Button) findViewById(R.id.optionsButton);
        helpButton = (Button) findViewById(R.id.helpButton);

        
        startGameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			startActivity(intent);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    
}
