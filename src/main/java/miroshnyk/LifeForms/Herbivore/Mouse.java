package miroshnyk.LifeForms.Herbivore;

import miroshnyk.LifeForms.Util.Herbivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Mouse extends Herbivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.MOUSE;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Mouse(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
