package mcm.edu.ph.inheritancerpg_sampler.Model;

public class GameItem {
    private String name;
    private String desc;
    private double goldValue;
    private double armor;

    private int statSTR;
    private int statAGI;
    private int statINT;
    private int statLUK;
    private int statCON;

    private int healthPt;
    private int manaPt;
    private int itemRarity;
    private String itemType;

    public GameItem(){} //default constructor

    //getters
    public String getName() { return name; }
    public String getDesc() { return desc; }
    public double getGoldValue() { return goldValue; }
    public double getArmor() { return armor; }
    public int getStatSTR() { return statSTR; }
    public int getStatAGI() { return statAGI; }
    public int getStatINT() { return statINT; }
    public int getStatLUK() { return statLUK; }
    public int getStatCON() { return statCON; }
    public int getHealthPt() { return healthPt; }
    public int getManaPt() { return manaPt; }
    public int getItemRarity() { return itemRarity; }
    public String getItemType() { return itemType; }

    //setters
    public void setName(String name) { this.name = name; }
    public void setDesc(String desc) { this.desc = desc; }
    public void setGoldValue(double goldValue) { this.goldValue = goldValue; }
    public void setArmor(double armor) { this.armor = armor; }
    public void setStatSTR(int statSTR) { this.statSTR = statSTR; }
    public void setStatAGI(int statAGI) { this.statAGI = statAGI; }
    public void setStatINT(int statINT) { this.statINT = statINT; }
    public void setStatLUK(int statLUK) { this.statLUK = statLUK; }
    public void setStatCON(int statCON) { this.statCON = statCON; }
    public void setHealthPt(int healthPt) { this.healthPt = healthPt; }
    public void setManaPt(int manaPt) { this.manaPt = manaPt; }
    public void setItemRarity(int itemRarity) { this.itemRarity = itemRarity; }
    public void setItemType(String itemType) { this.itemType = itemType; }
}
