package com.easternts.flowerworld.quiz.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


import com.easternts.flowerworld.quiz.Answer;
import com.easternts.flowerworld.quiz.Question;
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.quiz.QuizDAL;
import com.easternts.flowerworld.quiz.QuizMainActivity;
import com.easternts.flowerworld.util.Utils;


public class FragmentMulImage extends Fragment implements View.OnClickListener {

    private TextView mQuestionForMulImage;

    private FrameLayout mImage1Layout, mImage2Layout, mImage3Layout, mImage4Layout;

    private String mAns1IsClicked, mAns2IsClicked, mAns3IsClicked, mAns4IsClicked,correctans;

    private boolean mIsFabShowing = false;

    private Animation mScaleIn;

    public ImageView optionIV1FormulImage, optionIV2FormulImage, optionIV3FormulImage, optionIV4FormulImage;

    public FloatingActionButton quizFab;

    public boolean mflagMulImg;

    public boolean isMflagMulImg() {
        return mflagMulImg;
    }

    QuizMainActivity quizMainActivity = new QuizMainActivity();

    public FragmentMulImage() {
        // Required empty public constructor
        QuizMainActivity.quizFab.setVisibility(View.GONE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fragment_mul_image, container, false);

        quizFab = (FloatingActionButton) getActivity().findViewById(R.id.favourite_floatingActionButton);

        //animate Fab button
        mScaleIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_in);

        mQuestionForMulImage = (TextView) rootview.findViewById(R.id.textViewQuestionFormulImage);

        optionIV1FormulImage = (ImageView) rootview.findViewById(R.id.imgBtnOption1FormulImage);
        optionIV2FormulImage = (ImageView) rootview.findViewById(R.id.imgBtnOption2FormulImage);
        optionIV3FormulImage = (ImageView) rootview.findViewById(R.id.imgBtnOption3FormulImage);
        optionIV4FormulImage = (ImageView) rootview.findViewById(R.id.imgBtnOption4FormulImage);

        mImage1Layout = (FrameLayout) rootview.findViewById(R.id.firstFrameLayoutFormulImage);
        mImage2Layout = (FrameLayout) rootview.findViewById(R.id.secondFrameLayoutFormulImage);
        mImage3Layout = (FrameLayout) rootview.findViewById(R.id.thirdFrameLayoutFormulImage);
        mImage4Layout = (FrameLayout) rootview.findViewById(R.id.forthFrameLayoutFormulImage);

        setQuestionsAnswers();

        optionIV1FormulImage.setOnClickListener(this);
        optionIV2FormulImage.setOnClickListener(this);
        optionIV3FormulImage.setOnClickListener(this);
        optionIV4FormulImage.setOnClickListener(this);

