package com.deflatedpickle.intellij.concurnas.configuration

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project

class ConcurnasConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {
    val FACTORY_NAME = "Concurnas configuration factory"

    override fun createTemplateConfiguration(project: Project): RunConfiguration =
            ConcurnasRunConfiguration(project, this, "Concurnas")
}