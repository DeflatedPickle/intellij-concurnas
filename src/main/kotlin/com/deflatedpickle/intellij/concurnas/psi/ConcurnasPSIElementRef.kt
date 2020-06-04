package com.deflatedpickle.intellij.concurnas.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReferenceBase
import org.antlr.intellij.adaptor.psi.ScopeNode


abstract class ConcurnasPSIElementRef(element: ConcurnasIdentifierPSINode) : PsiReferenceBase<ConcurnasIdentifierPSINode?>(element, TextRange(0, element.text.length)) {
    override fun getVariants(): Array<Any?> = arrayOfNulls(0)

    override fun handleElementRename(newElementName: String): PsiElement? {
        return myElement?.setName(newElementName)
    }

    override fun resolve(): PsiElement? = (myElement?.context as ScopeNode).resolve(myElement)


    override fun isReferenceTo(def: PsiElement): Boolean {
        var mutDef = def
        val refName: String? = myElement?.name
        
        if (def is ConcurnasIdentifierPSINode && isDefSubtree(def.parent)) {
            mutDef = def.parent
        }
        if (isDefSubtree(def)) {
            val id = (mutDef as PsiNameIdentifierOwner).nameIdentifier
            val defName = id?.text
            return refName != null && defName != null && refName == defName
        }
        return false
    }

    abstract fun isDefSubtree(def: PsiElement?): Boolean
}