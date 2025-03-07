package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void testDefaultConstructor() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation()); // Начальная станция должна быть 0
        assertEquals(50, radio.getCurrentVolume()); // Начальная громкость должна быть 50
        assertEquals(9, radio.getMaxStation());     // По умолчанию 10 станций (0-9)
    }

    @Test
    void testCustomConstructor() {
        Radio radio = new Radio(30);
        assertEquals(0, radio.getCurrentStation()); // Начальная станция должна быть 0
        assertEquals(50, radio.getCurrentVolume()); // Начальная громкость должна быть 50
        assertEquals(29, radio.getMaxStation());    // Максимальная станция должна быть 29
    }

    @Test
    void testSetCurrentStation() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(15);
        assertEquals(15, radio.getCurrentStation()); // Установка допустимой станции

        radio.setCurrentStation(30);
        assertEquals(15, radio.getCurrentStation()); // Попытка установить недопустимую станцию (остаётся предыдущее значение)

        radio.setCurrentStation(-1);
        assertEquals(15, radio.getCurrentStation()); // Попытка установить недопустимую станцию (остаётся предыдущее значение)
    }

    @Test
    void testNextStation() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation()); // Переключение с максимальной станции на 0

        radio.nextStation();
        assertEquals(1, radio.getCurrentStation()); // Переключение на следующую станцию
    }

    @Test
    void testPrevStation() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(29, radio.getCurrentStation()); // Переключение с 0 на максимальную станцию

        radio.prevStation();
        assertEquals(28, radio.getCurrentStation()); // Переключение на предыдущую станцию
    }

}