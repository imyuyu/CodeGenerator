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
@RequestMapping("/templates")
public class TemplateController {

    private UserService userService;
    private TemplateService templateService;

    @PostMapping
    public R<Template> createTemplate(Principal principal, @Valid TemplateForm templateForm) {
        User user = userService.fetchUser(principal.getName()).get();
        Template post = templateService.addTemplate(templateForm, user);
        return R.ok(post);
    }

    @PostMapping("/{id}")
    public R updateTemplate(Principal principal, @PathVariable Long id, @Valid TemplateForm templateForm) {
        Template template = templateService.getTemplate(id);
        User user = userService.fetchUser(principal.getName()).get();
        templateService.updateTemplate(template, templateForm, user);
        return R.ok();
    }

    @PostMapping("/batch")
    public R batchProcessingMapping(Principal principal, BatchInput<Long> batchInput) {
        User user = userService.fetchUser(principal.getName()).get();
        switch (batchInput.getMethod()) {
            case DELETE:
                List<Long> data = batchInput.getData();
                List<Template> templates = new ArrayList<>();
                for (Long datum : data) {
                    Template template = templateService.getTemplate(datum);
                    if (template == null) {
                        continue;
                    }
                    templates.add(template);
                }
                templateService.updateDeleteState(templates, user);
                break;
            case UPDATE:
                break;
        }
        return R.ok();
    }
}
