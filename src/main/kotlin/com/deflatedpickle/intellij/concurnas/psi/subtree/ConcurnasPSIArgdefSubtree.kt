package com.deflatedpickle.intellij.concurnas.psi.subtree

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType

class ConcurnasPSIArgdefSubtree(node: ASTNode, idElementType: IElementType)
    : ConcurnasPSIVardefSubtree(node, idElementType)