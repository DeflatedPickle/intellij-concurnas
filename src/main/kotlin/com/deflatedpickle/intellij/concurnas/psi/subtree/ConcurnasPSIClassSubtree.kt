package com.deflatedpickle.intellij.concurnas.psi.subtree

import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode

class ConcurnasPSIClassSubtree(node: ASTNode, idElementType: IElementType)
    : IdentifierDefSubtree(node, idElementType), ScopeNode {
    override fun resolve(element: PsiNamedElement): PsiElement? =
            SymtabUtils.resolve(
                    this, ConcurnasLanguage,
                    element, "/script/class/ID"
            )
}