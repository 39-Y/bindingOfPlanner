package com.y39.bindingofplanner.action.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class QuestTypeConverter implements AttributeConverter<QuestType, String> {
    @Override
    public String convertToDatabaseColumn(QuestType questType) {
        if(questType == null){
            return null;
        }
        return questType.getName();
    }

    @Override
    public QuestType convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData.isBlank()){
            return null;
        }
        return QuestType.fromName(dbData);
    }
}
