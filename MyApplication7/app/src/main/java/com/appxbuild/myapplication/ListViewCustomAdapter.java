package com.appxbuild.myapplication;



import java.util.ArrayList;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

public class ListViewCustomAdapter extends BaseAdapter{

    ArrayList<Object> itemList;

    public Activity context;
    public LayoutInflater inflater;

    AQuery aQuery;
    public ListViewCustomAdapter(Activity context,ArrayList<Object> itemList) {
        super();

        this.context = context;
        this.itemList = itemList;

        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        aQuery = new AQuery(context);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder
    {
        ImageView imgViewLogo;
        TextView txtViewTitle;
        TextView txtViewDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.items, null);

            holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.imgViewLogo);
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.txtViewTitle);
           // holder.txtViewDescription = (TextView) convertView.findViewById(R.id.txtViewDescription);

            convertView.setTag(holder);
        }
        else

            holder=(ViewHolder)convertView.getTag();

        ItemBean1 bean1 = (ItemBean1) itemList.get(position);

        //holder.imgViewLogo.setImageURI(Uri.parse(bean1.getDescription()));
        aQuery.id(holder.imgViewLogo).image(bean1.getDescription(),false,false);
      
        holder.txtViewTitle.setText(bean1.getTitle());
        //holder.txtViewDescription.setText(bean1.getDescription());

        return convertView;
    }

}
