package com.javarush.island.khmelov.view.javafx;

import com.javarush.island.khmelov.api.view.View;
import com.javarush.island.khmelov.config.Setting;
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
    private final StringBuilder mapOut = new StringBuilder("empty");

    private final static int cellWidth = 4;
    private Label statistics;

    public JavaFxView() {
        System.out.println("test");
    }

    @Override
    public void init() {
        game = gameWorker.getGame();
        rows = game.getGameMap().getRows();
        cols = game.getGameMap().getCols();
    }

    @Override
    public void start(Stage primaryStage) {

        int width = Setting.get().window.getWidth();
        int height = Setting.get().window.getHeight();

        GridPane gameMapPane = new GridPane();
        gameMapPane.setPrefHeight(height);

        viewMap = new Label[rows][cols];

        for (int i = 0; i < cols; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100d/cols);
            gameMapPane.getColumnConstraints().add(col);
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100d/rows);
            row.setVgrow(Priority.NEVER);
            gameMapPane.getRowConstraints().add(row);
        }

        gameMapPane.setGridLinesVisible(true);
        for (int i = 0, mapLength = viewMap.length; i < mapLength; i++) {
            for (int j = 0; j < viewMap[i].length; j++) {
                Label label = new Label(i + "|" + j);
                Font font = Font.font( 15); // создаем объект класса Font
                label.setFont(font);
                label.setWrapText(true);
                viewMap[i][j] = label;
                gameMapPane.add(viewMap[i][j], j, i);
            }
        }


        statistics = new Label();
        Font font = Font.font( 22); // создаем объект класса Font
        statistics.setFont(font);
        VBox vBox = new VBox(gameMapPane, statistics);

        Scene scene = new Scene(vBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
        game.setView(this);
        Platform.runLater(gameWorker);
    }

    public static void start(GameWorker gameWorker) {
        JavaFxView.gameWorker = gameWorker;
        launch();
        gameWorker.getGame().setFinished(true);
    }

    @Override
    public void show() {
        showScale();
        showMap();
        showStatistics();
    }

    @Override
    public String showStatistics() {
        String text = game.getGameMap().getStatistics().toString();
        Platform.runLater(()->statistics.setText(text));
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
