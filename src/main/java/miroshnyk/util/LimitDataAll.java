package miroshnyk.util;

import miroshnyk.util.LimitData.LimitData;

import static miroshnyk.util.LifeFormsOnIdlend.*;

public class LimitDataAll {

    public static final LimitData limitDataBear = new LimitData(500, 5,2, 80, 80, BEAR);
    public static final LimitData limitDataBoa = new LimitData(15, 30, 1,3,3, BOA_CONSTRICTOR);
    public static final LimitData limitDataFox = new LimitData(8, 	30,	2, 	2, 2, FOX);
    public static final LimitData limitDataWolf = new LimitData(50, 	30, 	3, 	8, 8, WOLF);
    public static final LimitData limitDataEagle = new LimitData(6, 	20,	3, 	1, 1, EAGLE);
    public static final LimitData limitDataHorse = new LimitData(400, 	20, 	4, 	60, 60, HORSE);
    public static final LimitData limitDataDeer = new LimitData(300, 	20, 	4, 	50, 50, DEER);
    public static final LimitData limitDataRabbit = new LimitData(2, 	150, 	2,	0.45, 0.45, RABBIT);
    public static final LimitData limitDataMouse = new LimitData(0.05, 	500, 	1, 	0.01, 0.01, MOUSE);
    public static final LimitData limitDataGoat = new LimitData(60, 	140, 	3, 	10, 10, GOAT);
    public static final LimitData limitDataSheep = new LimitData(70, 	140, 	3, 	15, 15, SHEEP);
    public static final LimitData limitDataHog = new LimitData(400, 	50, 	2, 	50, 50, HOG);
    public static final LimitData limitDataBuffalo = new LimitData(700, 	10, 	3, 	100, 100, BUFFALO);
    public static final LimitData limitDataDuck = new LimitData(1, 	200, 	4, 	0.15, 0.15, DUCK);
    public static final LimitData limitDataCaterpillar = new LimitData(0.01, 	1000, 	0, 	0, 0, CATERPILLAR);
    public static final LimitData limitDataGrass = new LimitData(1, 200, 0, 0,0, GRASS);

}
    /*Вес одного животного, кг 	Максимальное количество животных этого вида на одной клетке 	Скорость перемещения, не более чем, клеток за ход 	Сколько килограммов пищи нужно животному для полного насыщения
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
