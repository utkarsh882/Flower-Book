package com.easternts.flowerworld.quiz.Fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.quiz.Answer;
import com.easternts.flowerworld.quiz.Question;
import com.easternts.flowerworld.quiz.QuizDAL;
import com.easternts.flowerworld.quiz.QuizMainActivity;
import com.easternts.flowerworld.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;


public class FragmentQuesImageAnsButton extends Fragment implements View.OnClickListener {

    QuizMainActivity quizMainActivity = new QuizMainActivity();

    private TextView questiontype6;//show ques

    private ImageView queImgForQueImgAnsBtn;

    public FloatingActionButton quizFab;

    private boolean misFabShowing = false;

    private Animation mScaleIn;

    private int mBtnWidth, mBtnHeight;

    private LinearLayout enteredAnsForQueImgAnsBtn, suggestions1ForQueImgAnsBtn, suggestions2ForQueImgAnsBtn;

    private ArrayList<Button> suggestionButtonList, ansButtonList;
    private ArrayList<Boolean> ansButtonFlags;

    private String suggestion, ans;
    private int tag, anstag, counter = 0;
    private boolean flagQueImgAnsButton;

    public String corectans;

    public boolean mflagQueImgAnsButton;//check clicked ans is true or false

    public boolean isMflagQueImgAnsButton() {
        return mflagQueImgAnsButton;
    }

    String finalans = "";

    private Button ansbtn, suggbtn;

    public FragmentQuesImageAnsButton() {
        // Required empty public constructor
        QuizMainActivity.quizFab.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fragment_ques_image_ans_button, container, false);

        questiontype6 = (TextView) rootview.findViewById(R.id.questiontype6);
        queImgForQueImgAnsBtn = (ImageView) rootview.findViewById(R.id.queImgForQueImgAnsBtn);

        enteredAnsForQueImgAnsBtn = (LinearLayout) rootview.findViewById(R.id.enteredAnsForQueImgAnsBtn);
        suggestions1ForQueImgAnsBtn = (LinearLayout) rootview.findViewById(R.id.suggestions1ForQueImgAnsBtn);
        suggestions2ForQueImgAnsBtn = (LinearLayout) rootview.findViewById(R.id.suggestions2ForQueImgAnsBtn);


        mBtnWidth = (int) getActivity().getResources().getDimension(R.dimen.quiz_queimgansbut_width);
        mBtnHeight = (int) getActivity().getResources().getDimension(R.dimen.quiz_queimgansbut__height);

        //find activity fab button
        quizFab = (FloatingActionButton) getActivity().findViewById(R.id.favourite_floatingActionButton);

