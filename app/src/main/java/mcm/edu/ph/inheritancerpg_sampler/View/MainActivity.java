package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import mcm.edu.ph.inheritancerpg_sampler.Model.GameUnit;
import mcm.edu.ph.inheritancerpg_sampler.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView p1name,p2name,p1atk,p2atk,p1health,p2health,p1mana,p2mana,txtLog;
    Button btnNextTurn;

    GameUnit protag = new GameUnit("Protag","Friend", 20, 25, 2000, 500, 5, 5);
    GameUnit enemy = new GameUnit("Enemy", "Monster", 10, 15, 4000, 200, 3, 3);

    int gameCounter = 1;


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


        p1name.setText(protag.getName());
        p2name.setText(enemy.getName());
        p1atk.setText(String.valueOf(protag.getAtkMin())+ " ~ "+ String.valueOf(protag.getAtkMax()));
        p2atk.setText(String.valueOf(enemy.getAtkMin())+ " ~ "+ String.valueOf(enemy.getAtkMax()));
        p1health.setText(String.valueOf(protag.getHealthPt()));
        p2health.setText(String.valueOf(enemy.getHealthPt()));
        p1mana.setText(String.valueOf(protag.getManaPt()));
        p2mana.setText(String.valueOf(enemy.getManaPt()));



    }
    @Override
    public void onClick(View v){

        Random randomizer = new Random();
        int heroatk = randomizer.nextInt(protag.getAtkMax() - protag.getAtkMin()) + protag.getAtkMin();
        int monsatk = randomizer.nextInt(enemy.getAtkMax() - enemy.getAtkMin()) + enemy.getAtkMin();

        switch (v.getId()){
            case R.id.btnNxtTurn:

                if(gameCounter%2 == 1){
                    enemy.setHealthPt(enemy.getHealthPt() - heroatk);
                    txtLog.setText(protag.getName() + " dealt "+heroatk+ " damage to the enemy.");
                    p1health.setText(String.valueOf(enemy.getHealthPt()));
                    gameCounter++;


                }
                else if(gameCounter %2 !=1 ){
                    protag.setHealthPt(protag.getHealthPt() - monsatk);
                    txtLog.setText(enemy.getName() + " dealt "+heroatk+ " damage to the protag.");
                    p2health.setText(String.valueOf(protag.getHealthPt()));
                    gameCounter++;
                }




                break;
        }

    }
}