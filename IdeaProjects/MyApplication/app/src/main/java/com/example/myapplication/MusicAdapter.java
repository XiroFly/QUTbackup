package com.example.myapplication;

import android.widget.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

// MusicAdapter.java
public class MusicAdapter extends BaseAdapter {
    private Context context;
    private List<MusicItem> musicList;
    private LayoutInflater inflater;

    public MusicAdapter(Context context, List<MusicItem> musicList) {
        this.context = context;
        this.musicList = musicList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.titleTextView = convertView.findViewById(R.id.titleTextView);
            holder.artistTextView = convertView.findViewById(R.id.artistTextView);
            holder.checkBox = convertView.findViewById(R.id.checkBox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        //有holder，则拿出来并修改
        }
        //拿取初始数据在musicList中通过int position
        //将数据传给holder
        MusicItem musicItem = musicList.get(position);

        holder.imageView.setImageResource(musicItem.getImageResId());
        holder.titleTextView.setText(musicItem.getTitle());
        holder.artistTextView.setText(musicItem.getArtist());
        holder.checkBox.setChecked(musicItem.isSelected());

        // 为CheckBox设置OnCheckedChangeListener
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 更新isSelected属性
                musicItem.setSelected(isChecked);
            }
        });

        return convertView;
    }


    static class ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView artistTextView;
        CheckBox checkBox;
    }
}
