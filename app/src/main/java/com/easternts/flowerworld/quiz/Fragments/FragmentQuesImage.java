package com.easternts.flowerworld.quiz.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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


public class FragmentQuesImage extends Fragment implements View.OnClickListener {

    private ImageView mQueMulImag;

    private String mAns1IsClicked, mAns2IsClicked, mAns3IsClicked, mAns4IsClicked;

    private boolean mIsFabShowing = false;

    private Animation mScaleIn;

    public TextView mTvForQueImg, mTvForQueImgAnsA, mTvForQueImgAnsB, mTvForQueImgAnsC, mTvForQueImgAnsD;

    public String correctansquesimage;

    public boolean mflagQueImage;

    public boolean isMflagQueImage() {
        return mflagQueImage;
    }

    public FloatingActionButton quizFab;

    QuizMainActivity quizMainActivity = new QuizMainActivity();

    public FragmentQuesImage() {
        // Required empty public constructor
        QuizMainActivity.quizFab.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_fragment_ques_image, container, false);

        mQueMulImag  = (ImageView) rootview.findViewById(R.id.flower_ques_image);
        mTvForQueImg  = (TextView) rootview.findViewById(R.id.flower_ques_image_text);
        mTvForQueImgAnsA = (TextView) rootview.findViewById(R.id.imageansA);
        mTvForQueImgAnsB = (TextView) rootview.findViewById(R.id.imageansB);
        mTvForQueImgAnsC = (TextView) rootview.findViewById(R.id.imageansC);
        mTvForQueImgAnsD = (TextView) rootview.findViewById(R.id.imageansD);

        quizFab = (FloatingActionButton) getActivity().findViewById(R.id.favourite_floatingActionButton);

        //animate Fab button
        mScaleIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_in);


        setQuestionsAnswers();

        mTvForQueImgAnsA.setOnClickListener(this);
        mTvForQueImgAnsB.setOnClickListener(this);
        mTvForQueImgAnsC.setOnClickListener(this);
        mTvForQueImgAnsD.setOnClickListener(this);

        return rootview;
    }

    private void setQuestionsAnswers() {
        QuizDAL dal = new QuizDAL(getActivity());

        dal.openDB();

        Question q = dal.getQuestionByType(Utils.TYPE_QUES_IMAGE);
        Log.e("Ques Id","" + q.getQuesId());

        ArrayList<Answer> Options = dal.getAnswersByQuestionId(q.getQuesId());

        dal.closeDB();

        mTvForQueImg.setText(getString(q.getQues()));
        Glide.with(getActivity()).load(q.getQuesResource()).into(mQueMulImag);
        mQueMulImag.setTag(q.getQuesResource());

        mTvForQueImgAnsA.setText(getString(Options.get(0).getAns()));
        mTvForQueImgAnsB.setText(getString(Options.get(1).getAns()));
        mTvForQueImgAnsC.setText(getString(Options.get(2).getAns()));
        mTvForQueImgAnsD.setText(getString(Options.get(3).getAns()));

        int count = 0;
        for(Answer ans: Options ){
            count++;
            if(ans.getAnsIsCorrect() == Utils.CORRECT){
                correctansquesimage = getActivity().getString(ans.getAns());
                break;
            }

        }
    }


    @Override
    public void onClick(View v) {

        mAns1IsClicked = mTvForQueImgAnsA.getText().toString();
        mAns2IsClicked = mTvForQueImgAnsB.getText().toString();
        mAns3IsClicked = mTvForQueImgAnsC.getText().toString();
        mAns4IsClicked = mTvForQueImgAnsD.getText().toString();

        switch (v.getId()){
            case R.id.imageansA:

                mTvForQueImgAnsA.setBackgroundResource(R.drawable.rounded_corner_correctans);
                mTvForQueImgAnsB.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsC.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsD.setBackgroundColor(Color.TRANSPARENT);

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                if(mAns1IsClicked.equals(correctansquesimage)){
                    mflagQueImage = true;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                else{
                    mflagQueImage = false;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                break;

            case R.id.imageansB:

                mTvForQueImgAnsB.setBackgroundResource(R.drawable.rounded_corner_correctans);
                mTvForQueImgAnsA.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsC.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsD.setBackgroundColor(Color.TRANSPARENT);

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                if(mAns2IsClicked.equals(correctansquesimage)){
                    mflagQueImage = true;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                else{
                    mflagQueImage = false;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                break;

            case R.id.imageansC:

                mTvForQueImgAnsC.setBackgroundResource(R.drawable.rounded_corner_correctans);
                mTvForQueImgAnsB.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsA.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsD.setBackgroundColor(Color.TRANSPARENT);

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                if(mAns3IsClicked.equals(correctansquesimage)){
                    mflagQueImage = true;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                else{
                    mflagQueImage = false;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                break;

            case R.id.imageansD:

                mTvForQueImgAnsD.setBackgroundResource(R.drawable.rounded_corner_correctans);
                mTvForQueImgAnsB.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsC.setBackgroundColor(Color.TRANSPARENT);
                mTvForQueImgAnsA.setBackgroundColor(Color.TRANSPARENT);

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                if(mAns4IsClicked.equals(correctansquesimage)){
                    mflagQueImage = true;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                else{
                    mflagQueImage = false;
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                }
                break;

            default:
                break;

        }

    }

    public void showCorrectansQuesImage(){

        QuizMainActivity quizMainActivity = new QuizMainActivity();

        if(mAns1IsClicked.equals(correctansquesimage)){
            mTvForQueImgAnsA.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(mAns2IsClicked.equals(correctansquesimage)){
            mTvForQueImgAnsB.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(mAns3IsClicked.equals(correctansquesimage)){
            mTvForQueImgAnsC.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(mAns4IsClicked.equals(correctansquesimage)){
            mTvForQueImgAnsD.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
    }

    public void animateFAB(){

        quizFab.startAnimation(mScaleIn);
        quizFab.setClickable(true);

    }
}
