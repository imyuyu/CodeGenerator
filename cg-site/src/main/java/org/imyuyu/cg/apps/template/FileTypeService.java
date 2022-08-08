package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.applog.AppLogType;
import org.imyuyu.cg.apps.applog.Log;
import org.imyuyu.cg.apps.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class FileTypeService {

    private FileTypeRepository fileTypeRepository;
    private FileTypeMapper fileTypeMapper;

    public FileType getFileType(Long fileTypeId) {
        return fileTypeRepository.findById(fileTypeId).orElseThrow(() -> new FileTypeNotFoundException(fileTypeId));
    }

    public FileType addFileType(FileTypeForm fileTypeForm, User user) {
        FileType fileType = fileTypeMapper.createFileTypeFromFileTypeForm(fileTypeForm);
        fileType.setCreatedBy(user);
        fileType.setNewId();
        fileTypeRepository.save(fileType);
        return fileType;
    }

    public void updateFileType(FileType fileType, FileTypeForm fileTypeForm, User user) {
        fileType = fileTypeMapper.updateFileTypeFromFileTypeForm(fileType, fileTypeForm);
        fileType.setLastModifiedBy(user);
        fileType.setLastModifiedDate(LocalDateTime.now());
        fileTypeRepository.save(fileType);
    }

    @Log(AppLogType.UpdateFileType)
    public void updateDeleteState(List<FileType> fileTypes, User user) {
        for (FileType fileType : fileTypes) {
            fileType.setDeleted();
            fileType.setLastModifiedDate(LocalDateTime.now());
            fileType.setLastModifiedBy(user);
        }
        fileTypeRepository.saveAll(fileTypes);
    }
}
