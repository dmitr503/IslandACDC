package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Horse extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.HORSE;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Horse(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
