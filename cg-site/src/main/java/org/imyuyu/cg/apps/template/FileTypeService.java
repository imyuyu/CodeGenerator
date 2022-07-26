package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FileTypeService {

    private FileTypeRepository fileTypeRepository;

    public FileType getFileType(Long fileTypeId) {
        return fileTypeRepository.findById(fileTypeId).orElseThrow(() -> new FileTypeNotFoundException(fileTypeId));
    }
}
