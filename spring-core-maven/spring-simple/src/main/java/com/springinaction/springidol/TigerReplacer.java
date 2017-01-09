package com.springinaction.springidol;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by artemtursunov on 25.12.16.
 */
public class TigerReplacer implements MethodReplacer {
    public Object reimplement(Object target,
                              Method method, // Подмена метода
                              Object[] args) throws Throwable {
        return "A ferocious tiger"; // Помещает тигра в ящик
    }

}
