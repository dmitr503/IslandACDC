package com.javarush.island.khmelov;

import com.javarush.island.khmelov.api.init.Initialization;
import com.javarush.island.khmelov.api.view.View;
import com.javarush.island.khmelov.config.Setting;
import com.javarush.island.khmelov.entity.Game;
import com.javarush.island.khmelov.entity.map.GameMap;
import com.javarush.island.khmelov.repository.EntityCreator;
import com.javarush.island.khmelov.repository.GameMapCreator;
import com.javarush.island.khmelov.services.GameWorker;
import com.javarush.island.khmelov.view.console.ConsoleView;

public class ConsoleRunner {
    public static void main(String[] args) {
        Initialization entityFactory = new EntityCreator();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        int rows = Setting.get().life.getRows();
        int cols = Setting.get().life.getCols();
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(rows, cols, 50);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
