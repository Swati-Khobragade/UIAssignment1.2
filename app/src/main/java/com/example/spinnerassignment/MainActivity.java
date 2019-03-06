package com.example.spinnerassignment;
/**
 * @Author-Swati.Khobragade
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    private EditText editTxtName;
    private Spinner spinnerAge;
    private EditText editTxtQual;
    private Button btnSave;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerListeners();
    }

    /**
     * Initialize views
     */
    private void initViews() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        editTxtName = (EditText) findViewById(R.id.editTextName);
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        editTxtQual = (EditText) findViewById(R.id.editTextQualification);
        btnSave = (Button) findViewById(R.id.buttonSave);
        btnClear = (Button) findViewById(R.id.buttonClear);
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSave:
                saveData();
                break;
            case R.id.buttonClear:
                clearData();
                break;

        }
    }

    /**
     * Method to save input data to Result Textview
     */
    private void saveData() {
        String name = editTxtName.getText().toString().trim();
        String age = spinnerAge.getSelectedItem().toString().trim();
        String qualification = editTxtQual.getText().toString().trim();
        if (validateFields(name, age, qualification)) {
            tvResult.setText("");
            tvResult.setText("Name:" + name + "  Age:" + age + "  Qualification:" + qualification);
        }
    }

    /**
     * Method to clear all data
     */
    private void clearData() {
        editTxtName.getText().clear();
        editTxtQual.getText().clear();
        spinnerAge.setSelection(0);
        tvResult.setText("");
    }

    /**
     * Method to validate empty fields
     * @param name
     * @param age
     * @param qualification
     * @return
     */
    private boolean validateFields(String name, String age, String qualification) {
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(age)) {
            Toast.makeText(getApplicationContext(), "Please Select Age", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(qualification)) {
            Toast.makeText(getApplicationContext(), "Please Enter Qualification", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
