package miroshnyk.LifeForms.Util;

import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Plant extends LifeForm {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.GRASS;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Plant(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }


}
