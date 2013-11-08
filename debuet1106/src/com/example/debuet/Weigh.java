package com.example.debuet;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Weigh extends Activity implements OnClickListener{
	Button ok1;
	EditText w1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weigh);

		ok1 = (Button)findViewById(R.id.ok1);
		ok1.setOnClickListener(this);
		w1 = (EditText)findViewById(R.id.w1);

	}

	public void onClick(View arg0) {
		// TODO 自動生成されたメソッド・スタブ
		switch(arg0.getId()){
		case R.id.ok1:

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
			// アラートダイアログのタイトルを設定します
			alertDialogBuilder.setTitle("確認");
			// アラートダイアログのメッセージを設定します
			alertDialogBuilder.setMessage("体重:"+w1.getText().toString()+"kg");
			// アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
			alertDialogBuilder.setPositiveButton("OK",
					new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface dialog, int which) {

				}
			});

			// アラートダイアログの否定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
			alertDialogBuilder.setNegativeButton("cancel",
					new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(Weigh.this,MainActivity.class);
					startActivity(intent);
				}
			});
			// アラートダイアログのキャンセルが可能かどうかを設定します
			alertDialogBuilder.setCancelable(true);
			AlertDialog alertDialog = alertDialogBuilder.create();
			// アラートダイアログを表示します
			alertDialog.show();

			break;

		}
	}
}
