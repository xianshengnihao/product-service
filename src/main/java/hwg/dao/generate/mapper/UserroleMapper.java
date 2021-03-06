package hwg.dao.generate.mapper;

import hwg.model.Userrole;
import hwg.model.UserroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserroleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Wed Feb 05 22:16:49 CST 2020
     */
    long countByExample(UserroleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Wed Feb 05 22:16:49 CST 2020
     */
    int deleteByExample(UserroleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Wed Feb 05 22:16:49 CST 2020
     */
    int insert(Userrole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Wed Feb 05 22:16:49 CST 2020
     */
    int insertSelective(Userrole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Wed Feb 05 22:16:49 CST 2020
     */
    List<Userrole> selectByExample(UserroleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Wed Feb 05 22:16:49 CST 2020
     */
    int updateByExampleSelective(@Param("record") Userrole record, @Param("example") UserroleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Wed Feb 05 22:16:49 CST 2020
     */
    int updateByExample(@Param("record") Userrole record, @Param("example") UserroleExample example);
}