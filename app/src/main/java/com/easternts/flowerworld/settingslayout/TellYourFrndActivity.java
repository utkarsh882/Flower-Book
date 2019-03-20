package com.easternts.flowerworld.settingslayout;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.util.Utils;

public class TellYourFrndActivity extends AppCompatActivity {
    private android.app.ActionBar actionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_your_frnd);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
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
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_tell_your_frnd, container, false);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.message) + Utils.PLAY_STORE_LINK);
            startActivity(Intent.createChooser(intent, getString(R.string.choose_clien)));
            return rootView;
        }


    }
}
