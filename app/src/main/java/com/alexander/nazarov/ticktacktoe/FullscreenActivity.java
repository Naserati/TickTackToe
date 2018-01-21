package com.alexander.nazarov.ticktacktoe;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This app displays an order form to order coffee.
 */

public class FullscreenActivity extends AppCompatActivity {
    static ArrayList<Button> buttons= new ArrayList<>();
    static String lastCommand = "O";
    int lightBlue = 0xeccff;
    int x = 0;
    int o = 0;
    int round = 1;
    static int turn = 0;
    Toast winner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void threePointsA(View view) {

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void pushButton(View view) {
        Button b1 = (Button) findViewById(R.id.first_button);
        buttons.add(b1);
        Button b2 = (Button) findViewById(R.id.second_button);
        buttons.add(b2);
        Button b3 = (Button) findViewById(R.id.third_button);
        buttons.add(b3);
        Button b4 = (Button) findViewById(R.id.fourth_button);
        buttons.add(b4);
        Button b5 = (Button) findViewById(R.id.fith_button);
        buttons.add(b5);
        Button b6 = (Button) findViewById(R.id.sixth_button);
        buttons.add(b6);
        Button b7 = (Button) findViewById(R.id.seventh_button);
        buttons.add(b7);
        Button b8 = (Button) findViewById(R.id.eigth_button);
        buttons.add(b8);
        Button b9 = (Button) findViewById(R.id.ninth_button);
        buttons.add(b9);
        TextView score = (TextView) findViewById(R.id.score);
        TextView round_text = (TextView) findViewById(R.id.round_text);

        switch (view.getId()) {
            case R.id.first_button:
                turn(b1);
                break;
            case R.id.second_button:
                turn(b2);
                break;
            case R.id.third_button:
                turn(b3);
                break;
            case R.id.fourth_button:
                turn(b4);
                break;
            case R.id.fith_button:
                turn(b5);
                break;
            case R.id.sixth_button:
                turn(b6);
                break;
            case R.id.seventh_button:
                turn(b7);
                break;
            case R.id.eigth_button:
                turn(b8);
                break;
            case R.id.ninth_button:
                turn(b9);
                break;
        }
        if ((b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X")) ||
                (b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X")) ||
                (b1.getText().equals("X") && b4.getText().equals("X") && b7.getText().equals("X")) ||
                (b2.getText().equals("X") && b5.getText().equals("X") && b8.getText().equals("X")) ||
                (b3.getText().equals("X") && b5.getText().equals("X") && b7.getText().equals("X")) ||
                (b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X")) ||
                (b4.getText().equals("X") && b5.getText().equals("X") && b6.getText().equals("X")) ||
                (b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X"))) {

            turn = 0;
            round++;
            x++;
            score.setText(x + " : " + o);
            winner("Крестики");
            round_text.setText("РАУНД " + round);

        } else if (b1.getText().equals("O") && b2.getText().equals("O") && b3.getText().equals("O") ||
                b1.getText().equals("O") && b5.getText().equals("O") && b9.getText().equals("O") ||
                b1.getText().equals("O") && b4.getText().equals("O") && b7.getText().equals("O") ||
                b2.getText().equals("O") && b5.getText().equals("O") && b8.getText().equals("O") ||
                b3.getText().equals("O") && b5.getText().equals("O") && b7.getText().equals("O") ||
                b3.getText().equals("O") && b6.getText().equals("O") && b9.getText().equals("O") ||
                b4.getText().equals("O") && b5.getText().equals("O") && b6.getText().equals("O") ||
                b7.getText().equals("O") && b8.getText().equals("O") && b9.getText().equals("O")) {

            turn = 0;
            o++;
            score.setText(x + " : " + o);
            winner("Нолики");
            round++;
            round_text.setText("РАУНД " + round);
        } else if (turn == 9) {
            winner("");
            turn = 0;
            round++;
            round_text.setText("РАУНД " + round);
        }
    }

    private void turn(Button button) {
        TextView turn_text = (TextView) findViewById(R.id.turn_text);
        if (lastCommand.equals("O")) {
            button.setText("X");
            turn_text.setText("НОЛИКИ");
            lastCommand = "X";
            turn++;
        } else {
            button.setText("O");
            turn_text.setText("КРЕСТИКИ");
            lastCommand = "O";
            turn++;
        }
        button.setEnabled(false);
      }
     static class ClearField {
          public static void clearField() {
              for (int i = 0; i < buttons.size(); i++) {
                  buttons.get(i).setText("");
                  buttons.get(i).setEnabled(true);

              }
          }
      }

      private void winner(String win){
          for (int i = 0; i < buttons.size(); i++) {
              buttons.get(i).setEnabled(false);
          }
        if(!(turn == 9)) {
            winner = Toast.makeText(getApplicationContext(),
                    "Победили " + win + "!", Toast.LENGTH_SHORT);

        }
        else if (turn==9){
            winner = Toast.makeText(getApplicationContext(),
                    "Ничья", Toast.LENGTH_SHORT);
        }


          winner.setGravity(Gravity.CENTER, 0, 0);
          winner.show();

          Handler h = new Handler();
          h.postDelayed(new Runnable() {
              @Override
              public void run() {
                  ClearField.clearField();
              }
          }, 2000);

      }


//        if(lastCommand.equals("O")){
//        button.setText("X");
//        lastCommand = "X";}
//        else {
//            button.setText("O");
//            lastCommand = "O";
//        }
//        button.setEnabled(false);

//    public void pushSecondButton(View view) {
//        Button button = (Button) findViewById(R.id.second_button);
//        if(lastCommand.equals("O")){
//            button.setText("X");
//            lastCommand = "X";}
//        else {
//            button.setText("O");
//            lastCommand = "O";
//        }
//        button.setEnabled(false);
//    }
//    public void pushThirdButton(View view) {
//        Button button = (Button) findViewById(R.id.third_button);
//        if(lastCommand.equals("O")){
//            button.setText("X");
//            lastCommand = "X";}
//        else {
//            button.setText("O");
//            lastCommand = "O";
//        }
//        button.setEnabled(false);
//    }
}

