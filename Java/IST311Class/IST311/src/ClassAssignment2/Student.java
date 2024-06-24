package ClassAssignment2;

import java.time.Year;
import java.util.ArrayList;

public class Student {
    private String id;
    private String name;

    private String collegeId;

    private String admitSem;

    private ArrayList<Course> listOfCourses;

    public Student() {
        this.id="";
        this.name="";
        this.collegeId="";
        this.admitSem="";
        this.listOfCourses = new ArrayList<>();
    }

    public Student(String name, String collegeId, String admitSem) {
        this.name = name;
        this.collegeId = collegeId;
        int year = Integer.parseInt(admitSem.substring(admitSem.length() - 4, admitSem.length()));
        if (year <= Year.now().getValue()) {
            this.admitSem = admitSem;
        } else {
            throw new IllegalArgumentException("Year must be equal to or less than current year: " + Year.now().getValue());
        }
        setId();
        this.listOfCourses = new ArrayList<>();
    }//end constructor

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId(){
        if(this.name.length()>3){
            this.id = this.name.substring(0,3);
        }else{
            this.id=this.name;
        }
        if(this.collegeId.length()>3){
            this.id = this.id + this.collegeId.substring(0,3);
        }else{
            this.id = this.id + this.collegeId;
        }

        if(this.admitSem.length()>3){
            this.id = this.id + this.admitSem.substring(0,3);
        }else{
            this.id = this.id + this.admitSem;
        }
    }

    public String getName() {
        return name;
    }

    public String getCollegeId() {
        return collegeId;
    }


    public String getAdmitSem() {
        return admitSem;
    }

    @Override
    public String toString() {
        return "ClassAssignment2.Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", admitSem='" + admitSem + '\'' +
                '}';
    }

    public void registerCourses(Course course){
        if(!this.listOfCourses.contains(course)){
            this.listOfCourses.add(course);
        }
    }

    public void unregisterCourses(Course course){
        if(this.listOfCourses.contains(course)){
            this.listOfCourses.remove(course);
        }
    }

    public void listOfCourses(){
        System.out.println("List of courses:\n");
        for(Course c : this.listOfCourses){
            System.out.println(c.toString());
        }
    }
}
