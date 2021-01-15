package com.example.shitagain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Venta extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);
        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        NavDrawerr.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        NavDrawerr.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        NavDrawerr.redirecActivity(this,NavDrawerr.class);
    }
    public void  Clickbebid(View view){
        NavDrawerr.redirecActivity(this,Bebidas.class);
    }
    public void  ClickVenta(View view){
      recreate();
    }
    public void ClickLogout(View view){
        NavDrawerr.logout(this);
    }
    protected void onPause(){
        super.onPause();
        NavDrawerr.closeDrawer(drawerLayout);
    }
}