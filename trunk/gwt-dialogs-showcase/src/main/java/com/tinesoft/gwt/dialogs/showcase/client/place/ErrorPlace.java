
package com.tinesoft.gwt.dialogs.showcase.client.place;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import com.google.inject.BindingAnnotation;

/**
 * Error Place.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: DefaultPlace.java 2167 2011-05-04 14:51:20Z kondotine $
 */
@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD })
@Retention(RUNTIME)
public @interface ErrorPlace {}
