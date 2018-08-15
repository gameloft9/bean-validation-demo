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
 * 自定义注解测试
 * Created by admin on 2018/8/14.
 */
@Slf4j
public class CustomValidationTest {

    /**
     * 测试自定义校验
     * */
    @Test
    public void testCustomValidation(){
        Person person = new Person("<"); // 测试不通过打开这个
        //Person person = new Person("Gameloft9"); // 测试通过打开这个

        // 拿到validator对象
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 开始校验
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate( person );

        // 获取校验结果
        if(constraintViolations.isEmpty()){
           log.info("校验通过！");
           return;
        }

        StringBuilder sb = new StringBuilder();
        Iterator it = constraintViolations.iterator();
        while(it.hasNext()){
            ConstraintViolation<Person> cv = (ConstraintViolation<Person>)it.next();
            sb.append(cv.getMessage()).append(";");
        }

        log.info("校验不通过.{}",sb.toString());
    }
}
