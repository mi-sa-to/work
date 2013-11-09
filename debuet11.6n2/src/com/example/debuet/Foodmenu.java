package com.example.debuet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class Foodmenu extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodmenu);
		//buttonを取得
		LinearLayout pencil = (LinearLayout)findViewById(R.id.pencil);
		pencil.setOnClickListener(this);

		LinearLayout zoom = (LinearLayout)findViewById(R.id.zoom);
		zoom.setOnClickListener(this);

		LinearLayout star = (LinearLayout)findViewById(R.id.star);
		star.setOnClickListener(this);

		LinearLayout delete = (LinearLayout)findViewById(R.id.delete);
		delete.setOnClickListener(this);
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
		switch (arg0.getId()) {
		case R.id.pencil:
			Intent intent = new Intent(Foodmenu.this,Food1.class);
			startActivity(intent);
			break;

		case R.id.zoom:
			Intent intent2 = new Intent(Foodmenu.this,Food2.class);
			startActivity(intent2);
			break;
			
		case R.id.star:
			Intent intent3 = new Intent(Foodmenu.this,Food3.class);
			startActivity(intent3);
			break;
			
		case R.id.delete:
			finish();
			break;

		}

	}

}
