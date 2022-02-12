package mcm.edu.ph.inheritancerpg_sampler.Controller;

import java.util.Random;

import mcm.edu.ph.inheritancerpg_sampler.View.Zone;


public class GameBehavior {

    Random randomizer = new Random();

    public GameBehavior(){}

    public int attack(int atkMin,int atkMax,double armor){
        double damageReductionFactor = 1- ((0.06 * armor)/(1 +(0.06 * armor)));
        double result = Double.valueOf(randomizer.nextInt(atkMax - atkMin) + damageReductionFactor * atkMin);
        return (int) result;
    }

    public void delve(int provisions, Zone zone){
        String zoneName;
        String zoneDesc;



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
                }else{
                    //else, nothing happens
                }
                instanceCount--;

            }









        }

    }








}
