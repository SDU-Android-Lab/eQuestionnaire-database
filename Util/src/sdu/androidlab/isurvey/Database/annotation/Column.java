/*
 * Util sdu.androidlab.isurvey.Database.annotation Column.java
 * 2012 2012-7-23 下午2:03:06
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhenzxie
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
	public abstract String name();
}
