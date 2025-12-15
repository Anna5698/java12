package com.example.taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить хлебобулочные изделия",
                "Пекарня",
                "Завтра утром"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        // Поиск "Хлеб" - должен найти simpleTask и epic
        Task[] found = todos.search("Хлеб");
        Task[] expectedForBread = {simpleTask, epic};
        assertArrayEquals(expectedForBread, found);

        // Поиск "Молоко" - должен найти только epic
        found = todos.search("Молоко");
        Task[] expectedForMilk = {epic};
        assertArrayEquals(expectedForMilk, found);

        // Поиск "Пекарня" - должен найти только meeting
        found = todos.search("Пекарня");
        Task[] expectedForBakery = {meeting};
        assertArrayEquals(expectedForBakery, found);

        // Поиск "Несуществующее" - не должен ничего найти
        found = todos.search("Несуществующее");
        Task[] expectedForNonExistent = {};
        assertArrayEquals(expectedForNonExistent, found);
    }
}