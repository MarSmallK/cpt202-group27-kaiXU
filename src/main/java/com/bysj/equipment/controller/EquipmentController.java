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
import com.bysj.equipment.entity.Equipment;
import com.bysj.equipment.service.IEquipmentService;

/**
 * <p>
 * 设备表 控制层
 * </p>
 * @since 2024-04-25
 */
@Api(tags = "设备表")
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private IEquipmentService equipmentService;

    @ApiOperation("新增/编辑设备表")
    @PostMapping("saveOrUpdateEquipment")
    AjaxJson saveOrUpdateEquipment(Equipment equipment){
        try {
            return AjaxJson.getSuccessData(equipmentService.saveOrUpdateEquipment(equipment));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("保存失败");
        }
    }

    @ApiOperation("查询设备表")
    @GetMapping("queryOneEquipment")
    AjaxJson queryOneEquipment(String id){
        try {
            return AjaxJson.getSuccessData(equipmentService.queryOneEquipment(id));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }

    @ApiOperation("删除设备表")
    @GetMapping("logicalDeleteEquipment")
    AjaxJson logicalDeleteEquipment(String ids){
        try {
            return AjaxJson.getSuccessData(equipmentService.logicalDeleteEquipment(ids));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("删除失败");
        }
    }

    @ApiOperation("分页查询设备表")
    @PostMapping("/queryPageEquipment")
    AjaxJson queryPageEquipment(Page page, Equipment equipment ){
        try {
            equipmentService.queryPageEquipment(page,equipment);
            return AjaxJson.getSuccessData(page);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }

}

