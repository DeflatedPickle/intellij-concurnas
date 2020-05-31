package com.deflatedpickle.intellij.concurnas.configuration

import com.deflatedpickle.intellij.concurnas.ConcurnasIcons
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import javax.swing.Icon

class ConcurnasRunConfigurationType : ConfigurationType {
    override fun getDisplayName(): String = "Concurnas"
    override fun getConfigurationTypeDescription(): String = "Concurnas Run Configuration Type"
    override fun getIcon(): Icon = ConcurnasIcons.CONCURNAS
    override fun getId(): String = "CONCURNAS_RUN_CONFIGURATION"
    override fun getConfigurationFactories(): Array<ConfigurationFactory> =
            arrayOf(ConcurnasConfigurationFactory(this))
}