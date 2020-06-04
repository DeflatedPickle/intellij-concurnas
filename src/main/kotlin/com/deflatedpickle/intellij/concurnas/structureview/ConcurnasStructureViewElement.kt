package com.deflatedpickle.intellij.concurnas.structureview

import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.deflatedpickle.intellij.concurnas.psi.ConcurnasPSIFileRoot
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import org.antlr.intellij.adaptor.xpath.XPath
import java.util.*


class ConcurnasStructureViewElement(private val element: NavigatablePsiElement) : StructureViewTreeElement, SortableTreeElement {
    override fun getValue(): Any = this.element

    override fun navigate(requestFocus: Boolean) {
        this.element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean = this.element.canNavigate()
    override fun canNavigateToSource(): Boolean = this.element.canNavigateToSource()

    override fun getAlphaSortKey(): String = this.element.name ?: ""

    override fun getPresentation(): ItemPresentation = this.element.presentation ?: PresentationData()

    override fun getChildren(): Array<TreeElement?> {
        if (element is ConcurnasPSIFileRoot) {
            val funcs = XPath.findAll(ConcurnasLanguage, element, "/script/function/ID")
            val treeElements = mutableListOf<TreeElement>()
            for (el in funcs) {
                treeElements.add(ConcurnasStructureViewElement(el as NavigatablePsiElement))
            }

            return treeElements.toTypedArray()
        }
        return arrayOfNulls(0)
    }
}