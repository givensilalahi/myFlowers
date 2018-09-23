package com.example.android.tflitecamerademo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {


    List<FlowersActivity.Flower> flowers;
        private Context context;



    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView flowerName;
        TextView flowerContent;
        ImageView flowerPhoto;
        Button share;
        Button visit;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cvAja);
            flowerName = itemView.findViewById(R.id.tvNama);
            flowerContent = itemView.findViewById(R.id.tvIsi);
            flowerPhoto = itemView.findViewById(R.id.ivAja);
            share = itemView.findViewById(R.id.btnShare);
            visit = itemView.findViewById(R.id.btnVisit);

        }
    }


    public RVAdapter(Context context, List<FlowersActivity.Flower> flowers){
        this.context = context;
        this.flowers = flowers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main2, parent, false);
        return new ViewHolder(v);

    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.flowerName.setText(flowers.get(position).name);
        holder.flowerContent.setText(flowers.get(position).content);
        holder.flowerPhoto.setImageResource(flowers.get(position).photoId);


        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, context.getString(flowers.get(position).content));
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));
            }
        });

        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(context.getString(flowers.get(position).link)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    //tambahan
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}

