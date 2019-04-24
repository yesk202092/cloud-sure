package com.sure.page;


import org.apache.commons.lang3.StringUtils;
import sure.Enum.EnumContons;

import java.util.*;
import java.util.Map.Entry;

public abstract class Params {
    public static final String SYSDATE_KEY = "sysdate";
    private final Map<String, Object> data = new HashMap();

    public Params() {
    }

    public Params add(String key, Object value) {
        if (this.canAdd(value)) {
            this.data.put(key, value);
        }

        return this;
    }

    public Params add(Object value) {
        if (this.canAdd(value)) {
            this.data.put("entity", value);
        }

        return this;
    }

    public Params addSysdate() {
        this.data.put("sysdate", new Date());
        return this;
    }

    public Params addLike(String key, String value) {
        return this.addLike(key, value, true, true);
    }

    public Params addLLike(String key, String value) {
        return this.addLike(key, value, true, false);
    }

    public Params addRLike(String key, String value) {
        return this.addLike(key, value, false, true);
    }

    public Params add(Map<String, Object> params) {
        if (params != null) {
            Iterator var2 = params.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, Object> entry = (Entry)var2.next();
                if (this.canAdd(entry.getValue())) {
                    this.data.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return this;
    }

    public Params addDeleted(EnumContons bool) {
        return this.add("deleted", bool.value);
    }

    public Params addCorpCode(String corpCode) {
        if (!this.data.containsKey("corpCode")) {
            this.add("corpCode", corpCode);
        }

        return this;
    }

    public String toString() {
        return this.data.toString();
    }

    private Params addLike(String key, String value, boolean left, boolean right) {
        if (this.canAdd(value)) {
            if (left) {
                value = "%" + value;
            }

            if (right) {
                value = value + "%";
            }

            this.data.put(key, value);
        }

        return this;
    }

    private boolean canAdd(Object value) {
        if (value == null) {
            return false;
        } else {
            return !(value instanceof String) || !StringUtils.isBlank((String)value);
        }
    }

    public Map<String, Object> toMap() {
        return this.data;
    }

    public static Params create() {
        return new Params.ParamsMap();
    }

    private static class ParamsMap extends Params implements Map<String, Object> {
        private ParamsMap() {
        }

        public int size() {
            return super.data.size();
        }

        public boolean isEmpty() {
            return super.data.isEmpty();
        }

        public boolean containsKey(Object key) {
            return super.data.containsKey(key);
        }

        public boolean containsValue(Object value) {
            return super.data.containsValue(value);
        }

        public Object get(Object key) {
            return super.data.get(key);
        }

        public Object put(String key, Object value) {
            return super.data.put(key, value);
        }

        public Object remove(Object key) {
            return super.data.remove(key);
        }

        public void putAll(Map<? extends String, ? extends Object> m) {
            super.data.putAll(m);
        }

        public void clear() {
            super.data.clear();
        }

        public Set<String> keySet() {
            return super.data.keySet();
        }

        public Collection<Object> values() {
            return super.data.values();
        }

        public Set<Entry<String, Object>> entrySet() {
            return super.data.entrySet();
        }
    }
}
