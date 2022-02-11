package mcm.edu.ph.inheritancerpg_sampler.Model;

public class Hero extends GameUnit{
    double xpPt;
    int statSTR;
    int statAGI;
    int statINT;
    int statLUK;
    int statCON;
    int goldValue;

    //borrowed variables
    String name;
    String title;
    int atkMin;
    int atkMax;
    int healthPt;
    int manaPt;
    int lvl;
    double armor;


    public Hero(){} //default constructor

    public Hero(String name,String title, double xpPt, int statSTR, int statAGI, int statINT, int statLUK, int statCON, int atkMin, int atkMax, int healthPt, int manaPt, int lvl, double armor){

        this.name = name;
        this.title = title;
        this.atkMin = atkMin;
        this.atkMax = atkMax;
        this.healthPt = healthPt;
        this.manaPt = manaPt;
        this.lvl = lvl;
        this.armor = armor;

        this.xpPt = xpPt;
        this.statSTR = statSTR;
        this.statAGI = statAGI;
        this.statINT = statINT;
        this.statLUK = statLUK;

        super.setName(name);
        super.setTitle(title);
        super.setAtkMin(atkMin);
        super.setAtkMax(atkMax);
        super.setHealthPt(healthPt);
        super.setManaPt(manaPt);
        super.setLvl(lvl);
        super.setArmor(armor);
    }
    public Hero(String name, double xpPt, int statSTR, int statAGI, int statINT, int statLUK, int atkMin, int atkMax, int healthPt, int manaPt, int lvl, double armor){

        this.name = name;
        this.title = "";
        this.atkMin = atkMin;
        this.atkMax = atkMax;
        this.healthPt = healthPt;
        this.manaPt = manaPt;
        this.lvl = lvl;
        this.armor = armor;

        this.xpPt = xpPt;
        this.statSTR = statSTR;
        this.statAGI = statAGI;
        this.statINT = statINT;
        this.statLUK = statLUK;
        this.statCON = statCON;

        super.setName(name);
        super.setTitle(title);
        super.setAtkMin(atkMin);
        super.setAtkMax(atkMax);
        super.setHealthPt(healthPt);
        super.setManaPt(manaPt);
        super.setLvl(lvl);
        super.setArmor(armor);
    }
    public Hero(String name, double xpPt, int statSTR, int statAGI, int statINT, int statLUK, int atkMin, int atkMax, int healthPt, int manaPt, double armor){

        this.name = name;
        this.title = "";
        this.atkMin = atkMin;
        this.atkMax = atkMax;
        this.healthPt = healthPt;
        this.manaPt = manaPt;
        this.lvl = 1;
        this.armor = armor;

        this.xpPt = xpPt;
        this.statSTR = statSTR;
        this.statAGI = statAGI;
        this.statINT = statINT;
        this.statLUK = statLUK;

        super.setName(name);
        super.setTitle(title);
        super.setAtkMin(atkMin);
        super.setAtkMax(atkMax);
        super.setHealthPt(healthPt);
        super.setManaPt(manaPt);
        super.setLvl(lvl);
        super.setArmor(armor);
    }

    @Override
    public int getHealthPt() {
        this.healthPt = super.getHealthPt();
        this.healthPt += (statCON * 20); //20 points of health added per stat point of CON
        return healthPt;
    }

    @Override
    public int getManaPt() {
        this.manaPt = super.getManaPt();
        this.manaPt += (statINT * 12); //12 points of mana added per stat point of INT
        return manaPt;
    }
    @Override
    public int getAtkMax() {
        this.atkMax = super.getAtkMax();
        this.atkMax += (statSTR * 2); //2 points of maximum damage added per stat point of STR
        return atkMax;
    }

    @Override
    public int getAtkMin() {
        this.atkMin = super.getAtkMin();
        this.atkMin += (statAGI * 2); //2 points of minimum damage added per stat point of AGI
        return atkMin;
    }

}
