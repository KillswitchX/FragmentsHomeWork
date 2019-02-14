package com.icesi.fragmentshomework;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;


public class FragmentA extends Fragment {

    private EditText url;

    public FragmentA() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_a, container, false);
        Button btn_a = v.findViewById(R.id.btn_fragmentA_Ver);
        url = v.findViewById(R.id.btn_fragmentA_URL);


        btn_a.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onMessage(url.getText().toString());
                }
            }
        });

        return v;
    }




    //1. Interface
    public interface FragmentAActions{
        void onMessage(String msj);
    }
    //2. Crear el objeto
    FragmentAActions listener;

    //3. Crear metodo Set para el listener
    public void setListener(FragmentAActions listener){
        this.listener = listener;
    }

}
