package ru.job4j.ood.ocp;

public class ViolationOfTheOCP {

    /*
    * Во всех 3-х вариантох могут быть проблемы при расширении функционала класса
    * тогда придется изменять существующие методы
    *
    * 1. ссылка на класс, а не на интерфейс
    * */
    public AnotherClass ac;

    /*
     * 2. метод вернет тип класс, а не интерфейс
     * */
    public AnotherClass getSomething() {
        return null;
    }

    /*
     * 3. здесь аргументом служит класс, а не на интерфейс
     * */
    public void doSomething(AnotherClass ac) {
    }
}
