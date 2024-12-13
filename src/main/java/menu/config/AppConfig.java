package menu.config;

import menu.controller.MenuController;
import menu.domain.RandomMachine;
import menu.domain.Recommender;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {

    public MenuController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new MenuController(inputView, outputView, recommender());
    }

    private Recommender recommender() {
        return new Recommender(new RandomMachine());
    }
}
