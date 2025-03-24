package com.example.pirmp_4;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_main );
        ViewCompat.setOnApplyWindowInsetsListener( findViewById( R.id.main ), ( v, insets ) ->
        {
            Insets systemBars = insets.getInsets( WindowInsetsCompat.Type.systemBars() );
            v.setPadding( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );


        EditText editTextFirstName = findViewById( R.id.editTextFirstName );
        EditText editTextLastName = findViewById( R.id.editTextLastName );
        Button buttonNext = findViewById( R.id.buttonNext );

        buttonNext.setOnClickListener( v ->
        {
            Intent intent = new Intent( MainActivity.this, SecondActivity.class );

            intent.putExtra( "firstName", editTextFirstName.getText().toString() );
            intent.putExtra( "lastName", editTextLastName.getText().toString() );

            startActivity( intent );
        } );
    }

}
