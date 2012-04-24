package com.ekito

import org.gradle.api.Project
import org.gradle.api.Plugin

class DoxiaPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.task('hello', type: DoxiaConverterTask)
    }
}
