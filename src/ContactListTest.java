import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void newList(){
        ContactList test = new ContactList();
        assertEquals(0,test.size());
    }

    @Test
    public void addingIncreasesSize(){
        ContactList test = new ContactList();
        test.add(new ContactItem("Luis","Cordero", "444-444-4444","", "Friend"));
        assertEquals(1,test.size());
    }
    @Test
    public void removingDecreasesSize(){
        ContactList test = new ContactList();
        test.add(new ContactItem("Luis","Cordero", "444-444-4444","", "Friend"));
        test.add(new ContactItem("Jake","Cordero", "444-555-4444","hello@yahoo.com", "Friend"));
        test.add(new ContactItem("Luis","", "","", "Friend"));
        test.remove(2);
        assertEquals(2,test.size());
    }

    @Test
    public void getWithValidIndex(){
        ContactList test = new ContactList();
        test.add(new ContactItem("Luis","Cordero", "444-444-4444","", "Friend"));
        ContactItem copy = test.get(0);
        assertEquals("Luis",copy.getFirstName());
    }
    @Test
    public void getFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        assertThrows(IndexOutOfBoundsException.class,()->test.get(0));
    }
    //This test as well says that its identical to each other
    @Test
    public void editingWithValidParameters(){
        ContactList test = new ContactList();
        test.add(new ContactItem("Luis","Cordero", "444-444-4444","", "Friend"));
        test.edit(0,"Luis","Cordero","444-444-4444","luey@aol.com");
        assertEquals("Name: Luis Cordero\r\nPhone number: 444-444-4444\r\nEmail: luey@aol.com\n",test.get(0).toString());
    }
    @Test
    public void editingWithInvalidParameters(){
        ContactList test = new ContactList();
        test.add(new ContactItem("","", "","", "Friend"));
        assertThrows(IllegalArgumentException.class,()->test.edit(0,"","","",""));
    }

    @Test
    public void removingTaskWithValidIndex(){
        ContactList test = new ContactList();
        test.add(new ContactItem("Luis","Cordero", "444-444-4444","", "Friend"));
        assertDoesNotThrow(()->test.remove(0));
    }
    @Test
    public void addingNewItemWithEmptyParameters(){
        ContactList test = new ContactList();
        assertThrows(IllegalArgumentException.class,()->test.add(new ContactItem("","", "","", "Friend")));
    }
    @Test
    public void savingValidContacts(){
        ContactList test = new ContactList();
        test.add(new ContactItem("Luis","Cordero", "444-444-4444","", "Friend"));
        test.add(new ContactItem("Jake","Cordero", "444-555-4444","hello@yahoo.com", "Friend"));
        assertDoesNotThrow(()->test.save("test.txt"));

    }

    @Test
    public void loadingValidContacts(){
        ContactList test = new ContactList();
        test.add(new ContactItem("Luis","Cordero", "444-444-4444","", "Friend"));
        test.add(new ContactItem("Jake","Cordero", "444-555-4444","hello@yahoo.com", "Friend"));
        test.save("test.txt");

        ContactList test2 = new ContactList();
        test2.load("test.txt");
        assertEquals("Luis",test2.get(0).getFirstName());

    }
}