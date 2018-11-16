package com.example.eva.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boto = (Button) findViewById(R.id.botoinici);
        boto.setOnClickListener(this);



    }

    @Override
    protected void onStart() {
        super.onStart();

        /*
        //TODO: Quan el fragment s'infli al onCreate podré recuperar els botons del Fragment1 des de l'activity
        Fragment fragment_inflado = (Fragment) getFragmentManager().findFragmentByTag("fr");

        Button button1 = (Button)
                fragment_inflado.getView().findViewById(R.id.fragment1Button1);
        Button button2 = (Button)
                fragment_inflado.getView().findViewById(R.id.fragment1Button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has pulsat boto 1", Toast.LENGTH_SHORT).show();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has pulsat boto 2", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }

    @Override
    public void onClick(View v) {

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.contenidorFragment1) == null) {   //Per no carregar el fragment més d'un cop
            Fragment1 fragment1 = new Fragment1();


            /*  OPCIONAL si volem enviar informació al Fragment des del Main Activity
            Bundle data = new Bundle();
            data.putString("nom", "Eva");
            fragment1.setArguments(data);
            */

            fm.beginTransaction().replace(R.id.contenidorFragment1, fragment1).commit();


            /***************************** NOTIFICACIÓ ****************************/
            // Creem la notificació definint una icona, un títol i un text
           /* NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.ic_action_accept) //icona de la notificació
                            .setContentTitle("Notificació de prova:") // Títol de la notificació
                            .setContentText(item); // Text de la notificació (paràmetre d'entrada del mètode)

            // La notificació es tancarà una vegada hem fet clic
            mBuilder.setAutoCancel(true);
            */
        }

    }
}
