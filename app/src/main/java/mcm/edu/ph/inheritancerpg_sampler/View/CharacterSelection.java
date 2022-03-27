package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import mcm.edu.ph.inheritancerpg_sampler.R;


public class CharacterSelection extends AppCompatActivity implements View.OnClickListener{


    ImageButton hero1, hero2, hero3, hero4;
    Button btnProceed;
    ImageView heroPortrait;
    TextView heroDesc,txtHeroClass;
    Intent intent;

    int selection = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);



        hero1 = findViewById(R.id.btnHeroIconMage);
        hero2 = findViewById(R.id.btnHeroHunter);
        hero3 = findViewById(R.id.btnHeroWarrior);
        hero4 = findViewById(R.id.btnHeroPaladin);
        btnProceed = findViewById(R.id.btnProceed);
        heroPortrait = findViewById(R.id.imgHeroPortrait);
        heroDesc = findViewById(R.id.txtHeroDesc);
        txtHeroClass = findViewById(R.id.txtHeroClass);

        hero1.setOnClickListener(this);
        hero2.setOnClickListener(this);
        hero3.setOnClickListener(this);
        hero4.setOnClickListener(this);
        btnProceed.setOnClickListener(this);

        intent = new Intent(this,StartingPointAllocation.class);

        hero1.setEnabled(false);
        txtHeroClass.setText("Mage");
        heroDesc.setText("A class with high intelligence growth, they specialize in devastating spells.");
        heroPortrait.setImageResource(R.drawable.hero2);
    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.btnHeroIconMage:
                hero1.setEnabled(false);
                hero2.setEnabled(true);
                hero3.setEnabled(true);
                hero4.setEnabled(true);

                heroPortrait.setImageResource(R.drawable.hero2);
                txtHeroClass.setText("Mage");
                heroDesc.setText("A class with high intelligence growth, they specialize in devastating spells.");
                selection = 1;
                break;

            case R.id.btnHeroHunter:
                hero1.setEnabled(true);
                hero2.setEnabled(false);
                hero3.setEnabled(true);
                hero4.setEnabled(true);


                heroPortrait.setImageResource(R.drawable.hero4);
                txtHeroClass.setText("Ranger");
                heroDesc.setText("A class that makes use of ranged physical attacks");
                selection = 2;
                break;
            case R.id.btnHeroWarrior:
                hero1.setEnabled(true);
                hero2.setEnabled(true);
                hero3.setEnabled(false);
                hero4.setEnabled(true);

                heroPortrait.setImageResource(R.drawable.hero1);
                txtHeroClass.setText("Warrior");
                heroDesc.setText("A hero class that deals great amounts of physical damage");
                selection = 3;



                break;
            case R.id.btnHeroPaladin:
                hero1.setEnabled(true);
                hero2.setEnabled(true);
                hero3.setEnabled(true);
                hero4.setEnabled(false);

                heroPortrait.setImageResource(R.drawable.hero3);
                txtHeroClass.setText("Paladin");
                heroDesc.setText("A class of hero that is inherently tough with its high constitution base");

                intent.putExtra("heroClass","paladin");
                selection = 4;


                break;


            case R.id.btnProceed:
                intent.putExtra("heroClass",selection);
                startActivity(intent);
                break;
        }

    }
}