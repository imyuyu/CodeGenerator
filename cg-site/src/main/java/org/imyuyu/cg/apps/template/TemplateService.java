package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.applog.AppLogType;
import org.imyuyu.cg.apps.applog.Log;
import org.imyuyu.cg.apps.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.function.Function;

@AllArgsConstructor
@Service
public class TemplateService {

    private TemplateRepository templateRepository;
    private TemplateFormAdapter templateFormAdapter;

    public Page<TemplateDto> getAllTemplates(PageRequest pageRequest) {

        Page<Template> all = templateRepository.findAll(new Specification<Template>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Template> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        }, pageRequest);
        return all.map(new Function<Template, TemplateDto>() {
            @Override
            public TemplateDto apply(Template template) {
                return null;
            }
        });
    }

    public Template getTemplate(Long templateId) {
        return templateRepository.findById(templateId).orElseThrow(() -> new TemplateNotFoundException(templateId));
    }

    @Log(value = AppLogType.AddTemplate, params = {@Log.Param("${}")})
    public Template addTemplate(TemplateForm templateForm, User user) {
        Template template = templateFormAdapter.createTemplateFromTemplateForm(templateForm, user);
        templateRepository.save(template);
        return template;
    }

    public void updateTemplate(Template post, TemplateForm postForm, User user) {
        templateFormAdapter.updateTemplateFromTemplateForm(post, postForm, user);
        templateRepository.save(post);
    }

    public void deleteTemplate(Template post) {
        templateRepository.delete(post);
    }

}
