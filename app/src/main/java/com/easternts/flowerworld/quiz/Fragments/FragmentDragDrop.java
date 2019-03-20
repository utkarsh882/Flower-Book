package com.easternts.flowerworld.quiz.Fragments;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.easternts.flowerworld.quiz.Answer;
import com.easternts.flowerworld.quiz.Question;
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.quiz.QuizDAL;
import com.easternts.flowerworld.quiz.QuizMainActivity;
import com.easternts.flowerworld.util.Utils;

public class FragmentDragDrop extends Fragment {

    private ImageView mImage1, mImage2, mImage3, mImage4;
    private TextView mTvForOpt1, mTvForOpt2, mTvForOpt3, mTvForOpt4;
    private TextView mQueDragDrop;
    private String[] mTrueAns = new String[4];

    private Animation mScaleIn;
    private boolean mIsFabShowing = false;

    private ArrayList<Answer> mAnswerList;
    private ArrayList<Boolean> mDropArray;

    public TableLayout firstLinear, secondLinear, thirdLinear, fourthlinear;
    public TableLayout bottomlinear1, bottomlinear2, bottomlinear3, bottomlinear4;
    public FloatingActionButton quizFab;

    public boolean mFlagDragDrop;

    public boolean ismFlagDragDrop() {
        return mFlagDragDrop;
    }

    QuizMainActivity quizMainActivity = new QuizMainActivity();

    public FragmentDragDrop() {
        // Required empty public constructor
        QuizMainActivity.quizFab.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_drag_drop, container, false);

        mQueDragDrop = (TextView) rootView.findViewById(R.id.dragAndDropQuestion);

        quizFab = (FloatingActionButton) getActivity().findViewById(R.id.favourite_floatingActionButton);

