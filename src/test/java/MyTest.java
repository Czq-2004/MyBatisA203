import dao.DeptDao;
import entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private DeptDao mapper;

    @Before
    public void Before() throws IOException {
         //加载配置文件
         is= Resources.getResourceAsStream("mybatis-config.xml");
         //创建会话工厂
         sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
         //获取会话对象
         sqlSession=sqlSessionFactory.openSession(true);
         //获取映射接口
         mapper = sqlSession.getMapper(DeptDao.class);

    }
    @Test
    public void testSelectAll(){
        List<Dept> depts = mapper.selectAll();
        for (Dept dept : depts) {
            System.out.println("dept = " + dept);
        }
    }
    @Test
    public void testSelectById(){
        Dept dept = mapper.selectById(4);
        System.out.println("dept = " + dept);
    }
    @Test
    public void testInsert(){
        Dept dept=new Dept();
        dept.setName("人的哼唧");
        int insert = mapper.insert(dept);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testDelete(){

        int delete = mapper.delete(8);
        System.out.println("delete = " + delete);

    }

    @Test
    public void testUpdate(){
        Dept dept=new Dept();
        dept.setId(7);
        dept.setName("hello");
        int update = mapper.update(dept);
        System.out.println("update = " + update);
    }

    @After
    public void After(){

    }
}
