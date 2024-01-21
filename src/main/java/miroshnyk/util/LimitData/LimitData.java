package miroshnyk.util.LimitData;

import miroshnyk.util.LifeFormsOnIdlend;

public class LimitData {
    private int maxCountOnField;
    private double massMaxLim;
    private int speedMaxLim;
    private double eatSpeedLim;
    private double growSpeedLim;

    private LifeFormsOnIdlend spesies;


    public LimitData(double massMaxLim, double maxCountOnField,  int speedMaxLim, double eatSpeedLim, double growSpeedLim, LifeFormsOnIdlend spesies) {
        this.massMaxLim = maxCountOnField;
        this.massMaxLim = massMaxLim;
        this.speedMaxLim = speedMaxLim;
        this.eatSpeedLim = eatSpeedLim;
        this.growSpeedLim = growSpeedLim;
        this.spesies = spesies;
    }

    public int getmaxCountOnField() {
        return maxCountOnField;
    }

    public double getMassMaxLim() {
        return massMaxLim;
    }

    public int getSpeedMaxLim() {
        return speedMaxLim;
    }

    public double getEatSpeedLim() {
        return eatSpeedLim;
    }

    public double getGrowSpeedLim() {
        return growSpeedLim;
    }
}
