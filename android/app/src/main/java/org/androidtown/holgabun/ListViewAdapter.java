package org.androidtown.holgabun;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<Garden> listViewItemList = new ArrayList<Garden>() ;

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        GridItem holder;

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);


            holder=new GridItem();

            holder.tv = (TextView)convertView.findViewById(R.id.textView1);
            holder.tv2 = (TextView)convertView.findViewById(R.id.textView2);
            holder.iv = (ImageView)convertView.findViewById(R.id.imageView1);

            convertView.setTag(holder);
        }
        else{
            holder=(GridItem)convertView.getTag();
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Garden listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        holder.iv.setImageBitmap(listViewItem.getImgno());
        holder.tv.setText(listViewItem.getName());
        holder.tv2.setText(listViewItem.getAddress());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Bitmap icon, String title, String desc) {
        Garden item = new Garden(title,icon,desc);

        listViewItemList.add(item);
    }
    static class GridItem{
        public TextView tv;
        public ImageView iv;
        public TextView tv2;
    }
}

