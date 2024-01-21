package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Buffalo extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.BUFFALO;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Buffalo(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
