package com.easternts.flowerworld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.crashlytics.android.Crashlytics;
import com.easternts.flowerworld.util.MyExceptionHandler;
import com.easternts.flowerworld.view.SplashView;
import com.easternts.flowerworld.view.SplashView.ISplashListener;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Fabric;
import com.crashlytics.android.Crashlytics;
import com.easternts.flowerworld.util.MyExceptionHandler;

public class SplashActivity extends Activity {

  private static final String TAG = "MainActivity";
  private static final boolean DO_XML = false;
  
  private ViewGroup mMainView;
  private SplashView mSplashView;
  private View mContentView;

  private ImageView mImgView;


  private TextView t1;

  private Handler mHandler = new Handler();
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Crashlytics crashlytics = new Crashlytics();
    Fabric.with(this, new Crashlytics());
    Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(this, crashlytics));
    // change the DO_XML variable to switch between code and xml
    if(DO_XML){
      // inflate the view from XML and then get a reference to it
      setContentView(R.layout.activity_splash);
      mMainView = (ViewGroup) findViewById(R.id.main_view);
//      mSplashView = (SplashView) findViewById(R.id.splash_view);
    } else {
      // create the main view
      mMainView = new FrameLayout(getApplicationContext());
      
      // create the splash view
      mSplashView = new SplashView(getApplicationContext());
      mSplashView.setRemoveFromParentOnEnd(true); // remove the SplashView from MainView once animation is completed
      mSplashView.setSplashBackgroundColor(ContextCompat.getColor(SplashActivity.this, R.color.splash_bg)); // the background color of the view
      mSplashView.setRotationRadius(getResources().getDimensionPixelOffset(R.dimen.splash_rotation_radius)); // radius of the big circle that the little circles will rotate on
      mSplashView.setCircleRadius(getResources().getDimensionPixelSize(R.dimen.splash_circle_radius)); // radius of each circle
      mSplashView.setRotationDuration(getResources().getInteger(R.integer.splash_rotation_duration)); // time for one rotation to be completed by the small circles
      mSplashView.setSplashDuration(getResources().getInteger(R.integer.splash_duration)); // total time taken for the circles to merge together and disappear
      mSplashView.setCircleColors(getResources().getIntArray(R.array.splash_circle_colors)); // the colors of each circle in order
      
      // add splash view to the parent view
      mMainView.addView(mSplashView);
      setContentView(mMainView);
    }
    
    // pretend like we are loading data
    startLoadingData();
  }
  
  private void startLoadingData(){
    // finish "loading data" in a random time between 1 and 3 seconds
    Random random = new Random();
    mHandler.postDelayed(new Runnable(){
      @Override
      public void run(){
        onLoadingDataEnded();
      }
    }, 1000 + random.nextInt(2000));
  }
  
  private void onLoadingDataEnded(){
    final Context context = getApplicationContext();

      FrameLayout.LayoutParams llp = new FrameLayout.LayoutParams(400,400);

      mImgView = new ImageView(this);
      mImgView.setImageResource(R.drawable.screen1);
      mImgView.setLayoutParams(llp);
      llp.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
      mMainView.addView(mImgView, 0);


      Typeface tf = Typeface.createFromAsset(getAssets(),
              "fonts/fontawesome-webfont.ttf");

    t1 = new TextView(this);
    t1.setText("Flower World");
    t1.setTextSize(40);
    t1.setTypeface(tf);
//    t1.setTypeface(EasyFonts.ostrichBold(this));

    t1.setGravity(Gravity.CENTER_HORIZONTAL);
    mMainView.addView(t1, 0);

    playAnimation(t1);
    
    // start the splash animation
    mSplashView.splashAndDisappear(new ISplashListener(){
      @Override
      public void onStart(){
        // log the animation start event
        if(BuildConfig.DEBUG){
          Log.d(TAG, "splash started");
        }
      }
      
      @Override
      public void onUpdate(float completionFraction){
        // log animation update events
        if(BuildConfig.DEBUG){
          Log.d(TAG, "splash at " + String.format("%.2f", (completionFraction * 100)) + "%");
        }
      }
      
      @Override
      public void onEnd(){
        // log the animation end event
        if(BuildConfig.DEBUG){
          Log.d(TAG, "splash ended");

          TimerTask task = new TimerTask() {
            @Override
            public void run() {
              Intent i = new Intent(context,MainActivity.class);
              startActivity(i);
              finishScreen();
            }
          };

          Timer t = new Timer();
          t.schedule(task,2000);
        }
        // free the view so that it turns into garbage
        mSplashView = null;
      }
    });
  }
  private void finishScreen(){
    this.finish();
  }
  private void playAnimation(TextView tv){
    Animation animation = AnimationUtils.loadAnimation(this,R.anim.slide_in_bottom_splash);
    animation.reset();
    tv.clearAnimation();
    tv.startAnimation(animation);
  }
}
