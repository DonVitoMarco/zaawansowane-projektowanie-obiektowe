package pl.marek;

public class Start {

    public static void main(String[] args) throws Exception {
        FabrykaSamochodow carFactory = new FabrykaSamochodow();

        ISamochod car1 = (ISamochod) carFactory.createInstance(carFactory.getSamochody().get(0));
        ISamochod car2 = (ISamochod) carFactory.createInstance(carFactory.getSamochody().get(1));
        ISamochod car3 = (ISamochod) carFactory.createInstance(carFactory.getSamochody().get(2));

        System.out.println(car1.getNazwa());
        car1.wlacz();
        car1.wylacz();

        System.out.println(car2.getNazwa());
        car2.wlacz();
        car2.wylacz();

        System.out.println(car3.getNazwa());
        car3.wlacz();
        car3.wylacz();
    }
}
