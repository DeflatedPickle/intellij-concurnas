package com.deflatedpickle.intellij.concurnas.psi.subtree

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree

open class ConcurnasPSIVardefSubtree(node: ASTNode, idElementType: IElementType)
    : IdentifierDefSubtree(node, idElementType)