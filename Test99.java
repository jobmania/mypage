package project123;

public class Test99 {
    public static void main(String[] args) {

        PublicBus bus1 = new PublicBus();
        PublicBus bus2 = new PublicBus();

//        bus1.CompareCarNumber(bus1.carNumber, bus2.carNumber);
//          bus1.takeBusCar(2);
//        bus1.haveOil(-50);
//        bus1.changeInformation("정지");
//        bus1.changeInformation("운행중");
//        bus1.takeBusCar(5);
//        bus1.takeBusCar(-6);
//        bus1.haveOil(+10);
//        bus1.operationInformation();
//        bus1.changeSpeed(10);




        PublicTaxi taxi1 = new PublicTaxi();
        PublicTaxi taxi2 = new PublicTaxi();

        taxi1.CompareCarNumber(taxi1.carNumber, taxi2.carNumber);
        taxi1.changeSpeed(15);
        taxi1.taketaxiCar(1,10,"역삼역");
        taxi1.haveTaxiOil(-10);
        taxi1.operationTaxiInfo();
        taxi1.taketaxiCar(0,0,"기러기");
        taxi1.haveTaxiOil(-80);
        taxi1.changeInformation("정지");



    }
}
