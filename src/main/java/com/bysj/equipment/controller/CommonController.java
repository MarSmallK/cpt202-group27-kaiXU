/*
package com.bysj.equipment.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.bysj.equipment.dto.SysDict;
import com.bysj.equipment.entity.Gyms;
import com.bysj.equipment.entity.Users;
import com.bysj.equipment.enums.DegreeTypeEnum;
import com.bysj.equipment.enums.DictTypeEnum;
import com.bysj.equipment.enums.HealthTypeEnum;
import com.bysj.equipment.enums.RoleTypeEnum;
import com.bysj.equipment.service.IGymsService;
import com.bysj.equipment.service.IUsersService;
import com.bysj.equipment.utils.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Api(tags = "通用")
@RestController
@RequestMapping("/common/")
public class CommonController {

    @Value("${files.upload.path}")
    private String fileUploadPath;
    @Autowired
    private IGymsService gymsService;
    @Autowired
    private IUsersService usersService;

    @ApiOperation(value = "头像上传", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PostMapping(value = "uploadPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    AjaxJson uploadPhoto(@ApiParam(name = "file", value = "文件", required = true)   @RequestPart("file") MultipartFile file){
        try {
            //获取文件原始名称
            String originalFilename = file.getOriginalFilename();
            //获取文件的类型
            String type = FileUtil.extName(originalFilename);
            //获取文件
            File uploadParentFile = new File(fileUploadPath);
            //判断文件目录是否存在
            if(!uploadParentFile.exists()) {
            //如果不存在就创建文件夹
                uploadParentFile.mkdirs();
            }
            String uuid = UUID.randomUUID().toString();
            File uploadFile = new File(fileUploadPath + uuid + StrUtil.DOT + type);
            //将临时文件转存到指定磁盘位置
            file.transferTo(uploadFile);
            //将用户头像地址存储到数据库中
            //Users users = usersService.getById((Serializable) StpUtil.getLoginId());
            //users.setUrl(uuid + StrUtil.DOT + type);
            //usersService.saveOrUpdate(users);
            return AjaxJson.getSuccessData(true);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("上传失败");
        }
    }

    @ApiOperation("获取字典值通过类型简拼")
    @GetMapping("getDictByLxjp")
    AjaxJson getDictByLxjp(@ApiParam(name = "lxjp", value = "类型简拼枚举", required = true) @RequestParam() DictTypeEnum lxjp){
        try {
            List<SysDict> sysDictList=new ArrayList<>();
            if(lxjp.equals(DictTypeEnum.DegreeTypeEnum)){
                for (DegreeTypeEnum enums : DegreeTypeEnum.values()) {
                    sysDictList.add(new SysDict(DictTypeEnum.DegreeTypeEnum.getCode(), enums.getCode(),enums.getDescribe()));
                }
            }
            if(lxjp.equals(DictTypeEnum.HealthTypeEnum)){
                for (HealthTypeEnum enums : HealthTypeEnum.values()) {
                    sysDictList.add(new SysDict(DictTypeEnum.HealthTypeEnum.getCode(), enums.getCode(),enums.getDescribe()));
                }
            }
            if(lxjp.equals(DictTypeEnum.RoleTypeEnum)){
                for (RoleTypeEnum enums : RoleTypeEnum.values()) {
                    sysDictList.add(new SysDict(DictTypeEnum.RoleTypeEnum.getCode(), enums.getCode(),enums.getDescribe()));
                }
            }
            if(lxjp.equals(DictTypeEnum.GymsListDict)){
                List<Gyms> gymsList = gymsService.getGymsList(new Gyms());
                for (Gyms gym : gymsList) {
                    sysDictList.add(new SysDict(DictTypeEnum.GymsListDict.getCode(), gym.getGymId().toString(),gym.getGymName()));
                }
            }
            if(lxjp.equals(DictTypeEnum.CoachListDict)){
                Users users = new Users();
                users.setRole(RoleTypeEnum.COACH.getCode());
                List<Users> usersList = usersService.getUsersList(users);
                for (Users user : usersList) {
                    sysDictList.add(new SysDict(DictTypeEnum.CoachListDict.getCode(), user.getUserId().toString(),user.getUserName()));
                }
            }
            return AjaxJson.getSuccessData(sysDictList);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError("查询失败");
        }
    }

}
*/
