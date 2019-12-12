package com.example.sistec_event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PostAdapter extends FirebaseRecyclerAdapter<Post, PostAdapter.PostVieHolder> {


    public PostAdapter(@NonNull FirebaseRecyclerOptions<Post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostVieHolder holder, int position, @NonNull Post model) {

        holder.name.setText(model.getName());
        holder.college.setText(model.getCollege());
        holder.email.setText(model.getEmail());
        holder.phone.setText(model.getPhone());
        holder.event.setText(model.getEvent());


    }

    @NonNull
    @Override
    public PostVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);

        return new PostVieHolder(view);
    }

    class PostVieHolder extends RecyclerView.ViewHolder{


        TextView name,college,email,phone,event;
        public PostVieHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            college=itemView.findViewById(R.id.college);
            email=itemView.findViewById(R.id.email);
            phone=itemView.findViewById(R.id.phone);
            event=itemView.findViewById(R.id.event);
        }
    }
}




