package com.example.abhi.saarangbeta;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*Adapter for the RecyclerView is implemented here */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    //List which will hold the data as classes
    private List<DataInfo> dataList;

    public String getTitle(int index){
        return dataList.get(index).getTitle();
    }
    //Constructor - assigns values to the list of data items
    public SimpleAdapter() {
        this.dataList = new ArrayList<>();
        this.dataList.add(new DataInfo(1,"Decibels","Rock","saarang1"));
        this.dataList.add(new DataInfo(2,"Acapella","Light Music","saarang1"));
        this.dataList.add(new DataInfo(3,"Alankaar","Classical Music","saarang1"));
        this.dataList.add(new DataInfo(4,"Street Play","Thespian Arts","saarang1"));
        this.dataList.add(new DataInfo(5,"World Culture Show","International Artistes","saarang1"));
        this.dataList.add(new DataInfo(6,"Scrabble","Word Games","saarang1"));
    }

    public final static String TITLE_MESSAGE = "com.mycompany.myfirstapp.title";          //TODO - why do we need these 2 lines?
    public final static String SUBTITLE_MESSAGE = "com.mycompany.myfirstapp.subtitle";
    public final static String POS_MESSAGE = "com.mycompany.myfirstapp.position";



    /*This is the class that implements the ViewHolder*/
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, subtitle;
        int position;
        //ImageView image;
        private final Context context;
        public ViewHolder(View itemView) {
            /*on passing the view to the fn, it assigns the \
            respective parts of the view to respectve variables
            Here the 'title textview' from the XML is given to 'title' variable, for example.*/
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            //image = (ImageView) itemView.findViewById(R.id.image1);
        }

       @Override
       public void onClick(View v) {

           final Intent intent;
           intent = new Intent(context, displayDetails.class);
           intent.putExtra(TITLE_MESSAGE, title.getText().toString() );
           intent.putExtra(SUBTITLE_MESSAGE, subtitle.getText().toString() );
           intent.putExtra(POS_MESSAGE,position);
           context.startActivity(intent);
       }
    }


    /*
    To implement an adapter, we have to override two methods.
    onCreateViewHolder is called whenever a new instance of our ViewHolder class is created.
    onBindViewHolder is called when the SO binds the view with the data -- or, in other words, the data is shown in the UI.

    onBindviewholder takes the Viewholder class (Here, it will be SimpleAdapter.ViewHolder)
    and the position of the data in the given list (here int position) as parameters)
    It assigns the text values for the textViews that we have imported from the XML
    */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleAdapter.ViewHolder holder, int position) {
        holder.title.setText(this.dataList.get(position).getTitle());
        holder.subtitle.setText(this.dataList.get(position).getSubtitle());
        holder.position = position;
        //holder.title.setText(events[position]);
        //holder.subtitle.setText(details[position]);
        //int id = context.getResources().getIdentifier("saarang1", "drawable", "R");
        //holder.image.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
