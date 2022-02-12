package mcm.edu.ph.inheritancerpg_sampler.Controller;

import android.widget.TextView;
import java.util.Random;
import mcm.edu.ph.inheritancerpg_sampler.Model.Monster;
import mcm.edu.ph.inheritancerpg_sampler.View.Zone;
import mcm.edu.ph.inheritancerpg_sampler.Model.Hero;
import mcm.edu.ph.inheritancerpg_sampler.R;
import androidx.appcompat.app.AppCompatActivity;


public class GameBehavior {

    Random randomizer = new Random();

    public GameBehavior(){}

    public int attack(int atkMin,int atkMax,double armor){
        double damageReductionFactor = 1- ((0.06 * armor)/(1 +(0.06 * armor)));
        double result = Double.valueOf(randomizer.nextInt(atkMax - atkMin) + damageReductionFactor * atkMin);
        return (int) result;
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

        zoneName = zone.getZoneName();
        zoneDesc = zone.getZoneDesc();
        expRate = zone.getExpRate();
        lootRate = zone.getLootRate();
        enemyEncounterRate = zone.getEnemyEncounterRate();
        chestEncounterRate = zone.getChestEncounterRate();
        instanceCount = zone.getInstanceCount();
        bossEncounter = zone.isBossEncounter();

        while(instanceCount > 0){ //while Instance amount is greater than 10

            int chestRoll = (int)(chestEncounterRate * zone.getChestEncounterFactor())*100;
            int enemyRoll = (int)(enemyEncounterRate * zone.getChestEncounterFactor())*100;

            if(bossEncounter == false){ //typical field/dungeon with no bosses

                if( chestRoll <= 20) { //if the dice rolls 1 to 20, then open a chest
                    //code for chest encounter
                }
                else if(enemyRoll <= 21 && enemyRoll >= 90){ //if the dice rolls 21 to 90, you encounter an enemy
                    //code for enemy encounter
                    combat(monster, hero, txtLog, p1health, p2health);
                }else{
                    //else, nothing happens
                }
                instanceCount--;
            }
        }




    }

    public void combat(Monster monster, Hero hero, TextView txtLog, TextView p1health, TextView p2health){

        int gameCounter = 1;

        int heroatk = attack(hero.getAtkMin(),hero.getAtkMax(),0);
        int monsatk = attack(monster.getAtkMin(),monster.getAtkMax(),0);

        if(gameCounter%2 == 1){
            monster.setHealthPt(monster.getHealthPt() - heroatk);
            txtLog.setText(hero.getName() + " dealt "+heroatk+ " damage to the enemy.");
            p1health.setText(String.valueOf(hero.getHealthPt()));
            gameCounter++;

            if(monster.getHealthPt() < 0){
                txtLog.setText(hero.getName() + " dealt "+heroatk+ " damage to the enemy.\n You are victorious!");
                gameCounter = 1;
            }
        }

        else if(gameCounter %2 !=1 ){
            hero.setHealthPt(hero.getHealthPt() - monsatk);
            txtLog.setText(monster.getName() + " dealt "+monsatk+ " damage to the protag.");
            p2health.setText(String.valueOf(monster.getHealthPt()));
            gameCounter++;

            if(hero.getHealthPt() < 0){
                txtLog.setText(monster.getName() + " dealt "+monsatk+ " damage to the hero.\n Game over!");
                gameCounter = 1;
            }
        }
    }


}
