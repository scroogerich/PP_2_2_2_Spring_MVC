package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {

    private static Long CAR_COUNT = 0L;
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CAR_COUNT, "Tesla", 70));
        cars.add(new Car(++CAR_COUNT, "Toyota", 90));
        cars.add(new Car(++CAR_COUNT, "BMW", 120));
        cars.add(new Car(++CAR_COUNT, "Mercedes", 150));
        cars.add(new Car(++CAR_COUNT, "Hyundai", 250));
    }

    public List<Car> getCarsList(int count) {

        if (count <= 0 || count >=5) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}