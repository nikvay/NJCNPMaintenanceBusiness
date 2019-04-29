package com.cnp_maintenance.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cnp_maintenance.MainActivity;
import com.cnp_maintenance.R;
import com.cnp_maintenance.utils.SharedUtils;
import com.cnp_maintenance.utils.SnackbarCommon;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private EditText edt_email,edt_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        find_All_Ids();
        events();
    }

    private void events() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=edt_email.getText().toString().trim();
                String password=edt_password.getText().toString().trim();
                if(email.equalsIgnoreCase(""))
                {
                    SnackbarCommon.displayValidation(v,"Email ID Can't Be Empty");
                }
                else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(edt_email.getText().toString()).matches())
                {
                    SnackbarCommon.displayValidation(v,"Enter valid Email");
                }
                else if(password.equalsIgnoreCase(""))
                {
                    SnackbarCommon.displayValidation(v,"Password Can't Be Empty");
                }
                else if(password.length()>15||password.length()<5)
                {
                    SnackbarCommon.displayValidation(v,"Password Length Between 5 to 15");
                }
                else
                {
                    SharedUtils.putSharedUtils(LoginActivity.this);
                    Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    private void find_All_Ids() {
        edt_email=findViewById(R.id.edt_email);
        edt_password=findViewById(R.id.edt_password);
        btn_login=findViewById(R.id.btn_login);

    }
}
