package lierabbit.jpalearn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaLearnApplicationTests
{
    // 注入userRepository
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads()
    {
        // 添加10个测试用例
        userRepository.save(new User("QQQ",1));
        userRepository.save(new User("WWW",2));
        userRepository.save(new User("EEE",3));
        userRepository.save(new User("AAA",4));
        userRepository.save(new User("SSS",5));
        userRepository.save(new User("DDD",6));
        userRepository.save(new User("ZZZ",7));
        userRepository.save(new User("XXX",8));
        userRepository.save(new User("CCC",9));
        userRepository.save(new User("QQQ2",10));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为AAA的User
        Assert.assertEquals(4, userRepository.findByName("AAA").getAge().longValue());

        // 测试findByHQL, 查询姓名为AAA的User
        Assert.assertEquals(4, userRepository.findByHQL("AAA").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为SSS并且年龄为5的User
        Assert.assertEquals("SSS", userRepository.findByNameAndAge("SSS", 5).getName());

        // 测试findBySQL, 查询姓名为SSS并且年龄为5的User
        Assert.assertEquals("SSS", userRepository.findBySQL("SSS", 5).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());

        // 测试findAll, 查询名字有Q的有几个
        Assert.assertEquals(2,userRepository.findByNameLike("%Q%").size());
    }

}
