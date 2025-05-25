public class Utilisateur{
    private String firstName;
    private String lastName;
    private String EMAIL;

    public Utilisateur(String firstName, String lastName,String EMAIL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.EMAIL = EMAIL;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    public String getPrenom() {
        return firstName;
    }

    public String getNom() {
        return lastName;
    }

    public String getEmail() {
        return EMAIL;
    }
}

