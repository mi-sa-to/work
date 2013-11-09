package com.example.debuet;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
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
	String dateNow;

	private SharedPreferences preference;  
    private Editor editor;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);

	ok = (Button)findViewById(R.id.ok);
	ok.setOnClickListener(this);
	age = (EditText)findViewById(R.id.age);
	h = (EditText)findViewById(R.id.h);
	w = (EditText)findViewById(R.id.w);
	
	preference = getSharedPreferences("Preference Name", MODE_PRIVATE);  
    editor = preference.edit();  

    if (preference.getBoolean("fast_start", false)){
        //初回起動時の処理  
	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	// ダイアログ設定
	alertDialogBuilder.setTitle("ようこそ");
	alertDialogBuilder.setMessage("データの入力お願いします");
	alertDialogBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			}

		}); 
	alertDialogBuilder.setCancelable(true);
	AlertDialog alertDialog = alertDialogBuilder.create();
	alertDialog.show();
	
	editor.putBoolean("Launched", true);  
    editor.commit(); 
    }
    
    else {  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	// ダイアログ設定
	alertDialogBuilder.setTitle("aaa");
	alertDialogBuilder.setMessage("データの入力お願いします");
	alertDialogBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			}

		}); 
	alertDialogBuilder.setCancelable(true);
	AlertDialog alertDialog = alertDialogBuilder.create();
	alertDialog.show();
    	

    }  
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

		// 現在の時刻を取得
		Date date = new Date();
		// 表示形式を設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateNow = sdf.format(date);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		// アラートダイアログのタイトルを設定します
		alertDialogBuilder.setTitle("確認");
		// アラートダイアログのメッセージを設定します
		alertDialogBuilder.setMessage("これまでのデータを消去し、以下の内容で新規登録しますか？\n\n"+"日付："+dateNow+"\n"+"性別："+a.getText().toString()+"\n"+"年齢:"+age.getText().toString()+"歳"+"\n"+"身長:"+h.getText().toString()+"cm"+"\n"+"体重:"+w.getText().toString()+"kg");
		// アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
		alertDialogBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dbc = new UserDBController(Index.this);
				dbc.delAllEntry();
				dbc.doAddEntry(dateNow, a.getText().toString(), Integer.parseInt(age.getText().toString()), Double.parseDouble(h.getText().toString()), Double.parseDouble(w.getText().toString()));
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
