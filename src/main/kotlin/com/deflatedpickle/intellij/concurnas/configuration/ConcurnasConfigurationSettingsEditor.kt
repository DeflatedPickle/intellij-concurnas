package com.deflatedpickle.intellij.concurnas.configuration

import com.intellij.openapi.options.SettingsEditor
import javax.swing.JComponent
import javax.swing.JPanel

class ConcurnasConfigurationSettingsEditor : SettingsEditor<ConcurnasRunConfiguration>() {
    val panel = JPanel()

    override fun resetEditorFrom(s: ConcurnasRunConfiguration) {
    }

    override fun applyEditorTo(s: ConcurnasRunConfiguration) {
    }

    override fun createEditor(): JComponent = panel
}