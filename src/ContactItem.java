public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String category;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email, String category){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.category = category;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCategory() { return category; }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(!firstName.isBlank() || !lastName.isBlank()) {
            sb.append(String.format("Name: %s %s%n", this.firstName, this.lastName));
        }
        if(!phoneNumber.isBlank()){
            sb.append(String.format("Phone number: %s%n",this.phoneNumber));
        }
        if(!email.isBlank()){
            sb.append(String.format("Email: %s%n",this.email));
        }
        return sb.toString() ;
    }


}
