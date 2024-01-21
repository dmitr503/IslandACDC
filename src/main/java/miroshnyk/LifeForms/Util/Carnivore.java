package miroshnyk.LifeForms.Util;

import miroshnyk.util.LimitData.LimitData;
import miroshnyk.LifeForms.Util.interfaces.Consument2;
import miroshnyk.Map.Field;

public class Carnivore extends Animal implements Consument2 {

    public Carnivore(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }

    @Override
    public void eetAnimal(Field field) {

    }
}
