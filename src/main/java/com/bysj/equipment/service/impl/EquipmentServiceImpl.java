package com.bysj.equipment.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bysj.equipment.entity.Equipment;
import com.bysj.equipment.mapper.EquipmentMapper;
import com.bysj.equipment.service.IEquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @since 2024-04-25
 */
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements IEquipmentService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Equipment saveOrUpdateEquipment(Equipment equipment) {
        if(ObjectUtil.isNull(equipment.getId())){
            equipment.setAddTime(LocalDateTime.now());
        }
        super.saveOrUpdate(equipment);
        return equipment;
    }

    @Override
    public Equipment queryOneEquipment(String id) {
        Equipment equipment = super.getById(id);
        Assert.notNull(equipment,"查询异常");
        return equipment;
    }

    @Override
    public boolean logicalDeleteEquipment(String ids) {
        Assert.notBlank(ids,"ids不能为空");
        List<String> idList = Arrays.asList(StringUtils.split(ids, ","));
        return super.removeByIds(idList);
    }

    @Override
    public void queryPageEquipment(Page page, Equipment equipment) {
        super.page(page,
            new QueryWrapper<Equipment>()
                    .select("t_equipment.*," +
                            "(select classify_name from t_classify tc where t_equipment.equipment_type=tc.id)equipmentTypeName")
                    .eq(StringUtils.isNotBlank(equipment.getEquipmentType()),"equipment_type",equipment.getEquipmentType())
                    .orderByDesc("add_time")
        );
    }

}
