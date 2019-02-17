package com.icesi.fragmentshomework;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements FragmentA.FragmentAActions , FragmentB.FragmentBActions  {


    private FragmentA fragmentA;

    private FragmentB fragmentB;


    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentA.setListener(this);

        fragmentB = new FragmentB();


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.menubar_url:
                        transaction.replace(R.id.contenido, fragmentA);
                        transaction.commit();
                        break;
                    case R.id.menubar_imagen:
                        Bundle bundle = new Bundle();
                        bundle.putString("url",url);
                        fragmentB = new FragmentB();
                        fragmentB.setArguments(bundle);
                        transaction.replace(R.id.contenido, fragmentB);
                        transaction.commit();
                        break;
                }

                return true;
            }
        });


    }


    @Override
    public void onMessage(String msj) {
        url=msj;
        Toast.makeText(this, "Cargando la imagen de: " +msj, Toast.LENGTH_LONG).show();


    }
}
