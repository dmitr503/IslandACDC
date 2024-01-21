package miroshnyk.LifeForms.Carnivore;

import miroshnyk.LifeForms.Util.Carnivore;
import miroshnyk.util.LimitData.LimitData;
import miroshnyk.util.LifeFormsOnIdlend;

public class Boa extends Carnivore {
    LifeFormsOnIdlend species = LifeFormsOnIdlend.BOA_CONSTRICTOR;
    public LifeFormsOnIdlend getSpecies() {
        return species;
    }

    public Boa(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }
}
