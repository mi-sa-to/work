package com.example.debuet;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;

public class Index extends Activity implements OnClickListener{
	Button ok;
	EditText age;
	EditText h;
	EditText w;
	RadioGroup rg;
	int id;
	RadioButton a;
	UserDBController dbc;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);

		ok = (Button)findViewById(R.id.ok);
		ok.setOnClickListener(this);
		age = (EditText)findViewById(R.id.age);
		h = (EditText)findViewById(R.id.h);
		w = (EditText)findViewById(R.id.w);



	}

	public void onClick(View arg0) {
		// TODO 自動生成されたメソッド・スタブ
		switch(arg0.getId()){
		case R.id.ok:

			// ラジオグループのオブジェクトを取得
			rg = (RadioGroup)findViewById(R.id.rg);
			// チェックされているラジオボタンの ID を取得
			id = rg.getCheckedRadioButtonId();
			// チェックされているラジオボタンオブジェクトを取得
			a = (RadioButton)findViewById(id);

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
			// アラートダイアログのタイトルを設定します
			alertDialogBuilder.setTitle("確認");
			// アラートダイアログのメッセージを設定します
			alertDialogBuilder.setMessage("これまでのデータを消去し、以下の内容で新規登録しますか？\n\n"+"性別："+a.getText().toString()+"\n"+"年齢:"+age.getText().toString()+"歳"+"\n"+"身長:"+h.getText().toString()+"cm"+"\n"+"体重:"+w.getText().toString()+"kg");
			// アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
			alertDialogBuilder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
			
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dbc = new UserDBController(Index.this);
					dbc.delAllEntry();
					dbc.doAddEntry(a.getText().toString(), Integer.parseInt(age.getText().toString()), Double.parseDouble(h.getText().toString()), Double.parseDouble(w.getText().toString()));
				}
			});

			// アラートダイアログの否定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
			alertDialogBuilder.setNegativeButton("cancel",
					new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(Index.this,MainActivity.class);
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
