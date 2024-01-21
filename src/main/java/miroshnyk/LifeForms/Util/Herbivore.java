package miroshnyk.LifeForms.Util;

import miroshnyk.LifeForms.Grass;
import miroshnyk.util.LifeFormsOnIdlend;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.LifeForms.Util.interfaces.Consument1;
import miroshnyk.Map.Field;

public class Herbivore extends Animal implements Consument1 {
    public Herbivore(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }

    @Override
    public void eatPlant(Field field) {
        double eatPotential = this.getEatSpeed();

        for (int i = 0; i < field.lifeForms.size(); i++){

            if (field.lifeForms.get(i).getSpecies().equals(LifeFormsOnIdlend.GRASS)){
                LifeForm grass = field.lifeForms.get(i);
                if(grass.getMass() > eatPotential){
                    grass.setMass(getMass() - eatPotential);
                    eatPotential = 0;
                    return;
                } else {
                    eatPotential -= grass.getMass();
                    field.lifeForms.remove(i);
                }
            }
            if (eatPotential <= 0) return;
        }
    }
}
