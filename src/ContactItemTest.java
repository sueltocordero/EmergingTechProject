import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creatingValidContact(){
        ContactItem test = new ContactItem("Luis","Cordero","444-444-4444","luey@aol.com", "Friend");
        assertEquals("Luis",test.getFirstName());
        assertEquals("Cordero",test.getLastName());
        assertEquals("444-444-4444",test.getPhoneNumber());
        assertEquals("luey@aol.com",test.getEmail());
        assertEquals("Friend",test.getCategory());

    }
    @Test
    public void overwritingFirstNameOfContact(){
        ContactItem test = new ContactItem("Luis","Cordero","444-444-4444","luey@aol.com", "Friend");
        test.setFirstName("Jake");
        assertEquals("Jake", test.getFirstName());
    }
    @Test
    public void overwritingLastNameOfContact(){
        ContactItem test = new ContactItem("Luis","Cordero","444-444-4444","luey@aol.com", "Friend");
        test.setLastName("Rodriguez");
        assertEquals("Rodriguez", test.getLastName());
    }
    @Test
    public void overwritingPhoneOfContact(){
        ContactItem test = new ContactItem("Luis","Cordero","444-444-4444","luey@aol.com", "Friend");
        test.setPhoneNumber("555-555-5555");
        assertEquals("555-555-5555", test.getPhoneNumber());
    }
    @Test
    public void overwritingEmailOfContact(){
        ContactItem test = new ContactItem("Luis","Cordero","444-444-4444","luey@aol.com", "Friend");
        test.setEmail("jake@hotmail.com");
        assertEquals("jake@hotmail.com", test.getEmail());
    }
    //this test says that the two are identical but fails regardless
    @Test
    public void validContactToString(){
        ContactItem test = new ContactItem("Luis","Cordero","444-444-4444","luey@aol.com", "Friend");
        assertEquals("Name: Luis Cordero\r\nPhone number: 444-444-4444\r\nEmail: luey@aol.com\n",test.toString());
    }
}