        //animate Fab button
        mScaleIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_in);

        mDropArray = new ArrayList<Boolean>(Collections.nCopies(4, false));

        mImage1 = (ImageView) rootView.findViewById(R.id.image1);
        mImage2 = (ImageView) rootView.findViewById(R.id.image2);
        mImage3 = (ImageView) rootView.findViewById(R.id.image3);
        mImage4 = (ImageView) rootView.findViewById(R.id.image4);

        mTvForOpt1 = (TextView) rootView.findViewById(R.id.text1);
        mTvForOpt2 = (TextView) rootView.findViewById(R.id.text2);
        mTvForOpt3 = (TextView) rootView.findViewById(R.id.text3);
        mTvForOpt4 = (TextView) rootView.findViewById(R.id.text4);

        mTvForOpt1.setOnLongClickListener(new MyClickListener());
        mTvForOpt2.setOnLongClickListener(new MyClickListener());
        mTvForOpt3.setOnLongClickListener(new MyClickListener());
        mTvForOpt4.setOnLongClickListener(new MyClickListener());

        firstLinear = (TableLayout) rootView.findViewById(R.id.firstlinear);
        secondLinear = (TableLayout) rootView.findViewById(R.id.secondlinear);
        thirdLinear = (TableLayout) rootView.findViewById(R.id.thirdlinear);
        fourthlinear = (TableLayout) rootView.findViewById(R.id.fourthlinear);

        firstLinear.setOnDragListener(new MyDragListener());
        secondLinear.setOnDragListener(new MyDragListener());
        thirdLinear.setOnDragListener(new MyDragListener());
        fourthlinear.setOnDragListener(new MyDragListener());

        bottomlinear1 = (TableLayout) rootView.findViewById(R.id.bottomlinear1);
        bottomlinear2 = (TableLayout) rootView.findViewById(R.id.bottomlinear2);
        bottomlinear3 = (TableLayout) rootView.findViewById(R.id.bottomlinear3);
        bottomlinear4 = (TableLayout) rootView.findViewById(R.id.bottomlinear4);

        bottomlinear1.setOnDragListener(new MyDragListener());
        bottomlinear2.setOnDragListener(new MyDragListener());
        bottomlinear3.setOnDragListener(new MyDragListener());
        bottomlinear4.setOnDragListener(new MyDragListener());

        setupQuestionAnswers();

        return rootView;
    }

    public void setupQuestionAnswers() {
        QuizDAL dal = new QuizDAL(getActivity());

        dal.openDB();

        Question q = dal.getQuestionByType(Utils.TYPE_DRAGDROP);

        mAnswerList = dal.getAnswersByQuestionId(q.getQuesId());

        dal.closeDB();

        //get and set question
        mQueDragDrop.setText(getString(q.getQues()));

        Log.e("Image:", "" + mAnswerList.get(0).getAnsResource());
        Log.e("Data:", "" + getActivity().getString(mAnswerList.get(0).getAns()));
        Log.e("Data:", "" + getActivity().getString(mAnswerList.get(1).getAns()));
        Log.e("Data:", "" + getActivity().getString(mAnswerList.get(2).getAns()));
        Log.e("Data:", "" + getActivity().getString(mAnswerList.get(3).getAns()));

        //set true answers in array-list before they are changed
        for(int i = 0; i < 4; i++){
            mTrueAns[i] = getActivity().getString(mAnswerList.get(i).getAns());
        }

        //get images from ans list
        Glide.with(getActivity()).load(mAnswerList.get(0).getAnsResource()).into(mImage1);
        Glide.with(getActivity()).load(mAnswerList.get(1).getAnsResource()).into(mImage2);
        Glide.with(getActivity()).load(mAnswerList.get(2).getAnsResource()).into(mImage3);
        Glide.with(getActivity()).load(mAnswerList.get(3).getAnsResource()).into(mImage4);

        ArrayList<Integer> numbers = generateRandomNumber();//set up random answers
        mTvForOpt1.setText(getActivity().getString(mAnswerList.get(numbers.get(0)).getAns()));
        mTvForOpt1.setTag(getActivity().getString(mAnswerList.get(numbers.get(0)).getAns()));

        mTvForOpt2.setText(getActivity().getString(mAnswerList.get(numbers.get(1)).getAns()));
        mTvForOpt2.setTag(getActivity().getString(mAnswerList.get(numbers.get(1)).getAns()));

        mTvForOpt3.setText(getActivity().getString(mAnswerList.get(numbers.get(2)).getAns()));
        mTvForOpt3.setTag(getString(mAnswerList.get(numbers.get(2)).getAns()));

        mTvForOpt4.setText(getActivity().getString(mAnswerList.get(numbers.get(3)).getAns()));
        mTvForOpt4.setTag(getActivity().getString(mAnswerList.get(numbers.get(3)).getAns()));


    }

    private final class MyClickListener implements View.OnLongClickListener {

        // called when the item is long-clicked
        @Override
        public boolean onLongClick(View textView) {
            // create it from the object's tag
            ClipData.Item item = new ClipData.Item(
                    (CharSequence) textView.getTag());

            String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
            ClipData data = new ClipData(textView.getTag().toString(),
                    mimeTypes, item);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(textView);

            textView.startDrag(data, // data to be dragged
                    shadowBuilder, // drag shadow
                    textView, // local data about the drag and drop operation
                    0 // no needed flags
            );
            textView.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View LayoutInWhichItemIsDropped, DragEvent event) {

            // Handles each of the expected events
            switch (event.getAction()) {

                // signal for the start of a drag and drop operation.
                case DragEvent.ACTION_DRAG_STARTED:

                    if(!mIsFabShowing){
                        animateFAB();
                        quizFab.setVisibility(View.VISIBLE);
                        quizFab.setImageResource(R.drawable.checkmark);
                        mIsFabShowing = true;
                    }

                    break;
                // the drag point has entered the bounding box of the View
                case DragEvent.ACTION_DRAG_ENTERED:

                    // change the shape of the view
                    break;

                // the user has moved the drag shadow outside the bounding box of
                // the View
                case DragEvent.ACTION_DRAG_EXITED:

                    // the shape of the view back to normal
                    break;

                // drag shadow has been released,the drag point is within the
                // bounding box of the View
                case DragEvent.ACTION_DROP:

                    View textView = (View) event.getLocalState();

                    ViewGroup LayoutFromWhereItemDragged = (ViewGroup) textView
                            .getParent();
                    String source = (String) LayoutFromWhereItemDragged.getTag();
                    String dest = (String) LayoutInWhichItemIsDropped.getTag();


                    if (source == null || !source.equals(dest))

                        if (LayoutInWhichItemIsDropped == firstLinear) {
                            performTransferAction(LayoutFromWhereItemDragged, LayoutInWhichItemIsDropped, textView, mAnswerList.get(0).getAns(), 0);
                        } else if (LayoutInWhichItemIsDropped == secondLinear) {
                            performTransferAction(LayoutFromWhereItemDragged, LayoutInWhichItemIsDropped, textView, mAnswerList.get(1).getAns(), 1);
                        } else if (LayoutInWhichItemIsDropped == thirdLinear) {
                            performTransferAction(LayoutFromWhereItemDragged, LayoutInWhichItemIsDropped, textView, mAnswerList.get(2).getAns(), 2);
                        } else if (LayoutInWhichItemIsDropped == fourthlinear) {
                            performTransferAction(LayoutFromWhereItemDragged, LayoutInWhichItemIsDropped, textView, mAnswerList.get(3).getAns(), 3);
                        } else {
                            Context context = getActivity();
                            Toast.makeText(context, "You can't drop the text here", Toast.LENGTH_LONG).show();
                        }
                    textView.setVisibility(View.VISIBLE);

                    break;

                // the drag and drop operation has concluded.
                case DragEvent.ACTION_DRAG_ENDED:



                    if (!(LayoutInWhichItemIsDropped == firstLinear || LayoutInWhichItemIsDropped == secondLinear || LayoutInWhichItemIsDropped == thirdLinear || LayoutInWhichItemIsDropped == fourthlinear)) {
                        // code for [you cannot drop the text outside the layout]

                        View textview = (View) event.getLocalState();
                        // ViewGroup LyaoutInWhichItemIsDropped1 = (ViewGroup)
                        // textview.getParent();
                        // LyaoutInWhichItemIsDropped1.removeView(textview);
                        // LyaoutInWhichItemIsDropped1.addView(textview);
                        textview.setVisibility(View.VISIBLE);
                        // textView.setLayoutParams(params);
                    }
                    break;
            }
            return true;
        }

        // Reset the Layout Of Drag and Drop.
        private void resetDropFlagFromWhereDragged(
                ViewGroup LayoutFromWhereItemDragged) {
            if (LayoutFromWhereItemDragged.equals(firstLinear))
                mDropArray.set(0, false);
            else if (LayoutFromWhereItemDragged.equals(secondLinear))
                mDropArray.set(1, false);
            else if (LayoutFromWhereItemDragged.equals(thirdLinear))
                mDropArray.set(2, false);
            else if (LayoutFromWhereItemDragged.equals(fourthlinear))
                mDropArray.set(3, false);
        }

        // Check the image with particular option which is dragged on it.
        private void performTransferAction(
                ViewGroup LayoutFromWhereItemDragged,
                View LayoutInWhichItemIsDropped, View textView, int ansText,
                int position) {
            String ss = (String) LayoutInWhichItemIsDropped.getTag();

            if (ss == null || ss.equals("") || ss.equals("null")) {
                LayoutFromWhereItemDragged.removeView(textView);
                LayoutFromWhereItemDragged.setTag("");
                resetDropFlagFromWhereDragged(LayoutFromWhereItemDragged);
                ((TableLayout) LayoutInWhichItemIsDropped).addView(textView);
                LayoutInWhichItemIsDropped.setTag(getActivity().getString(ansText));
                mDropArray.set(position, (LayoutInWhichItemIsDropped.getTag()
                        .equals(textView.getTag().toString())));
            }
        }

    }


    public void animateFAB(){

        quizFab.startAnimation(mScaleIn);
        quizFab.setClickable(true);

    }

    public void showDragDropAns() {

        QuizMainActivity quizMainActivity = new QuizMainActivity();
        Boolean check = true;
        quizFab.setImageResource(R.drawable.next);
        QuizMainActivity.goToNext = false;

        for (int i = 0; i < mDropArray.size(); i++) {
            if (!mDropArray.get(i)) {
                check = false;
                break;
            }
        }
        if (check) {
            mFlagDragDrop = true;

        } else {

            mFlagDragDrop = false;

            TextView t1 = new TextView(getActivity());
            TextView t2 = new TextView(getActivity());
            TextView t3 = new TextView(getActivity());
            TextView t4 = new TextView(getActivity());

            bottomlinear1.removeView(mTvForOpt1);
            bottomlinear2.removeView(mTvForOpt2);
            bottomlinear3.removeView(mTvForOpt3);
            bottomlinear4.removeView(mTvForOpt4);

            t1.setText(mTrueAns[0]);
            t2.setText(mTrueAns[1]);
            t3.setText(mTrueAns[2]);
            t4.setText(mTrueAns[3]);

            t1.setGravity(Gravity.CENTER);
            t2.setGravity(Gravity.CENTER);
            t3.setGravity(Gravity.CENTER);
            t4.setGravity(Gravity.CENTER);

            bottomlinear1.addView(t1);
            bottomlinear2.addView(t2);
            bottomlinear3.addView(t3);
            bottomlinear4.addView(t4);

            bottomlinear1.setBackgroundResource(R.drawable.bordertrue);
            bottomlinear2.setBackgroundResource(R.drawable.bordertrue);
            bottomlinear3.setBackgroundResource(R.drawable.bordertrue);
            bottomlinear4.setBackgroundResource(R.drawable.bordertrue);

        }
    }


    private ArrayList<Integer> generateRandomNumber() {
        int rnd;
        Random rand = new Random();
        int[] randNo = new int[4];
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int k = 0; k < 4; k++) {
            rnd = rand.nextInt(4) + 0;
            if (k == 0) {
                randNo[0] = rnd;
                numbers.add(randNo[0]);
            } else {
                while (numbers.contains(new Integer(rnd))) {
                    rnd = rand.nextInt(4) + 0;
                }
                randNo[k] = rnd;
                numbers.add(randNo[k]);
            }
        }
        return numbers;
    }
}
