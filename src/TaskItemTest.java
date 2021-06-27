import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingValidObject(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        assertEquals("Title",test.getTitle());
        assertEquals("Desc",test.getDescription());
        assertEquals("2020-12-01",test.getDate());
    }
    @Test
    public void settingTitleOfExistingTaskItem(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        test.setTitle("New Title");
        assertEquals("New Title",test.getTitle());
    }
    @Test
    public void settingDescOfExistingTaskItem(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        test.setDescription("Brand new desc");
        assertEquals("Brand new desc",test.getDescription());
    }
    @Test
    public void settingDateOfExistingTaskItem(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        test.setDate("2021-07-04");
        assertEquals("2021-07-04",test.getDate());
    }
    @Test
    public void checkingCompletionOfNewItem(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        assertEquals(false,test.completionStatus());
    }
    @Test
    public void markingNewItemComplete(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        test.markComplete();
        assertEquals(true,test.completionStatus());
    }
    @Test
    public void markingNewItemIncomplete(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        test.markComplete();
        test.unmarkComplete();
        assertEquals(false,test.completionStatus());
    }
    @Test
    public void toStringMethodWithValidItem(){
        TaskItem test = new TaskItem("Title", "Desc", "2020-12-01");
        assertEquals("[2020-12-01] Title: Desc",test.toString());
    }
}