import Controller.QueueController;
import Model.QueueModel;
import View.QueueView;

public class App {
    public static void main(String[] args) {
        QueueModel model = new QueueModel();
        QueueView view = new QueueView();
        QueueController controller = new QueueController(view,model);
        view.setVisible(true);
    }
}
