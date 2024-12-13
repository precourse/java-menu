package menu;

import menu.config.AppConfig;
import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MenuController controller = appConfig.controller();
        controller.run();
    }
}
