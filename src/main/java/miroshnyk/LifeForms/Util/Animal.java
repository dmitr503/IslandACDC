package miroshnyk.LifeForms.Util;

import miroshnyk.util.LimitData.LimitData;
import miroshnyk.LifeForms.Util.interfaces.Movable;
import miroshnyk.Map.Field;

public class Animal extends LifeForm implements Movable {
    private boolean isAlive = true;


    public Animal(String name, String icon, double mass, LimitData limitData) {
        super(name, icon, mass, limitData);
    }

    @Override
    public void move(Field field) {

    }

    @Override
    public void grow(Field field) {

    }

    public boolean isAlive() {
        return isAlive;
    }
    public void kill(){
        isAlive = false;
    }
}
