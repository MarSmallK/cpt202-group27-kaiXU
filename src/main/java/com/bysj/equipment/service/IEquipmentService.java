package com.bysj.equipment.service;

import com.bysj.equipment.entity.Equipment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @since 2024-04-25
 */
public interface IEquipmentService extends IService<Equipment> {

    Equipment saveOrUpdateEquipment(Equipment equipment);

    Equipment queryOneEquipment(String id);

    boolean logicalDeleteEquipment(String ids);

    void queryPageEquipment(Page page,Equipment equipment);

}
