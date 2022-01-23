package com.example.schotu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schotu.Class.Tutor;
import com.example.schotu.Class.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginTutor extends AppCompatActivity {

    //sign in button
    EditText TutorName;
    EditText TutorPassword;
    //Button
    Button sign_in_Tutor,sign_up_Tutor;

    //FireStore initialisation
    FirebaseFirestore database;
    DocumentReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_login);
        database = FirebaseFirestore.getInstance().getInstance();
        usersRef=database.collection("Tutors").document();
        TutorName= (EditText) findViewById(R.id.TutorName);
        TutorPassword= (EditText) findViewById(R.id.TutorPassword);
        sign_in_Tutor=(Button) findViewById(R.id.sign_in_Tutor);
        sign_up_Tutor=(Button) findViewById(R.id.sign_up_Tutor);

        sign_in_Tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInMet( TutorName.getText().toString(),TutorPassword.getText().toString());
                // Log.i("Bouton","Bouton sign in presser");
            }
        });

        sign_up_Tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signupInt = new Intent(LoginTutor.this, SignUpTutor.class);
                startActivity( signupInt);

            }
        });

    }



    private void signInMet(final String user, final String pwd) {

        if(TutorName.getText().toString().equals("")){
            Toast.makeText(LoginTutor.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
        }else if( TutorPassword.getText().toString().equals("")){
            Toast.makeText(LoginTutor.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
        }

        database.collection("Tutors").whereEqualTo("tutorName",TutorName.getText().toString())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String a1=null,b1=null;
                        if(task.isSuccessful()){
                            // Log.i("SIGN IN","TASK SUCCESSFULL");
                            QueryDocumentSnapshot doc1;

                            for(QueryDocumentSnapshot doc : task.getResult()) {
                                Tutor Q_user = doc.toObject(Tutor.class);
                                a1 = Q_user.getTutorName().trim();
                                b1 = Q_user.getTutor_pwd().trim();
                                String c1=Q_user.getTutor_email().trim();


                                if (TutorName.getText().toString().equalsIgnoreCase(a1) & TutorPassword.getText().toString().equalsIgnoreCase(b1)) {
                                    Intent homeT = new Intent(LoginTutor.this, TutorHome.class);
                                    startActivity(homeT);

                                    Toast.makeText(LoginTutor.this, "Logged In", Toast.LENGTH_SHORT).show();


                                }


                                if(!TutorName.getText().toString().equalsIgnoreCase(a1) & !TutorPassword.getText().toString().equalsIgnoreCase(b1)){
                                    Toast.makeText(LoginTutor.this, " Acount not exist Unable to Logged In", Toast.LENGTH_SHORT).show();
                                }

                                if(!TutorName.getText().toString().equalsIgnoreCase(a1) & TutorPassword.getText().toString().equalsIgnoreCase(b1)){
                                    Toast.makeText(LoginTutor.this, "Wrong Email", Toast.LENGTH_SHORT).show();
                                }//fin if



                            }//Fin Boucle For

                            //Check if document exist or not
                            QuerySnapshot doc=task.getResult();
                            if(doc.isEmpty()) {
                                Log.d("Exist not :", "le document n'exist pas");
                                Toast.makeText(LoginTutor.this, "L'utilisateur n'existe pas!!!!!", Toast.LENGTH_SHORT).show();
                            }
                        }//task.isSuccessful()


                    }//fin onComplete
                });//Fin




    }



    }
