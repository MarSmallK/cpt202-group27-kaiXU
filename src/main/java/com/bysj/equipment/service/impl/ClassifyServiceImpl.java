package com.bysj.equipment.service.impl;

import com.bysj.equipment.entity.Classify;
import com.bysj.equipment.mapper.ClassifyMapper;
import com.bysj.equipment.service.IClassifyService;
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
 * 分类表 服务实现类
 * </p>
 *
 * @since 2024-04-25
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Classify saveOrUpdateClassify(Classify classify) {
        super.saveOrUpdate(classify);
        return classify;
    }

    @Override
    public Classify queryOneClassify(String id) {
        Classify classify = super.getById(id);
        Assert.notNull(classify,"查询异常");
        return classify;
    }

    @Override
    public boolean logicalDeleteClassify(String ids) {
        Assert.notBlank(ids,"ids不能为空");
        List<String> idList = Arrays.asList(StringUtils.split(ids, ","));
        return super.removeByIds(idList);
    }

    @Override
    public void queryPageClassify(Page page, Classify classify) {
        super.page(page,
            new LambdaQueryWrapper<Classify>()
        );
    }

}
