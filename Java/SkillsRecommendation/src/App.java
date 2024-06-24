import edu.psu.ist.controller.InterestController;
import edu.psu.ist.controller.MajorController;
import edu.psu.ist.controller.UserListController;
import edu.psu.ist.model.Interest;
import edu.psu.ist.model.Major;
import edu.psu.ist.model.UserTableModel;
import edu.psu.ist.view.UserListView;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        /**
         * Manual Tests
         * TestHarness testHarness = new TestHarness();
         *         System.out.println("Testing Major Model Class ................");
         *         testHarness.testMajor();
         *         System.out.println();
         *         System.out.println("Testing Interest Model Class ................");
         *         testHarness.testInterest();
         *         System.out.println("\nTesting Inheritance");
         *         testHarness.testClassHierarchy();
         *         System.out.println("\nTesting Interface");
         *         testHarness.testInterface();
         *
         *         Datascience Science of Data
         *         Computer Science Sicence of computers
         *         Cybersecurity Online Security
         *         Information Science Science of Infomration
         *
         *         Programming Coding
         *         Writing Writing reports
         *         Cloud Cloud architecture
         *         Science Learning about chem, physics, bio etc
         */

        MajorController majorController = new MajorController();
        majorController.setMajors(populateMajors());
        InterestController interestController = new InterestController();
        interestController.setInterests(populateInterest());
        //SkillView view = new SkillView();
        /**
         * List<Skill> skillList = new ArrayList<Skill>();
         *         ArrayList<String> learn = new ArrayList<>();learn.add("example");
         *         skillList.add(new Skill("Example","Example",populateMajors(),populateInterest(),learn,"Example"));
         *         SkillTableModel model = new SkillTableModel(skillList);
         *         SkillListView listView = new SkillListView();
         *         SkillTableController skillTableController = new SkillTableController(model, listView);
         */

        UserListView listView = new UserListView();
        UserTableModel model = new UserTableModel();
        UserListController userListController = new UserListController(model, listView, majorController,interestController);
        //SkillController skillController = new SkillController(view,majorController, interestController);
        listView.revalidate();
        listView.repaint();
        listView.setVisible(true);
    }

    private static ArrayList<Major> populateMajors(){
        ArrayList<Major> majors = new ArrayList<Major>();
        majors.add(new Major("Data Science","Science of Data", 130, "IT"));
        majors.add(new Major("Computer Science", "Science of Computer", 130, "IT"));
        majors.add(new Major("Cyber-security", "Online Security", 130, "IT"));
        majors.add(new Major("Information Science", "Science of Information", 130, "IT"));
        return majors;
    }//end populateMajors

    private static ArrayList<Interest> populateInterest(){
        ArrayList<Interest> interests = new ArrayList<Interest>();
        interests.add(new Interest("Programming","Coding","Technical"));
        interests.add(new Interest("Writing","Writing Reports","Non-Technical"));
        interests.add(new Interest("Cloud","Cloud Architecture","Technical"));
        interests.add(new Interest("Science","Learning about chem, phys, and bio","Non-Technical"));
        return interests;
    }
    //0-1 --> 0.9874 --> 0-> 10 )*10 =0 1*10 =10
    //int random = (int)(Math.random() *10)

}