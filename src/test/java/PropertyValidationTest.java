import com.gameloft9.demo.beans.Car;
import com.gameloft9.demo.beans.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * 只校验某个字段(用处不大)
 * Created by gameloft9 on 2018/8/14.
 */
@Slf4j
public class PropertyValidationTest {

    @Test
    public void testPropertyValidation(){
        Car car = new Car("BMW","",2);

        // 拿到validator对象
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 开始校验
        Set<ConstraintViolation<Car>> constraintViolations = validator.validateProperty(car, "licensePlate" );

        // 获取校验结果
        if(constraintViolations.isEmpty()){
            log.info("校验通过！");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Iterator it = constraintViolations.iterator();
        while(it.hasNext()){
            ConstraintViolation<Car> cv = (ConstraintViolation<Car>)it.next();
            sb.append(cv.getMessage()).append(";");
        }

        log.info("校验不通过.{}",sb.toString());
    }
}
