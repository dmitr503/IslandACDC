package com.javarush.island.khmelov.services;

import com.javarush.island.khmelov.api.init.Initialization;
import com.javarush.island.khmelov.api.view.View;
import com.javarush.island.khmelov.config.Setting;
import com.javarush.island.khmelov.entity.Game;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@RequiredArgsConstructor
public class GameWorker extends Thread {
    public static final int CORE_POOL_SIZE = 4;
    private final Game game;
    private final int PERIOD = Setting.get().life.getPeriod();
    private Initialization entityFactory;
    private ScheduledExecutorService mainPool;

    @Override
    public void run() {
        View view = game.getView();
        mainPool = Executors.newSingleThreadScheduledExecutor();
        entityFactory = game.getEntityFactory();
        List<OrganismWorker> workers = entityFactory
                .getAllPrototypes()
                .stream()
                .map(o -> new OrganismWorker(o, game.getGameMap()))
                .toList();
        mainPool.scheduleWithFixedDelay(() -> doOneStepGame(view, workers)
                , 0, PERIOD, TimeUnit.MILLISECONDS);
    }

    private void doOneStepGame(View view, List<OrganismWorker> workers) {
        try (ExecutorService servicePool = Executors.newFixedThreadPool(CORE_POOL_SIZE)) {
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            awaitAndRepaint(view, servicePool);
            if (game.isFinished()) {
                mainPool.shutdown();
            } else {
                entityFactory.fill(game.getGameMap().getCells()[0][0], 5);
            }
        }
    }

    private void awaitAndRepaint(View view, ExecutorService servicePool) {
        if (awaitPool(servicePool)) {
            game.getGameMap().updateStatistics();
            view.show();
        }
    }

    @SneakyThrows
    private boolean awaitPool(ExecutorService servicePool) {
         return servicePool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

}
