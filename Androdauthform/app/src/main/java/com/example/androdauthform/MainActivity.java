package com.example.androdauthform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String location = "http://isapi.mekashron.com/icu-tech/ICUTech-test.dll/soap/IICUTech";
    private String namespase = "urn:ICUTech.Intf-IICUTech";
    // headers
    private String loginAction = "urn:ICUTech.Intf-IICUTech#Login";
    private String registerAction = "urn:ICUTech.Intf-IICUTech#RegisterNewCustomer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
    }
}