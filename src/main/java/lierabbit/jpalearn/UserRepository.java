package lierabbit.jpalearn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>//JpaRepository<实体类型，主键类型>
{
    // 通过名称找到用户
    User findByName(String name);

    // 通过名称和年龄找到用户
    User findByNameAndAge(String name, Integer age);

    // 通过名称模糊查询
    List<User> findByNameLike(String name);

    // 使用hql查询
    @Query("from User u where u.name=:name")//:name对应@Param里的name
    User findByHQL(@Param("name") String name);

    // 使用sql查询
    @Query(value = "select * from user where name = ?1 and age = ?2", nativeQuery = true)//?1表示第一个参数，?2表示第二个参数
    User findBySQL(String name, Integer age);
}
