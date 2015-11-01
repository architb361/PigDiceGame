package com.example.archi.pigdicegame;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int user=0,comp=0;
    int rounduser=0, roundcomp=0;
    ImageView image;
    Button roll,hold,reset;
    TextView UseSc,turns;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);
        roll = (Button) findViewById(R.id.Roll);
        hold = (Button) findViewById(R.id.Hold);
        reset = (Button) findViewById(R.id.Reset);
        UseSc = (TextView) findViewById(R.id.UserScore);
        turns = (TextView) findViewById(R.id.turn);

    }

    public static int random_int(int Min, int Max)
    {
        return (int) (Math.random()*(Max-Min))+Min;
    }

    public void RollOnClick(View v)
    {
        int no=random_int(1,6);
        switch (no)
        {
            case 1:
                roll.setEnabled(false);
                hold.setEnabled(false);
                turns.setText("you scored "+no);
                image.setImageResource(R.drawable.dice1);
                compturn();
                break;
            case 2:
                image.setImageResource(R.drawable.dice2);
                user += 2;
                rounduser += 2;
                turns.setText("you scored "+no);
                UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                break;
            case 3:
                image.setImageResource(R.drawable.dice3);
                user += 3;
                rounduser += 3;
                turns.setText("you scored "+no);
                UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                break;
            case 4:
                image.setImageResource(R.drawable.dice4);
                user += 4;
                rounduser += 4;
                turns.setText("you scored "+no);
                UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                break;
            case 5:
                image.setImageResource(R.drawable.dice5);
                user += 5;
                rounduser += 5;
                turns.setText("you scored "+no);
                UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                break;
            case 6:
                image.setImageResource(R.drawable.dice6);
                user += 6;
                rounduser += 6;
                turns.setText("you scored "+no);
                UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                break;
        }

    }

    public void HoldOnClick(View v)
    {
        roll.setEnabled(false);
        hold.setEnabled(false);
        rounduser=0;
        compturn();
    }

    public void ResetOnClick(View v)
    {

    }

    public void compturn()
    {
        int flag=0;
        while (true)
        {
            if(roundcomp>20 || flag==1 )
            {
                roll.setEnabled(true);
                hold.setEnabled(true);
                roundcomp=0;
                break;
            }
            int no=random_int(1,6);

            switch (no)
            {
                case 1:
                    roll.setEnabled(true);
                    hold.setEnabled(true);
                    image.setImageResource(R.drawable.dice1);
                    turns.setText("comp scored " + no);
                    flag=1;
                    break;
                case 2:
                    image.setImageResource(R.drawable.dice2);
                    comp += 2;
                    roundcomp += 2;
                    turns.setText("comp scored "+no);
                    UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                    break;
                case 3:
                    image.setImageResource(R.drawable.dice3);
                    comp += 3;
                    roundcomp += 3;
                    turns.setText("comp scored "+no);
                    UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                    break;
                case 4:
                    image.setImageResource(R.drawable.dice4);
                    comp += 4;
                    roundcomp += 4;
                    turns.setText("comp scored "+no);
                    UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                    break;
                case 5:
                    image.setImageResource(R.drawable.dice5);
                    comp += 5;
                    roundcomp += 5;
                    turns.setText("comp scored "+no);
                    UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                    break;
                case 6:
                    image.setImageResource(R.drawable.dice6);
                    comp += 6;
                    roundcomp += 6;
                    turns.setText("comp scored "+no);
                    UseSc.setText("your score = "+ user + "   Comp Score = " +comp);
                    break;
            }
            try
            {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
