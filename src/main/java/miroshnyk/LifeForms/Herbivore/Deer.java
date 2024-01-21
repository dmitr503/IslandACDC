package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Deer extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.DEER;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Deer(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
