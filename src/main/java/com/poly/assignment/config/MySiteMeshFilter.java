package com.poly.assignment.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/decorator.jsp")
                .addDecoratorPath("/admin/*", "/admin/adminDecorator.jsp")
                .addExcludedPath("/login");
    }
}
