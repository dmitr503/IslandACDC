package miroshnyk.LifeForms.Carnivore;

import miroshnyk.LifeForms.Util.Carnivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Wolf extends Carnivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.WOLF;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Wolf(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
