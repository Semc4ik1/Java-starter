package ru.gumenuk;

public class LegalEntity extends Client {
    private int balance;

    public void addMoney(int amount) {
        balance += amount;
    }

    public void removeMoney(int amount) {
        checkBalance(amount);
        double commission = amount * 0.01;
        int netAmount = (int) (amount + commission);
        balance -= netAmount;
    }

    @Override
    public void checkBalance(int amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("На счете недостаточно средств для вывода денег для определенной суммы");
        }
    }

    @Override
    public String info() {
        return "Количество денег у юр лица: " + balance;
    }
}
