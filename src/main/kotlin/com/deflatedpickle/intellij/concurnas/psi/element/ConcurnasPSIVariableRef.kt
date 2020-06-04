package com.deflatedpickle.intellij.concurnas.psi.element

import com.deflatedpickle.intellij.concurnas.psi.ConcurnasIdentifierPSINode
import com.deflatedpickle.intellij.concurnas.psi.ConcurnasPSIElementRef
import com.deflatedpickle.intellij.concurnas.psi.subtree.ConcurnasPSIVardefSubtree
import com.intellij.psi.PsiElement

class ConcurnasPSIVariableRef(element: ConcurnasIdentifierPSINode) : ConcurnasPSIElementRef(element) {
    override fun isDefSubtree(def: PsiElement?): Boolean = def is ConcurnasPSIVardefSubtree
}