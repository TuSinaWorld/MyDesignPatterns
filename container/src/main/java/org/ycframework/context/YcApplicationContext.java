package org.ycframework.context;

public interface YcApplicationContext {
    public Object getBean(String beanId);
    public void showBeanMap();
}
