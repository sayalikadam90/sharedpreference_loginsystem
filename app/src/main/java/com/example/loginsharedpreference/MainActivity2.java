package com.example.loginsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    TextView txtmail,txtname;
    Button btnlogout;

    SharedPreferences sharedPreferences;
    private static final String Shared_pref_Name="pref";
    private static final String key_mail="mail";
    private static final String key_password="password";
    private static final String key_name="name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtmail=findViewById(R.id.mail);
        txtname=findViewById(R.id.name1);
        btnlogout=findViewById(R.id.btnlogout);

       sharedPreferences =getSharedPreferences(Shared_pref_Name,MODE_PRIVATE);

       String mail=sharedPreferences.getString(key_mail,null);
       txtmail.setText(""+mail);

       String name1=sharedPreferences.getString(key_name,null);
       txtname.setText(""+name1);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity2.this,"Logout Successfully..",Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }
}