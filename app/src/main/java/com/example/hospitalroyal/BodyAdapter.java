package com.example.hospitalroyal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BodyAdapter extends RecyclerView.Adapter<BodyAdapter.BodyVH> {

    List<Body>bodyList;

    public BodyAdapter(List<Body> bodyList) {
        this.bodyList = bodyList;
    }

    @NonNull
    @Override
    public BodyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cabecera,parent,false);
        return new BodyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BodyVH holder, int position) {

        Body b =bodyList.get(position);
        holder.head.setText(b.getHead());
        holder.body.setText(b.getBody());

        boolean isExpandible=bodyList.get(position).isExpandable();
        holder.expandbleLayout.setVisibility(isExpandible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return bodyList.size();
    }

    public class BodyVH extends RecyclerView.ViewHolder{

        TextView head,body;
        LinearLayout linearLayout;
        RelativeLayout expandbleLayout;

        public BodyVH(@NonNull View itemView) {
            super(itemView);

            head=itemView.findViewById(R.id.cabecera);
            body=itemView.findViewById(R.id.cuerpo);
            linearLayout=itemView.findViewById(R.id.linear_layout);
            expandbleLayout=itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Body b=bodyList.get(getAdapterPosition());
                    b.setExpandable(!b.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

    }
}
