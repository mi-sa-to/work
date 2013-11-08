package com.example.debuet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDBController {
	UserDBOpenHelper dbHelper;
	SQLiteDatabase db;

	UserDBController(Context context){
		// Helperを使用してデータベースを開く
		dbHelper = new UserDBOpenHelper(context);
		db = dbHelper.getWritableDatabase();
	}
	/** エントリ追加 */
	void doAddEntry(String date, String sex, int age,double height,double weight){
		// 挿入するデータはContentValuesに格納
		ContentValues val = new ContentValues();
		val.put( "date", date );
		val.put( "sex", sex );
		val.put( "age" , age  );
		val.put( "height", height );
		val.put( "weight" , weight  );
		// “user_table”に1件追加
		db.insert( "user_table", null, val );
	}

	/** 年齢を条件に削除 */
	void delByAge(int age ){
		db.delete( "user_table", 
				"age = ?",
				new String[]{ "" + age } );
	}

	/** 無条件で削除（全削除） */
	void delAllEntry(){
		db.delete( "user_table", null, null );
	}

	/** 特定の年齢のデータを更新 */
	void updateEntry(int targetAge,String newDate ,String newName, int newAge,double newHeight,double newWeight,boolean newSex ){
		// 更新内容はContentValuesに格納しておく
		ContentValues val = new ContentValues();
		val.put( "date", newDate );
		val.put( "sex", newSex );
		val.put( "age" , newAge  );
		val.put( "height", newHeight );
		val.put( "weight" , newWeight  );

		// 更新するデータの条件はquery()やdelete()と同じように記述する
		db.update( "user_table", 
				val,
				"age = ?",
				new String[]{ "" + targetAge } );
	}
}
