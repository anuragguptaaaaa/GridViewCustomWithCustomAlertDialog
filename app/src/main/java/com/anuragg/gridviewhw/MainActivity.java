package com.anuragg.gridviewhw;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String name[]={"Furious7","avatar","bahubali","bajiraomastani","dabangg","dhamaal","golmal","holiday","idiot","ishaqzaade","singham","sultan"};
    int image[]={R.drawable.furious,R.drawable.avatar,R.drawable.bahubali,R.drawable.bajiraomastani,R.drawable.dabangg,R.drawable.dhamal,R.drawable.golmaal,R.drawable.holiday,R.drawable.idiot,R.drawable.ishaqzaade,R.drawable.singham,R.drawable.sultan};
    GridView gv;
    ArrayList al;
    String keys[]={"image","name"};
    int to[]={R.id.iv1,R.id.tv1};
    ImageView iv;
    RatingBar rb;
    TextView tv;
    float rating=2.5f;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView)findViewById(R.id.gv1);
        al=new ArrayList();
        for(int i=0;i<image.length;i++)
        {
            HashMap hm=new HashMap();
            hm.put(keys[0],image[i]);
            hm.put(keys[1],name[i]);
            al.add(hm);
        }
        SimpleAdapter sm=new SimpleAdapter(this,al,R.layout.grid_style,keys,to);
        gv.setAdapter(sm);




        gv.setOnItemClickListener(this);



    }
    public void dialog(int i)
    {
        LayoutInflater  li=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.dialog_style,null,false);

        iv= (ImageView) view.findViewById(R.id.iv2);
        rb=(RatingBar)view.findViewById(R.id.rb1);
        tv=(TextView)view.findViewById(R.id.tv1);

        iv.setImageResource(image[i]);
        rb.setRating(rating);
        tv.setText(name[i]);
         ad=new AlertDialog.Builder(this)
                .setView(view)
                 .setCancelable(false)
                .create();
        ad.show();


    }
    public void buttonclose(View view)
    {
        ad.dismiss();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        dialog(i);
    }
}

