package com.example.pirmp_4;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class SecondActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_second );
        ViewCompat.setOnApplyWindowInsetsListener( findViewById( R.id.main ), ( v, insets ) ->
        {
            Insets systemBars = insets.getInsets( WindowInsetsCompat.Type.systemBars() );
            v.setPadding( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );


        TextView textViewFirstName = findViewById( R.id.textViewFirstName );
        TextView textViewLastName = findViewById( R.id.textViewLastName );
        Button buttonOk = findViewById( R.id.buttonOk );

        Intent intent = getIntent();

        textViewFirstName.setText( "Имя: " + intent.getStringExtra( "firstName" ) );
        textViewLastName.setText( "Фамилия: " + intent.getStringExtra( "lastName" ) );

        buttonOk.setOnClickListener( v ->
        {
            activityResultLauncher.launch( new Intent( SecondActivity.this, ThirdActivity.class ) );
        } );
    }

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(), result ->
        {
            Intent data = result.getData();

            if ( result.getResultCode() == RESULT_OK && data != null )
            {
                TextView textViewScheduleInfo = findViewById( R.id.textViewScheduleInfo );

                textViewScheduleInfo.setText( data.getStringExtra( "scheduleInfo" ) );

                Toast.makeText( SecondActivity.this, "Данные успешно переданы", Toast.LENGTH_SHORT ).show();
            }
        } );

}
