/*
 * arg license
 *
 */

package com.arg.common.enums;

import lombok.Getter;

public enum RoleEnum {

    ROLE_ADMIN("role_admin", 1), ROLE_ADMINISTRATOR("role_administrator", 2), ROLE_HEAD_MANAGER("role_head_manager",
            6), ROLE_BRANCH_MANAGER("role_branch_manager", 10), ROLE_CHECKER("role_checker",
                    14), ROLE_MAKER("role_maker", 18), ROLE_BRANCH_AGENT("role_branch_agent",
                            22), ROLE_USER("role_user", 26), ROLE_DSA("role_dsa", 30);

    @Getter
    private String value;

    @Getter
    private Integer order;

    RoleEnum(String value, Integer order) {
        this.value = value;
        this.order = order;
    }

    public static RoleEnum getRole(String value) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getValue().equals(value)) {
                return roleEnum;
            }
        }
        throw new IllegalArgumentException("Please provide a valid role");
    }

    public static boolean validateRole(String role) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getValue().equals(role)) {
                return true;
            }
        }
        throw new IllegalArgumentException("Please provide a valid role");
    }
}
