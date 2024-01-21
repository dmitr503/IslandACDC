package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Hog extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.HOG;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Hog(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
