package com.example.shitagain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class Bebidas extends AppCompatActivity {
    public static String siz,ex,fla,orden;
    public static Integer pre,cos,total,i;

    CheckBox sho,alm,bost;
    RadioButton g,m,c;
    Button btncapu, btnfrapp, btntisana, btnrocas;
    Spinner sabor,jarabe;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        setContentView(R.layout.bottom_cafes);
        setContentView(R.layout.bottom_tisa);
        drawerLayout=findViewById(R.id.drawer_layout);
        sabor=findViewById(R.id.sabor);
        jarabe=findViewById(R.id.jarabe);
        btncapu=findViewById(R.id.btncapu);
        btnfrapp=findViewById(R.id.btnfrapp);
        btntisana=findViewById(R.id.btntisana);
        btnrocas=findViewById(R.id.btnrocas);
        sho=(CheckBox)findViewById(R.id.sho);
        alm=(CheckBox) findViewById(R.id.alm);
        bost=(CheckBox) findViewById(R.id.bost);
        g=(RadioButton) findViewById(R.id.g);
        m=(RadioButton) findViewById(R.id.m);
        c=(RadioButton) findViewById(R.id.c);
        String[] tes= getResources().getStringArray(R.array.tes);
        String[] Cafe=getResources().getStringArray(R.array.Cafe);



        sabor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i=position;
                fla=tes[i];
            }
        });

        jarabe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i=position;
                fla=Cafe[i];
            }
        });


        btncapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sheetcafe();
            }
        });

        btnrocas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetcafe();
            }
        });

        btnfrapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetcafe();
            }
        });

        btntisana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheettisa();
            }
        });
    }

    public void sheetcafe(){
        BottomSheetDialog capuchino=new BottomSheetDialog(Bebidas.this);
        capuchino.setContentView(R.layout.bottom_cafes);
        capuchino.setCanceledOnTouchOutside(false);
        Button btncue=capuchino.findViewById(R.id.btncue);

        btncue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicksize(v);
                total=pre+cos;
                orden="\nBebida sabor:"+fla+" Tamaño"+siz+
                        "\n Extras:"+ex+
                        "\n Precio: $"+total.toString()+
                        "\n_________________________________";

            }
        });
        capuchino.show();
    }

    public void sheettisa(){
        BottomSheetDialog ti=new BottomSheetDialog(Bebidas.this);
        ti.setContentView(R.layout.bottom_tisa);
        ti.setCanceledOnTouchOutside(false);
        Button btncuenta=ti.findViewById(R.id.btncuenta);
        btncuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicksize(v);
                total=cos;
                orden="Bebida sabor:"+fla+" Tamaño"+siz+
                        "\n Precio: $"+total.toString();
            }
        });
        ti.show();
    }

    public void onclicksize(View view){
        boolean chec=((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.g:
                if (chec)
                    siz="Grande";
                    cos=65;
                    break;
            case R.id.m:
                if(chec)
                    siz="Mediano";
                    cos=60;
                    break;
            case R.id.c:
                if(chec)
                    siz="Chico";
                    cos=50;
                    break;
        }
    }

    public void onextras(View view){
        pre=0;
        boolean chek=((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.sho:
                if (chek)
                    ex="Shot +5";
                    pre=pre+5;
                    break;
            case R.id.alm:
                if(chek)
                    ex="Leche de almendras +15";
                    pre=pre+15;
                    break;
            case R.id.bost:
                if(chek)
                    ex="Jarabe extra +5";
                    pre=pre+5;
                    break;
        }
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
        recreate();
    }
    public void  ClickVenta(View view){
        NavDrawerr.redirecActivity(this,Venta.class);
    }
    public void ClickLogout(View view){
        NavDrawerr.logout(this);
    }
    protected void onPause(){
        super.onPause();
        NavDrawerr.closeDrawer(drawerLayout);
    }
}