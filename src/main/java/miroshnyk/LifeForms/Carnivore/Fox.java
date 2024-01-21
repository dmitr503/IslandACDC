package miroshnyk.LifeForms.Carnivore;

import miroshnyk.LifeForms.Util.Carnivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Fox extends Carnivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.FOX;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Fox(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
