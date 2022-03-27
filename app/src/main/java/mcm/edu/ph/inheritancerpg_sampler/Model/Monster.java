package mcm.edu.ph.inheritancerpg_sampler.Model;

public class Monster extends GameUnit{

    String name;
    String title;
    int atkMin;
    int atkMax;
    int healthPt;
    int manaPt;
    int lvl;
    double armor;

    public Monster(){}
    public Monster(String name, String title, int atkMin, int atkMax, int healthPt, int manaPt, int lvl, double armor){
        this.name = name;
        this.title = title;
        this.atkMin = atkMin;
        this.atkMax = atkMax;
        this.healthPt = healthPt;
        this.manaPt = manaPt;
        this.lvl = lvl;
        this.armor = armor;

        super.name = name;
        super.title = title;
        super.atkMin = atkMin;
        super.atkMax = atkMax;
        super.healthPt = healthPt;
        super.manaPt = manaPt;
        super.lvl = lvl;
        super.armor = armor;

    }


}
