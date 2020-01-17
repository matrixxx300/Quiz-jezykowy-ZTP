package main;

import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.progress.Progress;

public class Main extends Application {
    public static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Progress.getInstance().loadProgress();
        new MenuController();
    }
}
