package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.semana3.adaptador.PageAdapter;
import com.example.semana3.fragment.PerfilFragment;
import com.example.semana3.fragment.ReciclerViewFragment;
import com.example.semana3.actividades.AcercaDe;
import com.example.semana3.actividades.Contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar1;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar1 = findViewById(R.id.toolbar1);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);


        if(toolbar1 != null){
            setSupportActionBar(toolbar1);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReciclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.estrellita:
                Toast.makeText(getBaseContext(),"Irias a la otra actividad",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Contacto:
                Intent intent1 = new Intent(this, Contacto.class);
                startActivity(intent1);
                break;
            case R.id.AcercaDe:
                Intent intent2 = new Intent(this, AcercaDe.class);
                startActivity(intent2);
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

}
