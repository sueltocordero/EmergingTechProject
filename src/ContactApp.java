

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
  // Creates a contact list of contact items, works off the idea of an arraylist 
  // that can be ever expanding.
    public static ContactList contactListPog;


    public static void contactListOperationMenu(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("List Operation Menu\n---------\n" + "1) View the list\n" + "2) Add an item\n" + "3) Edit an item\n" + "4) Remove an item\n"  + "5) Save the current list\n" + "6) Quit to the main menu\n");
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1)
                    if(contactListPog.size() == 0){
                        System.out.println("Contact list is empty!!");
                    }
                    contactListPog.view();
                }
                if (choice == 2) {
                    System.out.print("First Name:");
                    String first = in2.nextLine();
                    System.out.print("Last Name:");
                    String last = in2.nextLine();
                    System.out.print("Phone Number (xxx-xxx-xxxx):");
                    String phone = in2.nextLine();
                    System.out.print("Email address (johnsmith@test.com):");
                    String email = in2.nextLine();
                    try {
                        contactListPog.add(new ContactItem(first,last,phone,email,"floater"));
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                if (choice == 3) {
                    contactListPog.view();

                    System.out.println("Which contact will you edit?");
                    int index = in.nextInt();
                    int indexTrue = index -1;
                    in.nextLine();
                    try {
                        System.out.print("Enter a new first name for contact "+index+":");
                        String first = in.nextLine();
                        System.out.print("Enter a new last name for contact "+index+":");
                        String last = in.nextLine();
                        System.out.print("Enter a new phone number for contact "+index+":");
                        String phone = in.nextLine();
                        System.out.print("Enter a new email for contact "+index+":");
                        String email = in.nextLine();
                        contactListPog.edit(indexTrue, first, last, phone, email);
                    }catch(InputMismatchException e) {
                        System.out.println("Enter a proper value! Retry that!");
                        in.next();
                    }catch(IndexOutOfBoundsException e){
                        System.out.println("Out of Bounds!!! Retry that!");
                        in.next();
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }

                if (choice == 4) {
                    contactListPog.view();
                    System.out.println("Which contact will you remove?");
                    int index = in.nextInt();
                    contactListPog.remove(index);
                }

                if (choice == 5) {
                    System.out.println("Enter the filename to save as: ");
                    String savename = in.nextLine();
                    contactListPog.save(savename);
                    System.out.println("Saved!\n");
                }
                if (choice == 6) {
                    System.out.println("Contact Main Menu\n---------\n\n" +
                            "1) Create a new list\n" +
                            "2) Load an existing list\n" +
                            "3) quit\n");
                    break;
                }

                if (choice < 0 || choice > 6) {
                    System.out.println("Not an option!");
                }
            } catch (InputMismatchException e) {
                System.out.println("That is not an option!");
                in.next();
            }

        }


    }



    public static void main(String[] args) {
        main();
    }


    public static void main() {

        Scanner in = new Scanner(System.in);
        System.out.println("Contacts Main Menu\n---------\n\n" +
                "1) Create a new list\n" +
                "2) Load an existing list\n" +
                "3) quit\n");

        while (true) {

            try {
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    contactListPog = new ContactList();
                    System.out.println("New contact list has been created\n ");
                    contactListOperationMenu();


                }
                if (choice == 2) {
                    try {
                        System.out.println("Enter the filename to be loaded:");
                        String filename = in.nextLine();
                        contactListPog = new ContactList();
                        contactListPog.load(filename);
                        System.out.println("Loaded!\n");
                        contactListOperationMenu();
                    }catch(IllegalArgumentException | InputMismatchException e){
                        System.out.println(e.getMessage());
                    }
                }
                if (choice == 3) {
                    System.out.println("You have returned to Main Menu!\n");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("That is not an option!");
                in.next();
            }

        }


    }
}
