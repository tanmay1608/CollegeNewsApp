package com.example.collegenews;


public class FacultyInfo {
    private String faculty_name;
    private String faculty_email;
    private String faculty_image;

    public FacultyInfo(String faculty_name, String faculty_email, String faculty_image) {
        this.faculty_name = faculty_name;
        this.faculty_email = faculty_email;
        this.faculty_image = faculty_image;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getFaculty_email() {
        return faculty_email;
    }

    public void setFaculty_email(String faculty_email) {
        this.faculty_email = faculty_email;
    }

    public String getFaculty_image() {
        return faculty_image;
    }

    public void setFaculty_image(String faculty_image) {
        this.faculty_image = faculty_image;
    }
}
