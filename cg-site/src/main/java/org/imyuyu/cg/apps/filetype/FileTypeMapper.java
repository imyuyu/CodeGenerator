package org.imyuyu.cg.apps.filetype;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {LocalDateTime.class}, componentModel = "spring")
public interface FileTypeMapper {

    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "createdDate", expression = "java(LocalDateTime.now())")
    FileType createFileTypeFromFileTypeForm(FileTypeForm fileTypeForm);

    FileType updateFileTypeFromFileTypeForm(@MappingTarget FileType fileType, FileTypeForm fileTypeForm);
}
