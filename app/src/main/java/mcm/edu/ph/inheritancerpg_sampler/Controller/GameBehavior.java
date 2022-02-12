package mcm.edu.ph.inheritancerpg_sampler.Controller;

import java.util.Random;

public class GameBehavior {

    Random randomizer = new Random();





    public GameBehavior(){}

    public int attack(int atkMin,int atkMax,double armor){

        double damageReductionFactor = 1- ((0.06 * armor)/(1 +(0.06 * armor)));

        double result = Double.valueOf(randomizer.nextInt(atkMax - atkMin) + damageReductionFactor * atkMin);

        return (int) result;
    }








}
