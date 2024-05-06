package com.bysj.equipment.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bysj.equipment.utils.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bysj.equipment.entity.MaintainLog;
import com.bysj.equipment.service.IMaintainLogService;

/**
 * <p>
 * 保养记录表 控制层
 * </p>
 * @since 2024-04-25
 */
@Api(tags = "保养记录表")
@RestController
@RequestMapping("/maintain-log")
public class MaintainLogController {
    @Autowired
    private IMaintainLogService maintainLogService;

    @ApiOperation("新增/编辑保养记录表")
    @PostMapping("saveOrUpdateMaintainLog")
    AjaxJson saveOrUpdateMaintainLog(MaintainLog maintainLog){
        try {
            return AjaxJson.getSuccessData(maintainLogService.saveOrUpdateMaintainLog(maintainLog));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("保存失败");
        }
    }

    @ApiOperation("查询保养记录表")
    @GetMapping("queryOneMaintainLog")
    AjaxJson queryOneMaintainLog(String id){
        try {
            return AjaxJson.getSuccessData(maintainLogService.queryOneMaintainLog(id));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }

    @ApiOperation("删除保养记录表")
    @GetMapping("logicalDeleteMaintainLog")
    AjaxJson logicalDeleteMaintainLog(String ids){
        try {
            return AjaxJson.getSuccessData(maintainLogService.logicalDeleteMaintainLog(ids));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("删除失败");
        }
    }

    @ApiOperation("分页查询保养记录表")
    @PostMapping("/queryPageMaintainLog")
    AjaxJson queryPageMaintainLog(Page page, MaintainLog maintainLog ){
        try {
            maintainLogService.queryPageMaintainLog(page,maintainLog);
            return AjaxJson.getSuccessData(page);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }

}

