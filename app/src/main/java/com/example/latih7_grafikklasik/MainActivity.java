package com.example.latih7_grafikklasik;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.opengl.GLSurfaceView;

public class MainActivity extends Activity {
    private Button tekan;
    private GLSurfaceView grafik1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tekan=(Button)findViewById(R.id.button1);
        grafik1 = new HelloESSurfaceView(this);
        setContentView(grafik1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        grafik1.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        grafik1.onResume();
    }

    class HelloESSurfaceView extends GLSurfaceView {
        public HelloESSurfaceView(Context context) {
            super(context);
            setRenderer (new com.example.latih7_grafik_klasik.segitiga());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_latih7_grafik_klasik,menu);
        return true;
    }
}
