package miroshnyk.LifeForms;

import miroshnyk.util.LimitData.LimitData;
import miroshnyk.LifeForms.Util.Plant;
import miroshnyk.Map.Field;
import miroshnyk.util.LifeFormsFactory;
import miroshnyk.util.LifeFormsOnIdlend;

import static miroshnyk.util.LifeFormsOnIdlend.GRASS;

public class Grass extends Plant {
    private String name;
    private String icon;
    private double mass;
    private int maxCountOnField;
    private final double massMax;
    private final int speed;
    private final double eatSpeed;
    private final double growSpeed;
    private LimitData limitData;

    LifeFormsOnIdlend species = GRASS;
    public Grass(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
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

   public void reproduce(Field field){
        field.correntFieldCountGrass = 0;
        for(int i = 0 ; i < field.lifeForms.size(); i++){
            System.out.println(field.lifeForms.getClass());
            System.out.println(this.getClass());
            if (field.lifeForms.get(i).getSpecies()==(this.getSpecies())){
                field.correntFieldCountGrass++;
            }
        }
       if(field.correntFieldCountGrass > limitData.getmaxCountOnField()){
           field.lifeForms.add(LifeFormsFactory.creatNewLifeform(this.species));
           return;
       }
    }
}