        //animate Fab button
        mScaleIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_in);

        suggestionButtonList = new ArrayList<Button>();
        ansButtonList = new ArrayList<Button>();
        ansButtonFlags = new ArrayList<Boolean>();

        setQuestionsAnswers();

        String randomCharArr[] = random(corectans);

        // For Suggestion Buttons
        for (int i = 0; i < 10; i++) {
            suggbtn = new Button(getActivity());
            ViewGroup.LayoutParams buttonParams = new LinearLayout.LayoutParams(mBtnWidth, mBtnHeight, 0.5f);

            suggbtn.setLayoutParams(buttonParams);

            suggbtn.setTag(i);
            suggbtn.setText(randomCharArr[i]);

            suggbtn.setTextSize(12);
            suggbtn.setOnClickListener(handleOnClick(suggbtn, i));
            suggestionButtonList.add(suggbtn);

            suggestions1ForQueImgAnsBtn.addView(suggestionButtonList
                    .get(i));
        }

        for (int i = 10; i < 20; i++) {
            suggbtn = new Button(getActivity());
            ViewGroup.LayoutParams buttonParams = new LinearLayout.LayoutParams(mBtnWidth, mBtnHeight,
                    0.5f);
            suggbtn.setLayoutParams(buttonParams);
            suggbtn.setTag(i);
            suggbtn.setText(randomCharArr[i]);
            suggbtn.setTextSize(12);
            suggbtn.setOnClickListener(handleOnClick(suggbtn, i));
            suggestionButtonList.add(suggbtn);
            suggestions2ForQueImgAnsBtn.addView(suggestionButtonList
                    .get(i));
        }

        // For Answer Buttons
        for (int i = 0; i < corectans.length(); i++) {
            ansbtn = new Button(getActivity());
            // make text bold
            ansbtn.setTypeface(null, Typeface.NORMAL);
            ViewGroup.LayoutParams buttonParams = new LinearLayout.LayoutParams(mBtnWidth, mBtnHeight,
                    0.5f);
            ansbtn.setLayoutParams(buttonParams);
            ansbtn.setId(i);
            ansbtn.setWidth(20);
            ansbtn.setHeight(30);
            ansbtn.setTextSize(12);
            ansButtonList.add(ansbtn);
            ansbtn.setOnClickListener(handleOnClickAns(ansbtn, i));
            enteredAnsForQueImgAnsBtn.addView(ansButtonList.get(i));
        }

        for (int i = 0; i < ansButtonList.size(); i++) {
            ansButtonFlags.add(false);
        }

        return rootview;
    }

    public void setQuestionsAnswers() {

        QuizDAL dal = new QuizDAL(getActivity());

        dal.openDB();

        //Fetch questions by type
        Question q = dal.getQuestionByType(Utils.QUESTION_IMAGE_ANSWER_BUTTON);

        //Fetch ans from ques Id
        ArrayList<Answer> Options = dal.getAnswersByQuestionId(q.getQuesId());

        dal.closeDB();

        questiontype6.setText(getString(q.getQues()));

        Glide.with(getActivity()).load(q.getQuesResource()).into(queImgForQueImgAnsBtn);
        queImgForQueImgAnsBtn.setTag(q.getQuesResource());

        corectans = getString(Options.get(0).getAns());
    }


    @Override
    public void onClick(View v) {

    }

    public void showqueImgAnsButtonAns() {


        finalans = "";
        for (int i = 0; i < ansButtonList.size(); i++) {
            finalans = finalans + ansButtonList.get(i).getText();
        }

        if (finalans.equals(corectans)) {
            mflagQueImgAnsButton = true;
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        } else {
            mflagQueImgAnsButton = false;
            quizFab.setImageResource(R.drawable.next);
            QuizMainActivity.goToNext = false;
        }

    }

    static String[] random(String name) {
        Random rd = new Random();

        String[] finalArr = new String[20];
        Integer[] arr = new Integer[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        // System.out.println(Arrays.toString(arr));
        String[] nameCharArr = name.split("(?!^)");

        for (int j = 0; j < nameCharArr.length; j++) {
            finalArr[arr[j]] = nameCharArr[j];
        }
        char ch;

        Locale locale = Locale.getDefault();
        for (int k = nameCharArr.length; k < 20; k++) {
            ch = (char) (rd.nextInt(26) + 97);
            finalArr[arr[k]] = String.valueOf(ch).toUpperCase(locale);
        }
        return finalArr;
    }


    // For Suggestion Button
    View.OnClickListener handleOnClick(final Button button, final int buttonIndex) {


        return new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    quizFab.setVisibility(View.VISIBLE);
                    quizFab.setImageResource(R.drawable.checkmark);

                    if (!misFabShowing) {
                        animateFAB();
                        misFabShowing = true;
                    }

                    suggestion = button.getText().toString();
                    tag = (Integer) button.getTag();

                    for (int i = 0; i < ansButtonFlags.size(); i++) {
                        flagQueImgAnsButton = ansButtonFlags.get(i);

                        if (flagQueImgAnsButton == false) {
                            counter = i;
                            break;
                        }
                    }

                    if (counter < ansButtonList.size() && suggestion != null
                            && !suggestion.trim().equals("") && flagQueImgAnsButton != true) {

                        button.setText("");
                        ansButtonList.get(counter).setText(suggestion);
                        ansButtonList.get(counter).setTag(tag);
                        ansButtonFlags.set(counter, true);
                        counter++;
                    }
                } catch (Exception e) {
                    Log.e("msg : ", "" + e);
                }
            }
        };
    }


    // For Answer Buttons
    View.OnClickListener handleOnClickAns(final Button button,
                                          final int buttonIndex) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    ans = button.getText().toString();

                    anstag = (Integer) button.getTag();
                    if (counter > 0 && ans != null && !ans.trim().equals("")) {
                        counter--;
                        ansButtonList.get(counter);
                        ansButtonFlags.set(buttonIndex, false);
                        button.setText("");
                        suggestionButtonList.get(anstag).setText(ans);
                    }
                } catch (Exception e) {
                    Log.e("msg : ", "" + e);
                }
            }
        };
    }

    public void animateFAB() {

        quizFab.startAnimation(mScaleIn);
        quizFab.setClickable(true);

    }


}
