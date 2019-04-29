package com.cnp_maintenance.ui.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cnp_maintenance.R;
import com.cnp_maintenance.utils.SnackbarCommon;

public class AddCustomerActivity extends AppCompatActivity {


    Button btn_Add_Customer;
    TextView txt_customer_title;
    ImageView iv_back_activity;
    AutoCompleteTextView edt_name, edt_address, edt_phone, edt_email, edt_company_name, edt_gst_no;
    String name, address, phone, email, company_name, gst_no,title_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        Bundle bundle = getIntent().getExtras();

        find_All_IDs();

        if (bundle.getString("ADDCUSTOMER") != null) {
            title_name="add";
            btn_Add_Customer.setText("Add");
            txt_customer_title.setText("Add Customer");
        }
        if (bundle.getString("EDITCUSTOMER") != null) {
            title_name="edit";
            btn_Add_Customer.setText("Update");
            txt_customer_title.setText("Edit Customer");
        }

        events();
    }

    private void events() {

        iv_back_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btn_Add_Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = edt_name.getText().toString().trim();
                address = edt_address.getText().toString().trim();
                phone = edt_phone.getText().toString().trim();
                email = edt_email.getText().toString().trim();
                company_name = edt_company_name.getText().toString().trim();
                gst_no = edt_gst_no.getText().toString().trim();
                if (validation(v)) {

                    if(title_name.equalsIgnoreCase("add")) {
                        Toast.makeText(AddCustomerActivity.this, "Add Customer", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(AddCustomerActivity.this, "Edit Customer", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }

    private boolean validation(View view) {

        if (name.equalsIgnoreCase(""))
        {
            SnackbarCommon.displayValidation(view,"Enter Customer Name");
        }
        else if (address.equalsIgnoreCase(""))
        {
            SnackbarCommon.displayValidation(view,"Enter Address");
        }
        else if (phone.equalsIgnoreCase("")||phone.length()!=10)
        {
            SnackbarCommon.displayValidation(view,"Enter Valid Number");
        }
        else if (email.equalsIgnoreCase("")||!android.util.Patterns.EMAIL_ADDRESS.matcher(edt_email.getText().toString()).matches())
        {
            SnackbarCommon.displayValidation(view,"Enter Valid Email");
        }
        else if (company_name.equalsIgnoreCase(""))
        {
            SnackbarCommon.displayValidation(view,"Enter company Name Email");
        }

        return true;
    }


    private void find_All_IDs() {
        btn_Add_Customer = findViewById(R.id.btn_Add_Customer);
        txt_customer_title = findViewById(R.id.txt_customer_title);
        iv_back_activity = findViewById(R.id.iv_back_activity);

        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        edt_phone = findViewById(R.id.edt_phone);
        edt_email = findViewById(R.id.edt_email);
        edt_company_name = findViewById(R.id.edt_company_name);
        edt_gst_no = findViewById(R.id.edt_gst_no);

    }
}
