package com.example.loginsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtemail,edtpassword,edtName;
    Button btnlogin;
    SharedPreferences sharedPreferences;
    private static final String Shared_pref_Name="pref";
    private static final String key_mail="mail";
    private static final String key_password="password";
    private static final String key_name="name";


    String correct_password="sayali@";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtemail=findViewById(R.id.username);
        edtpassword=findViewById(R.id.password);
        edtName=findViewById(R.id.name);
        btnlogin=findViewById(R.id.btnlogin);

        sharedPreferences=getSharedPreferences(Shared_pref_Name,MODE_PRIVATE);
        String mail=sharedPreferences.getString(key_mail,null);
        if(mail!=null){
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
        //String name=sharedPreferences.getString(key_name,null);
          //  if(name!=null){
            //    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
              //  startActivity(intent);
            //
        //
        // }






        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(edtpassword.getText().toString())){
                    Toast.makeText(MainActivity.this,"Empty data provided",Toast.LENGTH_LONG).show();

                }else if(edtpassword.getText().toString().equals(correct_password)){
                    Toast.makeText(MainActivity.this,"Login done successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_LONG).show();
                }


                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(key_mail,edtemail.getText().toString());
                editor.putString(key_password,edtpassword.getText().toString());
                editor.putString(key_name,edtName.getText().toString());
                editor.apply();



            }
        });
    }
}