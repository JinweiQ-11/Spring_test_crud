package aop;

import com.itheima.aop.Itarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/21 0:04
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class Aoptest {
    @Autowired
    private Itarget itarget;

   @Test
    public void testAop(){
       itarget.save();
   }

}
