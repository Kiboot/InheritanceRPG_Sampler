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
    int lvl = 1;
    double armor = 0;
    // miscellaneous variables
    double xpToLvlUp = lvl * 200;


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

    public int getStatSTR() { return statSTR; }
    public int getStatAGI() { return statAGI; }
    public int getStatCON() { return statCON; }
    public int getStatINT() { return statINT; }
    public int getStatLUK() { return statLUK; }

    public void setStatSTR(int statSTR) {
        this.statSTR = statSTR;
    }
    public void setStatAGI(int statAGI) {
        this.statAGI = statAGI;
    }
    public void setStatCON(int statCON) {
        this.statCON = statCON;
    }
    public void setStatINT(int statINT) {
        this.statINT = statINT;
    }
    public void setStatLUK(int statLUK) {
        this.statLUK = statLUK;
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


    //passive level up stat growth
    public void levelUpGrowth(int statSTR, int statAGI, int statCON, int statLUK, int statINT){
        this.statSTR += statSTR;
        this.statAGI += statAGI;
        this.statINT += statINT;
        this.statCON += statCON;
        this.statLUK += statLUK;

        getHealthPt();
        getManaPt();
        getAtkMax();
        getAtkMin();


    }
    //point allocation stat growth
    public void statAllocGrowth(int statSTR, int statAGI, int statCON, int statLUK, int statINT){
        this.statSTR += statSTR;
        this.statAGI += statAGI;
        this.statINT += statINT;
        this.statCON += statCON;
        this.statLUK += statLUK;

        getHealthPt();
        getManaPt();
        getAtkMax();
        getAtkMin();

    }
    public void lvlUp(){
        if(xpPt > xpToLvlUp){
            xpPt = 0;
            lvl += 1;
            xpToLvlUp = lvl * 200;
            levelUpGrowth(statSTR,statAGI,statCON,statLUK,statINT);

        }

    }

}
