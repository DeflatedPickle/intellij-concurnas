package com.deflatedpickle.intellij.concurnas.facet

import com.deflatedpickle.intellij.concurnas.ConcurnasIcons
import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import javax.swing.Icon

class ConcurnasFacetType : FacetType<ConcurnasFacet, ConcurnasFacetConfiguration>(
        FACET_TYPE_ID, FACET_ID, FACET_NAME
) {
    companion object {
        val FACET_ID = "CONCURNAS"
        val FACET_NAME = "Concurnas"
        val FACET_TYPE_ID = FacetTypeId<ConcurnasFacet>(this.FACET_ID)
    }

    override fun createDefaultConfiguration(): ConcurnasFacetConfiguration =
            ConcurnasFacetConfiguration()

    override fun createFacet(
            module: Module, name: String,
            configuration: ConcurnasFacetConfiguration, underlyingFacet: Facet<*>?
    ): ConcurnasFacet = ConcurnasFacet(this, module, name, configuration, underlyingFacet!!)

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean = true

    override fun getIcon(): Icon? = ConcurnasIcons.CONCURNAS
}