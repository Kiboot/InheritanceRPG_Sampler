package mcm.edu.ph.inheritancerpg_sampler.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import mcm.edu.ph.inheritancerpg_sampler.Controller.GameBehavior;
import mcm.edu.ph.inheritancerpg_sampler.Model.Hero;
import mcm.edu.ph.inheritancerpg_sampler.Model.Monster;
import mcm.edu.ph.inheritancerpg_sampler.Model.Weapon;
import mcm.edu.ph.inheritancerpg_sampler.Model.Zone;
import mcm.edu.ph.inheritancerpg_sampler.R;

public class Adventure extends AppCompatActivity implements View.OnClickListener{

    Button btnInteract1, btnInteract2;

    GameBehavior g1;
    Zone startingArea;
    TextView txtLog, txtP1Health, txtP2Health;
    Hero hero;
    Monster monster;

    Random randomizer = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);


        btnInteract1 = findViewById(R.id.btnInteract1);
        btnInteract2 = findViewById(R.id.btnInteract2);
        txtLog = findViewById(R.id.txtLog);
        txtP1Health = findViewById(R.id.txtP1Health);
        txtP2Health = findViewById(R.id.txtP2Health);


        btnInteract1.setOnClickListener(this);
        btnInteract2.setOnClickListener(this);


        startingArea = new Zone("Starting Area", "Zone Desc", false, 10, 1, 1, 1, .20, .80);
        hero = new Hero("Hero Name","Paladin",8,8,8,8,8,55,50,6000,300);
        monster = new Monster("Bat","BAaAaT!", 15, 20, 3000, 300, 1, 5);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInteract1:
                //TODO: interact button 1.
                delve(30, startingArea, txtLog, txtP1Health, txtP2Health);
                break;
            case R.id.btnInteract2:
                //TODO: interact button 2
                break;
        }
    }






    public void delve(int provisions, Zone zone, TextView txtLog, TextView p1health, TextView p2health){

        String zoneName;
        String zoneDesc;
        Monster monster = new Monster();
        Hero hero = new Hero();

        double expRate = 1;
        double lootRate = 1;
        double enemyEncounterRate = 1;
        double chestEncounterRate = 1;
        int instanceCount = 10;
        boolean bossEncounter = false;
        int difficultyLevel = 1;

        zoneName = zone.getZoneName();
        zoneDesc = zone.getZoneDesc();
        expRate = zone.getExpRate();
        lootRate = zone.getLootRate();
        difficultyLevel = zone.getDifficultyLevel();
        enemyEncounterRate = zone.getEnemyEncounterRate();
        chestEncounterRate = zone.getChestEncounterRate();
        instanceCount = zone.getInstanceCount();
        bossEncounter = zone.isBossEncounter();

        while(instanceCount > 0){ //while Instance amount is greater than 10
            int chestRoll = (int)(chestEncounterRate * zone.getChestEncounterFactor())*100;
            int enemyRoll = (int)(enemyEncounterRate * zone.getEnemyEncounterFactor())*100;

            if(bossEncounter == false){ //typical field/dungeon with no bosses

                if( chestRoll <= 20) { //if the dice rolls 1 to 20, then open a chest
                    //TODO: put the code for chest encounter here
                    dungeonChest(difficultyLevel,hero); //code for chest loot randomizer
                }
                else if(enemyRoll <= 21 && enemyRoll >= 90){ //if the dice rolls 21 to 90, you encounter an enemy
                    //TODO: put the code for enemy encounter here
                    combat(monster, hero, txtLog, p1health, p2health); // the code for turn based combat
                }else{
                    //else, nothing happens
                    txtLog.setText("Nothing Happens...");
                }
                instanceCount--;
            }
        }
    }

    public void combat(Monster monster, Hero hero, TextView txtLog, TextView p1health, TextView p2health){
        int gameCounter = 1; //the games turn counter
        int heroAtk = g1.attack(hero.getAtkMin(),hero.getAtkMax(),monster.getArmor()); // damage randomizer for hero
        int monsAtk = g1.attack(monster.getAtkMin(),monster.getAtkMax(),hero.getArmor()); // damage randomizer for monster

        if(gameCounter%2 == 1){
            monster.setHealthPt(monster.getHealthPt() - heroAtk);
            txtLog.setText(hero.getName() + " dealt "+heroAtk+ " damage to the "+monster.getName()+".");
            p1health.setText(String.valueOf(hero.getHealthPt()));
            gameCounter++;
            if(monster.getHealthPt() < 0){
                txtLog.setText(hero.getName() + " dealt "+heroAtk+ " damage to the "+monster.getName()+".\n You are victorious!");
                gameCounter = 1;
            }
        }
        else if(gameCounter %2 !=1 ){
            hero.setHealthPt(hero.getHealthPt() - monsAtk);
            txtLog.setText(monster.getName() + " dealt "+monsAtk+ " damage to the "+hero.getName()+".");
            p2health.setText(String.valueOf(monster.getHealthPt()));
            gameCounter++;
            if(hero.getHealthPt() < 0){
                txtLog.setText(monster.getName() + " dealt "+monsAtk+ " damage to the "+hero.getName()+".\n Game Over!");
                gameCounter = 1;
            }
        }
    }
    public void dungeonChest(int difficultyLevel,Hero hero){
        // TODO: More sophisticated loot system
        // Self made rules for chest rarity. You can make a better one for yourself.
        // We have a base level of 1 for dungeon difficulty. Lets say for a dungeon this level,
        // we have this chances of rarity for chest:
        // 60% Chance for Common. Have a base value of 20 and a random factor of 10 ~ 15
        // 20% Chance for Uncommon. Have a base value of 30 and a random factor of 20 ~ 25
        // 10% Chance for Rare. Have a base value of 35 and a random factor of 30 ~ 35
        // 6%  Chance for Arcane. Have a base value of 40 and a random factor of 35 ~ 40
        // 3%  Chance for Legendary. Have a base value of 45 and a random factor of 50 ~ 55
        // 1%  Chance for Mythical. Have a base value of 50 and a random factor of 60 ~ 70

        Weapon weapon = new Weapon(); //Weapon class imported. Armor and other loot should be imported too

        int itemRoll = randomizer.nextInt(100); //basic roll to 100, TODO: to be replaced

        if(itemRoll >=0 && itemRoll <= 60){
            //Self-made common roll code TODO: better item generator
            weapon.setAtkMin(randomizer.nextInt(5) +difficultyLevel + hero.getLvl() + 5);
            weapon.setAtkMax(randomizer.nextInt(5) +difficultyLevel + hero.getLvl() + 10);
            hero.setGoldValue(randomizer.nextInt(difficultyLevel + hero.getLvl() + 2  * 3));
        }
        else if(itemRoll >= 61 && itemRoll <= 80){
            //Uncommon roll code
            weapon.setAtkMin(randomizer.nextInt(5) +difficultyLevel + hero.getLvl() + 15);
            weapon.setAtkMax(randomizer.nextInt(5) +difficultyLevel + hero.getLvl() + 20);
            hero.setGoldValue(randomizer.nextInt(difficultyLevel + hero.getLvl() + 4  * 3));
        }
        else if(itemRoll >= 81 && itemRoll <= 90){
            //Rare roll code
            weapon.setAtkMin(randomizer.nextInt(10) +difficultyLevel + hero.getLvl() + 20);
            weapon.setAtkMax(randomizer.nextInt(10) +difficultyLevel + hero.getLvl() + 25);
            hero.setGoldValue(randomizer.nextInt(difficultyLevel + hero.getLvl() + 8  * 3));
        }
        else if(itemRoll >= 91 && itemRoll <= 96){
            //Arcane roll code
            weapon.setAtkMin(randomizer.nextInt(15) +difficultyLevel + hero.getLvl() + 30);
            weapon.setAtkMax(randomizer.nextInt(15) +difficultyLevel + hero.getLvl() + 35);
            hero.setGoldValue(randomizer.nextInt(difficultyLevel + hero.getLvl() + 16  * 3));
        }
        else if(itemRoll >= 97 && itemRoll <= 99){
            //Legendary roll code
            weapon.setAtkMin(randomizer.nextInt(15) +difficultyLevel + hero.getLvl() + 40);
            weapon.setAtkMax(randomizer.nextInt(15) +difficultyLevel + hero.getLvl() + 50);
            hero.setGoldValue(randomizer.nextInt(difficultyLevel + hero.getLvl() + 32  * 3));
        }
        else{
            //Mythical roll code
            weapon.setAtkMin(randomizer.nextInt(20) +difficultyLevel + hero.getLvl() + 55);
            weapon.setAtkMax(randomizer.nextInt(20) +difficultyLevel + hero.getLvl() + 80);
            hero.setGoldValue(randomizer.nextInt(difficultyLevel + hero.getLvl() + 64  * 3));
        }






    }






}