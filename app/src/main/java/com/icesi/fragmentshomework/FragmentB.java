package com.icesi.fragmentshomework;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentB extends Fragment {

    public FragmentB() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
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
