package com.example.gad.model;

public class ProjectDetails
{
    public String firstname;
    public String lastname;
    public String emailaddress;
    public String giturl;



    public ProjectDetails(String firstname, String lastname, String emailaddress, String giturl) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.giturl = giturl;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setGiturl(String giturl) {
        this.giturl = giturl;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getGiturl() {
        return giturl;
    }

}
