package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Duck extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.DUCK;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Duck(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
