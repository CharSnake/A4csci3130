package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateBusinessAcitivity extends Activity {

    private Button submitButton;
    private EditText numberField, nameField, addressField;
    private Spinner businessField, provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        numberField = (EditText) findViewById(R.id.bnumber);
        nameField = (EditText) findViewById(R.id.name);
        businessField = (Spinner) findViewById(R.id.pbusiness);
        ArrayAdapter<CharSequence> adapterb = ArrayAdapter.createFromResource(this,
                R.array.pbusiness, android.R.layout.simple_spinner_item);
        adapterb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        businessField.setAdapter(adapterb);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (Spinner) findViewById(R.id.province);
        ArrayAdapter<CharSequence> adapterp = ArrayAdapter.createFromResource(this,
                R.array.province, android.R.layout.simple_spinner_item);
        adapterp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinceField.setAdapter(adapterp);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String businessID = appState.firebaseReference.push().getKey();
        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String business = businessField.getSelectedItem().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getSelectedItem().toString();
        Business person = new Business(businessID, number, name, business, address, province);

        appState.firebaseReference.child(businessID).setValue(person);

        finish();

    }
}
