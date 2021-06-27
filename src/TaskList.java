import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.*;

public class TaskList {


    private ArrayList<TaskItem> listOfTasks= new ArrayList<>();

    public int size(){
        return listOfTasks.size();
    }

    public void add(TaskItem item){
        listOfTasks.add(item);
    }

    public TaskItem get(int choice) {
        if(choice < 0 || choice > listOfTasks.size()){
            throw new IndexOutOfBoundsException("Out of bound!");
        }
        return listOfTasks.get(choice);
    }
    public void remove(int choice){listOfTasks.remove(choice);}

    public void edit(int choice, String title, String desc, String date){
        if(title.isBlank()){
            throw new IllegalArgumentException("Title must be at least 1 character long! It will not be updated!");
        }
        listOfTasks.get(choice).setTitle(title);
        listOfTasks.get(choice).setDescription(desc);
        listOfTasks.get(choice).setDate(date);

    }



    public void markAsComplete(int choice){
        listOfTasks.get(choice-1).markComplete();
    }
    public void markAsIncomplete(int choice){
        listOfTasks.get(choice-1).unmarkComplete();
    }
    public void view() {
        System.out.println("Current Tasks\n----------\n");
        for (int i = 0; i<listOfTasks.size();i++) {

            System.out.print(i +1+")");

            if(listOfTasks.get(i).completionStatus()){
                System.out.print("**COMPLETED**");
            }
            System.out.print(listOfTasks.get(i).toString()+"\n");
        }
    }

    public void save(String savename) {
        try(Formatter output = new Formatter(savename)){
            output.format("Saved Tasks%n");
            for (TaskItem listOfTask : listOfTasks) {
                output.format("%s%n", listOfTask.getTitle());
                output.format("%s%n", listOfTask.getDescription());
                output.format("%s%n", listOfTask.getDate());
                if (listOfTask.completionStatus()) {
                    output.format("complete%n");
                } else
                    output.format("uncompleted%n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public void load(String savename) {

        ArrayList<TaskItem> backup = listOfTasks;
        listOfTasks = new ArrayList<>();

        try (Scanner FILE = new Scanner(Paths.get(savename))) {
            String titleOfFile = FILE.nextLine();
            if (titleOfFile.equalsIgnoreCase("Saved Tasks")) {
                while (FILE.hasNext()) {
                    String title = FILE.nextLine();
                    String desc = FILE.nextLine();
                    String date = FILE.nextLine();
                    String isCompleted = FILE.nextLine();
                    TaskItem newItem = new TaskItem(title, desc, date);
                    if (isCompleted.equals("complete")) {
                        newItem.markComplete();
                    }
                    this.add(newItem);
                }
            }else{
                listOfTasks = backup;
                throw new InputMismatchException("Filename is not valid!");
            }
        }catch(FileNotFoundException e ){
            listOfTasks = backup;
            throw new IllegalArgumentException("File not found!");

        } catch (IOException e) {
            listOfTasks = backup;
            throw new IllegalArgumentException("Error!");
        }
    }
}
