package fr.univparis8.iut.csid.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdAndBodyMatcher {
}
