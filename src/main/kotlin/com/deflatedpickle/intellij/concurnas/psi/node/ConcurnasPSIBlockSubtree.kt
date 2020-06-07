package com.deflatedpickle.intellij.concurnas.psi.node

import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode


class ConcurnasPSIBlockSubtree(node: ASTNode) : ANTLRPsiNode(node), ScopeNode {
    override fun resolve(element: PsiNamedElement?): PsiElement? =
            SymtabUtils.resolve(
                    this, ConcurnasLanguage,
                element, "/block/vardef/ID"
            )
}