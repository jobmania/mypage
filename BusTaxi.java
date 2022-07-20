package project123;
import java.util.Random;
import java.util.concurrent.CompletionStage;

public class BusTaxi{
    Random random = new Random();
    int carNumber=random.nextInt(10000);
    int haveOil=100;
    int in_person;
    int Max_person;
    int Price;
    int CarSpeed=0;
    boolean CarStatus=true;
    int remainPerson = 0;

    public BusTaxi(int max_person) {
        this.Max_person = max_person;
    }

    void CompareCarNumber(int x, int y){
        if(x==y){
            System.out.println(""+x+","+y+"번호가 같습니다");
        }else {
            System.out.println(""+x+","+y+"번호가 다릅니다");
        }
    }



    void haveOil(int x){
        haveOil = haveOil + x;
        if(haveOil <= 10){
            CarStatus = false;
            System.out.println("주유가 필요합니다.그래서 차고지로 이동합니다.");
        }else {
            CarStatus = true;
            System.out.println(" oil 충분! 운행가능합니다");
        }
    }


    void changeInformation(String x){
        System.out.println("이것은 도움말! 입니다 '운행중' 입력시 운행, '정지'라고 할시 차고지로");
        if(haveOil <= 10){
            System.out.println("오일이 없어 차고지에 있습니다.");
        } else if (x=="운행중" ) {
            CarStatus = true;
            System.out.println("운행을 시작합니다");
        }else {
            CarStatus = false;
            System.out.println("운행을 안합니다");

        }
    }



    void operationInformation(){
        if(CarStatus){
            System.out.println("운행중입니다. 남은 오일은"+haveOil);
        }else {
            System.out.println("차고지에 있습니다.");
        }
    }

    void changeSpeed(int x){
        if(CarStatus){
            if(x!=0){
                CarSpeed=CarSpeed+x;
                System.out.println("현재 속력은 "+x+"입니다.");
            }else {
                System.out.println("현재 정지중입니다");
            }
        }else {
            System.out.println("현재 정차중입니다.");
        }



    }

}



class PublicTaxi extends BusTaxi {
    public PublicTaxi() {
        super(4);
    }


    void taketaxiCar(int x,int y,String z){
        if(CarStatus){
            in_person =  x;
            if(in_person>4 || in_person==0){
                System.out.println("너무 많이 타셨거나 안타셨네요?");
            }else {
                Max_person = Max_person-in_person;
                CarStatus = true;
                int Distance = y;
                String Destination = z;
                if(Distance>3){
                    int presentPrice = 3000 + 500*Distance;
                    Price = Price + presentPrice;
                    System.out.println("현재 요금은 "+presentPrice+"입니다.");
                }else {
                    int presentPrice = 3000;
                    Price = Price+presentPrice;
                    System.out.println("현재 요금은 "+presentPrice+"입니다.");
                }
                System.out.println("거리는 " + Distance + "km, 도착지는 " + Destination + "입니다");
                System.out.print("현재 택시에 "+ in_person+"명이 타고있습니다. 잔여승객은 "+ Max_person+"명이다. ");
                System.out.println("벌어들인 요금은"+Price+"입니다.");
            }
        }else {
            System.out.println("차는 현재 차고지에 있습니다");
        }

    }

    void operationTaxiInfo(){
        if(CarStatus){
            if(in_person!=0 && in_person<5) {
                System.out.println("운행중 사람을 태우고 있어요");
            }else {
                System.out.println("탑승가능");
            }

        }else {
            System.out.println("차고지에 있습니다.");
        }
    }

    void haveTaxiOil(int x){
        haveOil = haveOil + x;
        if(haveOil <= 10){
            CarStatus = false;
            System.out.println("주유가 필요합니다.그래서 차고지로 이동합니다.");
        }else {
            System.out.println(" oil 충분! 운행가능!");
        }
    }

}


class PublicBus extends BusTaxi {
    public PublicBus() {
        super(30);
    }

    void takeBusCar(int x){
        if(CarStatus){
            if(remainPerson+x<0){
                System.out.println("내리는 사람이 탑승자 보다 많습니다. 정확하게 입력하세요!!!");
            }else {
                Max_person = Max_person-x; // 탑승할수 있는 자리
                remainPerson = remainPerson + x; // 탑승한 자리


                if (Max_person < 0) {
                    int inputman = x + Max_person;
                    Price = Price + 1000 * inputman;
                    remainPerson = 30;
                    System.out.println("버스에 탈수있는 인원은 없습니다. 벌어들인 돈은" + Price + "입니다.");
                    System.out.println("버스용량이 최대한으로 탔습니다.");  // 최대한으로 우겨 타기

                } else {
                    if (x > 0) {

                        Price = Price + 1000 * x;

                    }
                    System.out.print("현재 버스에 " + remainPerson + "명이 타고있습니다. ");
                    System.out.println("버스에 탈수있는 인원은" + Max_person + "명입니다");
                    System.out.println("벌어들인 요금은" + Price + "입니다.");
                }

            }


        } else {
            System.out.println("차는 현재 차고지에 있습니다");
        }

    }
}







