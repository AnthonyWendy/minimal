package com.anthony.minimal.web.Tools;

import java.util.Collection;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    private static final Long INTEGER_ONE = Long.valueOf(1);
    private static final Long LONG_ONE = Long.valueOf(1);
    private static final Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);

    public static boolean isNullOrLessThanOne(Integer value) {
        return Objects.isNull(value) || INTEGER_ONE > value;
    }

    public static boolean isNullOrLessThanOne(Long value) {
        return Objects.isNull(value) || LONG_ONE > value;
    }

    public static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.trim().isEmpty();
    }

    public static boolean isNullOrEmpty(Collection collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    public static boolean isOnlyNumbers(String value) {
        return isNullOrEmpty(value) ? false : value.matches("^[0-9]+$");
    }

    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email))
            return false;

        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}