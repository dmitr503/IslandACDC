package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Sheep extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.SHEEP;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Sheep(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
