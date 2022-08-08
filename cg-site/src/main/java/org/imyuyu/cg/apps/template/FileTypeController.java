package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.user.User;
import org.imyuyu.cg.apps.user.UserService;
import org.imyuyu.cg.common.util.BatchInput;
import org.imyuyu.cg.common.util.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/file-types")
public class FileTypeController {

    private UserService userService;
    private FileTypeService fileTypeService;

    @PostMapping
    public R addFileType(FileTypeForm fileTypeForm) {
        return R.ok(fileTypeService.addFileType(fileTypeForm, null));
    }

    @PostMapping("/{id}")
    public R updateFileType(Principal principal, @PathVariable Long id, @Valid FileTypeForm fileTypeForm) {
        User user = userService.fetchUser(principal.getName()).get();
        FileType fileType = fileTypeService.getFileType(id);
        fileTypeService.updateFileType(fileType, fileTypeForm, user);
        return R.ok();
    }

    @PostMapping("/batch")
    public R batchProcessingMapping(Principal principal, BatchInput<Long> batchInput) {
        User user = userService.fetchUser(principal.getName()).get();
        switch (batchInput.getMethod()) {
            case DELETE:
                List<Long> data = batchInput.getData();
                List<FileType> fileTypes = new ArrayList<>();
                for (Long datum : data) {
                    FileType fileType = fileTypeService.getFileType(datum);
                    if (fileType == null) {
                        continue;
                    }
                    fileTypes.add(fileType);
                }
                fileTypeService.updateDeleteState(fileTypes, user);
                break;
            case UPDATE:
                break;
        }
        return R.ok();
    }
}
