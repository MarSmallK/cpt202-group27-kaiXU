package com.bysj.equipment.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * 损坏程度枚举类(损坏、一般、正常、优秀)
 */
public enum DegreeTypeEnum implements BaseEnum  , Serializable {

    DAMAGE("1","损坏"),
    COMMONLY("2","一般"),
    NORMAL("3","正常"),
    EXCELLENT("4","优秀");

    @JsonValue
    @EnumValue
    private final String code;

    private final String describe;

    @JsonCreator
    DegreeTypeEnum(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescribe() {
        return describe;
    }

}
