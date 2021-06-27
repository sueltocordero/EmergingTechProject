
import java.util.Scanner;

public class TaskItem {
    private String title;
    private String description;
    private String date;
    private boolean isCompleted = false;

    Scanner in = new Scanner(System.in);

    public TaskItem(String title, String desc, String date) {
        if(title.isBlank()){
            throw new IllegalArgumentException("Title must be at least 1 character long! It will not be created!");
        }

        this.title =title;
        this.description =desc;

        this.date =date;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setDescription(String description) {

        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public void setDate(String date){

        this.date = date;
    }
    public String getDate(){
        return this.date;
    }

    public void markComplete(){
        this.isCompleted = true;
    }

    public void unmarkComplete(){
        this.isCompleted = false;
    }

    public boolean completionStatus(){
        return isCompleted;
    }

    @Override
    public String toString(){
        return("["+this.date+"] "+ this.title + ": " + this.description);
    }

}
