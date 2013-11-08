package com.example.debuet;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private Button readButton;
	private TextView resultTextView;
	private UserDBController dbc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		readButton = (Button)findViewById(R.id.readButton);
		readButton.setOnClickListener(this);
		resultTextView = (TextView)findViewById(R.id.resultTextView);

		dbc = new UserDBController(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
		case R.id.readButton:

			Cursor cursor = dbc.db.query("user_table", new String[] { "name", "age" ,"height", "weight" }, null, null, null, null, null);
			cursor.moveToFirst();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cursor.getCount(); i++) {
				sb.append(cursor.getString(0)).append(",");
				sb.append(cursor.getString(1)).append(",");
				sb.append(cursor.getString(2)).append(",");
				sb.append(cursor.getInt(3)).append("\n");
				cursor.moveToNext();
			}
			cursor.close();
			resultTextView.setText(sb.toString());

			break;
		}
	}

}
