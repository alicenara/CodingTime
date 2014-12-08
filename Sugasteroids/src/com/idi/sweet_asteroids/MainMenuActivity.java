package com.idi.sweet_asteroids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainMenuActivity extends Activity {
	
	private Button bOptions;
	private Button bExit;
	private Button bPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        bOptions = (Button) findViewById(R.id.bOptions);
        bOptions.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View v) {
				launchOptions();
				
			}
        });
        
        bExit = (Button) findViewById(R.id.bExit);
        bExit.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View v) {
				finish();
				
			}
        });
        
        bPlay = (Button) findViewById(R.id.bPlay);
        bPlay.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View v) {
				launchGame();
				
			}
        });
    }
    
    public void launchOptions(){
    	Intent i = new Intent (this, OptionsActivity.class);
    	startActivity(i);
    }
    
    public void launchGame(){
    	Intent i = new Intent (this, GameActivity.class);
    	startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
