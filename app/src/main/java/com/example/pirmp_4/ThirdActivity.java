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


public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_third );
        ViewCompat.setOnApplyWindowInsetsListener( findViewById( R.id.main ), ( v, insets ) ->
        {
            Insets systemBars = insets.getInsets( WindowInsetsCompat.Type.systemBars() );
            v.setPadding( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );


        EditText editTextDay = findViewById( R.id.editTextDay );
        EditText editTextTime = findViewById( R.id.editTextTime );
        EditText editTextComment = findViewById( R.id.editTextComment );
        Button buttonOk = findViewById( R.id.buttonOk );

        buttonOk.setOnClickListener( v ->
        {
            String scheduleInfo = "День: " + editTextDay.getText().toString() +
                    ", Время: " + editTextTime.getText().toString() +
                    ", Комментарий: " + editTextComment.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra( "scheduleInfo", scheduleInfo );
            setResult( RESULT_OK, resultIntent );
            finish();
        } );
    }

}
