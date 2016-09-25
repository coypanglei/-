package com.example.administrator.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/25 0025.
 */
public class ListViewAdapter  extends BaseAdapter {
    private Context context;
    private String[] beans;
    private int mCurSelectPosition = 0;
    class ViewHolder {

        TextView tvName;
        RadioButton rb_state;
    }
    public void setCurSelectPosition(int mCurSelectPosition) {
        this.mCurSelectPosition = mCurSelectPosition;
    }
    public ListViewAdapter(Context context,String [] beans) {
        this.beans=beans;
        this.context = context;
    }
    @Override
    public int getCount() {
        return  beans.length;
    }

    @Override
    public Object getItem(int position) {
        return beans[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        String bean = beans[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.dialog_list, null);
            holder = new ViewHolder();

            holder.rb_state =(RadioButton) convertView.findViewById(R.id.rb_light);
            holder.tvName = (TextView) convertView
                    .findViewById(R.id.tv_device_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(bean);
        holder.rb_state.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                setCurSelectPosition(position);
                ListViewAdapter.this.notifyDataSetChanged();
            }
        });
        boolean res = false;
        if (position == mCurSelectPosition) {
            res = true;
        } else {
            res = false;
        }
        Log.d("panglei","res"+res);
        holder.rb_state.setChecked(res);
        return convertView;
    }
}
