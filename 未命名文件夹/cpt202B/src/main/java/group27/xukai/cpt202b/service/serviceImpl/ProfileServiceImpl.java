package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Profile;
import group27.xukai.cpt202b.mapper.ProfileMapper;
import group27.xukai.cpt202b.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import jakarta.annotation.Resource;

/**
 * (Profile)表服务实现类
 *
 * @author makejava
 * @since 2024-04-28 20:24:51
 */
@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    @Resource
    private ProfileMapper profileMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param profileId 主键
     * @return 实例对象
     */
    @Override
    public Profile queryById(Long profileId) {
        return this.profileMapper.queryById(profileId);
    }

    /**
     * 分页查询
     *
     * @param profile 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Profile> queryByPage(Profile profile, PageRequest pageRequest) {
        long total = this.profileMapper.count(profile);
        return new PageImpl<>(this.profileMapper.queryAllByLimit(profile, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param profile 实例对象
     * @return 实例对象
     */
    @Override
    public Profile insert(Profile profile) {
        this.profileMapper.insert(profile);
        return profile;
    }

    /**
     * 修改数据
     *
     * @param profile 实例对象
     * @return 实例对象
     */
    @Override
    public Profile update(Profile profile) {
        this.profileMapper.update(profile);
        return this.queryById(profile.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param profileId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long profileId) {
        return this.profileMapper.deleteById(profileId) > 0;
    }
}
