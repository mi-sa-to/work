package com.example.debuet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//buttonを取得
        LinearLayout foodmenu = (LinearLayout)findViewById(R.id.foodmenu);
        foodmenu.setOnClickListener(this);
        
        LinearLayout weigh = (LinearLayout)findViewById(R.id.weigh);
        weigh.setOnClickListener(this);
        
        LinearLayout sleep = (LinearLayout)findViewById(R.id.sleep);
        sleep.setOnClickListener(this);
        
        LinearLayout muscle = (LinearLayout)findViewById(R.id.muscle);
        muscle.setOnClickListener(this);
        
        ImageView gurafu = (ImageView)findViewById(R.id.gurafu);
        gurafu.setOnClickListener(this);
		
        ImageView calendar = (ImageView)findViewById(R.id.calendar);
        calendar.setOnClickListener(this);
        
        ImageView cog = (ImageView)findViewById(R.id.cog);
        cog.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自動生成されたメソッド・スタブ
		switch(arg0.getId()){
		case R.id.foodmenu:
			Intent intent = new Intent(Main.this,Foodmenu.class);
			startActivity(intent);
			break;
			
		case R.id.weigh:
			Intent intent2 = new Intent(Main.this,Weigh.class);
			startActivity(intent2);
			break;
			
		case R.id.sleep:
			Intent intent3 = new Intent(Main.this,Index.class);
			startActivity(intent3);
			break;
			
		case R.id.muscle:
			Intent intent4 = new Intent(Main.this,Weigh.class);
			startActivity(intent4);
			break;
			
		case R.id.gurafu:
			Intent intent5 = new Intent(Main.this,Weigh.class);
			startActivity(intent5);
			break;
			
		case R.id.calendar:
			Intent intent6 = new Intent(Main.this,Weigh.class);
			startActivity(intent6);
			break;
			
		case R.id.cog:
			Intent intent7 = new Intent(Main.this,Index.class);
			startActivity(intent7);
			break;
		}
	}

}