        return rootview;
    }

    private void setQuestionsAnswers() {
        QuizDAL dal = new QuizDAL(getActivity());

        dal.openDB();

        Question q = dal.getQuestionByType(Utils.TYPE_IMAGE);

        ArrayList<Answer> Options = dal.getAnswersByQuestionId(q.getQuesId());
        dal.closeDB();

        mQuestionForMulImage.setText(getString(q.getQues()));

        Glide.with(getActivity()).load(Options.get(0).getAns()).into(optionIV1FormulImage);
        Glide.with(getActivity()).load(Options.get(1).getAns()).into(optionIV2FormulImage);
        Glide.with(getActivity()).load(Options.get(2).getAns()).into(optionIV3FormulImage);
        Glide.with(getActivity()).load(Options.get(3).getAns()).into(optionIV4FormulImage);

       /* Glide.with(getActivity()).load(Options.get(3).getAns()).listener(new RequestListener<Integer, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                Log.e("exc4", e.getMessage());
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(optionIV4FormulImage);*/

        optionIV1FormulImage.setTag(Options.get(0).getAns());

        optionIV2FormulImage.setTag(Options.get(1).getAns());

        optionIV3FormulImage.setTag(Options.get(2).getAns());

        optionIV4FormulImage.setTag(Options.get(3).getAns());


        // Get the correct Answer
        int count = 0;
        for (Answer answer : Options) {
            count++;
            if (answer.getAnsIsCorrect() == Utils.CORRECT) {
                correctans = "" + answer.getAns();
                Log.e("correct","" + correctans);
                break;
            }
        }

    }

    @Override
    public void onClick(View v) {

        mAns1IsClicked = optionIV1FormulImage.getTag().toString();
        mAns2IsClicked = optionIV2FormulImage.getTag().toString();
        mAns3IsClicked = optionIV3FormulImage.getTag().toString();
        mAns4IsClicked = optionIV4FormulImage.getTag().toString();

        switch (v.getId()) {

            case R.id.imgBtnOption1FormulImage:

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }
                if (mAns1IsClicked.equals(correctans)) {

                    mflagMulImg = true;
                    if(optionIV1FormulImage.getAlpha()==1f)
                    {
                        optionIV1FormulImage.setAlpha(0.5f);
                        optionIV2FormulImage.setAlpha(1f);
                        optionIV3FormulImage.setAlpha(1f);
                        optionIV4FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);

                    }


                } else {

                    mflagMulImg = false;
                    if(optionIV1FormulImage.getAlpha()==1f)
                    {
                        optionIV1FormulImage.setAlpha(0.5f);
                        optionIV2FormulImage.setAlpha(1f);
                        optionIV3FormulImage.setAlpha(1f);
                        optionIV4FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);

                    }

                }
                break;

            case R.id.imgBtnOption2FormulImage:

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                if (mAns2IsClicked.equals(correctans)) {

                    mflagMulImg = true;
                    if(optionIV2FormulImage.getAlpha()==1f)
                    {

                        optionIV2FormulImage.setAlpha(0.5f);
                        optionIV1FormulImage.setAlpha(1f);
                        optionIV3FormulImage.setAlpha(1f);
                        optionIV4FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);

                    }

                } else {

                    mflagMulImg = false;
                    if(optionIV2FormulImage.getAlpha()==1f)
                    {

                        optionIV2FormulImage.setAlpha(0.5f);
                        optionIV1FormulImage.setAlpha(1f);
                        optionIV3FormulImage.setAlpha(1f);
                        optionIV4FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);

                    }

                }
                break;
            case R.id.imgBtnOption3FormulImage:
                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }
                if (mAns3IsClicked.equals(correctans)) {

                    mflagMulImg = true;
                    if(optionIV3FormulImage.getAlpha()==1f)
                    {

                        optionIV3FormulImage.setAlpha(0.5f);
                        optionIV1FormulImage.setAlpha(1f);
                        optionIV2FormulImage.setAlpha(1f);
                        optionIV4FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);
                    }

                } else {

                    mflagMulImg = false;
                    if(optionIV3FormulImage.getAlpha()==1f)
                    {

                        optionIV3FormulImage.setAlpha(0.5f);
                        optionIV1FormulImage.setAlpha(1f);
                        optionIV2FormulImage.setAlpha(1f);
                        optionIV4FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);

                    }

                }
                break;
            case R.id.imgBtnOption4FormulImage:
                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }
                if (mAns4IsClicked.equals(correctans)) {


                    mflagMulImg = true;
                    if(optionIV4FormulImage.getAlpha()==1f)
                    {

                        optionIV4FormulImage.setAlpha(0.5f);
                        optionIV1FormulImage.setAlpha(1f);
                        optionIV2FormulImage.setAlpha(1f);
                        optionIV3FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);

                    }

                } else {

                    mflagMulImg = false;
                    if(optionIV4FormulImage.getAlpha()==1f)
                    {
                        optionIV4FormulImage.setAlpha(0.5f);
                        optionIV1FormulImage.setAlpha(1f);
                        optionIV2FormulImage.setAlpha(1f);
                        optionIV3FormulImage.setAlpha(1f);

                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);

                    }

                }
                break;

            default:
                break;
        }
    }

    public void showCorrectImage(){


        if(mAns1IsClicked.equals(correctans)){
            ImageView i = new ImageView(getActivity());
            i.setImageResource(R.drawable.true1);
            mImage1Layout.addView(i);
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
         }
        else if(mAns2IsClicked.equals(correctans)){
            ImageView i = new ImageView(getActivity());
            i.setImageResource(R.drawable.true1);
            mImage2Layout.addView(i);
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(mAns3IsClicked.equals(correctans)){
            ImageView i = new ImageView(getActivity());
            i.setImageResource(R.drawable.true1);
            mImage3Layout.addView(i);
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(mAns4IsClicked.equals(correctans)){
            ImageView i = new ImageView(getActivity());
            i.setImageResource(R.drawable.true1);
            mImage4Layout.addView(i);
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
    }

    public void animateFAB(){

        quizFab.startAnimation(mScaleIn);
        quizFab.setClickable(true);

    }
}
