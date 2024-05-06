package com.bysj.equipment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="字典对象", description="字典对象 ")
public class SysDict {

    @ApiModelProperty(value = "类型简拼")
    private String lxjp;
    @ApiModelProperty(value = "编码")
    private String bm;
    @ApiModelProperty(value = "名称")
    private String mc;

    public String getLxjp() {
        return lxjp;
    }

    public void setLxjp(String lxjp) {
        this.lxjp = lxjp;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }


    public SysDict() {
    }

    public SysDict(String lxjp, String bm, String mc) {
        this.lxjp = lxjp;
        this.bm = bm;
        this.mc = mc;
    }
}