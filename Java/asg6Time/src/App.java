import controller.NavigableDocController;
import model.NavigableDocModel;
import view.NavigableDocView;

public class App {
    public static void main(String[] args) {
        NavigableDocModel<String> model = new NavigableDocModel<>();
        NavigableDocView view = new NavigableDocView();
        NavigableDocController controller = new NavigableDocController(model,view);
        view.setVisible(true);
    }
}
