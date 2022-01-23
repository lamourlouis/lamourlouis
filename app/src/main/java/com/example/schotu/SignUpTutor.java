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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class SignUpTutor extends AppCompatActivity {
    //sign up button
    EditText edtTutorName;
    EditText edtTutorPassword;
    EditText edtTutorEmail;

    //Button
    Button btnsign_up;

    //FireStore initialisation
    FirebaseFirestore database;
    DocumentReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_tutor);

        database =FirebaseFirestore.getInstance().getInstance();
        usersRef=database.collection("Tutors").document();
        edtTutorName= (EditText) findViewById(R.id.edtTutorName);
        edtTutorPassword= (EditText) findViewById(R.id.edtTutorPassword);
        edtTutorEmail= (EditText) findViewById(R.id.edtTutorEmail);
        btnsign_up=(Button) findViewById(R.id.btn_sign_up);


        btnsign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitSignUp();
            }
        });

    }//fin oncreate

    public void submitSignUp() {
       final  Tutor tutor=new Tutor(edtTutorName.getText().toString(),
                edtTutorPassword.getText().toString(),
                edtTutorEmail.getText().toString());
        //Check if document exist
        database.collection("Tutors")
                .whereEqualTo("tutorName",edtTutorName.getText().toString())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG CHECK", document.getId() + " => " + document.getData());
                            }
                            QuerySnapshot doc=task.getResult();
                            if(doc.isEmpty()){
                                Log.d("Exist not :","le document n'exist pas");


                                // Add user in database
                                database.collection("Tutors")
                                        .add(tutor)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Log.d("FirestoreDemo", "DocumentSnapshot added with ID: " + documentReference.getId());
                                                Toast.makeText(SignUpTutor.this,"User register with success!!!",Toast.LENGTH_LONG).show();
                                        //place pour le retour a la page sign up
                                                Intent homelogin = new Intent(SignUpTutor.this, LoginTutor.class);
                                                startActivity(homelogin);
                                                
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w("FirestoreDemo", "Error adding document", e);
                                            }
                                        });

                            }//fin if
                            else {
                                Log.d("Exist  :","L'utilisateur exist deja veuiller choisir un autre nom d'utilisateur!!!! ");
                                Toast.makeText(SignUpTutor.this,"User exists already!",Toast.LENGTH_LONG).show();
                            }
                        }//task is successfull
                        else {
                            Log.d("TAG CHECK", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
}//sign up tutor class