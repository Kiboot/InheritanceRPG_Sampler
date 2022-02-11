package mcm.edu.ph.inheritancerpg_sampler.Controller;

import java.util.Random;

public class GameBehavior {

    Random randomizer = new Random();





    public GameBehavior(){}

    public int attack(int atkMin,int atkMax){
        return randomizer.nextInt(atkMax - atkMin) + atkMin;
    }


}
