package com.easternts.flowerworld.quiz.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.quiz.Answer;
import com.easternts.flowerworld.quiz.Question;
import com.easternts.flowerworld.quiz.QuizDAL;
import com.easternts.flowerworld.quiz.QuizMainActivity;
import com.easternts.flowerworld.util.Utils;

import java.util.ArrayList;

public class FragmentTrueFalse extends Fragment implements View.OnClickListener {

    QuizMainActivity quizMainActivity = new QuizMainActivity();

    private TextView mQuestionTrueFalse;

    Button buttonTrue,buttonFalse;

    public FloatingActionButton quizFab;

    private Animation mScaleIn;

    private int mCorrectAns;

    public boolean flagtruefalse;

    private int mSaveButtonSpace;

    private boolean mIsFabShowing = false;

    public boolean isFlagtruefalse() {
        return flagtruefalse;
    }

    public FragmentTrueFalse() {
        // Required empty public constructor
        QuizMainActivity.quizFab.setVisibility(View.GONE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_fragment_true_false, container, false);

        mQuestionTrueFalse = (TextView) rootview.findViewById(R.id.questiontype6);

        buttonTrue = (Button) rootview.findViewById(R.id.buttonTrue);
        buttonFalse = (Button) rootview.findViewById(R.id.buttonFalse);

        quizFab = (FloatingActionButton) getActivity().findViewById(R.id.favourite_floatingActionButton);

        setQuestionsAnswers();


        buttonTrue.setOnClickListener(this);
        buttonFalse.setOnClickListener(this);

        //animate Fab button
        mScaleIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_in);


        return rootview;
    }

    public void setQuestionsAnswers(){
        QuizDAL dal = new QuizDAL(getActivity());

        dal.openDB();

        //Fetch questions by type
        Question q = dal.getQuestionByType(Utils.QUESTION_TRUE_FALSE);

        //Fetch ans from ques Id
        ArrayList<Answer> Options = dal.getAnswersByQuestionId(q.getQuesId());


        dal.closeDB();

        mQuestionTrueFalse.setText(getString(q.getQues()));

        mCorrectAns = Options.get(0).getAnsIsCorrect();
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.buttonTrue){

            if(!mIsFabShowing){
                animateFAB();
                mIsFabShowing = true;
            }

            quizFab.setVisibility(View.VISIBLE);
            quizFab.setImageResource(R.drawable.checkmark);

            buttonTrue.setBackgroundResource(R.drawable.select_ans_back);
            buttonFalse.setBackgroundResource(R.drawable.drawable_name);

            mSaveButtonSpace = 1;
        }

        else if(v.getId() == R.id.buttonFalse){

            if(!mIsFabShowing){
                animateFAB();
                mIsFabShowing = true;
            }

            quizFab.setVisibility(View.VISIBLE);
            quizFab.setImageResource(R.drawable.checkmark);

            buttonFalse.setBackgroundResource(R.drawable.select_ans_back);
            buttonTrue.setBackgroundResource(R.drawable.drawable_name);

            mSaveButtonSpace = 0;
        }


    }

    public void showTrueFalseAns(){

        buttonFalse.setEnabled(false);
        buttonTrue.setEnabled(false);

        if(mCorrectAns == mSaveButtonSpace){

            flagtruefalse = true;
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;

        }

        else{

            flagtruefalse = false;
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;

        }
    }

    public void animateFAB(){

        quizFab.startAnimation(mScaleIn);
        quizFab.setClickable(true);

    }
}
