package homeworks.homework03;
/*
Формулировка задания:
Реализовать класс Телевизор. У класса есть поля, свойства и методы.
Проверить работу в классе AppUpdate, методе main.
Обратить внимание на переопределение метода toString.
*/

public class Televisor {
    private String manufacturer;
    private String model;
    private double diagonal;

    // Конструктор для создания объекта телевизора.
    public Televisor(String manufacturer, String model, double diagonal) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.diagonal = diagonal;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getDiagonal() {
        return diagonal;
    }
    // Печатает информацию о телевизоре
    public void printInfo() {
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Модель: " + model);
        System.out.println("Диагональ: " + diagonal);
    }
    /* переопределение метода toString() */
    @Override
    public String toString() {
        return "Производитель: " + manufacturer + " Модель: " + model + " Диагональ: " + diagonal;
    }
}








