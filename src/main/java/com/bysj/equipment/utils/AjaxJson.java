package com.bysj.equipment.utils;


import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class AjaxJson extends LinkedHashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 500;
    public static final int CODE_WARNING = 501;
    public static final int CODE_NOT_JUR = 403;
    public static final int CODE_NOT_LOGIN = 401;
    public static final int CODE_INVALID_REQUEST = 400;

    public AjaxJson setCode(int code) {
        this.put("code", code);
        return this;
    }

    public Integer getCode() {
        return (Integer)this.get("code");
    }

    public AjaxJson setMsg(String msg) {
        this.put("msg", msg);
        return this;
    }

    public String getMsg() {
        return (String)this.get("msg");
    }

    public AjaxJson setData(Object data) {
        this.put("data", data);
        return this;
    }

    public String getData() {
        return (String)this.get("data");
    }

    /*public <T> T getData(Class<T> cs) {
        return this.get("data");
    }*/

    public AjaxJson setDataCount(Long dataCount) {
        this.put("dataCount", dataCount);
        if (dataCount != null && dataCount >= 0L) {
            if (this.get("pageNo") != null) {
                this.initPageInfo();
            } else if (SoMap.isJavaWeb()) {
                SoMap so = SoMap.getRequestSoMap();
                this.setPageNoAndSize((long)so.getKeyPageNo(), (long)so.getKeyPageSize());
                this.initPageInfo();
            }
        }

        return this;
    }

    public String getDataCount() {
        return (String)this.get("dataCount");
    }

    public AjaxJson setPageNoAndSize(long pageNo, long pageSize) {
        this.put("pageNo", pageNo);
        this.put("pageSize", pageSize);
        return this;
    }

    public AjaxJson initPageInfo() {
        long pageNo = (Long)this.get("pageNo");
        long pageSize = (Long)this.get("pageSize");
        long dataCount = (Long)this.get("dataCount");
        this.set("startIndex", (pageNo - 1L) * pageSize);
        long pc = dataCount / pageSize;
        this.set("pageCount", dataCount % pageSize == 0L ? pc : pc + 1L);
        return this;
    }

    public AjaxJson set(String key, Object data) {
        this.put(key, data);
        return this;
    }

    public AjaxJson setMap(Map<String, ?> map) {
        Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            this.put(key, map.get(key));
        }

        return this;
    }

    public AjaxJson(int code, String msg, Object data, Long dataCount) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        this.setDataCount(dataCount == null ? -1L : dataCount);
    }

    public static AjaxJson getSuccess() {
        return new AjaxJson(200, "ok", (Object)null, (Long)null);
    }

    public static AjaxJson getSuccess(String msg) {
        return new AjaxJson(200, msg, (Object)null, (Long)null);
    }

    public static AjaxJson getSuccess(String msg, Object data) {
        return new AjaxJson(200, msg, data, (Long)null);
    }

    public static AjaxJson getSuccessData(Object data) {
        return new AjaxJson(200, "ok", data, (Long)null);
    }

    public static AjaxJson getError() {
        return new AjaxJson(500, "error", (Object)null, (Long)null);
    }

    public static AjaxJson getError(String msg) {
        return new AjaxJson(500, msg, (Object)null, (Long)null);
    }

    public static AjaxJson getWarning() {
        return new AjaxJson(500, "warning", (Object)null, (Long)null);
    }

    public static AjaxJson getWarning(String msg) {
        return new AjaxJson(501, msg, (Object)null, (Long)null);
    }

    public static AjaxJson getNotLogin() {
        return new AjaxJson(401, "未登录，请登录后再次访问", (Object)null, (Long)null);
    }

    public static AjaxJson getNotJur(String msg) {
        return new AjaxJson(403, msg, (Object)null, (Long)null);
    }

    public static AjaxJson get(int code, String msg) {
        return new AjaxJson(code, msg, (Object)null, (Long)null);
    }

    public static AjaxJson getPageData(Long dataCount, Object data) {
        return new AjaxJson(200, "ok", data, dataCount);
    }

    public static AjaxJson getByLine(int line) {
        return line > 0 ? getSuccess("ok", line) : getError("error").setData(line);
    }

    public static AjaxJson getByBoolean(boolean b) {
        return b ? getSuccess("ok") : getError("error");
    }
}
