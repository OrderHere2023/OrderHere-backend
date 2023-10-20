package com.backend.OrderHere.util;

import com.backend.OrderHere.model.enums.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        return userRole.name();
    }

    @Override
    public UserRole convertToEntityAttribute(String userRole) {
        if (userRole == null) {
            return null;
        }
        return UserRole.valueOf(userRole);
    }
}

