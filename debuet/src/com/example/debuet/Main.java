package com.example.debuet;

import java.math.BigDecimal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener{

	LinearLayout foodmenu;
	LinearLayout weigh;
	LinearLayout sleep;
	LinearLayout muscle;
	ImageView gurafu;
	ImageView calendar;
	ImageView cog;
	TextView date;
	private UserDBController dbc;
	TextView h1;
	TextView h2;
	TextView h3;
	TextView h4;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		h1 = (TextView)findViewById(R.id.h1);
		h2 = (TextView)findViewById(R.id.h2);
		h3 = (TextView)findViewById(R.id.h3);
		h4 = (TextView)findViewById(R.id.h4);

		dbc = new UserDBController(this);

		try{
			Cursor cursor = dbc.db.query("user_table", new String[] {"date", "sex", "age" ,"height", "weight" }, null, null, null, null, "_id DESC");
			cursor.moveToFirst();
			//		(cursor.getString(0));
			//		(cursor.getString(1));
			//		(cursor.getInt(2));
			//		(cursor.getDouble(3));
			h3.setText("現在の体重\n"+cursor.getDouble(4));
			double bmi = cursor.getDouble(4)/((cursor.getDouble(3)/100)*(cursor.getDouble(3)/100));
			BigDecimal bd = new BigDecimal(bmi);
			BigDecimal k = bd.setScale(1,BigDecimal.ROUND_HALF_UP);
			h4.setText("BMI\n"+String.valueOf(k.doubleValue()));
			cursor.close();
		}catch(Exception e){
			Intent intent3 = new Intent(Main.this,Index.class);
			startActivity(intent3);

		}
		//buttonを取得
		foodmenu = (LinearLayout)findViewById(R.id.foodmenu);  
		foodmenu.setOnClickListener(this);
		weigh = (LinearLayout)findViewById(R.id.weigh);
		weigh.setOnClickListener(this);
		sleep = (LinearLayout)findViewById(R.id.sleep);
		sleep.setOnClickListener(this);
		muscle = (LinearLayout)findViewById(R.id.muscle);
		muscle.setOnClickListener(this);
		gurafu = (ImageView)findViewById(R.id.gurafu);
		gurafu.setOnClickListener(this);
		calendar = (ImageView)findViewById(R.id.calendar);
		calendar.setOnClickListener(this);
		cog = (ImageView)findViewById(R.id.cog);
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
			Intent intent6 = new Intent(Main.this,MainActivity.class);
			startActivity(intent6);
			break;

		case R.id.cog:
			Intent intent7 = new Intent(Main.this,Index.class);
			startActivity(intent7);
			break;

		}
	}

}
