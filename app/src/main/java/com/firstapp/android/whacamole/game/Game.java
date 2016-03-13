package com.firstapp.android.whacamole.game;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;

import com.firstapp.android.whacamole.activity.GameActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by android on 09/03/2016.
 */
public class Game
{
    private int nbMole;


    public Game(GameActivity gameActivity)
    {
        Iterator<Button> it = gameActivity.getBoutons().iterator();
        while (it.hasNext())
        {
            final Button current = it.next();
            current.setClickable(true);
            current.getBackground().setColorFilter(Color.rgb(0, 0, 0), PorterDuff.Mode.MULTIPLY);
            current.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current.getBackground().setColorFilter(Color.rgb(255, 128, 0), PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        Random generator = new Random();
        nbMole = generator.nextInt(3)+1;

        ArrayList<Integer> activeMoles = new ArrayList<>();
        for (int i = 0; i<nbMole; i++)
        {
            int numero = -1;
            while (numero < 0 || !activeMoles.contains(numero))
            {
                numero = generator.nextInt(25);
                activeMoles.add(numero);
            }
            final Button current = gameActivity.getBoutons().get(numero);
            current.setClickable(true);
            current.getBackground().setColorFilter(Color.rgb(153, 0, 0), PorterDuff.Mode.MULTIPLY);
            current.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current.getBackground().setColorFilter(Color.rgb(0,153,0),PorterDuff.Mode.MULTIPLY);
                }
            });
        }
    }
}
