package com.example.schotu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.schotu.Class.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class LoginClient extends AppCompatActivity {

    //sign up button
    EditText edtNewUserName;
    EditText edtNewUserPassword;
    EditText edtNewUserEmail;
    //sign in button
    EditText UserName;
    EditText UserPassword;
    //Button
    Button btnsign_in,btnsign_up;

    //FireStore initialisation
    FirebaseFirestore database;
    DocumentReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_login);


        database =FirebaseFirestore.getInstance().getInstance();
        usersRef=database.collection("users").document();
        UserName= (EditText) findViewById(R.id.UserName);
        UserPassword= (EditText) findViewById(R.id.UserPassword);
        btnsign_in=(Button) findViewById(R.id.sign_in);
        btnsign_up=(Button) findViewById(R.id.sign_up);


        btnsign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSignUpDialog();
            }
        });
        btnsign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInMet( UserName.getText().toString(),UserPassword.getText().toString());
                // Log.i("Bouton","Bouton sign in presser");
            }
        });
    }

    private void signInMet(final String user, final String pwd) {
        if(UserName.getText().toString().equals("")){
            Toast.makeText(LoginClient.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
        }else if( UserPassword.getText().toString().equals("")){
            Toast.makeText(LoginClient.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
        }

        database.collection("usersT").whereEqualTo("userName",UserName.getText().toString())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String a1=null,b1=null;
                        if(task.isSuccessful()){
                            // Log.i("SIGN IN","TASK SUCCESSFULL");
                            QueryDocumentSnapshot doc1;

                            for(QueryDocumentSnapshot doc : task.getResult()) {
                                User Q_user = doc.toObject(User.class);
                                a1 = Q_user.getUserName().trim();
                                b1 = Q_user.getPassword().trim();
                                String c1=Q_user.getEmail().trim();


                                if (UserName.getText().toString().equalsIgnoreCase(a1) & UserPassword.getText().toString().equalsIgnoreCase(b1)) {
                                    Intent home = new Intent(LoginClient.this, clientHome.class);
                                    startActivity(home);

                                    Toast.makeText(LoginClient.this, "Logged In", Toast.LENGTH_SHORT).show();


                                }


                                if(!UserName.getText().toString().equalsIgnoreCase(a1) & !UserPassword.getText().toString().equalsIgnoreCase(b1)){
                                    Toast.makeText(LoginClient.this, " Acount not exist Unable to Logged In", Toast.LENGTH_SHORT).show();
                                }

                                if(!UserName.getText().toString().equalsIgnoreCase(a1) & UserPassword.getText().toString().equalsIgnoreCase(b1)){
                                    Toast.makeText(LoginClient.this, "Wrong Email", Toast.LENGTH_SHORT).show();
                                }//fin if



                            }//Fin Boucle For

                            //Check if document exist or not
                            QuerySnapshot doc=task.getResult();
                            if(doc.isEmpty()) {
                                Log.d("Exist not :", "le document n'exist pas");
                                Toast.makeText(LoginClient.this, "L'utilisateur n'existe pas!!!!!", Toast.LENGTH_SHORT).show();
                            }
                        }//task.isSuccessful()


                    }//fin onComplete
                });//Fin




    }

    private void showSignUpDialog() {
        Log.i("Bouton Sign up","Bouton sign up presser");
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(LoginClient.this);
        alertDialog.setTitle("sign up");
        alertDialog.setMessage("please fill all the information");
        LayoutInflater inflater =this.getLayoutInflater();
        View sign_up= inflater.inflate(R.layout.sign_up,null);
        edtNewUserName=(EditText)sign_up.findViewById(R.id.edtNewUserName);
        edtNewUserPassword=(EditText)sign_up.findViewById(R.id.edtNewUserPassword);
        edtNewUserEmail=(EditText)sign_up.findViewById(R.id.edtNewUserEmail);
        alertDialog.setView(sign_up);
        alertDialog.setIcon(R.drawable.ic_baseline_account_circle_24);

        //button negative
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final User user=new User(edtNewUserName.getText().toString(),
                        edtNewUserPassword.getText().toString(),
                        edtNewUserEmail.getText().toString());
                //Check if document exist
                database.collection("usersT")
                        .whereEqualTo("userName",edtNewUserName.getText().toString())
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
                                        database.collection("usersT")
                                                .add(user)
                                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                    @Override
                                                    public void onSuccess(DocumentReference documentReference) {
                                                        Log.d("FirestoreDemo", "DocumentSnapshot added with ID: " + documentReference.getId());
                                                        Toast.makeText(LoginClient.this,"User register with success!!!",Toast.LENGTH_LONG).show();
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
                                        Toast.makeText(LoginClient.this,"User exists already!",Toast.LENGTH_LONG).show();
                                    }
                                }//task is successfull
                                else {
                                    Log.d("TAG CHECK", "Error getting documents: ", task.getException());
                                }
                            }
                        });


                dialog.dismiss();
            }//fin on click
        });
        alertDialog.show();
    }



}//End of LoginClient