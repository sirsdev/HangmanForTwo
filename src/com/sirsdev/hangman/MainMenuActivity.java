package com.sirsdev.hangman;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainMenuActivity extends Activity {
	Button startGameButton,optionsButton,helpButton;
	String word;
	Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        try{
        startGameButton = (Button) findViewById(R.id.startGameButton);
        optionsButton = (Button) findViewById(R.id.optionsButton);
        helpButton = (Button) findViewById(R.id.helpButton); 
        intent = new Intent(this,WordInput.class);
        
        startGameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			startActivity(intent);
			}
		});
        }catch(Exception e)
        {
        	Toast toast = Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG);
        	toast.show();
        }
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    
}
