package com.example.eva.fragments;

import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Fragment1.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boto = (Button)findViewById(R.id.botoinici);
        boto.setOnClickListener(this);

        PreferenceManager.setDefaultValues(this, R.xml.preferencies, false);




    }



    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        //Opció 1 no es per tablets
         if (fm.findFragmentById(R.id.contenidorFragment1) == null) {   //Per no carregar el fragment més d'un cop

             Fragment1 fragment1 = new Fragment1();
             /************  OPCIONAL si volem enviar informació al Fragment des del Main Activity
              Bundle data = new Bundle();
              data.putString("nom", "Eva");
              fragment1.setArguments(data);
              */
             fm.beginTransaction().replace(R.id.contenidorFragment1, fragment1).commit();
         }

        //FI Opció 1

        //Opció 2 es per tablets

        /*
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density = getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;
        Log.d("Fragment", "Density: " +  density + ". dpWidth: "+dpWidth);


        if (fm.findFragmentById(R.id.contenidorFragment1) == null) {
            Fragment1 fragment1 = new Fragment1();
            fm.beginTransaction().add(R.id.contenidorFragment1, fragment1).commit();
        }

        if (dpWidth > 600) {
            if (fm.findFragmentById(R.id.contenidorFragment2) == null) {
                Fragment2 fragment2 = new Fragment2();
                fm.beginTransaction().add(R.id.contenidorFragment2, fragment2).commit();
            }

        }
*/
            // FI opció 2


            /***************************** NOTIFICACIÓ ****************************/
            /*
            A Notification object must contain the following:
            A small icon, set by setSmallIcon().
            A title, set by setContentTitle().
            Detail text, set by setContentText().
            On Android 8.0 (API level 26) and higher, a valid notification channel ID, set by setChannelId() or provided in the NotificationCompat.Builder constructor when creating a channel.
            Caution: If you target Android 8.0 (API level 26) and post a notification without specifying a valid notifications channel, the notification fails to post and the system logs an error.
            */

            // Creem la notificació definint una icona, un títol i un text
        int notificationID = 1;
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_info) //icona de la notificació
                        .setContentTitle("Títol de la notificació de prova") // Títol de la notificació
                        .setContentText("Text de la notificació, has clicat"); // Text de la notificació (paràmetre d'entrada del mètode)

        // La notificació es tancarà una vegada hem fet clic
        mBuilder.setAutoCancel(true);

        /*El manager és qui mostra la notificació*/
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, mBuilder.build());


    }


    @Override
    public void onFragmentInteraction(View view) {
        //Carrega el segon Fragment  si es tablet al costat i sino abaix
        FragmentManager fm = getFragmentManager();

        /*Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density = getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;
        Log.d("Fragment", "Density: " +  density + ". dpWidth: "+dpWidth);
*/

       /* if (fm.findFragmentById(R.id.contenidorFragment1) == null) {
            Fragment1 fragment1 = new Fragment1();
            fm.beginTransaction().add(R.id.contenidorFragment1, fragment1).commit();
        }*/

        //if (dpWidth > 600) {
            if (fm.findFragmentById(R.id.contenidorFragment2) == null) {
                Fragment2 fragment2 = new Fragment2();
                fm.beginTransaction().add(R.id.contenidorFragment2, fragment2).commit();
            }

        //}
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void mostraPreferencies (View v) {
        Intent i = new Intent(this, PreferenciesActivity.class);
        startActivity(i);
    }

}
