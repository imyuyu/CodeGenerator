package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.user.User;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FileTypeService {

    private FileTypeRepository fileTypeRepository;

    public FileType getFileType(Long fileTypeId) {
        return fileTypeRepository.findById(fileTypeId).orElseThrow(() -> new FileTypeNotFoundException(fileTypeId));
    }

    public FileType addFileType(FileTypeForm fileTypeForm, User user) {
        FileType fileType = FileTypeMapper.MAPPER.createFileTypeFromFileTypeForm(fileTypeForm);
        fileType.setCreatedBy(user);
        fileType.setNewId();
        fileTypeRepository.save(fileType);
        return fileType;
    }
}
