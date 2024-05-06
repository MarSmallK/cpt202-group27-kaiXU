package com.bysj.equipment.service;

import com.bysj.equipment.entity.Classify;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @since 2024-04-25
 */
public interface IClassifyService extends IService<Classify> {

    Classify saveOrUpdateClassify(Classify classify);

    Classify queryOneClassify(String id);

    boolean logicalDeleteClassify(String ids);

    void queryPageClassify(Page page,Classify classify);

}
