package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.common.util.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/file-types")
public class FileTypeController {

    private FileTypeService fileTypeService;

    @PostMapping
    public R addFileType(FileTypeForm fileTypeForm) {
        return R.ok(fileTypeService.addFileType(fileTypeForm, null));
    }

    @PostMapping("/{id}")
    public R updateFileType(@PathVariable Long id, @Valid FileTypeForm fileTypeForm) {
        FileType fileType = fileTypeService.getFileType(id);
        return R.ok();
    }
}
