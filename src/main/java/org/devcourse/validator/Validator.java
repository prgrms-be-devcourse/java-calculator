package org.devcourse.validator;

@FunctionalInterface
public interface Validator<T> {

    boolean validate(T checkParam);

}
