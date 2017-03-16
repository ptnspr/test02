package com.example.pathorn.sqliteapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Pathorn on 15/3/2560.
 */

public class TodoListDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodoListDAO(Context context) {
        dbHelper = new DbHelper(context);
    }
    //void ไม่ต้องการส่งค่ากลับ
    public void open(){
        database = dbHelper.getWritableDatabase();
    }//open database

    public void close(){
        dbHelper.close();
    }

    public ArrayList<String > getAllTodoList(){
        ArrayList<String> todoList = new ArrayList<String>();
        Cursor cursor = database.rawQuery("SELECT * FROM todo_list;", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            todoList.add(cursor.getString(1));
            cursor.moveToNext();
        }//Loop FirstRecord to LastRecord
        cursor.close();
        return todoList;
    }

    public void add(TodoList todoList){
        TodoList newTodoList = new TodoList();
        newTodoList = todoList;
    }

}
