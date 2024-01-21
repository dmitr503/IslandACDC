package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Goat extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.GOAT;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Goat(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
