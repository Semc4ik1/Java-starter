package ru.gumenuk;

public class NaturalPerson extends Client {
    private int balance;

    public void addMoney(int amount) {
        balance += amount;
    }

    public void removeMoney(int amount) {
        checkBalance(amount);
        balance -= amount;
    }

    @Override
    public void checkBalance(int amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("На счете недостаточно средств для вывода денег для определенной суммы");
        }
    }

    @Override
    public String info() {
        return "Количество денег у физ лица: " + balance;
    }
}
