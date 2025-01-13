package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

// MainActivity.java
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button deleteButton;
    private MusicAdapter adapter;
    private List<MusicItem> musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("start","1");
        listView = findViewById(R.id.listView);
        deleteButton = findViewById(R.id.deleteButton);

        // 初始化音乐列表数据（模拟数据）
        musicList = new ArrayList<>();
        musicList.add(new MusicItem(R.drawable.picture1, "Song 1", "Artist 1"));
        musicList.add(new MusicItem(R.drawable.picture2, "Song 2", "Artist 2"));
        musicList.add(new MusicItem(R.drawable.picture3, "Song 3", "Artist 3"));

        // 设置ListView的Adapter
        adapter = new MusicAdapter(this, musicList);
        listView.setAdapter(adapter);

        // 设置ListView的Item点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("start","2");
                final String message = "正在播放：" + musicList.get(position).getTitle();

                // 在主线程中显示AlertDialog
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showAlertDialog(message);
                    }
                });
            }
        });

        // 设置删除按钮的点击监听器
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 删除选中项
                Log.d("start","5");
                deleteSelectedItems();
            }
        });
    }

    // 显示AlertDialog的方法
    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 点击确定按钮的操作
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    // 删除选中项的方法
    private void deleteSelectedItems() {
        List<MusicItem> selectedItems = new ArrayList<>();
        Log.d("start","6");
        // 找到选中的项
        for (MusicItem item : musicList) {

            if (item.isSelected()) {
                Log.d("start","7");
                Log.d("start",item.toString());
                selectedItems.add(item);
            }
        }

        // 从列表中移除选中的项
        musicList.removeAll(selectedItems);

        // 刷新ListView
        adapter.notifyDataSetChanged();
    }
}
