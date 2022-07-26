package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class TemplateFormAdapter {

    private FileTypeService fileTypeService;

    public Template createTemplateFromTemplateForm(TemplateForm templateForm, User user) {
        Template template = new Template();
        template.setName(templateForm.getName());
        template.setCode(templateForm.getCode());
        template.setContent(templateForm.getContent());
        template.setTemplateEngine(templateForm.getTemplateEngine());
        template.setEnabled(templateForm.isEnabled());
        template.setDeleted(false);
        long fileTypeId = templateForm.getFileType();
        FileType fileType = fileTypeService.getFileType(fileTypeId);
        template.setFileType(fileType);

        template.setCreatedBy(user);
        template.setCreatedDate(LocalDateTime.now());
        template.setNewId();
        return template;
    }

    public void updateTemplateFromTemplateForm(Template template, TemplateForm templateForm, User user) {
        template.setName(templateForm.getName());
        template.setCode(templateForm.getCode());
        template.setContent(templateForm.getContent());
        template.setTemplateEngine(templateForm.getTemplateEngine());
        template.setEnabled(templateForm.isEnabled());
        long fileTypeId = templateForm.getFileType();
        FileType fileType = fileTypeService.getFileType(fileTypeId);
        template.setFileType(fileType);

        template.setLastModifiedBy(user);
        template.setLastModifiedDate(LocalDateTime.now());
    }
}
