package demo1;

import com.java.dao.CronMapper;
import com.java.model.Cron;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wu
 * @Description:
 * @Title: MapperTest
 * @date 2018-9-20 15:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapperTest.class)
public class MapperTest {
    @Autowired
    private CronMapper cronMapper;

    @Test
    public void mapperTest(){
        cronMapper.findCronList(new Cron());
    }


    @Before
    public void init(){
        System.out.println("测试开始-----------------");
    }

    @After
    public void after(){
        System.out.println("测试结束-----------------");
    }
}
