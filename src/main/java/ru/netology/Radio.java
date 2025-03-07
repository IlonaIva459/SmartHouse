package ru.netology;

public class Radio {
    private int currentStation; // Номер текущей радиостанции
    private int currentVolume;  // Уровень громкости
    private int maxStation;     // Максимальный номер станции

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this.maxStation = 9; // По умолчанию 10 станций (0-9)
        this.currentStation = 0;
        this.currentVolume = 50;
    }

    // Конструктор с заданием количества станций
    public Radio(int stationCount) {
        if (stationCount <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть больше 0");
        }
        this.maxStation = stationCount - 1; // Нумерация с 0
        this.currentStation = 0;
        this.currentVolume = 50;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station <= maxStation) {
            this.currentStation = station;
        }
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = 0; // Если текущая станция максимальная, переключаемся на 0
        } else {
            currentStation++; // Иначе увеличиваем номер станции на 1
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = maxStation; // Если текущая станция 0, переключаемся на максимальную
        } else {
            currentStation--; // Иначе уменьшаем номер станции на 1
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) { // Проверка, что громкость не превышает максимум
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) { // Проверка, что громкость не ниже минимума
            currentVolume--;
        }
    }

    public int getMaxStation() {
        return maxStation;
    }
}