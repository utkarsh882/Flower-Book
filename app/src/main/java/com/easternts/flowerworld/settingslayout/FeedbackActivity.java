package com.easternts.flowerworld.settingslayout;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.easternts.flowerworld.R;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //   this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        // getActionBar().hide();
        setContentView(R.layout.activity_feedback);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

    }


    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();

    }


    @Override
    protected void onPause() {
        this.finish();
        super.onPause();
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_feedback,
                    container, false);

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("message/rfc822");

            String PhoneProduct = android.os.Build.PRODUCT;
            String PhoneModel = android.os.Build.MODEL;

            // Android version
            String AndroidVersion = android.os.Build.VERSION.RELEASE;

            share.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.feed_to)});

            share.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
            share.putExtra(Intent.EXTRA_TEXT, getString(R.string.AppVersion) + "\n\nPhone Name : " + PhoneProduct + "\n\nPhone Model : " + PhoneModel + "\n\nAndroid Version : " + AndroidVersion + getString(R.string.body));

            // share.putExtra(Intent.EXTRA_EMAIL, to);
            startActivity(Intent.createChooser(share, getString(R.string.choose_clien)));

            return rootView;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()) {
                case android.R.id.home:

                    getActivity().finish();
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }


}
