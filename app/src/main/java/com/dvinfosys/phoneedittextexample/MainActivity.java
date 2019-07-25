package com.dvinfosys.phoneedittextexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dvinfosys.phoneedittext.ui.PhoneEditText;
import com.dvinfosys.phoneedittext.ui.PhoneInputLayout;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private PhoneEditText phoneEditText;
    private PhoneInputLayout phoneInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_submit);
        phoneEditText = findViewById(R.id.edt_phone);
        phoneInputLayout = findViewById(R.id.layout_phone_input);

        phoneInputLayout.setHint(R.string.phone_hint);
        phoneInputLayout.setDefaultCountry("in");

        phoneEditText.setHint(R.string.phone_hint);
        phoneEditText.setDefaultCountry("FR");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;
                if (phoneInputLayout.isValid()) {
                    phoneInputLayout.setError(null);
                } else {
                    phoneInputLayout.setError(getString(R.string.invalid_phone_number));
                    valid = false;
                }

                if (phoneEditText.isValid()) {
                    phoneEditText.setError(null);
                } else {
                    phoneEditText.setError(getString(R.string.invalid_phone_number));
                    valid = false;
                }

                if (valid) {
                    Toast.makeText(MainActivity.this, R.string.valid_phone_number, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.invalid_phone_number, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
