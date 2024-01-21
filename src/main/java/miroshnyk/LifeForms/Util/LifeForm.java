package miroshnyk.LifeForms.Util;

import miroshnyk.util.LimitData.LimitData;
import miroshnyk.Map.Field;
import miroshnyk.util.ConsoleHelper;
import miroshnyk.util.LifeFormsFactory;
import miroshnyk.util.LifeFormsOnIdlend;

public class LifeForm {
    private String name;
    private String icon;
    private double mass;
    private int maxCountOnField;
    private final double massMax;
    private final int speed;
    private final double eatSpeed;
    private final double growSpeed;
    private LimitData limitData;

    LifeFormsOnIdlend species;

    public LifeForm(String name, String icon, double mass, LimitData limitData) {
        this.name = name;
        this.icon = icon;
        this.mass = mass;
        this.limitData = limitData;
        this.maxCountOnField = limitData.getmaxCountOnField();
        this.massMax = limitData.getMassMaxLim();
        this.speed = limitData.getSpeedMaxLim();
        this.eatSpeed = limitData.getEatSpeedLim();
        this.growSpeed = limitData.getEatSpeedLim(); //Считаем, что у животных КПД 100%
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public double getMass() {
        return mass;
    }

    public int getMaxCountOnField() {
        return maxCountOnField;
    }

    public double getMassMax() {
        return massMax;
    }

    public int getSpeed() {
        return speed;
    }

    public double getEatSpeed() {
        return eatSpeed;
    }

    public double getGrowSpeed() {
        return growSpeed;
    }

    public LifeFormsOnIdlend getSpecies() {
        return species;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }


    public void reproduce(Field field){
        int correntFieldCount = 0;
        for(LifeForm form : field.lifeForms){
            if (form.getClass().equals(this.getClass())){
                correntFieldCount++;
            }
            if(correntFieldCount > limitData.getmaxCountOnField()){
                field.lifeForms.add(LifeFormsFactory.creatNewLifeform(this.species));
            }
        }
    }

    public void printStatus(){
        ConsoleHelper.print("Name: " + this.name + " mass: " + this.getMass() );
    }
}
