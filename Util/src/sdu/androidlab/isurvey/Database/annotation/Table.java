/*
 * Util sdu.androidlab.isurvey.Data Table.java
 * 2012 2012-7-23 下午12:11:38
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
@Target({ ElementType.TYPE })
public @interface Table {
	
	public abstract String[] tables();
}
