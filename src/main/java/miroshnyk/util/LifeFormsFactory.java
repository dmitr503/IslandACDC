package miroshnyk.util;

import miroshnyk.LifeForms.Carnivore.*;
import miroshnyk.LifeForms.Grass;
import miroshnyk.LifeForms.Herbivore.*;
import miroshnyk.LifeForms.Util.LifeForm;

public class LifeFormsFactory {
    public static LifeForm creatNewLifeform(LifeFormsOnIdlend form) {

        LifeForm lifeForm = null;
        switch (form) {
            case BEAR -> lifeForm = new Bear("Bear", "B", 500, LimitDataAll.limitDataBear);
            case BOA_CONSTRICTOR -> lifeForm = new Boa("Boa", "B",15, LimitDataAll.limitDataBoa);
            case EAGLE -> lifeForm = new Eagle("Eagle", "E", 6, LimitDataAll.limitDataEagle);
            case FOX -> lifeForm = new Fox("Fox", "F", 8, LimitDataAll.limitDataFox);
            case WOLF -> lifeForm = new Wolf("Wolf", "W", 50, LimitDataAll.limitDataWolf);
            case BUFFALO -> lifeForm = new Buffalo("Buffalo", "W", 50, LimitDataAll.limitDataBuffalo);
            case CATERPILLAR -> lifeForm = new Caterpillar("Caterpillar", "W", 50, LimitDataAll.limitDataCaterpillar);
            case DEER -> lifeForm = new Deer("Deer", "De", 300, LimitDataAll.limitDataDeer);
            case DUCK -> lifeForm = new Duck("Duck", "Du", 1, LimitDataAll.limitDataDuck);
            case GOAT -> lifeForm = new Goat("Goat", "Go", 60, LimitDataAll.limitDataGoat);
            case HOG -> lifeForm = new Hog("Hog", "H", 400, LimitDataAll.limitDataHog);
            case HORSE -> lifeForm = new Horse("Horse", "Ho", 400, LimitDataAll.limitDataHorse);
            case MOUSE -> lifeForm = new Mouse("Mouse", "M", 0.05, LimitDataAll.limitDataMouse);
            case RABBIT -> lifeForm = new Rabbit("Rabbit", "R", 2, LimitDataAll.limitDataRabbit);
            case SHEEP -> lifeForm = new Sheep("Sheep", "S", 70, LimitDataAll.limitDataSheep);
            case GRASS -> lifeForm = new Grass("Grass", "G", 1, LimitDataAll.limitDataGrass);
            default -> {
            }
        }
        return lifeForm;
    }
}
/*
Вес одного животного, кг 	Максимальное количество животных этого вида на одной клетке 	Скорость перемещения, не более чем, клеток за ход 	Сколько килограммов пищи нужно животному для полного насыщения
        Волк 	50 	30 	3 	8
        Удав 	15 	30 	1 	3
        Лиса 	8 	30 	2 	2
        Медведь 	500 	5 	2 	80
        Орел 	6 	20 	3 	1
        Лошадь 	400 	20 	4 	60
        Олень 	300 	20 	4 	50
        Кролик 	2 	150 	2 	0,45
        Мышь 	0.05 	500 	1 	0.01
        Коза 	60 	140 	3 	10
        Овца 	70 	140 	3 	15
        Кабан 	400 	50 	2 	50
        Буйвол 	700 	10 	3 	100
        Утка 	1 	200 	4 	0,15
        Гусеница 	0.01 	1000 	0 	0
        Растения 	1 	200 	N/A 	N/A
 */