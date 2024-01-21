package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Rabbit extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.RABBIT;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Rabbit(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
