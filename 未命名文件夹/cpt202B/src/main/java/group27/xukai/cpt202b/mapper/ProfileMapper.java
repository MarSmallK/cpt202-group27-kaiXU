package group27.xukai.cpt202b.mapper;

import group27.xukai.cpt202b.entity.Profile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Profile)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-28 20:24:43
 */
@Mapper
@Component
public interface ProfileMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param profileId 主键
     * @return 实例对象
     */
    Profile queryById(Long profileId);

    /**
     * 查询指定行数据
     *
     * @param profile 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Profile> queryAllByLimit(Profile profile, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param profile 查询条件
     * @return 总行数
     */
    long count(Profile profile);

    /**
     * 新增数据
     *
     * @param profile 实例对象
     * @return 影响行数
     */
    int insert(Profile profile);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Profile> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Profile> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Profile> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Profile> entities);

    /**
     * 修改数据
     *
     * @param profile 实例对象
     * @return 影响行数
     */
    int update(Profile profile);

    /**
     * 通过主键删除数据
     *
     * @param profileId 主键
     * @return 影响行数
     */
    int deleteById(Long profileId);

}

