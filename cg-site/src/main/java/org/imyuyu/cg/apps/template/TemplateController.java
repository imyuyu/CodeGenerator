package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.user.User;
import org.imyuyu.cg.apps.user.UserService;
import org.imyuyu.cg.common.util.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

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

    @PostMapping("/{id:\\d+}")
    public R updateTemplate(Principal principal, @PathVariable Long id, @Valid TemplateForm templateForm) {
        Template template = templateService.getTemplate(id);
        User user = userService.fetchUser(principal.getName()).get();
        templateService.updateTemplate(template, templateForm, user);
        return R.ok();
    }

    public R deleteTemplate() {

        return R.ok();
    }
}
