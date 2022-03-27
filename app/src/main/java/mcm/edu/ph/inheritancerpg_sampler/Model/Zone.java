package mcm.edu.ph.inheritancerpg_sampler.Model;



public class Zone {

    private String zoneName,zoneDesc;

    private double expRate = 1;
    private double lootRate = 1;
    private double enemyEncounterRate = 1;
    private double chestEncounterRate = 1;
    private int instanceCount = 10;
    private int difficultyLevel = 1;
    private boolean bossEncounter = false;

    int x = 123;
    char car = 'J';
    String name = "Kevin";
    boolean single = true;
    double num = 123.31;
    float fal = 123.32f;


    String[] listofnames;
    String list[];





    Zone beginnerZone = new Zone("Beginner Area", "Where beginners level up", false, 10, 1, 1, 1, .2, .8);

    //double enemyEncounterFactor = 0.80;
    //private static double chestEncounterFactor = 0.20;



    public Zone(){}
    public Zone(String zoneName, boolean bossEncounter, int instanceCount, int difficultyLevel){
        this.zoneName = zoneName;
        this.bossEncounter = bossEncounter;
        this.instanceCount = instanceCount;
        this.difficultyLevel = difficultyLevel;
    }
    public Zone(String zoneName, String zoneDesc, boolean bossEncounter, int instanceCount, int difficultyLevel, double expRate, double lootRate, double chestEncounterRate, double enemyEncounterRate){
        this.zoneName = zoneName;
        this.bossEncounter = bossEncounter;
        this.instanceCount = instanceCount;
        this.difficultyLevel = difficultyLevel;
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
    public int getDifficultyLevel() { return difficultyLevel; }
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
    public void setDifficultyLevel(int difficultyLevel) { this.difficultyLevel = difficultyLevel; }
    public void setExpRate(double expRate) { this.expRate = expRate; }
    public void setLootRate(double lootRate) { this.lootRate = lootRate; }
    public void setChestEncounterRate(double chestEncounterRate) { this.chestEncounterRate = chestEncounterRate; }
    public void setEnemyEncounterRate(double enemyEncounterRate) { this.enemyEncounterRate = enemyEncounterRate; }









}