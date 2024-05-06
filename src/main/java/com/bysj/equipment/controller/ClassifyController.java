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
import com.bysj.equipment.entity.Classify;
import com.bysj.equipment.service.IClassifyService;

import java.util.List;

/**
 * <p>
 * 分类表 控制层
 * </p>
 * @since 2024-04-25
 */
@Api(tags = "分类表")
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private IClassifyService classifyService;

    @ApiOperation("新增/编辑分类表")
    @PostMapping("saveOrUpdateClassify")
    AjaxJson saveOrUpdateClassify(Classify classify){
        try {
            return AjaxJson.getSuccessData(classifyService.saveOrUpdateClassify(classify));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("保存失败");
        }
    }

    @ApiOperation("查询分类表")
    @GetMapping("queryOneClassify")
    AjaxJson queryOneClassify(String id){
        try {
            return AjaxJson.getSuccessData(classifyService.queryOneClassify(id));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }

    @ApiOperation("删除分类表")
    @GetMapping("logicalDeleteClassify")
    AjaxJson logicalDeleteClassify(String ids){
        try {
            return AjaxJson.getSuccessData(classifyService.logicalDeleteClassify(ids));
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("删除失败");
        }
    }

    @ApiOperation("分页查询分类表")
    @PostMapping("/queryPageClassify")
    AjaxJson queryPageClassify(Page page, Classify classify ){
        try {
            classifyService.queryPageClassify(page,classify);
            return AjaxJson.getSuccessData(page);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }
    @ApiOperation("列表查询分类表")
    @GetMapping("/queryListClassify")
    AjaxJson queryListClassify( ){
        try {
            List<Classify> list = classifyService.list();
            return AjaxJson.getSuccessData(list);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }

}

