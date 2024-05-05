package com.bysj.equipment.service.impl;

import com.bysj.equipment.entity.MaintainLog;
import com.bysj.equipment.mapper.MaintainLogMapper;
import com.bysj.equipment.service.IMaintainLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 保养记录表 服务实现类
 * </p>
 *
 * @since 2024-04-25
 */
@Service
public class MaintainLogServiceImpl extends ServiceImpl<MaintainLogMapper, MaintainLog> implements IMaintainLogService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MaintainLog saveOrUpdateMaintainLog(MaintainLog maintainLog) {
        super.saveOrUpdate(maintainLog);
        return maintainLog;
    }

    @Override
    public MaintainLog queryOneMaintainLog(String id) {
        MaintainLog maintainLog = super.getById(id);
        Assert.notNull(maintainLog,"查询异常");
        return maintainLog;
    }

    @Override
    public boolean logicalDeleteMaintainLog(String ids) {
        Assert.notBlank(ids,"ids不能为空");
        List<String> idList = Arrays.asList(StringUtils.split(ids, ","));
        return super.removeByIds(idList);
    }

    @Override
    public void queryPageMaintainLog(Page page, MaintainLog maintainLog) {
        super.page(page,
            new LambdaQueryWrapper<MaintainLog>()
        );
    }

}
