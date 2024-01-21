package miroshnyk;

import miroshnyk.LifeForms.Util.LifeForm;
import miroshnyk.Map.Field;
import miroshnyk.util.LifeFormsFactory;

import static miroshnyk.util.LifeFormsOnIdlend.GRASS;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Field field1 = new Field();
        field1.lifeForms.add(LifeFormsFactory.creatNewLifeform(GRASS));
        field1.lifeForms.add(LifeFormsFactory.creatNewLifeform(GRASS));
        for (LifeForm form:
                field1.lifeForms) {
            form.printStatus();
        }
        System.out.println("_________________________");
        System.out.println(field1.lifeForms.size());
        int size = field1.lifeForms.size();
        for (int i = 0; i< size; i++) {
            field1.lifeForms.get(i).reproduce(field1);
        }


        for (LifeForm form:
                field1.lifeForms) {
            form.printStatus();
        }
    }
}
