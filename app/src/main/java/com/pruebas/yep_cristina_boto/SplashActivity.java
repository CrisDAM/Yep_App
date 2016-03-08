package com.pruebas.yep_cristina_boto;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView titulo = (TextView)findViewById(R.id.txtTitulo);
        TextView subtitulo = (TextView) findViewById(R.id.txtSubtitulo);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/AmaticSC-Regular.ttf");
        titulo.setTypeface(font);
        subtitulo.setTypeface(font);


        Animation shake = AnimationUtils.loadAnimation(this, R.anim.pulse_animation);
        Animation girar = AnimationUtils.loadAnimation(this, R.anim.girar);
        Animation mover = AnimationUtils.loadAnimation(this, R.anim.mover);
        Animation ampliar = AnimationUtils.loadAnimation(this, R.anim.ampliar);
        Animation transparencia = AnimationUtils.loadAnimation(this, R.anim.transparencia);

        getSupportActionBar().hide();

        titulo.startAnimation(shake);

        openApp(true);
    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
}
