package com.sirsdev.hangman;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class hangmanClass extends Activity {
	int i;
	Bundle bund;
	TextView testTextView;
	String word;
	String hiddenWord="";
	EditText checkCharacterTextBox;
	Button tryButton;
	StringBuilder stringBuilder = new StringBuilder(hiddenWord);
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
		    //changes letters from the word with "-"
		    testTextView.setText("");
		    for(i=0;i<word.length();i++)
		    {
		    hiddenWord+="-";
			}
		    testTextView.setText(hiddenWord);
		    stringBuilder = new StringBuilder(hiddenWord);
		}catch(Exception e){
			testTextView.setText(e.toString());
		}
		
		
		checkCharacterTextBox.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				try{
				String temp = checkCharacterTextBox.getText().toString();
				temp.toLowerCase(Locale.US);
				if(temp.length()>1){
				checkCharacterTextBox.setText(temp.substring(1, temp.length()));
				checkCharacterTextBox.setSelection(1);
				}
				}catch(Exception e){
					Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
					toast.show();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String cmp = checkCharacterTextBox.getText().toString();
			try{
				boolean contains = false;
				for(i=0;i<word.length();i++){
				String characterBeingCompared = String.valueOf(word.charAt(i));
				if(cmp.equalsIgnoreCase(characterBeingCompared)){
					contains=true;
						break;
					}
				}
				
				if(contains)
				{Toast toast = Toast.makeText(getApplicationContext(),
						"Yes the word contains " + checkCharacterTextBox.getText().toString()
						,Toast.LENGTH_SHORT);
				toast.show();
				
				stringBuilder.setCharAt(i, word.charAt(i));
				testTextView.setText(stringBuilder);
				}
				else
				{
					Toast toast = Toast.makeText(getApplicationContext(), 
							"No the word does not have " + checkCharacterTextBox.getText().toString()
							, Toast.LENGTH_SHORT);
					toast.show();
				}
			}catch(Exception e)
			{Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
			toast.show();}
			}
		});
	}
}
