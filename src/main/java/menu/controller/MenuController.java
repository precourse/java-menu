package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Recommender;
import menu.domain.Result;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.utils.DataParser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Recommender recommender;

    public MenuController(final InputView inputView, final OutputView outputView, final Recommender recommender) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.recommender = recommender;
    }

    public void run() {
        outputView.printWelcomeMessage();
        Coaches coaches = parseCoaches();
        setInedibleMenu(coaches);
        Result result = recommender.recommend(coaches);
        outputView.printResult(result);
        outputView.printEndMessage();
    }

    private Coaches parseCoaches() {
        return retryTemplate(() -> {
            String input = inputView.inputCoachNames();
            List<Coach> coaches = DataParser.parseCoachName(input);
            return new Coaches(coaches);
        });
    }

    private void setInedibleMenu(final Coaches coaches) {
        coaches.getCoaches().forEach(this::parseInedibleMenu);
    }

    private void parseInedibleMenu(final Coach coach) {
        retryTemplate(() -> {
            String input = inputView.inputInedibleMenu(coach.getName());
            coach.addInedible(input);
        });
    }

    private <T> T retryTemplate(final Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void retryTemplate(final Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
