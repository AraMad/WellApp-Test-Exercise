package pro.kinect.testapp.fragments;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pro.kinect.testapp.R;

/**
 * Created by Arina on 03.10.2017
 */

public class PermissionFragment extends Fragment {

    private static final int PERMISSION_REQUEST_CODE = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_permission, container, false);
        rootView.findViewById(R.id.permission_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestPermissions(new String[] {
                                Manifest.permission.READ_CONTACTS,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.RECORD_AUDIO
                        },
                        PERMISSION_REQUEST_CODE);

            }
        });

        return rootView;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE && grantResults.length == permissions.length) {

            for (int result: grantResults) {
                if (result == PackageManager.PERMISSION_DENIED){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(getString(R.string.dialog_permission_title))
                            .setMessage(getString(R.string.dialog_permission_text))
                            .setIcon(R.mipmap.ic_launcher_round)
                            .setCancelable(false)
                            .setNegativeButton(getString(R.string.dialog_permission_button_text),
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return;
                }
            }

            Toast.makeText(getActivity().getApplicationContext(),
                    getString(R.string.toast_permission_text), Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
