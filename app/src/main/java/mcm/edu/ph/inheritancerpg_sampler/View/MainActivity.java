package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import mcm.edu.ph.inheritancerpg_sampler.Model.GameUnit;
import mcm.edu.ph.inheritancerpg_sampler.Model.Hero;
import mcm.edu.ph.inheritancerpg_sampler.Model.Monster;
import mcm.edu.ph.inheritancerpg_sampler.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView p1name,p2name,p1atk,p2atk,p1health,p2health,p1mana,p2mana,txtLog;
    Button btnNextTurn;

    Hero heroKnight = new Hero("Sebas","Knight", 0, 12, 6, 5, 3, 9, 20, 25, 1800, 500, 1, 4);

    Monster acidSlime = new Monster("Acid Slime", "Slime", 10, 15, 4000, 200, 3, 3);


    int gameCounter = 1;


    @SuppressLint("SetTextI18n") //Suppress warnings regarding strings
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1name = findViewById(R.id.txtP1Name);
        p2name = findViewById(R.id.txtP2Name);
        p1atk = findViewById(R.id.txtP1Damage);
        p2atk = findViewById(R.id.txtP2Damage);
        p1health = findViewById(R.id.txtP1hp);
        p2health = findViewById(R.id.txtP2hp);
        p1mana = findViewById(R.id.txtP1mp);
        p2mana = findViewById(R.id.txtP2mp);
        btnNextTurn = findViewById(R.id.btnNxtTurn);
        txtLog = findViewById(R.id.txtLog);


        btnNextTurn.setOnClickListener(this);


        p1name.setText(heroKnight.getName());
        p2name.setText(acidSlime.getName());
        p1atk.setText(String.valueOf(heroKnight.getAtkMin())+ " ~ "+ String.valueOf(heroKnight.getAtkMax()));
        p2atk.setText(String.valueOf(acidSlime.getAtkMin())+ " ~ "+ String.valueOf(acidSlime.getAtkMax()));
        p1health.setText(String.valueOf(heroKnight.getHealthPt()));
        p2health.setText(String.valueOf(acidSlime.getHealthPt()));
        p1mana.setText(String.valueOf(heroKnight.getManaPt()));
        p2mana.setText(String.valueOf(acidSlime.getManaPt()));



    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v){

        Random randomizer = new Random();
        int heroatk = randomizer.nextInt(heroKnight.getAtkMax() - heroKnight.getAtkMin()) + heroKnight.getAtkMin();
        int monsatk = randomizer.nextInt(acidSlime.getAtkMax() - acidSlime.getAtkMin()) + acidSlime.getAtkMin();

        switch (v.getId()){
            case R.id.btnNxtTurn:

                if(gameCounter%2 == 1){
                    acidSlime.setHealthPt(acidSlime.getHealthPt() - heroatk);
                    txtLog.setText(heroKnight.getName() + " dealt "+heroatk+ " damage to the enemy.");
                    p1health.setText(String.valueOf(heroKnight.getHealthPt()));
                    gameCounter++;

                    if(acidSlime.getHealthPt() < 0){
                        txtLog.setText(heroKnight.getName() + " dealt "+heroatk+ " damage to the enemy.\n You are victorious!");
                        gameCounter = 1;
                        heroKnight.setHealthPt(2000);
                        acidSlime.setHealthPt(4000);
                        btnNextTurn.setText("Reset Game");
                    }
                }

                else if(gameCounter %2 !=1 ){
                    heroKnight.setHealthPt(heroKnight.getHealthPt() - monsatk);
                    txtLog.setText(acidSlime.getName() + " dealt "+monsatk+ " damage to the protag.");
                    p2health.setText(String.valueOf(acidSlime.getHealthPt()));
                    gameCounter++;

                    if(heroKnight.getHealthPt() < 0){
                        txtLog.setText(acidSlime.getName() + " dealt "+monsatk+ " damage to the hero.\n Game over!");
                        gameCounter = 1;
                        heroKnight.setHealthPt(2000);
                        acidSlime.setHealthPt(4000);
                        btnNextTurn.setText("Reset Game");
                    }
                }

                break;
        }

    }
}