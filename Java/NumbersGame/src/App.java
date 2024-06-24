import controller.NumbersController;
import model.NumbersModel;
import view.NumberView;

public class App {
    public static void main(String[] args) {
        NumberView view = new NumberView();
        NumbersModel model = new NumbersModel();
        NumbersController controller = new NumbersController(model,view);
        view.setVisible(true);
    }
}