package com.jack.healthManage.util;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Helper to get an {@link Enum} of any Type by attribute or method
 *
 */
public final class FunctionalEnumHelper {

    // Constructors
    //-------------------------------------------------

    /**
     * Private constructor
     * A helper should not be instantiated in order to force static calls
     */
    private FunctionalEnumHelper() {}


    // Static methods
    //-------------------------------------------------

    /**
     * Get the enum of type <code>E</code> associated to the attribute
     * @param enumType
     * @param method
     * @param expectedValue
     * @return
     */
//    public static <E extends Enum<E>, R> E getEnum(final Class<E> enumType, final Function<E, R> method, final R expectedValue) {
//        E enumVariable = null;
//        E[] values = enumType.getEnumConstants();
//        if(values != null) {
//            for(E e : values) {
//                if(e != null) {
//                    Object value = method.apply(e);
//                    if(value == null && expectedValue == null || value != null && value.equals(expectedValue)) {
//                        enumVariable = e;
//                        break;
//                    }
//                }
//            }
//        }
//        return enumVariable;
//    }

    /* Functional style */
    public static <E extends Enum<E>, R> E getEnum(final Class<E> enumType, final Function<E, R> method, final R expectedValue) {
        return Arrays.stream(enumType.getEnumConstants())
                .filter(e -> {
                    final Object value = method.apply(e);
                    return value == null && expectedValue == null || value != null && value.equals(expectedValue);
                })
                .findAny()
                .orElse(null);
    }

}