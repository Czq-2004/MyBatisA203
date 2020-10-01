package dao;

import entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptDao {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from dept")
    @Results(id="deptResult",value = {
            @Result(id=true, property="id",column = "dept_id"),
            @Result(property = "name" ,column = "dept_name")
    })
    List<Dept> selectAll();

    /**
     * 根据id查询
     * @param dept_id
     * @return
     */
    @Select("select * from dept where dept_id=#{dept_id}")
    @ResultMap("deptResult")
    Dept selectById(int dept_id);

    /**
     * 添加   删除  修改
     * @param dept
     * @return
     */
    @Insert("insert into dept(dept_name) values(#{dept_name})")
    int insert(Dept dept);

    @Delete("delete from dept where dept_id=#{dept_id}")
    int delete(int dept_id);

    @Update("update dept set dept_name=#{dept_name} where dept_id=#{dept_id}")
    int update(Dept dept);
}
