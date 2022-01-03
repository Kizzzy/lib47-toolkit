package cn.kizzzy.toolkit.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PluginParameter {
    
    PluginType type() default PluginType.EMBEDED;
    
    String url();
    
    String title();
    
    String icon() default "";
    
    boolean transparent() default false;
    
    boolean show() default true;
    
    boolean single() default true;
    
    boolean closable() default true;
    
    boolean resize() default true;
    
    boolean top() default false;
}
