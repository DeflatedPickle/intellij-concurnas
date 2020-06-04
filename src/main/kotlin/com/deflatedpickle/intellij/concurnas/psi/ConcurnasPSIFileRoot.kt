package com.deflatedpickle.intellij.concurnas.psi

import com.deflatedpickle.intellij.concurnas.ConcurnasIcons
import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.deflatedpickle.intellij.concurnas.file.ConcurnasFileType
import com.deflatedpickle.intellij.concurnas.psi.node.ConcurnasPSICallSubtree
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ScopeNode
import javax.swing.Icon

class ConcurnasPSIFileRoot(viewProvider: FileViewProvider) : PsiFileBase(
        viewProvider, ConcurnasLanguage
), ScopeNode {
    override fun getFileType(): FileType = ConcurnasFileType
    override fun getIcon(flags: Int): Icon? = ConcurnasIcons.CONCURNAS

    override fun getContext(): ScopeNode? = null

    override fun resolve(element: PsiNamedElement): PsiElement? {
        return if (element.parent is ConcurnasPSICallSubtree) {
            SymtabUtils.resolve(
                    this, ConcurnasLanguage,
                    element, "/script/function/ID"
            )
        } else {
            SymtabUtils.resolve(
                    this, ConcurnasLanguage,
                    element, "/script/vardef/ID"
            )
        }
    }

    override fun toString(): String = "Concurnas Language"
}