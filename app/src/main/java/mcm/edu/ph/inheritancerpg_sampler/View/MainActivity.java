package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import mcm.edu.ph.inheritancerpg_sampler.Controller.GameBehavior;
import mcm.edu.ph.inheritancerpg_sampler.Model.GameItem;
import mcm.edu.ph.inheritancerpg_sampler.Model.GameUnit;
import mcm.edu.ph.inheritancerpg_sampler.Model.Hero;
import mcm.edu.ph.inheritancerpg_sampler.Model.Monster;
import mcm.edu.ph.inheritancerpg_sampler.Model.Weapon;
import mcm.edu.ph.inheritancerpg_sampler.Model.Zone;
import mcm.edu.ph.inheritancerpg_sampler.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView p1name,p2name,p1atk,p2atk,p1health,p2health,p1mana,p2mana,txtLog;
    Button btnNextTurn;

    Hero heroKnight = new Hero(
            "Sebas",
            "Knight",
            0,
            12,
            6,
            5,
            3,
            9,
            20,
            25,
            1800,
            500,
            1,
            4);

    Weapon katana = new Weapon("Katana",15,25,60);
    Monster acidSlime = new Monster("Acid Slime", "Slime", 10, 15, 4000, 200, 3, 3);


    GameBehavior g1 = new GameBehavior();

    int gameCounter = 1;
    Zone zone;

    Hero miguel = new Hero(){};

    GameItem redPotion = new GameItem();




    @SuppressLint("SetTextI18n") //Suppress warnings regarding strings
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        miguel.setName("Miguel Langones");
        miguel.setTitle("Protector of Mankind");

        Hero christian = new Hero("Christian","Pogi",0.0,10,3,5,1,5,1,99,10,1000,1, 5){};

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

    int attackDamage(int atkMin, int atkMax,double armor){
        return g1.attack(atkMin, atkMax,armor);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v){


        switch (v.getId()){
            case R.id.btnNxtTurn:

                //g1.delve(1,Zone zone,txtLog,p1health,p2health);

                if(gameCounter%2 == 1){
                    acidSlime.setHealthPt(acidSlime.getHealthPt() - attackDamage(heroKnight.getAtkMin(),heroKnight.getAtkMax(), heroKnight.getArmor()));
                    txtLog.setText(heroKnight.getName() + " dealt "+attackDamage(heroKnight.getAtkMin(),heroKnight.getAtkMax(), heroKnight.getArmor())+ " damage to the enemy.");
                    p1health.setText(String.valueOf(heroKnight.getHealthPt()));
                    gameCounter++;

                    if(acidSlime.getHealthPt() < 0){
                        txtLog.setText(heroKnight.getName() + " dealt "+attackDamage(heroKnight.getAtkMin(),heroKnight.getAtkMax(), heroKnight.getArmor())+ " damage to the enemy.\n You are victorious!");
                        gameCounter = 1;
                        heroKnight.setHealthPt(2000);
                        acidSlime.setHealthPt(4000);
                        btnNextTurn.setText("Reset Game");
                    }
                }

                else if(gameCounter %2 !=1 ){
                    heroKnight.setHealthPt(heroKnight.getHealthPt() - attackDamage(acidSlime.getAtkMin(),acidSlime.getAtkMax(),acidSlime.getArmor()));
                    txtLog.setText(acidSlime.getName() + " dealt "+attackDamage(acidSlime.getAtkMin(),acidSlime.getAtkMax(),acidSlime.getArmor())+ " damage to the protag.");
                    p2health.setText(String.valueOf(acidSlime.getHealthPt()));
                    gameCounter++;

                    if(heroKnight.getHealthPt() < 0){
                        txtLog.setText(acidSlime.getName() + " dealt "+attackDamage(acidSlime.getAtkMin(),acidSlime.getAtkMax(),acidSlime.getArmor())+ " damage to the hero.\n Game over!");
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