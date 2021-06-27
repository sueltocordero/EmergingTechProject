

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
    public static TaskList taskListPog;
    // Creates a task list of contact items, works off the idea of an arraylist
    // that can be ever expanding.

    public static void taskListOperationMenu(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("List Operation Menu\n---------\n" + "1) View the list\n" + "2) Add an item\n" + "3) Edit an item\n" + "4) Remove an item\n" + "5) Mark an item as completed\n" + "6) Unmark an item as completed\n" + "7) Save the current list\n" + "8) Quit to the Task Menu\n");
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    if(taskListPog.size() == 0){
                        System.out.println("Task list is empty!!");
                    }
                    taskListPog.view();
                }
                if (choice == 2) {
                    System.out.print("Title:");
                    String title = in2.nextLine();
                    System.out.print("Description:");
                    String desc = in2.nextLine();
                    System.out.print("Task Due Date (YYYY-MM-DD):");
                    String date = in2.nextLine();
                    try {
                        taskListPog.add(new TaskItem(title, desc, date));
                        System.out.println("Task Saved!\n");

                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                if (choice == 3) {
                    taskListPog.view();

                    System.out.println("Which task will you edit?");
                    int index = in.nextInt();
                    int indexTrue = index-1;
                    in.nextLine();
                    try {


                        System.out.print("Enter a new title for task "+index+":");
                        String title = in.nextLine();
                        System.out.print("Enter a new description for task "+index+":");
                        String desc = in.nextLine();
                        System.out.print("Enter a new task due date (YYYY-MM-DD) for task "+index+":");
                        String date = in.nextLine();
                        taskListPog.edit(indexTrue, title, desc, date);
                    }catch(InputMismatchException e) {
                        System.out.println("Enter a proper value!");
                        in.next();
                    }catch(IndexOutOfBoundsException e){
                        System.out.println("Out of Bounds!!!");
                        in.next();
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }

                if (choice == 4) {
                    taskListPog.view();
                    System.out.println("Which task will you remove?");
                    int index = in.nextInt();
                    taskListPog.remove(index-1);
                }
                if (choice == 5) {
                    taskListPog.view();
                    System.out.println("Which task do you want to mark as complete? ");
                    int index = in.nextInt();
                    taskListPog.markAsComplete(index);
                }
                if (choice == 6) {
                    taskListPog.view();
                    System.out.println("Which task do you want to mark as incomplete? ");
                    int index = in.nextInt();
                    taskListPog.markAsIncomplete(index);
                }
                if (choice == 7) {
                    System.out.println("Enter the filename to save as: ");
                    String savename = in.nextLine();
                    taskListPog.save(savename);
                    System.out.println("saved!\n");
                }
                if (choice == 8) {
                    System.out.println("Tasks Main Menu\n---------\n\n" +
                            "1) Create a new list\n" +
                            "2) Load an existing list\n" +
                            "3) quit\n");
                    break;
                }
                if (choice < 0 || choice > 8) {
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
        System.out.println("Tasks Main Menu\n---------\n\n" +
                "1) Create a new list\n" +
                "2) Load an existing list\n" +
                "3) quit");

        while (true) {

            try {
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    taskListPog = new TaskList();
                    System.out.println("new task list has been created\n ");
                    taskListOperationMenu();


                }
                if (choice == 2) {
                    try {
                        System.out.println("Enter the filename to be loaded: (add .txt at the end)");
                        String filename = in.nextLine();
                        taskListPog = new TaskList();
                        taskListPog.load(filename);
                        System.out.println("Loaded!");
                        taskListOperationMenu();
                    }catch(IllegalArgumentException | InputMismatchException e){
                        System.out.println(e.getMessage());
                    }
                }
                if (choice == 3) {
                    System.out.println("You have returned to Main Menu\n ");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("That is not an option!");
                in.next();
            }

        }
    }
}
