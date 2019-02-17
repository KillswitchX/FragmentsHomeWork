package com.icesi.fragmentshomework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;


public class FragmentB extends Fragment {

    public FragmentB() {
    }

    private ImageView image;
    private String url;
    private Bitmap myBitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);



        image = v.findViewById(R.id.imageViewxD);

        Bundle bundle = this.getArguments();
        if(bundle!=null){
            url = bundle.getString("url");
            Picasso.get().load(url).into(image);
        }

        return v;
    }





    //1. Interface
    public interface FragmentBActions{
        void onMessage(String msj);
    }
    //2. Crear el objeto
    FragmentB.FragmentBActions listener;

    //3. Crear metodo Set para el listener
    public void setListener(FragmentB.FragmentBActions listener){
        this.listener = listener;
    }

}
