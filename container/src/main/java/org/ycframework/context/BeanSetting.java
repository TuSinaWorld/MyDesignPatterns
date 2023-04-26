package org.ycframework.context;

import java.lang.reflect.Method;

public class BeanSetting {
    private String beanId = null;
    private Class<?> cls = null;
    private Method md = null;
    private boolean useMethod = false;
    private boolean useLazy = false;
    private boolean useScope = false;

    @Override
    public String toString() {
        return "BeanSetting{" +
                "beanId='" + beanId + '\'' +
                ", cls=" + cls +
                ", md=" + md +
                ", useMethod=" + useMethod +
                ", useLazy=" + useLazy +
                ", useScope=" + useScope +
                '}';
    }

    public boolean isUseMethod() {
        return useMethod;
    }

    public void setUseMethod(boolean useMethod) {
        this.useMethod = useMethod;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public boolean isUseScope() {
        return useScope;
    }

    public void setUseScope(boolean useScope) {
        this.useScope = useScope;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public boolean isUseLazy() {
        return useLazy;
    }

    public void setUseLazy(boolean useLazy) {
        this.useLazy = useLazy;
    }

    public Method getMd() {
        return md;
    }

    public void setMd(Method md) {
        this.md = md;
    }

}
