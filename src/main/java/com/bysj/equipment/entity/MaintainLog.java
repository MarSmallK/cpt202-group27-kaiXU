package com.bysj.equipment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 保养记录表
 * </p>
 *
 * @since 2024-04-25
 */
@TableName("t_maintain_log")
@ApiModel(value="MaintainLog对象", description="保养记录表")
public class MaintainLog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "设备id")
    private Long equipmentId;

    @ApiModelProperty(value = "保养时间")
    private LocalDateTime maintainTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public LocalDateTime getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(LocalDateTime maintainTime) {
        this.maintainTime = maintainTime;
    }
}
