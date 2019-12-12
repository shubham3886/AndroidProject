package com.example.sistec_event;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private Activity context;
    List<User> Users;

    public UserAdapter(Activity context, List<User> users) {
        super(context, R.layout.user_list, users);
        this.context = context;
        this.Users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.user_list, null, true);
        TextView txtName = listViewItem.findViewById(R.id.textViewName);
        TextView txtEmail = listViewItem.findViewById(R.id.textviewemail);
        TextView txtMno = listViewItem.findViewById(R.id.textviewnumber);
        ImageView photo=listViewItem.findViewById(R.id.imgPhot);

        User user = Users.get(position);
        txtName.setText(user.getName());
        txtEmail.setText(user.getEmail());
        txtMno.setText(user.getMno());
        Bitmap bitmap=ImageUtility.StringToBitMap(user.getPhoto());
        photo.setImageBitmap(bitmap);
        return listViewItem;
    }
}
