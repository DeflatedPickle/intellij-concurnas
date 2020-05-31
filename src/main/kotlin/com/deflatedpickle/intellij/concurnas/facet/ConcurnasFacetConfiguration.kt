package com.deflatedpickle.intellij.concurnas.facet

import com.intellij.facet.FacetConfiguration
import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.facet.ui.FacetValidatorsManager
import com.intellij.openapi.components.PersistentStateComponent

class ConcurnasFacetConfiguration : FacetConfiguration, PersistentStateComponent<ConcurnasFacetState> {
    var facetState = ConcurnasFacetState()

    override fun createEditorTabs(
            editorContext: FacetEditorContext?,
            validatorsManager: FacetValidatorsManager?
    ): Array<FacetEditorTab> = arrayOf(ConcurnasFacetEditorTab())

    override fun getState(): ConcurnasFacetState? = this.facetState

    override fun loadState(state: ConcurnasFacetState) {
        this.facetState = state
    }
}