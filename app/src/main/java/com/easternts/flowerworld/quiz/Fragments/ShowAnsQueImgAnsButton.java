package com.easternts.flowerworld.quiz.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.quiz.QuizMainActivity;


public class ShowAnsQueImgAnsButton extends Fragment {

    TextView setCorrectAns;
    private static String s;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_show_ans_que_img_ans_button, container, false);

        setCorrectAns = (TextView) rootview.findViewById(R.id.setCorrectAns);
        QuizMainActivity q = new QuizMainActivity();
        setCorrectAns.setText(toTitleCase(QuizMainActivity.sSaveCorrectAns));


        return rootview;
    }


    public static String toTitleCase(String givenString) {


        StringBuilder result = new StringBuilder();
        for(int i=0 ; i<givenString.length() ; i++) {
            char c = givenString.charAt(i);
            if(i!=0&&Character.isUpperCase(c)) {
                result.append(' ');
            }
           s = String.valueOf(result.append(c));
        }
        return  s;            

    }


}
