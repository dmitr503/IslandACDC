package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Caterpillar extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.CATERPILLAR;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Caterpillar(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
