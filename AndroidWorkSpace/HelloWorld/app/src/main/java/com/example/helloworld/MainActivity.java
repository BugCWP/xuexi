package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        context=getApplicationContext();
        final TextView tv_hello =findViewById(R.id.tv_hello);
        tv_hello.setText("今天天气真热啊，火辣辣的");
        tv_hello.setTextColor(Color.RED);
        tv_hello.setTextSize(30);
        TextView tv_width=findViewById(R.id.tv_width);
        tv_width.setText("宽"+getScreenWidth(context)+"高"+getScreenHeight(context)+"像素"+getScreenDensity(context));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btn_open=(Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
//                tv_hello.setText("1111111111");
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //获取屏幕的宽度
    public static int getScreenWidth(Context ctx){
        WindowManager wm=(WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    //获取屏幕的高度
    public  static  int getScreenHeight(Context ctx){
        WindowManager wm=(WindowManager)ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    //获取屏幕的像素密度
    public static float getScreenDensity(Context ctx){
        WindowManager wm=(WindowManager)ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.density;
    }
}
