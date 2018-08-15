import com.gameloft9.demo.beans.Person;
import com.gameloft9.demo.service.impl.RentalStation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 测试方法参数校验
 * Created by admin on 2018/8/14.
 */
@Slf4j
public class MethodValidationTest {

    @Test
    public void testMethodValidation() throws Exception{
        // 拿到validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator executableValidator = factory.getValidator().forExecutables();

        RentalStation obj = new RentalStation();
        Method method = RentalStation.class.getMethod("rentCar", Person.class, Date.class, int.class);
        Object[] param = {new Person(""),new Date(),1};

        // 校验参数
        Set<ConstraintViolation<RentalStation>> violations  = executableValidator.validateParameters(obj,method,param);

        // 获取校验结果
        if(violations.isEmpty()){
            log.info("校验通过！");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Iterator it = violations.iterator();
        while(it.hasNext()){
            ConstraintViolation<RentalStation> cv = (ConstraintViolation<RentalStation>)it.next();
            sb.append(cv.getMessage()).append(";");
        }

        log.info("校验不通过.{}",sb.toString());
    }

}
