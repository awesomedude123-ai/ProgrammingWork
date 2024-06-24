package edu.psu.ist.test;

import edu.psu.ist.model.SchoolType;
import edu.psu.ist.model.StudentUser;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest_jUnit {
    StudentUser user = new StudentUser("Sri", 2026, SchoolType.Undergraduate,"PSU");

    @Test
    @Order(1)
    @DisplayName("Get User Name")
    public void testGetUserName(){
        assertEquals("Sri", user.getName());
    }

    @Test
    @Order(2)
    @DisplayName("Get Year")
    public void testGetUserYear() {
        assertEquals(2026, user.getYear());
    }

    @Test
    @Order(3)
    @DisplayName("Get School")
    public void testGetUserSchool() {
        assertEquals("PSU", user.getSchoolName());
    }

    @Test
    @Order(4)
    @DisplayName("Get School Type")
    public void testGetUserSchoolType() {
        assertEquals(SchoolType.Undergraduate, user.getSchoolType());
    }

    @Test
    @Order(5)
    @DisplayName("Set User Name")
    public void testSetUserName(){
        user.setName("Sri M.");
        assertEquals("Sri M.", user.getName());
    }

    @Test
    @Order(6)
    @DisplayName("Set Year")
    public void testSetUserYear(){
        user.setYear(2025);
        assertEquals(2025,user.getYear());
    }

    @Test
    @Order(7)
    @DisplayName("Set School")
    public void testSetUserSchool(){
        user.setSchoolName("Penn State");
        assertEquals("Penn State", user.getSchoolName());
    }

    @Test
    @Order(8)
    @DisplayName("Set School Type")
    public void testSetUserSchoolType(){
        user.setSchoolType(SchoolType.Graduate);
        assertEquals(SchoolType.Graduate, user.getSchoolType());
    }

    @Test
    @Order(9)
    @DisplayName("Get ID")
    public void testGetUserID(){
        assertEquals(1, user.getId());
    }

    @Test
    @Order(10)
    @DisplayName("Set ID")
    public void testSetUserID(){
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    @Order(11)
    @DisplayName("toString")
    public void testToString(){
        String value = "ID: "+user.getId()+"\nName: "+user.getName()+"\nSchool Type: "+user.getSchoolType()+"\nSchool Name: "+user.getSchoolName()+"\nYear: "+user.getYear()+"\nType: Student";
        assertEquals(value, user.toString());
    }
}
