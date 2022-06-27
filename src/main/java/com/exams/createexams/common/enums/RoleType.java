package com.exams.createexams.common.enums;

public enum RoleType {

    ADMIN, USER, MEMBER, STUDENT;

    private static final String ROLE_PREFIX = "ROLE_";

    public String getFullRoleName() {
        return ROLE_PREFIX + this.name();
    }
}
