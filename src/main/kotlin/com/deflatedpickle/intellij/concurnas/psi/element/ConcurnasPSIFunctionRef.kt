package com.deflatedpickle.intellij.concurnas.psi.element

import com.deflatedpickle.intellij.concurnas.psi.ConcurnasIdentifierPSINode
import com.deflatedpickle.intellij.concurnas.psi.ConcurnasPSIElementRef
import com.deflatedpickle.intellij.concurnas.psi.subtree.ConcurnasPSIFunctionSubtree
import com.intellij.psi.PsiElement


class ConcurnasPSIFunctionRef(element: ConcurnasIdentifierPSINode) : ConcurnasPSIElementRef(element) {
    override fun isDefSubtree(def: PsiElement?): Boolean {
        return def is ConcurnasPSIFunctionSubtree
    }
}