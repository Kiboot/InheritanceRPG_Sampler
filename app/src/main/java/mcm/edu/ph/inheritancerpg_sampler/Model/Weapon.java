package mcm.edu.ph.inheritancerpg_sampler.Model;

public class Weapon extends GameItem{
    private String weaponType;
    private int atkMin;
    private int atkMax;


    public Weapon(){} //default constructor

    //basic weapon constructor
    public Weapon(String name,int atkMin, int atkMax, double goldValue){
        setName(name);
        setDesc("");
        setWeaponType("");
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
    public Weapon(String name, String weaponType, int atkMin, int atkMax, double goldValue){
        setName(name);
        setWeaponType(weaponType);
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



    //getters
    public int getAtkMin() { return atkMin; }
    public int getAtkMax() { return atkMax; }
    public String getWeaponType() { return weaponType; }

    //setters
    public void setAtkMin(int atkMin) { this.atkMin = atkMin; }
    public void setAtkMax(int atkMax){ this.atkMax = atkMax; }
    public void setWeaponType(String weaponType){ this.weaponType = weaponType;}

    ;
}
