package com.sirsdev.hangman;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WordInput extends Activity {
	Button startGame;
	EditText textField;
	String word;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_input);
		 try {
			startGame = (Button) findViewById(R.id.inputWordButton);
			 textField = (EditText) findViewById(R.id.checkCharacterTextBox);
			 intent =  new Intent(this,hangmanClass.class);
			 startGame.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					word=textField.getText().toString();
					word.toLowerCase();
					intent.putExtra("word",word);
					startActivity(intent);
				}
			});
		} catch (Exception e) {
			Toast toast = Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG);
			toast.show();
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word_input, menu);
		return true;
	}

}
