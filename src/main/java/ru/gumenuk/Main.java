package ru.gumenuk;
public class Main {
    public static void main(String[] args) {
        Client individual = new NaturalPerson();
        Client entity = new LegalEntity();
        Client individualEntrepreneur = new IndividualEntrepreneur();


        System.out.println(individual.info());
        individual.addMoney(500);
        System.out.println(individual.info());
        try {
            individual.removeMoney(600);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(individual.info());


        System.out.println("\n" + entity.info());
        entity.addMoney(2000);
        System.out.println(entity.info());
        entity.removeMoney(1100);
        System.out.println(entity.info());


        System.out.println("\n" + individualEntrepreneur.info());
        individualEntrepreneur.addMoney(1500);
        System.out.println(individualEntrepreneur.info());
        individualEntrepreneur.removeMoney(750);
        System.out.println(individualEntrepreneur.info());
    }
}
