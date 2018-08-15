import com.gameloft9.demo.beans.Car;
import com.gameloft9.demo.beans.Menu;
import com.gameloft9.demo.validation.group.MenuDeleteCheck;
import com.gameloft9.demo.validation.group.MenuUpdateCheck;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * 分组校验测试
 * Created by gameloft9 on 2018/8/14.
 */
@Slf4j
public class GroupValidationTest {

    /**
     * 测试分组校验
     * */
    @Test
    public void testGroupValidation(){
        Menu menu = new Menu();

        // 拿到validator对象
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 开始校验
        Set<ConstraintViolation<Menu>> constraintViolations = validator.validate( menu, MenuUpdateCheck.class);

        // 获取校验结果
        if(constraintViolations.isEmpty()){
           log.info("校验通过");
        }

        StringBuilder sb = new StringBuilder();
        Iterator it = constraintViolations.iterator();
        while(it.hasNext()){
            ConstraintViolation<Menu> cv = (ConstraintViolation<Menu>)it.next();
            sb.append(cv.getMessage()).append(";");
        }

        log.info("校验不通过.{}",sb.toString());
    }
}
