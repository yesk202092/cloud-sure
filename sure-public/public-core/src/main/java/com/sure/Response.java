package com.sure;


import sure.Enum.EnumResStatus;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> datas = new HashMap();

    public Response() {
    }

    public boolean isSuccess() {
        return (Boolean)this.datas.get("success");
    }

    public String getMessage() {
        return (String)this.datas.get("message");
    }

    public Response add(String key, Object value) {
        this.datas.put(key, value);
        return this;
    }

    public Response add(Map<String, Object> attrs) {
        this.datas.putAll(attrs);
        return this;
    }

    public static Response success() {
        return new Response.InnerResponse(true);
    }

    public static Response success(String message) {
        return new Response.InnerResponse(true, message);
    }

    public static Response error() {
        return new Response.InnerResponse(false);
    }

    public static Response error(String message) {
        return new Response.InnerResponse(false, message);
    }

    public static Response ApiError(String message) {
        return new Response.InnerResponse((Object)null, message, EnumResStatus.errorCustom.getCode(), (String)null);
    }

    public static Response ApiSuccess() {
        return new Response.InnerResponse((Object)null, "操作成功", EnumResStatus.success.getCode(), (String)null);
    }

    public static Response ApiSuccess(String message) {
        return new Response.InnerResponse((Object)null, message, EnumResStatus.success.getCode(), (String)null);
    }

    public static Response ApiSuccess(Object obj) {
        return new Response.InnerResponse(obj, (String)null, EnumResStatus.success.getCode(), (String)null);
    }

    public Map<String, Object> getDatas() {
        return this.datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }

    private static class InnerResponse extends Response implements Map<String, Object> {
        private InnerResponse(boolean success) {
            super.datas.put("success", success);
        }

        private InnerResponse(boolean success, String message) {
            super.datas.put("success", success);
            super.datas.put("message", message);
        }

        private InnerResponse(Object obj, String message, Integer status, String date) {
            super.datas.put("status", status);
            if (obj != null) {
                super.datas.put("data", obj);
            }

            if (message != null) {
                super.datas.put("message", message);
            }

            if (date != null) {
                super.datas.put("timestamp", date);
            }

        }

        public int size() {
            return super.datas.size();
        }

        public boolean isEmpty() {
            return super.datas.isEmpty();
        }

        public boolean containsKey(Object key) {
            return super.datas.containsKey(key);
        }

        public boolean containsValue(Object value) {
            return super.datas.containsValue(value);
        }

        public Object get(Object key) {
            return super.datas.get(key);
        }

        public Object put(String key, Object value) {
            return super.datas.put(key, value);
        }

        public Object remove(Object key) {
            return super.datas.remove(key);
        }

        public void putAll(Map<? extends String, ? extends Object> m) {
            super.datas.putAll(m);
        }

        public void clear() {
            super.datas.clear();
        }

        public Set<String> keySet() {
            return super.datas.keySet();
        }

        public Collection<Object> values() {
            return super.datas.values();
        }

        public Set<Entry<String, Object>> entrySet() {
            return super.datas.entrySet();
        }
    }
}
