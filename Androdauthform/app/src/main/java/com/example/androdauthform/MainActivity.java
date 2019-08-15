package com.example.androdauthform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String location = "http://isapi.mekashron.com/icu-tech/ICUTech-test.dll/soap/IICUTech";
    private String namespase = "urn:ICUTech.Intf-IICUTech";
    // headers
    private String loginAction = "urn:ICUTech.Intf-IICUTech#Login";
    private String registerAction = "urn:ICUTech.Intf-IICUTech#RegisterNewCustomer";

    // Login0Request
    String Login0Request="<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<message name=\"Login0Request\">\n" +
            "<part name=\"UserName\" type=\"xs:string\">artem@koorochka.com</part>\n" +
            "<part name=\"Password\" type=\"xs:string\"/>artem:android:koorochka</part>\n" +
            "<part name=\"IPs\" type=\"xs:string\">178.133.140.174</part>\n" +
            "</message>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
