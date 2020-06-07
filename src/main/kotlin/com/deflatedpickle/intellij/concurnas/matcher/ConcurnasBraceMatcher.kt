package com.deflatedpickle.intellij.concurnas.matcher

import com.concurnas.compiler.ConcurnasLexer
import com.concurnas.compiler.ConcurnasParser
import com.deflatedpickle.intellij.concurnas.ConcurnasTokenTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class ConcurnasBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = arrayOf(
            // Parenthesis
            BracePair(
                    ConcurnasTokenTypes.getTokenElementType(ConcurnasLexer.LPARA),
                    ConcurnasTokenTypes.getTokenElementType(ConcurnasLexer.RPARA),
                    false
            ),
            // Square brackets
            BracePair(
                    ConcurnasTokenTypes.getTokenElementType(ConcurnasLexer.LBRACK),
                    ConcurnasTokenTypes.getTokenElementType(ConcurnasLexer.RBRACK),
                    false
            ),
            // Curly braces
            BracePair(
                    ConcurnasTokenTypes.getTokenElementType(ConcurnasLexer.LBRACE),
                    ConcurnasTokenTypes.getTokenElementType(ConcurnasLexer.RBRACE),
                    true
            )
    )

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true
    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}