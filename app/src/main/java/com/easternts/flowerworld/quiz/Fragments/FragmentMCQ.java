package com.easternts.flowerworld.quiz.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

import com.easternts.flowerworld.quiz.Answer;
import com.easternts.flowerworld.quiz.Question;
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.quiz.QuizDAL;
import com.easternts.flowerworld.quiz.QuizMainActivity;
import com.easternts.flowerworld.util.Utils;


public class FragmentMCQ extends Fragment implements View.OnClickListener {

    private TextView mQueMcq;

    private boolean mIsFabShowing = false;

    private Animation mScaleIn;

    public TextView tvForMcqOptA, tvForMcqOptB, tvForMcqOptC, tvForMcqOptD;

    public FloatingActionButton quizFab;

    public String Ans1,Ans2,Ans3,Ans4,corectans;

    public boolean flagMcq;//check clicked ans is true or false

    public boolean isFlagMcq() {
        return flagMcq;
    }

    QuizMainActivity quizMainActivity = new QuizMainActivity();

    public FragmentMCQ() {
        // Required empty public constructor
        QuizMainActivity.quizFab.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_fragment_mcq, container, false);

        //find activity fab button
        quizFab = (FloatingActionButton) getActivity().findViewById(R.id.favourite_floatingActionButton);

        mQueMcq = (TextView) rootView.findViewById(R.id.question);

        tvForMcqOptA = (TextView) rootView.findViewById(R.id.opttextA);
        tvForMcqOptB = (TextView) rootView.findViewById(R.id.opttextB);
        tvForMcqOptC = (TextView) rootView.findViewById(R.id.opttextC);
        tvForMcqOptD = (TextView) rootView.findViewById(R.id.opttextD);

        setQuestionsAnswers();

        tvForMcqOptA.setOnClickListener(this);
        tvForMcqOptB.setOnClickListener(this);
        tvForMcqOptC.setOnClickListener(this);
        tvForMcqOptD.setOnClickListener(this);

        //animate Fab button
        mScaleIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_in);

        return rootView;
    }

    public void setQuestionsAnswers(){
        //QuizMainActivity o = new QuizMainActivity(getActivity());

        QuizDAL dal = new QuizDAL(getActivity());

        dal.openDB();

        //Fetch questions by type
        Question q = dal.getQuestionByType(Utils.TYPE_NORMAL);

        //Fetch ans from ques Id
        ArrayList<Answer> Options = dal.getAnswersByQuestionId(q.getQuesId());

        dal.closeDB();

        mQueMcq.startAnimation(new AlphaAnimation(0.0f,1.0f));
        mQueMcq.setText(getString(q.getQues()));

        tvForMcqOptA.setText(getString(Options.get(0).getAns()));
        tvForMcqOptB.setText(getString(Options.get(1).getAns()));
        tvForMcqOptC.setText(getString(Options.get(2).getAns()));
        tvForMcqOptD.setText(getString(Options.get(3).getAns()));

        int count = 0;
        for(Answer ans: Options ){
            count++;
            if(ans.getAnsIsCorrect() == Utils.CORRECT){
                    corectans = getActivity().getString(ans.getAns());
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        Ans1 = tvForMcqOptA.getText().toString();
        Ans2 = tvForMcqOptB.getText().toString();
        Ans3 = tvForMcqOptC.getText().toString();
        Ans4 = tvForMcqOptD.getText().toString();

        switch (v.getId()) {
            case R.id.opttextA:
                tvForMcqOptA.setBackgroundResource(R.drawable.rounded_corner_correctans);
                tvForMcqOptB.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptC.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptD.setBackgroundColor(Color.TRANSPARENT);

                quizFab.setVisibility(View.VISIBLE);
                quizFab.setImageResource(R.drawable.checkmark);
                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                flagMcq = Ans1.equals(corectans);
                break;

            case R.id.opttextB:
                tvForMcqOptB.setBackgroundResource(R.drawable.rounded_corner_correctans);
                tvForMcqOptA.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptC.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptD.setBackgroundColor(Color.TRANSPARENT);

                quizFab.setVisibility(View.VISIBLE);
                quizFab.setImageResource(R.drawable.checkmark);

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                flagMcq = Ans2.equals(corectans);
                break;

            case R.id.opttextC:
                tvForMcqOptC.setBackgroundResource(R.drawable.rounded_corner_correctans);
                tvForMcqOptB.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptA.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptD.setBackgroundColor(Color.TRANSPARENT);

                quizFab.setVisibility(View.VISIBLE);
                quizFab.setImageResource(R.drawable.checkmark);

                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                flagMcq = Ans3.equals(corectans);
                break;

            case R.id.opttextD:
                tvForMcqOptD.setBackgroundResource(R.drawable.rounded_corner_correctans);
                tvForMcqOptB.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptC.setBackgroundColor(Color.TRANSPARENT);
                tvForMcqOptA.setBackgroundColor(Color.TRANSPARENT);

                quizFab.setVisibility(View.VISIBLE);
                quizFab.setImageResource(R.drawable.checkmark);
                if(!mIsFabShowing){
                    animateFAB();
                    mIsFabShowing = true;
                }

                flagMcq = Ans4.equals(corectans);
                break;

            default:
                break;
        }
    }

    public void showCorectAns(){

        if(Ans1.equals(corectans)){
            tvForMcqOptA.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(Ans2.equals(corectans)){
            tvForMcqOptB.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(Ans3.equals(corectans)){
            tvForMcqOptC.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
        else if(Ans4.equals(corectans)){
            tvForMcqOptD.setBackgroundColor(getResources().getColor(R.color.answer_color_correct));
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }
    }

    public void animateFAB(){

            quizFab.startAnimation(mScaleIn);
            quizFab.setClickable(true);

    }
}
