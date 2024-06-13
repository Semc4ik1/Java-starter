package ru.gumenuk;

public class IndividualEntrepreneur extends Client {
    private int balance;

    @Override
    public void addMoney(int amount) {
        double commission = 0;
        if (amount >= 1000) {
            commission = amount * 0.05;
        } else {
            commission = amount * 0.01;
        }
        int netAmount = (int) (amount - commission);
        balance += netAmount;
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
        return "Количество денег у индивидуального предпринимателя: " + balance;
    }


}

