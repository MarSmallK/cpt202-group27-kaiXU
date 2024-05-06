package com.bysj.equipment.service;

import com.bysj.equipment.entity.MaintainLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 保养记录表 服务类
 * </p>
 *
 * @since 2024-04-25
 */
public interface IMaintainLogService extends IService<MaintainLog> {

    MaintainLog saveOrUpdateMaintainLog(MaintainLog maintainLog);

    MaintainLog queryOneMaintainLog(String id);

    boolean logicalDeleteMaintainLog(String ids);

    void queryPageMaintainLog(Page page,MaintainLog maintainLog);

}
