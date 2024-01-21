package miroshnyk.LifeForms.Carnivore;

import miroshnyk.LifeForms.Util.Carnivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Bear extends Carnivore {
    private LifeFormsOnIdlend species = LifeFormsOnIdlend.BEAR;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }
    public Bear(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }


}
