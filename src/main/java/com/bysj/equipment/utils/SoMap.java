package com.bysj.equipment.utils;


import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SoMap extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    public static final Object[] NULL_ELEMENT_ARRAY = new Object[]{null, ""};
    public static final List<Object> NULL_ELEMENT_LIST;
    static Pattern patternNumber;

    public SoMap() {
    }

    public Object get(Object key) {
        return "this".equals(key) ? this : super.get(key);
    }

    public Object get(Object key, Object defaultValue) {
        Object value = this.get(key);
        return this.valueIsNull(value) ? defaultValue : value;
    }

    public String getString(String key) {
        Object value = this.get(key);
        return value == null ? null : String.valueOf(value);
    }

    public String getString(String key, String defaultValue) {
        Object value = this.get(key);
        return this.valueIsNull(value) ? defaultValue : String.valueOf(value);
    }

    public int getInt(String key) {
        Object value = this.get(key);
        return this.valueIsNull(value) ? 0 : Integer.valueOf(String.valueOf(value));
    }

    public int getInt(String key, int defaultValue) {
        Object value = this.get(key);
        return this.valueIsNull(value) ? defaultValue : Integer.valueOf(String.valueOf(value));
    }

    public long getLong(String key) {
        Object value = this.get(key);
        return this.valueIsNull(value) ? 0L : Long.valueOf(String.valueOf(value));
    }

    public double getDouble(String key) {
        Object value = this.get(key);
        return this.valueIsNull(value) ? 0.0D : Double.valueOf(String.valueOf(value));
    }

    public boolean getBoolean(String key) {
        Object value = this.get(key);
        return this.valueIsNull(value) ? false : Boolean.valueOf(String.valueOf(value));
    }

    public Date getDateByFormat(String key, String format) {
        try {
            return (new SimpleDateFormat(format)).parse(this.getString(key));
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public Date getDate(String key) {
        return this.getDateByFormat(key, "yyyy-MM-dd");
    }

    public Date getDateTime(String key) {
        return this.getDateByFormat(key, "yyyy-MM-dd HH:mm:ss");
    }

    public List<Object> getList(String key) {
        Object value = this.get(key);
        List<Object> list = null;
        if (value != null && !value.equals("")) {
            if (value instanceof List) {
                list = (List)value;
            } else {
                list = new ArrayList();
                ((List)list).add(value);
            }
        } else {
            list = new ArrayList();
        }

        return (List)list;
    }


    public void setDefaultValue(String key, Object defaultValue) {
        if (this.isNull(key)) {
            this.set(key, defaultValue);
        }

    }

    public SoMap set(String key, Object value) {
        if (key.toLowerCase().equals("this")) {
            return this;
        } else {
            this.put(key, value);
            return this;
        }
    }

    public SoMap setMap(Map<String, ?> map) {
        if (map != null) {
            Iterator var2 = map.keySet().iterator();

            while(var2.hasNext()) {
                String key = (String)var2.next();
                this.set(key, map.get(key));
            }
        }

        return this;
    }

    public SoMap setModel(Object model) {
        if (model == null) {
            return this;
        } else {
            Field[] fields = ReflectUtil.getFields(model.getClass());
            Field[] var3 = fields;
            int var4 = fields.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Field field = var3[var5];

                try {
                    field.setAccessible(true);
                    boolean isStatic = Modifier.isStatic(field.getModifiers());
                    if (!isStatic) {
                        this.set(field.getName(), field.get(model));
                    }
                } catch (Exception var8) {
                    throw new RuntimeException(var8);
                }
            }

            return this;
        }
    }

    public SoMap setJsonString(String jsonString) {
        try {
            Map<String, Object> map = (Map)(new ObjectMapper()).readValue(jsonString, Map.class);
            return this.setMap(map);
        } catch (JsonProcessingException var3) {
            throw new RuntimeException(var3);
        }
    }

    public SoMap delete(String key) {
        this.remove(key);
        return this;
    }

    public SoMap clearNull() {
        Iterator iterator = this.keySet().iterator();

        while(iterator.hasNext()) {
            String key = (String)iterator.next();
            if (this.isNull(key)) {
                iterator.remove();
                this.remove(key);
            }
        }

        return this;
    }

    public SoMap clearIn(String... keys) {
        List<String> keys2 = Arrays.asList(keys);
        Iterator iterator = this.keySet().iterator();

        while(iterator.hasNext()) {
            String key = (String)iterator.next();
            if (keys2.contains(key)) {
                iterator.remove();
                this.remove(key);
            }
        }

        return this;
    }

    public SoMap clearNotIn(String... keys) {
        List<String> keys2 = Arrays.asList(keys);
        Iterator iterator = this.keySet().iterator();

        while(iterator.hasNext()) {
            String key = (String)iterator.next();
            if (!keys2.contains(key)) {
                iterator.remove();
                this.remove(key);
            }
        }

        return this;
    }

    public SoMap clearAll() {
        this.clear();
        return this;
    }

    public static SoMap getSoMap() {
        return new SoMap();
    }

    public static SoMap getSoMap(String key, Object value) {
        return (new SoMap()).set(key, value);
    }

    public static SoMap getSoMap(Map<String, ?> map) {
        return (new SoMap()).setMap(map);
    }

    public static SoMap getSoMapByModel(Object model) {
        return getSoMap().setModel(model);
    }

    public static List<SoMap> getSoMapByList(List<?> list) {
        List<SoMap> listMap = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Object model = var2.next();
            listMap.add(getSoMapByModel(model));
        }

        return listMap;
    }

    public SoMap cloneKeys(String... keys) {
        SoMap so = new SoMap();
        String[] var3 = keys;
        int var4 = keys.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String key = var3[var5];
            so.set(key, this.get(key));
        }

        return so;
    }

    public SoMap cloneSoMap() {
        SoMap so = new SoMap();
        Iterator var2 = this.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            so.set(key, this.get(key));
        }

        return so;
    }

    public SoMap toUpperCase() {
        SoMap so = new SoMap();
        Iterator var2 = this.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            so.set(key.toUpperCase(), this.get(key));
        }

        this.clearAll().setMap(so);
        return this;
    }

    public SoMap toLowerCase() {
        SoMap so = new SoMap();
        Iterator var2 = this.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            so.set(key.toLowerCase(), this.get(key));
        }

        this.clearAll().setMap(so);
        return this;
    }

    public SoMap toKebabCase() {
        SoMap so = new SoMap();
        Iterator var2 = this.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            so.set(wordEachKebabCase(key), this.get(key));
        }

        this.clearAll().setMap(so);
        return this;
    }

    public SoMap toHumpCase() {
        SoMap so = new SoMap();
        Iterator var2 = this.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            so.set(wordEachBigFs(key), this.get(key));
        }

        this.clearAll().setMap(so);
        return this;
    }

    public SoMap humpToLineCase() {
        SoMap so = new SoMap();
        Iterator var2 = this.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            so.set(wordHumpToLine(key), this.get(key));
        }

        this.clearAll().setMap(so);
        return this;
    }

    public boolean isNull(String key) {
        return this.valueIsNull(this.get(key));
    }

    public boolean isContainNull(String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            if (this.isNull(key)) {
                return true;
            }
        }

        return false;
    }

    public boolean isNotNull(String key) {
        return !this.isNull(key);
    }

    public boolean has(String key) {
        return !this.isNull(key);
    }

    public boolean valueIsNull(Object value) {
        return NULL_ELEMENT_LIST.contains(value);
    }

    public SoMap checkNull(String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            if (this.isNull(key)) {
                throw new RuntimeException("参数" + key + "不能为空");
            }
        }

        return this;
    }

    public boolean isNumber(String key) {
        String value = this.getString(key);
        return value == null ? false : patternNumber.matcher(value).matches();
    }

    public String toJsonString() {
        try {
            return (new ObjectMapper()).writeValueAsString(this);
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public String toJsonFormatString() {
        try {
            return JSON.toJSONString(this, true);
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static SoMap getRequestSoMap() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new RuntimeException("当前线程非JavaWeb环境");
        } else {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            if (request.getAttribute("currentSoMap") == null || !(request.getAttribute("currentSoMap") instanceof SoMap)) {
                initRequestSoMap(request);
            }

            return (SoMap)request.getAttribute("currentSoMap");
        }
    }

    private static void initRequestSoMap(HttpServletRequest request) {
        SoMap soMap = new SoMap();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator var3 = parameterMap.keySet().iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();

            try {
                String[] values = (String[])parameterMap.get(key);
                if (values.length == 1) {
                    soMap.set(key, values[0]);
                } else {
                    List<String> list = new ArrayList();
                    String[] var7 = values;
                    int var8 = values.length;

                    for(int var9 = 0; var9 < var8; ++var9) {
                        String v = var7[var9];
                        list.add(v);
                    }

                    soMap.set(key, list);
                }
            } catch (Exception var11) {
                throw new RuntimeException(var11);
            }
        }

        request.setAttribute("currentSoMap", soMap);
    }

    public static boolean isJavaWeb() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes != null;
    }

    public int getKeyPageNo() {
        int pageNo = this.getInt("pageNo", 1);
        if (pageNo <= 0) {
            pageNo = 1;
        }

        return pageNo;
    }

    public int getKeyPageSize() {
        int pageSize = this.getInt("pageSize", 10);
        if (pageSize <= 0 || pageSize > 1000) {
            pageSize = 10;
        }

        return pageSize;
    }

    public int getKeySortType() {
        return this.getInt("sortType");
    }



    /** @deprecated */
    @Deprecated

    public static List<SoMap> listToTree(List<SoMap> list, String idKey, String parentIdKey, String childListKey) {
        List<SoMap> newTreeList = new ArrayList();
        SoMap hash = new SoMap();

        int j;
        SoMap aVal;
        for(j = 0; j < list.size(); ++j) {
            aVal = (SoMap)list.get(j);
            hash.put(aVal.getString(idKey), aVal);
        }

        for(j = 0; j < list.size(); ++j) {
            aVal = (SoMap)list.get(j);
            SoMap hashVp = (SoMap)hash.get(aVal.get(parentIdKey, "").toString());
            if (hashVp != null) {
                if (hashVp.get(childListKey) != null) {
                    List<SoMap> ch = (List)hashVp.get(childListKey);
                    ch.add(aVal);
                    hashVp.put(childListKey, ch);
                } else {
                    List<SoMap> ch = new ArrayList();
                    ch.add(aVal);
                    hashVp.put(childListKey, ch);
                }
            } else {
                newTreeList.add(aVal);
            }
        }

        return newTreeList;
    }

    private static String wordEachBig(String str) {
        String newStr = "";
        String[] var2 = str.split("_");
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String s = var2[var4];
            newStr = newStr + wordFirstBig(s);
        }

        return newStr;
    }

    private static String wordEachBigFs(String str) {
        return wordFirstSmall(wordEachBig(str));
    }

    private static String wordFirstBig(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }

    private static String wordFirstSmall(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
    }

    private static String wordEachKebabCase(String str) {
        return str.replaceAll("_", "-");
    }

    private static String wordHumpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    static {
        NULL_ELEMENT_LIST = Arrays.asList(NULL_ELEMENT_ARRAY);
        patternNumber = Pattern.compile("[0-9]*");
    }
}
