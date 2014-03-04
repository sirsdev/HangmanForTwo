package com.sirsdev.hangman;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WordInput extends Activity {
	Button startGame;
	EditText textField;
	String word;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_input);
		 startGame = (Button) findViewById(R.id.inputWordButton);
		 textField = (EditText) findViewById(R.id.checkCharacterTextBox);
		 
		 startGame.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				word=textField.getText().toString();
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word_input, menu);
		return true;
	}

}
