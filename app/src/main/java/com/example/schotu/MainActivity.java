package com.example.schotu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    String currentUser=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //Si current user n'est pas  loguer
     if(currentUser==null){
         //essaie de loguer la page de loging
        // if()
         //si il n'y a pas d'erreur :c'est reussi
             //if(e==null)
         Log.i("info","Loging successful");
           //else


     }
     else{
         Log.i("info","Loging failed");
     }

    }//oncreate Bundle

    public void openLoginClient(){
        Intent intentLogC= new Intent(this,LoginClient.class);
        startActivity(intentLogC);

       }//openLoginClient()

    public void openLoginTutor(){
        Intent intentLogT= new Intent(this, LoginTutor.class);
        startActivity(intentLogT);

    }//openLoginTutor()

    public void getStarted(View view) {

        Switch userTypeSwitch = (Switch) findViewById(R.id.userTypeSwitch);

        Log.i("Switch value", String.valueOf(userTypeSwitch.isChecked()));

        String userType = "Client";

        if (userTypeSwitch.isChecked()) {

            userType = "Tutor";

        }
        if(userType=="Client"){
            openLoginClient();

        }
        else{
            openLoginTutor();
        }

        //ParseUser.getCurrentUser().put("riderOrDriver", userType);

        Log.i("Info", "Redirecting as: " + userType);

    }//Fin getstarted method

}