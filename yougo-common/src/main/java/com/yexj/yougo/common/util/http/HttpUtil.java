package com.chinaredstar.bill.common.util.http;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author zhengwen
 * 该注解实际上就是一个@Component，因为在一个httpclient上标一个@Component不够直观，所以改了下注解名称
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface HttpUtil {

}
