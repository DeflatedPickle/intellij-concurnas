package com.deflatedpickle.intellij.concurnas.psi

import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.deflatedpickle.intellij.concurnas.parser.ConcurnasParserDefinition
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode
import org.antlr.intellij.adaptor.psi.Trees

class ConcurnasIdentifierPSINode(type: IElementType, text: CharSequence) : ANTLRPsiLeafNode(type, text), PsiNamedElement {
    override fun setName(name: String): PsiElement {
        if (parent == null) return this

        Trees.createLeafFromText(
                project, ConcurnasLanguage,
                context, name, ConcurnasParserDefinition.NAME
        )

        return this
    }
}