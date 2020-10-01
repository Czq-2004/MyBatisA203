import dao.DeptDao;
import entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

    @org.junit.Test
    public void Test() throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        /*第一种，查询全部
        List<Object> list = sqlSession.selectList("dao.DeptDao.selectAll");
        for (Object o : list) {
            System.out.println("o = " + o);
        }*/
        //第二种 查询全部
        //获取映射接口
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        List<Dept> depts = mapper.selectAll();
        for (Dept dept : depts) {
            System.out.println("dept = " + dept);
        }
    }

}