package org.imyuyu.cg.apps.template;

import org.imyuyu.cg.apps.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.time.LocalDateTime;

@Mapper
public interface FileTypeMapper {

    FileTypeMapper MAPPER = Mappers.getMapper(FileTypeMapper.class);

    @Mapping(target = "deleted", expression = "java(false)")
    @Mapping(target = "createdDate", expression = "java(LocalDateTime.now())")
    FileType createFileTypeFromFileTypeForm(FileTypeForm fileTypeForm);

    FileType updateFileTypeFromFileTypeForm(@MappingTarget FileType fileType, FileTypeForm fileTypeForm);
}
