package com.javarush.island.khmelov.view.javafx;

import com.javarush.island.khmelov.api.view.View;
import com.javarush.island.khmelov.config.Setting;
import com.javarush.island.khmelov.config.Window;
import com.javarush.island.khmelov.entity.Game;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizm.Organisms;
import com.javarush.island.khmelov.services.GameWorker;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.stream.Collectors;

public class JavaFxView extends Application implements View {

    private static GameWorker gameWorker;

    private Game game;
    private int rows;
    private int cols;
    private Label[][] viewMap;
    private final StringBuilder mapOut = new StringBuilder();

    private int cellWidth;
    private Label statistics;
    private int statWidth;
    private int width;
    private int height;

    public static void launchFxWindow(GameWorker gameWorker) {
        JavaFxView.gameWorker = gameWorker; //send to init(...) and start(...)
        launch();
        gameWorker.getGame().setFinished(true);
    }

    @Override
    public void init() {
        game = gameWorker.getGame();
        rows = game.getGameMap().getRows();
        cols = game.getGameMap().getCols();

        Window window = Setting.get().window;
        statWidth = 200;
        cellWidth = window.getCellWidth();
        width = window.getWidth();
        height = window.getHeight();
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane gameMapPane = new GridPane();
        gameMapPane.setPrefHeight(height);
        gameMapPane.setPrefWidth(width - statWidth);

        viewMap = new Label[rows][cols];

        for (int i = 0; i < cols; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100d / cols);
            col.setHgrow(Priority.NEVER);
            gameMapPane.getColumnConstraints().add(col);
        }

        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100d / rows);
            row.setVgrow(Priority.NEVER);
            gameMapPane.getRowConstraints().add(row);
        }

        gameMapPane.setGridLinesVisible(true);
        for (int i = 0, mapLength = viewMap.length; i < mapLength; i++) {
            for (int j = 0; j < viewMap[i].length; j++) {
                Label label = new Label(i + "|" + j);
                label.setFont(Font.font(15));
                label.setWrapText(true);
                viewMap[i][j] = label;
                gameMapPane.add(viewMap[i][j], j, i);
            }
        }

        statistics = new Label();
        statistics.setWrapText(true);
        statistics.setFont(Font.font(18));
        statistics.setMaxWidth(statWidth);
        statistics.setMinWidth(statWidth);

        HBox hBox = new HBox(gameMapPane, statistics);

        Scene scene = new Scene(hBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
        game.setView(this); //view complete, send to game.
        Platform.runLater(gameWorker);
    }

    @Override
    public void show() {
        showScale();
        showMap();
        showStatistics();
    }

    @Override
    public String showStatistics() {
        String text = game.getGameMap()
                .getStatistics()
                .entrySet()
                .stream()
                .map(e -> e.getKey().getIcon() + "(" + e.getKey().getName() + "): " + e.getValue())
                .collect(Collectors.joining("\n"));
        Platform.runLater(() -> statistics.setText(text));
        return text;
    }

    @Override
    public String showScale() {
        return null;
    }

    @Override
    public String showMap() {
        Platform.runLater(this::fillViewMap);
        return mapOut.toString();
    }

    private void fillViewMap() {
        mapOut.setLength(0);
        Cell[][] cells = game.getGameMap().getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                String text = get(cells[i][j]);
                mapOut.append(text).append(j < cells[i].length - 1 ? "|" : "\n");
                viewMap[i][j].setText(text);
            }
        }
    }

    private String get(Cell cell) {
        try {
            cell.getLock().lock();
            return cell.getResidents().values().stream()
                    .filter((list) -> !list.isEmpty())
                    .sorted((o1, o2) -> o2.size() - o1.size())
                    .limit(cellWidth)
                    .map(Organisms::getIcon)
                    .collect(Collectors.joining());
        } finally {
            cell.getLock().unlock();
        }
    }
}
