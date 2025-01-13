package com.example.shiyan4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText ageEditText;
    private EditText heightEditText;
    private Button addButton;
    private Button updateButton;
    private Button deleteButton;
    private Button queryButton;
    private ListView listView;

    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private ArrayAdapter<String> adapter;
    private List<Integer> idList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        heightEditText = findViewById(R.id.heightEditText);
        addButton = findViewById(R.id.addButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);
        queryButton = findViewById(R.id.queryButton);
        listView = findViewById(R.id.listView);

        dbHelper = new MyDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        idList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryData(v);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Set the item as checked
                listView.setItemChecked(position, true);
                showSelectedData(position);
            }
        });


        refreshListView();
    }

    private void addData() {
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.COLUMN_NAME, nameEditText.getText().toString());
        values.put(MyDatabaseHelper.COLUMN_AGE, Integer.parseInt(ageEditText.getText().toString()));
        values.put(MyDatabaseHelper.COLUMN_HEIGHT, Double.parseDouble(heightEditText.getText().toString()));

        long newRowId = db.insert(MyDatabaseHelper.TABLE_NAME, null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show();
            refreshListView();
            clearInputFields();
        } else {
            Toast.makeText(this, "Error adding data", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateData() {
        int position = listView.getCheckedItemPosition();
        if (position != AdapterView.INVALID_POSITION) {
            ContentValues values = new ContentValues();
            values.put(MyDatabaseHelper.COLUMN_NAME, nameEditText.getText().toString());
            values.put(MyDatabaseHelper.COLUMN_AGE, Integer.parseInt(ageEditText.getText().toString()));
            values.put(MyDatabaseHelper.COLUMN_HEIGHT, Double.parseDouble(heightEditText.getText().toString()));

            int selectedId = idList.get(position);
            String selection = MyDatabaseHelper.COLUMN_ID + "=?";
            String[] selectionArgs = {String.valueOf(selectedId)};

            int updatedRows = db.update(MyDatabaseHelper.TABLE_NAME, values, selection, selectionArgs);

            if (updatedRows > 0) {
                Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                refreshListView();
                clearInputFields();
            } else {
                Toast.makeText(this, "Error updating data", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please select a row to update", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteData() {
        int position = listView.getCheckedItemPosition();
        Log.d("delete",position+"");
        if (position != AdapterView.INVALID_POSITION) {
            int selectedId = idList.get(position);
            String selection = MyDatabaseHelper.COLUMN_ID + "=?";
            String[] selectionArgs = {String.valueOf(selectedId)};

            int deletedRows = db.delete(MyDatabaseHelper.TABLE_NAME, selection, selectionArgs);

            if (deletedRows > 0) {
                Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                refreshListView();
                clearInputFields();
            } else {
                Toast.makeText(this, "Error deleting data", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please select a row to delete", Toast.LENGTH_SHORT).show();
        }
    }

    private void queryData(View view) {
        int ageThreshold = Integer.parseInt(ageEditText.getText().toString());

        String[] projection = {
                MyDatabaseHelper.COLUMN_ID,
                MyDatabaseHelper.COLUMN_NAME,
                MyDatabaseHelper.COLUMN_AGE,
                MyDatabaseHelper.COLUMN_HEIGHT
        };

        String selection = MyDatabaseHelper.COLUMN_AGE + ">=?";
        String[] selectionArgs = {String.valueOf(ageThreshold)};

        Cursor cursor = db.query(
                MyDatabaseHelper.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        showQueryResults(cursor);
    }

    private void showQueryResults(Cursor cursor) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Query Results");

        StringBuilder result = new StringBuilder();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_AGE));
            double height = cursor.getDouble(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_HEIGHT));

            result.append(id).append("  ").append(name).append("  ").append(age).append("  ").append(height).append("\n");
        }

        if (result.length() > 0) {
            builder.setMessage(result.toString());
        } else {
            builder.setMessage("No matching records found.");
        }

        builder.setPositiveButton("OK", null);
        builder.show();

        cursor.close();
    }

    private void showSelectedData(int position) {
        int selectedId = idList.get(position);
        String selection = MyDatabaseHelper.COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(selectedId)};

        Cursor cursor = db.query(
                MyDatabaseHelper.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            nameEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_NAME)));
            ageEditText.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_AGE))));
            heightEditText.setText(String.valueOf(cursor.getDouble(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_HEIGHT))));
        }

        cursor.close();
    }

    private void refreshListView() {
        adapter.clear();
        idList.clear();

        Cursor cursor = db.query(
                MyDatabaseHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_AGE));
            double height = cursor.getDouble(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_HEIGHT));

            idList.add(id);
            adapter.add(id + "  " + name + "  " + age + "  " + height);
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }

    private void clearInputFields() {
        nameEditText.getText().clear();
        ageEditText.getText().clear();
        heightEditText.getText().clear();
    }

}
