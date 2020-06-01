package com.deflatedpickle.intellij.concurnas.syntax.highlight

import com.concurnas.compiler.ConcurnasLexer
import com.concurnas.compiler.ConcurnasParser
import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ConcurnasSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val EMPTY_KEYS = emptyArray<TextAttributesKey>()

        val NAME: TextAttributesKey = createTextAttributesKey(
                "CONCURNAS_ID", DefaultLanguageHighlighterColors.IDENTIFIER
        )
        val KEYWORD: TextAttributesKey = createTextAttributesKey(
                "CONCURNAS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
        )
        val STRING: TextAttributesKey = createTextAttributesKey(
                "CONCURNAS_STRING", DefaultLanguageHighlighterColors.STRING
        )
        val NUMBER: TextAttributesKey = createTextAttributesKey(
                "CONCURNAS_NUMBER", DefaultLanguageHighlighterColors.NUMBER
        )
        val LINE_COMMENT: TextAttributesKey = createTextAttributesKey(
                "CONCURNAS_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        val BLOCK_COMMENT: TextAttributesKey = createTextAttributesKey(
                "CONCURNAS_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                    ConcurnasLanguage,
                    ConcurnasParser.tokenNames, ConcurnasParser.ruleNames
            )
        }
    }

    override fun getHighlightingLexer(): Lexer =
            ANTLRLexerAdaptor(ConcurnasLanguage, ConcurnasLexer(null))

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        if (tokenType !is TokenIElementType) return EMPTY_KEYS

        return arrayOf(when (tokenType.antlrTokenType) {
            ConcurnasLexer.NAME -> NAME
            ConcurnasLexer.VAL, ConcurnasLexer.VAR, ConcurnasLexer.PRIVATE, ConcurnasLexer.PUBLIC, ConcurnasLexer.INJECT, ConcurnasLexer.PROTECTED, ConcurnasLexer.PACKAGE -> KEYWORD
            ConcurnasLexer.STRING_ITMcit, ConcurnasLexer.STRING_ITMquot, ConcurnasLexer.REGEX_STRING_ITM -> STRING
            ConcurnasLexer.INT, ConcurnasLexer.DOUBLE, ConcurnasLexer.FLOAT -> NUMBER
            ConcurnasLexer.LINE_COMMENT -> LINE_COMMENT
            ConcurnasLexer.MULTILINE_COMMENT -> BLOCK_COMMENT
            else -> return EMPTY_KEYS
        })
    }
}