import com.gameloft9.demo.beans.Car;
import com.gameloft9.demo.service.impl.CarFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by admin on 2018/8/14.
 */
@Slf4j
public class CarFactoryTest {

    @Test
    public void testCheckCar(){
        Car car = new Car(null,"1",1);
        CarFactory cf = new CarFactory();
        log.info(cf.checkCar(car));
    }

}
