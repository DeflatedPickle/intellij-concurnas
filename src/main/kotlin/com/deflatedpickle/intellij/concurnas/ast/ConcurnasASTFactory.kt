package com.deflatedpickle.intellij.concurnas.ast

import com.concurnas.compiler.ConcurnasLexer
import com.deflatedpickle.intellij.concurnas.psi.ConcurnasIdentifierPSINode
import com.intellij.core.CoreASTFactory
import com.intellij.lang.DefaultASTFactoryImpl
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ConcurnasASTFactory : DefaultASTFactoryImpl() {
    override fun createLeaf(type: IElementType, text: CharSequence): LeafElement {
        return if (type is TokenIElementType &&
                type.antlrTokenType == ConcurnasLexer.NAME) {
            ConcurnasIdentifierPSINode(type, text)
        } else {
            super.createLeaf(type, text)
        }
    }
}