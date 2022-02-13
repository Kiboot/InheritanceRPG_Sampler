package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mcm.edu.ph.inheritancerpg_sampler.R;

public class TownHall extends AppCompatActivity implements View.OnClickListener{

    Button btnAdventure, btnMarket, btnQuest, btnShowStats, btnShowInventory;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_hall);

        btnAdventure = findViewById(R.id.btnAdventure);
        btnMarket = findViewById(R.id.btnMarket);
        btnQuest = findViewById(R.id.btnQuest);
        btnShowStats = findViewById(R.id.btnShowStats);
        btnShowInventory = findViewById(R.id.btnShowInventory);

        btnAdventure.setOnClickListener(this);
        btnMarket.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdventure:
                //TODO: Adventure button.
                i = new Intent(this,Adventure.class);
                startActivity(i);
                break;

            case R.id.btnMarket:
                //TODO: Market button intent
                break;
        }
    }
}