package com.carsharing.antisergiu.main;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// LOGIN LOGIC
public class LoginDialog extends DialogFragment {
    public static final String PREFS_NAME = "MyPrefsFile";

    private EditText mEditText;
    private LoginDialog mdialog = this;
    public LoginDialog() {
        // Empty constructor required for DialogFragment

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view;
        if (CreatePoolActivity.getRegistrationStatus() == true) {
            view = inflater.inflate(R.layout.fragment_login, container);

            mEditText = (EditText) view.findViewById(R.id.login_et_password);
            ((Button)view.findViewById(R.id.login_btn)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "Created car pool!", Toast.LENGTH_LONG);
                    mdialog.dismiss();
                }
            });
            getDialog().setTitle("Please confirm password!");
        } else {
            view = inflater.inflate(R.layout.fragment_register, container);
            getDialog().setTitle("Please register to use the App!");((Button)view.findViewById(R.id.login_btn)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CreatePoolActivity.setmIsRegistered(true);
                    Toast.makeText(view.getContext(), "Created car pool!", Toast.LENGTH_LONG);
                    mdialog.dismiss();
                }
            });

        }

        return view;
    }
}