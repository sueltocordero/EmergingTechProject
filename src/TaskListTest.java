import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void newList(){
        TaskList test = new TaskList();
        assertEquals(0,test.size());
    }

    @Test
    public void addingIncreasesSize(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        assertEquals(1,test.size());
    }
    @Test
    public void removingDecreasesSize(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        test.add(new TaskItem("Title2","Desc2", "2020-11-01"));
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        test.remove(2);
        assertEquals(2,test.size());
    }

    @Test
    public void getWithValidIndex(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        TaskItem copy = test.get(0);
        assertEquals("[2020-12-01] Title: Desc",copy.toString());
    }
    @Test
    public void getFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        assertThrows(IndexOutOfBoundsException.class,()->test.get(0));
    }
    @Test
    public void editingWithValidParameters(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        test.edit(0,"new title","","2021-01-01");
        assertEquals("[2021-01-01] new title: ",test.get(0).toString());
    }
    @Test
    public void editingWithInvalidParameters(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        assertThrows(IllegalArgumentException.class,()->test.edit(0,"","","2021-01-01"));
    }
    @Test
    public void completingTaskItem(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        test.markAsComplete(0);
        assertEquals(true, test.get(0).completionStatus() );
    }
    @Test
    public void unmarkingCompletedTask(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        test.markAsComplete(0);
        test.markAsIncomplete(0);
        assertEquals(false, test.get(0).completionStatus() );
    }
    @Test
    public void removingTaskWithValidIndex(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        assertDoesNotThrow(()->test.remove(0));
    }
    @Test
    public void addingNewItemWithEmptyTitle(){
        TaskList test = new TaskList();
        assertThrows(IllegalArgumentException.class,()->test.add(new TaskItem("","Desc", "2020-12-01")));
    }
    @Test
    public void savingValidTasks(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        test.add(new TaskItem("Title2","Desc", "2020-12-01"));
        assertDoesNotThrow(()->test.save("test.txt"));

    }

    @Test
    public void loadingValidTasks(){
        TaskList test = new TaskList();
        test.add(new TaskItem("Title","Desc", "2020-12-01"));
        test.add(new TaskItem("Title2","Desc", "2020-12-01"));
        test.save("test.txt");

        TaskList test2 = new TaskList();
        test2.load("test.txt");
        assertEquals("Title",test2.get(0).getTitle());

    }
}