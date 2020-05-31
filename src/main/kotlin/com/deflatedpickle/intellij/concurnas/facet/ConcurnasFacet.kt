package com.deflatedpickle.intellij.concurnas.facet

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.openapi.module.Module


class ConcurnasFacet(
        facetType: FacetType<*, *>,
        module: Module,
        name: String,
        configuration: ConcurnasFacetConfiguration,
        underlyingFacet: Facet<*>
) : Facet<ConcurnasFacetConfiguration?>(
        facetType, module, name, configuration, underlyingFacet
)