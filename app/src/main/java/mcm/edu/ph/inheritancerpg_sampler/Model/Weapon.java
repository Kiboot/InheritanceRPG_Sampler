package mcm.edu.ph.inheritancerpg_sampler.Model;

public class Weapon extends GameItem{
    int atkMin;
    int atkMax;

    public Weapon(){}

    public Weapon(String name,int atkMin, int atkMax, double goldValue){
        setName(name);
        setDesc("");
        setGoldValue(goldValue);
        setArmor(0);
        this.atkMin = atkMin;
        this.atkMax = atkMax;
        setStatSTR(0);
        setStatAGI(0);
        setStatINT(0);
        setStatLUK(0);
        setStatCON(0);
        setHealthPt(0);
        setManaPt(0);
    }


}
