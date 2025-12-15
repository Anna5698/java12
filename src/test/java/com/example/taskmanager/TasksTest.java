package com.example.taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        assertTrue(simpleTask.matches("Позвонить"));
        assertTrue(simpleTask.matches("родителям"));
        assertFalse(simpleTask.matches("написать"));
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        assertTrue(epic.matches("Молоко"));
        assertTrue(epic.matches("Яйца"));
        assertTrue(epic.matches("Хлеб"));
        assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertTrue(meeting.matches("Выкатка"));
        assertTrue(meeting.matches("НетоБанка"));
        assertFalse(meeting.matches("обеда"));
    }
}
