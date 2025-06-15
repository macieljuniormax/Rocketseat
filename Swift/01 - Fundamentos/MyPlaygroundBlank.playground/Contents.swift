import UIKit

class Car {
    private var carName: String;
    private var engine: String;
    private var numberOfWheels: Int;
    private var numberOfPassengers: Int;
    private var wheelHight: Int?;
    
    init(carName: String, engine: String, numberOfWheels: Int, numberOfPassengers: Int, wheelHight: Int? = nil) {
        self.carName = carName;
        self.engine = engine;
        self.numberOfWheels = numberOfWheels;
        self.numberOfPassengers = numberOfPassengers;
        self.wheelHight = wheelHight;
    }
    
    func getCarName() -> String {
        return self.carName;
    }
    
    func getwheelHight() -> Int? {
        return self.wheelHight;
    }
    
    func setwheelHight(newHeight: Int) {
        self.wheelHight = newHeight;
    }
}

let fordKa: Car = Car(carName: "FordKa", engine: "1.0L TSI", numberOfWheels: 4, numberOfPassengers: 5);
let golf: Car = Car(carName: "Golf", engine: "1.6L TSI", numberOfWheels: 4, numberOfPassengers: 5, wheelHight: 17);

//updateWheelsHeight(car: fordKa, newHeight: 18);

if let fordKaHeight = fordKa.getwheelHight(),
   let golfHeight = golf.getwheelHight() {
    if fordKa.getwheelHight() == golf.getwheelHight() {
        print("Same height");
    } else {
        print("Diferent height");
    }
} else {
    print("Uma das vaiáveis não existe");
}

func updateWheelsHeight(car:Car, newHeight:Int) {
    car.setwheelHight(newHeight: newHeight);
}

func bringWheelHeight(car:Car) -> Int {
    guard let carWheelHeight = car.getwheelHight() else {
        print(car.getCarName() + "Não possui altura configurada");
        return 0;
    }
    
    return carWheelHeight;
}

print(bringWheelHeight(car: fordKa));
