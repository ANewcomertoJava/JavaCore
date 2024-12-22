package homeworks.homework05Addition;/*
Формулировка задания:
Реализовать класс Телевизор. У класса есть поля, свойства и методы.
Проверить работу в классе App, методе main.
Обратить внимание на переопределение метода toString.
*/

import java.util.Objects;

public class TelevisorUpdate {
    private String manufacturer;
    private String model;
    private double diagonal;
    private int currentChannel;        // включенный канал
    private int volume;                // звук
    private boolean isOn;              // Признак включенного телевизора

    // Конструктор для создания объекта телевизора.
    public TelevisorUpdate(String manufacturer, String model, double diagonal) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.diagonal = diagonal;
        this.currentChannel = 1;       // По умолчанию первый канал
        this.volume = 50;              // Средняя громкость
        this.isOn = false;             // т.к телевизор ещё надо включить
    }

    public String getManufacturer() {
        return manufacturer;
    } // Производитель

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    } // Устанавливает производителя телевизора.

    public String getModel() {
        return model;
    } // Модель

    public void setModel(String model) {
        this.model = model; // Устанавливает новую модель телевизора.
    }

    public double getDiagonal() {
        return diagonal;
    } // Диагональ

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal; // Устанавливает новую диагональ экрана телевизора.
    }

    public int getCurrentChannel() { return currentChannel;}  // номер канала

    public void setCurrentChannel(int currentChannel) {
        if (currentChannel > 0 && !isOn) {  // Если телевизор включен, то меняем канал
            this.currentChannel = currentChannel;
        } else {
            System.err.println("Телевизор выключен, невозможно сменить канал.");
        }
    }


    public int getVolume() { return volume;}// уровень громкости

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100 && isOn) {  // Если телевизор включен, то меняем громкость
            this.volume = volume;
        } if (volume < 0 || volume > 100) {
            System.out.println("Громкость должна быть в пределах от 0 до 100, либо телевизор выключен.");
        }
    }

    public boolean isOn() {
        return isOn; // Возвращает признак включения телевизора.
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn; // Включает/выключает телевизор.
    }


    // Печатает информацию о телевизоре
    public void printInfo() {
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Модель: " + model);
        System.out.println("Диагональ: " + diagonal);
    }
    /* переопределение метода toString() х*/
    @Override
    public String toString() {
        return "Производитель: " + manufacturer + " Модель: " + model + " Диагональ: " + diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelevisorUpdate)) return false;
        TelevisorUpdate that = (TelevisorUpdate) o;
        return currentChannel == that.currentChannel &&
                Double.compare(that.diagonal, diagonal) == 0 &&
                volume == that.volume &&
                isOn == that.isOn &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(model, that.model);
    }

    public int hashCode() {
        return Objects.hash(manufacturer, model, diagonal, currentChannel, volume, isOn);
    }

}









