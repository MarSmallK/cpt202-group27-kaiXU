package com.bysj.equipment.utils;

public class Constants {



    /**
     * 删除类型
     */
    public interface  DELETED_TYPE{
        String DELETED = "1";
        String UN_DELETED = "0";
    }

    public interface  DEGREE_TYPE{
        String FINISH = "finish";
        String HEARTBEAT = "HeartBeat";
        String NOT_IMEREMAINING = "noTimeRemaining";
    }

    public interface  SA_TOKEN_SESSION_KEY{
        String USER = "USER";
        String USER_NAME = "USER_NAME";
        String ROLE_ID = "ROLE_ID";
        String USER_DEPT = "USER_DEPT";
        String USER_DEPT0 = "USER_DEPT0";
        String USER_ID = "USER_ID";
        String USER_PHONE_NUMBER = "USER_PHONE_NUMBER";
        String USER_TOKEN = "USER_TOKEN";
        String USER_TOKEN_NAME = "USER_TOKEN_NAME";
        String USER_TOKEN_VALUE = "USER_TOKEN_VALUE";
    }

    // 角色
    public interface ROLE_ID {
        String CJGLY = "1";// 超级管理员 1
        String EJGLY = "2";// 二级管理员 2
        String GKY = "3";// 管库员 3
        String RSKFZR = "4";// 人事科负责人 4
        String HBGKY = "5";// 后备管库员 5
        String KZR = "6";// 库主任 6
        String FGFZR = "7";// 分管负责人 7
        String CZY = "8";// 操作员 8
        String FXKJ = "9";// 发行会计 9
        String BMZYFZR = "10";// 部门主要负责人 10
        String KFZR = "11";// 库副主任 11
        String QTRY = "12";// 其他人员 12
    }

    public interface DEPT_TYPE{
        String UNIT = "1";//机构
        String PARENT_ID = "-1";// 根级
        String DEPT = "2";// 部门
    }

}
