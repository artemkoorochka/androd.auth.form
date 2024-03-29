package com.example.androdauthform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HandlerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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

    private URL serviceLocation;
    private HttpURLConnection connection;

    BufferedReader rd  = null;
    StringBuilder sb = null;
    String line = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            serviceLocation = new URL(location);
            connection = (HttpURLConnection)serviceLocation.openConnection();
            connection.setRequestProperty("Content-Type", "text/xml; UTF-8");
            connection.setRequestProperty("SOAPAction", loginAction);
            connection.setRequestMethod("POST");


            OutputStream reqStream = connection.getOutputStream();

            // try send Login request to service
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(Login0Request);
            writer.flush();
            writer.close();
            
            // try get data of strim
            rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            sb = new StringBuilder();

            while ((line = rd.readLine()) != null)
            {
                sb.append(line + '\n');
            }

            System.out.println(sb.toString());


        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (ProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        finally
        {
            //close the connection, set all objects to null
            connection.disconnect();
            connection = null;
        }

    }

}


