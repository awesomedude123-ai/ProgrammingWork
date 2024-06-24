public class Assignment {
    private static int id = 0;

    private String description;

    private int points;

    private Course course;

    public Assignment(String description, int points, Course course) {
        this.description = description;
        this.points = points;
        this.course = course;
        id++;
    }

    public void changeCourse(){

    }
}
