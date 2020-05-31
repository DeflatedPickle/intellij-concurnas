package com.deflatedpickle.intellij.concurnas.facet

import com.intellij.facet.ui.FacetEditorTab
import javax.swing.JComponent
import javax.swing.JPanel

class ConcurnasFacetEditorTab : FacetEditorTab() {
    override fun getDisplayName(): String = ConcurnasFacetType.FACET_NAME

    override fun createComponent(): JComponent = JPanel()

    override fun isModified(): Boolean = true
}