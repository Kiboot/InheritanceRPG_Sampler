package mcm.edu.ph.inheritancerpg_sampler.Model;


public class GameUnit {
    String name;
    String title;
    int atkMin;
    int atkMax;
    int healthPt;
    int manaPt;
    int lvl;
    double armor;


    public GameUnit(){}

    public GameUnit(String name, String title, int atkMin, int atkMax, int healthPt, int manaPt, int lvl, double armor){
        this.name = name;
        this.title = title;
        this.atkMin = atkMin;
        this.atkMax = atkMax;
        this.healthPt = healthPt;
        this.manaPt = manaPt;
        this.lvl = lvl;
        this.armor = armor;
    }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setTitle(String title) { this.title = title; }
    public void setAtkMin(int atkMin) { this.atkMin = atkMin; }
    public void setAtkMax(int atkMax) { this.atkMax = atkMax; }
    public void setHealthPt(int healthPt) { this.healthPt = healthPt; }
    public void setManaPt(int manaPt) { this.manaPt = manaPt; }
    public void setLvl(int lvl) { this.lvl = lvl; }
    public void setArmor(double armor) { this.armor = armor; }

    //Getters
    public String getName() { return name; }
    public String getTitle() { return title;}
    public int getAtkMin() { return atkMin; }
    public int getAtkMax() { return atkMax; }
    public int getHealthPt() {return healthPt; }
    public int getManaPt() {return manaPt; }
    public int getLvl() { return lvl; }
    public double getArmor() { return armor; }




}
