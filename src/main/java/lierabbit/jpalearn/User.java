package lierabbit.jpalearn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//这是一个和数据库表相关联的类
public class User
{
    @Id//主键
    @GeneratedValue//自增长
    private Long id;//id
    @Column(length = 30)//长度30
    private String name;//名称
    @Column(nullable = false)//不可空
    private Integer age;//年龄

    public User()
    {
    }

    public User(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
}
