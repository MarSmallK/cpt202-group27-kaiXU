package group27.xukai.cpt202b.service;

import group27.xukai.cpt202b.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Profile)表服务接口
 *
 * @author makejava
 * @since 2024-04-28 20:24:51
 */
public interface ProfileService {

    /**
     * 通过ID查询单条数据
     *
     * @param profileId 主键
     * @return 实例对象
     */
    Profile queryById(Long profileId);

    /**
     * 分页查询
     *
     * @param profile 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Profile> queryByPage(Profile profile, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param profile 实例对象
     * @return 实例对象
     */
    Profile insert(Profile profile);

    /**
     * 修改数据
     *
     * @param profile 实例对象
     * @return 实例对象
     */
    Profile update(Profile profile);

    /**
     * 通过主键删除数据
     *
     * @param profileId 主键
     * @return 是否成功
     */
    boolean deleteById(Long profileId);

}
