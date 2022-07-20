package Signature.Models;

public class SignatureModelHttp {

    private String Id;
    private String ExamBuroName;
    private String LastName;
    private String FirstName;
    private String SecondName;

    public SignatureModelHttp(String id, String examBuroName, String lastName, String firstName, String secondName) {
        this.Id = id;
        this.ExamBuroName = examBuroName;
        this.LastName = lastName;
        this.FirstName = firstName;
        this.SecondName = secondName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getExamBuroName() {
        return ExamBuroName;
    }

    public void setExamBuroName(String examBuroName) {
        ExamBuroName = examBuroName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }
}
