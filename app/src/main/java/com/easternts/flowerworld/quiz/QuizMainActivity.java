package com.easternts.flowerworld.quiz;

import android.app.FragmentTransaction;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.quiz.Fragments.Correct;
import com.easternts.flowerworld.quiz.Fragments.FragmentDragDrop;
import com.easternts.flowerworld.quiz.Fragments.FragmentMCQ;
import com.easternts.flowerworld.quiz.Fragments.FragmentMulImage;
import com.easternts.flowerworld.quiz.Fragments.FragmentQuesImage;
import com.easternts.flowerworld.quiz.Fragments.FragmentQuesImageAnsButton;
import com.easternts.flowerworld.quiz.Fragments.FragmentTrueFalse;
import com.easternts.flowerworld.quiz.Fragments.Incorrect;
import com.easternts.flowerworld.quiz.Fragments.ShowAnsQueImgAnsButton;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class QuizMainActivity extends AppCompatActivity implements View.OnClickListener{

    private boolean flag = true;
//    private int type1=1,type2=51,type3=71,type4=76,totalQues = 77;
    private Context context = this;
    private View content;
    private int mRemoveAnsFragment;//remove correct or incorrect fragment
    private MediaPlayer mPlayAnsCorrect, mPlayAnsIncorrect;
    private Vibrator mVibrate;

    public static boolean goToNext = true;
    public static FloatingActionButton quizFab;
    public static String sSaveCorrectAns;

    Correct correct = new Correct();
    Incorrect incorrect = new Incorrect();
    ShowAnsQueImgAnsButton showAnsType6 = new ShowAnsQueImgAnsButton();

    private InterstitialAd mInterstitialAd;
    private AdRequest mAdRequest;
    private AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        android.support.v7.app.ActionBar actionBar =getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assert actionBar != null;

        actionBar.setHomeButtonEnabled(true);


        MobileAds.initialize(getApplicationContext(), Utils.banner_ad_unit_id);
        mAdview = (AdView) findViewById(R.id.adView);
        mAdRequest = new AdRequest.Builder().build();
        mAdview.loadAd(mAdRequest);

        changeStatusBarColor();
        content = findViewById(R.id.content);

        quizFab = (FloatingActionButton) findViewById(R.id.favourite_floatingActionButton);
        quizFab.setOnClickListener(this);

        if(savedInstanceState == null){

            android.app.FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container, new FragmentMCQ(), Utils.FRAGMENT_NAME);
            ft.commit();
        }
        mPlayAnsCorrect = MediaPlayer.create(QuizMainActivity.this,R.raw.applause);
        mPlayAnsIncorrect = MediaPlayer.create(QuizMainActivity.this,R.raw.buzzer_x);
        mVibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    private static int nextQues = 501;

    public void displayNextQues(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(getFragmentManager().findFragmentByTag(Utils.FRAGMENT_NAME));

        if(nextQues == 1){
            goToNext = true;
            ft.replace(R.id.container, new FragmentMCQ(),Utils.FRAGMENT_NAME);
            nextQues = 501;
        }
        else if(nextQues == 501){
            goToNext = true;
            ft.replace(R.id.container, new FragmentMulImage(),Utils.FRAGMENT_NAME);
            nextQues = 1001;
        }
        else if(nextQues == 1001){
            goToNext = true;
            ft.replace(R.id.container, new FragmentQuesImage(),Utils.FRAGMENT_NAME);
            nextQues = 1501;
        }
        else if(nextQues == 1501){
            goToNext = true;
            ft.replace(R.id.container, new FragmentDragDrop(),Utils.FRAGMENT_NAME);
            nextQues = 2001;
        }
        else if(nextQues == 2001){
            goToNext = true;
            ft.replace(R.id.container, new FragmentQuesImageAnsButton(),Utils.FRAGMENT_NAME);
            nextQues = 2501;
        }
        else if(nextQues == 2501){
            goToNext = true;
            ft.replace(R.id.container, new FragmentTrueFalse(),Utils.FRAGMENT_NAME);
            nextQues = 1;
        }

        ft.commit();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.favourite_floatingActionButton){

            if(nextQues == 501) {
                if(goToNext){
                    FragmentMCQ f = (FragmentMCQ) getFragmentManager().findFragmentById(R.id.container);

                    f.showCorectAns();
                    f.tvForMcqOptA.setEnabled(false);
                    f.tvForMcqOptB.setEnabled(false);
                    f.tvForMcqOptC.setEnabled(false);
                    f.tvForMcqOptD.setEnabled(false);

                    if (f.isFlagMcq()) {

                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, correct).commit();

                        mPlayAnsCorrect.start();
                        mRemoveAnsFragment = 1;

                    } else {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, incorrect).commit();

                        mPlayAnsIncorrect.start();
                        mVibrate.vibrate(500);
                        mRemoveAnsFragment = 0;

                    }
                }
                else{

                    displayNextQues();

                    if(mRemoveAnsFragment == 1){
                        getFragmentManager().beginTransaction().remove(correct).commit();
                    }
                    else {
                        getFragmentManager().beginTransaction().remove(incorrect).commit();
                    }
                }


            }
            else if(nextQues == 1001){
                if(goToNext){
                    FragmentMulImage f1 = (FragmentMulImage) getFragmentManager().findFragmentById(R.id.container);

                    f1.showCorrectImage();
                    f1.optionIV1FormulImage.setEnabled(false);
                    f1.optionIV2FormulImage.setEnabled(false);
                    f1.optionIV3FormulImage.setEnabled(false);
                    f1.optionIV4FormulImage.setEnabled(false);

                    if( f1.isMflagMulImg()){
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset,correct).commit();

                        mPlayAnsCorrect.start();
                        mRemoveAnsFragment = 1;
                    }
                    else{
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset,incorrect).commit();

                        mPlayAnsIncorrect.start();
                        mVibrate.vibrate(500);
                        mRemoveAnsFragment = 0;

                    }

                }

                else{
                    displayNextQues();

                    if(mRemoveAnsFragment == 1){
                        getFragmentManager().beginTransaction().remove(correct).commit();
                    }
                    else {
                        getFragmentManager().beginTransaction().remove(incorrect).commit();
                    }
                }
            }


            else if(nextQues == 1501){
                if(goToNext){
                    FragmentQuesImage f3 = (FragmentQuesImage) getFragmentManager().findFragmentById(R.id.container);


                    f3.showCorrectansQuesImage();
                    f3.mTvForQueImgAnsA.setEnabled(false);
                    f3.mTvForQueImgAnsB.setEnabled(false);
                    f3.mTvForQueImgAnsC.setEnabled(false);
                    f3.mTvForQueImgAnsD.setEnabled(false);

                    if( f3.isMflagQueImage()){
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset,correct).commit();

                        mPlayAnsCorrect.start();
                        mRemoveAnsFragment = 1;

                    }
                    else{
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset,incorrect).commit();

                        mPlayAnsIncorrect.start();
                        mVibrate.vibrate(500);
                        mRemoveAnsFragment = 0;

                    }

                }
                else{
                    displayNextQues();

                    if(mRemoveAnsFragment == 1){
                        getFragmentManager().beginTransaction().remove(correct).commit();
                    }
                    else {
                        getFragmentManager().beginTransaction().remove(incorrect).commit();
                    }
                }

            }
            else if(nextQues == 2001){

                if(goToNext){
                    FragmentDragDrop f4 = (FragmentDragDrop) getFragmentManager().findFragmentById(R.id.container);

                    f4.showDragDropAns();

                    if (f4.ismFlagDragDrop()) {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, correct).commit();
                        f4.firstLinear.setBackgroundResource(R.drawable.bordertrue);
                        f4.secondLinear.setBackgroundResource(R.drawable.bordertrue);
                        f4.thirdLinear.setBackgroundResource(R.drawable.bordertrue);
                        f4.fourthlinear.setBackgroundResource(R.drawable.bordertrue);
                        mPlayAnsCorrect.start();
                        mRemoveAnsFragment = 1;

                    } else {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, incorrect).commit();
                        f4.firstLinear.setBackgroundResource(R.drawable.borderwrong);
                        f4.secondLinear.setBackgroundResource(R.drawable.borderwrong);
                        f4.thirdLinear.setBackgroundResource(R.drawable.borderwrong);
                        f4.fourthlinear.setBackgroundResource(R.drawable.borderwrong);
                        mPlayAnsIncorrect.start();
                        mVibrate.vibrate(500);
                        mRemoveAnsFragment = 0;
                    }
                }
                else{
                    displayNextQues();

                    if(mRemoveAnsFragment == 1){
                        getFragmentManager().beginTransaction().remove(correct).commit();
                    }
                    else {
                        getFragmentManager().beginTransaction().remove(incorrect).commit();
                    }
                }

            }

            else if(nextQues == 2501){
                if(goToNext){
                    FragmentQuesImageAnsButton f5 = (FragmentQuesImageAnsButton) getFragmentManager().findFragmentById(R.id.container);
                    f5.showqueImgAnsButtonAns();

                    sSaveCorrectAns = f5.corectans;

                    if (f5.isMflagQueImgAnsButton()) {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, correct).commit();

                        mPlayAnsCorrect.start();
                        mRemoveAnsFragment = 1;

                    } else {

                        sSaveCorrectAns = f5.corectans;
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, incorrect).commit();
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fade_in,R.animator.fade_out).add(R.id.correctAnsSetType6, showAnsType6).commit();

                        mPlayAnsIncorrect.start();
                        mVibrate.vibrate(500);
                        mRemoveAnsFragment = 0;

                    }
                }

                else{
                    displayNextQues();

                    if(mRemoveAnsFragment == 1){
                        getFragmentManager().beginTransaction().remove(correct).commit();
                    }
                    else {
                        getFragmentManager().beginTransaction().remove(incorrect).commit();
                        getFragmentManager().beginTransaction().remove(showAnsType6).commit();
                    }
                }
            }

            else if(nextQues == 1){

                if(goToNext){

                    FragmentTrueFalse f6 = (FragmentTrueFalse) getFragmentManager().findFragmentById(R.id.container);
                    f6.showTrueFalseAns();

                    if (f6.isFlagtruefalse()) {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, correct).commit();

                        mPlayAnsCorrect.start();
                        mRemoveAnsFragment = 1;

                    } else {

                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left).add(R.id.truefalsefragmentset, incorrect).commit();

                        mPlayAnsIncorrect.start();
                        mVibrate.vibrate(500);
                        mRemoveAnsFragment = 0;
                    }
                }
                else{
                    displayNextQues();

                    if(mRemoveAnsFragment == 1){
                        getFragmentManager().beginTransaction().remove(correct).commit();
                    }
                    else {
                        getFragmentManager().beginTransaction().remove(incorrect).commit();
                    }
                }
            }

        }
    }

    public void changeStatusBarColor()
    {
        int primaryDark = ContextCompat.getColor(context,R.color.primary_dark);
        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(primaryDark);
    }

}
