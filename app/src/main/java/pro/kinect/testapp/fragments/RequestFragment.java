package pro.kinect.testapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pro.kinect.testapp.R;
import pro.kinect.testapp.activities.RequestActivity;

import static pro.kinect.testapp.utils.Constants.REQUEST_INTENT_DATA_KEY;

/**
 * Created by Arina on 03.10.2017
 */

public class RequestFragment extends Fragment {

    private static final int REQUEST_ACTIVITY_RESULT_CODE = 0;

    private TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_request, container, false);
        rootView.findViewById(R.id.do_request_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(RequestFragment.this.getActivity(),
                        RequestActivity.class), REQUEST_ACTIVITY_RESULT_CODE);
            }
        });
        result = (TextView) rootView.findViewById(R.id.result);
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ACTIVITY_RESULT_CODE){
            result.setText(data.getStringExtra(REQUEST_INTENT_DATA_KEY));
        }
    }
}
