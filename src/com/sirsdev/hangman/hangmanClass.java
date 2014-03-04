package com.sirsdev.hangman;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class hangmanClass extends Activity {
	
	Bundle bund;
	TextView testTextView;
	String word;
	EditText checkCharacterTextBox;
	Button tryButton;
	 @Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hangman_game);
		try{
			bund = this.getIntent().getExtras();
		    testTextView = (TextView) findViewById(R.id.testTextView);
			checkCharacterTextBox = (EditText) findViewById(R.id.checkCharacterTextBox);
		    tryButton = (Button) findViewById(R.id.checkCharacterButton);
		    word = bund.getString("word");
			testTextView.setText(word);
		}catch(Exception e){
			testTextView.setText(e.toString());
		}
		
		tryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			
			}
		});
	}
}
