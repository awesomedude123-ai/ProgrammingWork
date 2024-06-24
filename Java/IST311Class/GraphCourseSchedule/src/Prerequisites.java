public class Prerequisites {
    private Course course;

    public Prerequisites(Course course) {
        this.course = course;
    }//end constructor

    public Course getVertex() {
        return course;
    }

    public void setVertex(Course course) {
        this.course = course;
    }
}
