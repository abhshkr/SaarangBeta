package com.example.abhi.saarangbeta;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/*Adapter for the RecyclerView is implemented here */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    //List which will hold the data
    private List<DataInfo> dataList;

    //Constructor - assigns values to the list of data items
    public SimpleAdapter(List<DataInfo> data) {
        dataList = data;
    }

    //key for passing data to the next (DisplayDetails) activity
    public final static String DATA_MESSAGE = "com.example.saarangbeta.title";

    /*This is the class that implements the ViewHolder*/
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, subtitle;
        int position;
        //ImageView image;
        private final Context context;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            //image = (ImageView) itemView.findViewById(R.id.image1);
        }
        //Function called when user clicks on any ViewHolder in RecyclerView
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(context, displayDetails.class);
           intent.putExtra(DATA_MESSAGE,dataList.get(position));
           context.startActivity(intent);
       }
    }

    //onCreateViewHolder is called whenever a new instance of our ViewHolder class is created.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    //onBindViewHolder is called when the view is bound with the data, i.e. when the data is shown in the UI.
    @Override
    public void onBindViewHolder(SimpleAdapter.ViewHolder holder, int position) {
        holder.title.setText(this.dataList.get(position).getTitle());
        holder.subtitle.setText(this.dataList.get(position).getSubtitle());
        holder.position = position;
        //int id = context.getResources().getIdentifier("saarang1", "drawable", "R");
        //holder.image.setImageResource(id);
    }

    //Gets the number of items in list
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
