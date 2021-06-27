import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactList {

    private ArrayList<ContactItem> listsofContacts = new ArrayList<>();

    public int size() {
        return listsofContacts.size();
    }

    public void add(ContactItem contactItem) {
        if (contactItem.getFirstName().isBlank() && contactItem.getLastName().isBlank() && contactItem.getPhoneNumber().isBlank() && contactItem.getEmail().isBlank() && contactItem.getCategory().isBlank()) {
            throw new IllegalArgumentException("Must have at least one of these parameters to be a contact!");
        }
        listsofContacts.add(contactItem);
        System.out.println("Contact Saved!\n");
    }

    public ContactItem get(int choice) {
        if (choice < 0 || choice > listsofContacts.size()) {
            throw new IndexOutOfBoundsException("Out of bound!");
        }
        return listsofContacts.get(choice);
    }

    public void view() {
        System.out.println("Current Contacts\n----------\n");
        for (int i = 0; i < listsofContacts.size(); i++) {

            System.out.print(i + 1+  ")");

            System.out.print(listsofContacts.get(i).toString() + "\n");
        }
    }
    /*public void filterView(String choice){
        System.out.println("Filtered Contacts\n----------\n");
        for (int i = 0; i < listsofContacts.size(); i++) {
            if(listsofContacts.get(i).getCategory() == choice) {
                System.out.print(i + ")");

                System.out.print(listsofContacts.get(i).toString() + "\n");
            }
        }
    }*/

    public void remove(int index) {
        listsofContacts.remove(index-1);
    }

    public void edit(int index, String first, String last, String phone, String email) {
        if (first.isBlank() && last.isBlank() && phone.isBlank() && email.isBlank()) {
            throw new IllegalArgumentException("Must have at least one of these parameters to be a contact!");
        }
        listsofContacts.get(index).setFirstName(first);
        listsofContacts.get(index).setLastName(last);
        listsofContacts.get(index).setPhoneNumber(phone);
        listsofContacts.get(index).setEmail(email);


    }


    public void load(String savename) {

        ArrayList<ContactItem> backup = listsofContacts;
        listsofContacts = new ArrayList<>();

        try (Scanner FILE = new Scanner(Paths.get(savename))) {
            String titleOfFile = FILE.nextLine();
            if (titleOfFile.equalsIgnoreCase("Saved Contacts")) {
                while (FILE.hasNext()) {
                    String first = FILE.nextLine();
                    String last = FILE.nextLine();
                    String phone = FILE.nextLine();
                    String email = FILE.nextLine();
                    String category = FILE.nextLine();
                    ContactItem newItem = new ContactItem(first, last, phone, email, category);

                    this.add(newItem);
                }
            } else {
                listsofContacts = backup;
                throw new InputMismatchException("Filename is not valid!");
            }
        } catch (FileNotFoundException e) {
            listsofContacts = backup;
            throw new IllegalArgumentException("File not found!");

        } catch (IOException e) {
            listsofContacts = backup;
            throw new IllegalArgumentException("Error!");
        }
    }



    public void save(String savename) {
        try(Formatter output = new Formatter(savename)){
            output.format("Saved Contacts%n");
            for (ContactItem listsofContact : listsofContacts) {
                output.format("%s%n", listsofContact.getFirstName());
                output.format("%s%n", listsofContact.getLastName());
                output.format("%s%n", listsofContact.getPhoneNumber());
                output.format("%s%n", listsofContact.getEmail());
                output.format("%s%n",listsofContact.getCategory());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
