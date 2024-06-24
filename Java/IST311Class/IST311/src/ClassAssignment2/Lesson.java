package ClassAssignment2;

public class Lesson extends CourseModule{

    private int lessonNumber;
    private String lessonName;


    private String description;

    public Lesson() {
        this.lessonName="";
        this.lessonNumber=0;
        this.description="";
    }

    public Lesson(int lessonNumber, String lessonName, String description) {
        this.lessonNumber = lessonNumber;
        this.lessonName = lessonName;
        this.description = description;
    }

    @Override
    void toBeGraded() {
        System.out.println("This is not Graded");
    }

    @Override
    String contentBeViewed() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonNumber=" + lessonNumber +
                ", lessonName='" + lessonName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
