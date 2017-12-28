package in.asetalias.alias.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import in.asetalias.alias.R;

public class SplashActivity extends Activity {

    private ImageView imgLogoSplash;
    private Animation animation;

    private TextView txtAliasName;

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initialize();
        setAnimation();

        //for showing splash screen for certain duration
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //close this activity
                finish();
                loadMainView();
            }
        }, SPLASH_TIME_OUT);
        */
    }

    private void initialize() {

        imgLogoSplash = (ImageView) findViewById(R.id.img_logo_splash);
        txtAliasName = (TextView) findViewById(R.id.txt_alias_name);
    }

/*
    private void loadMainView() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    */

    private void setAnimation() {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imgLogoSplash.startAnimation(animation);
        txtAliasName.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}