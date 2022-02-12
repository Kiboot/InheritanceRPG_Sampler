package mcm.edu.ph.inheritancerpg_sampler.View;



public class Zone {

    private String zoneName;
    private String zoneDesc;

    private double expRate = 1;
    private double lootRate = 1;
    private double enemyEncounterRate = 1;
    private double chestEncounterRate = 1;
    private int instanceCount = 10;
    private boolean bossEncounter = false;
    //double enemyEncounterFactor = 0.80;
    //private static double chestEncounterFactor = 0.20;



    public Zone(){}
    public Zone(String zoneName, boolean bossEncounter, int instanceCount){
        this.zoneName = zoneName;
        this.bossEncounter = bossEncounter;
        this.instanceCount = instanceCount;
    }
    public Zone(String zoneName, String zoneDesc, boolean bossEncounter, int instanceCount, double expRate, double lootRate, double chestEncounterRate, double enemyEncounterRate){
        this.zoneName = zoneName;
        this.bossEncounter = bossEncounter;
        this.instanceCount = instanceCount;
        this.zoneDesc = zoneDesc;
        this.expRate = expRate;
        this.lootRate = lootRate;
        this.chestEncounterRate = chestEncounterRate;
        this.enemyEncounterRate = enemyEncounterRate;
    }
    //getters
    public String getZoneName() { return zoneName; }
    public String getZoneDesc() { return zoneDesc; }
    public boolean isBossEncounter() { return bossEncounter; }
    public int getInstanceCount() { return instanceCount; }
    public double getExpRate() { return expRate; }
    public double getLootRate() { return lootRate; }
    public double getChestEncounterRate() { return chestEncounterRate; }
    public double getEnemyEncounterRate() { return enemyEncounterRate; }
    public double getChestEncounterFactor() { return 0.80; }
    public double getEnemyEncounterFactor() { return 0.20; }

    //setters
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }
    public void setZoneDesc(String zoneDesc) { this.zoneDesc = zoneDesc; }
    public void setBossEncounter(boolean bossEncounter) { this.bossEncounter = bossEncounter; }
    public void setInstanceCount(int instanceCount) { this.instanceCount = instanceCount; }
    public void setExpRate(double expRate) { this.expRate = expRate; }
    public void setLootRate(double lootRate) { this.lootRate = lootRate; }
    public void setChestEncounterRate(double chestEncounterRate) { this.chestEncounterRate = chestEncounterRate; }
    public void setEnemyEncounterRate(double enemyEncounterRate) { this.enemyEncounterRate = enemyEncounterRate; }

}