package ClassAssignment2;

public class Assignment extends CourseModule{

    private int assignmentNumber;

    private String assignmentName;

    private String description;

    private int questions;

    private int answersCorrect;
    private double grade;


    public Assignment(int assignmentNumber, String assignmentName, String description, int questions, int answersCorrect){
        this.assignmentNumber = assignmentNumber;
        this.assignmentName = assignmentName;
        this.description = description;
        this.questions = questions;
        this.answersCorrect = answersCorrect;
        toBeGraded();
    }
    public Assignment(){
        this.assignmentNumber = 0;
        this.assignmentName = "";
        this.description = "";
        this.questions = 0;
        this.answersCorrect = 0;
        this.grade = 0.0;
    }
    @Override
    void toBeGraded() {
        System.out.println("This is graded.");
        if(questions == 0 || answersCorrect>questions) {
            this.grade = 0;
        }else{
            this.grade = (this.answersCorrect*1.0)/questions*100;
        }
    }

    @Override
    String contentBeViewed() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentNumber=" + assignmentNumber +
                ", assignmentName='" + assignmentName + '\'' +
                ", description='" + description + '\'' +
                ", questions=" + questions +
                ", answersCorrect=" + answersCorrect +
                ", grade=" + grade +
                '}';
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(int assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public int getAnswersCorrect() {
        return answersCorrect;
    }

    public void setAnswersCorrect(int answersCorrect) {
        this.answersCorrect = answersCorrect;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
