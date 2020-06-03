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

        val NAME = createTextAttributesKey(
                "CONCURNAS_ID", DefaultLanguageHighlighterColors.IDENTIFIER
        )

        val KEYWORD = createTextAttributesKey(
                "CONCURNAS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
        )

        val STRING = createTextAttributesKey(
                "CONCURNAS_STRING", DefaultLanguageHighlighterColors.STRING
        )

        val NUMBER = createTextAttributesKey(
                "CONCURNAS_NUMBER", DefaultLanguageHighlighterColors.NUMBER
        )

        val LINE_COMMENT = createTextAttributesKey(
                "CONCURNAS_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT
        )

        val BLOCK_COMMENT = createTextAttributesKey(
                "CONCURNAS_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )

        val SEMI_COLON = createTextAttributesKey(
                "CONCURNAS_SEMI_COLON", DefaultLanguageHighlighterColors.SEMICOLON
        )

        val DOT = createTextAttributesKey(
                "CONCURNAS_DOT", DefaultLanguageHighlighterColors.DOT
        )

        val ESCAPE = createTextAttributesKey(
                "CONCURNAS_ESCAPE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE
        )

        val PARENTHESES = createTextAttributesKey(
                "CONCURNAS_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES
        )

        val OPERATION = createTextAttributesKey(
                "CONCURNAS_OPERATION", DefaultLanguageHighlighterColors.OPERATION_SIGN
        )

        // Sets of symbols

        val PREDEFINED = createTextAttributesKey(
                "CONCURNAS_PREDEFINED", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL
        )

        val BRACES = createTextAttributesKey(
                "CONCURNAS_BRACE", DefaultLanguageHighlighterColors.BRACES
        )

        val BRACKETS = createTextAttributesKey(
                "CONCURNAS_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS
        )

        // Parser

        val PARAMETER = createTextAttributesKey(
                "CONCURNAS_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER
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
            ConcurnasLexer.DOT, ConcurnasLexer.QUESTION_DOT, ConcurnasLexer.ESCAPE_DOT,
            ConcurnasLexer.DUEL_DOT, ConcurnasLexer.TRIPLE_DOT -> DOT

            ConcurnasLexer.QUESTION, ConcurnasLexer.EXCLAMATION -> PREDEFINED

            ConcurnasLexer.EQUALS,
            ConcurnasLexer.PLUS, ConcurnasLexer.PLUS_EQUALS,
            ConcurnasLexer.MINUS, ConcurnasLexer.MINUS_EQUALS,
            ConcurnasLexer.MULTIPLY, ConcurnasLexer.MULTIPLY_EQUALS,
            ConcurnasLexer.DIVIDE, ConcurnasLexer.DIVIDE_EQUALS,
            ConcurnasLexer.DUEL_EQUALS,
            ConcurnasLexer.DUEL_LESS_THAN, ConcurnasLexer.DUEL_LESS_THAN_EQUALS,
            ConcurnasLexer.DUEL_MORE_THAN, ConcurnasLexer.DUEL_MORE_THAN_EQUALS,
            ConcurnasLexer.DUEL_PLUS, ConcurnasLexer.DUEL_MINUS,
            ConcurnasLexer.DUEL_MULTIPLY, ConcurnasLexer.DUEL_MULTIPLY_EQUALS,
            ConcurnasLexer.TRIPLE_MORE_THAN, ConcurnasLexer.TRIPLE_MORE_THAN_EQUALS,
            ConcurnasLexer.MOD_N_EQUALS,
            ConcurnasLexer.OR_N_EQUALS,
            ConcurnasLexer.AND_N_EQUALS,
            ConcurnasLexer.COMP_N,
            ConcurnasLexer.BAND_N, ConcurnasLexer.BAND_N_EQUALS,
            ConcurnasLexer.BOR_N, ConcurnasLexer.BOR_N_EQUALS,
            ConcurnasLexer.BXOR_N, ConcurnasLexer.BXOR_N_EQUALS -> OPERATION

            ConcurnasLexer.LEFT_BRACE, ConcurnasLexer.RIGHT_BRACE -> BRACES
            ConcurnasLexer.LEFT_PARENTHESES, ConcurnasLexer.RIGHT_PARENTHESES -> PARENTHESES
            ConcurnasLexer.LEFT_BRACKET, ConcurnasLexer.LEFT_BRACKET_ALT, ConcurnasLexer.RIGHT_BRACKET -> BRACKETS

            ConcurnasLexer.VAL, ConcurnasLexer.VAR,
            ConcurnasLexer.PRIVATE, ConcurnasLexer.PUBLIC, ConcurnasLexer.PROTECTED,
            ConcurnasLexer.ABSTRACT_N, ConcurnasLexer.ACTOR_N, ConcurnasLexer.ALSO_N,
            ConcurnasLexer.ANNOTATION_N, ConcurnasLexer.ASSERT_N, ConcurnasLexer.ASYNC_N,
            ConcurnasLexer.AWAIT_N, ConcurnasLexer.AND_N, ConcurnasLexer.AS_N,
            ConcurnasLexer.BOOL_N, ConcurnasLexer.BOOLEAN_N, ConcurnasLexer.BREAK_N, ConcurnasLexer.BYTE_N,
            ConcurnasLexer.CASE_N, ConcurnasLexer.CATCH_N, ConcurnasLexer.CHANGED_N,
            ConcurnasLexer.CHAR_N, ConcurnasLexer.CLASS_N, ConcurnasLexer.CLOSED_N,
            ConcurnasLexer.CONSTANT_N, ConcurnasLexer.CONTINUE_N,
            ConcurnasLexer.DEF_N, ConcurnasLexer.DEFAULT_N, ConcurnasLexer.DEL_N, ConcurnasLexer.DOUBLE_N,
            ConcurnasLexer.ELIF_N, ConcurnasLexer.ELSE_N,
            ConcurnasLexer.ENUM_N, ConcurnasLexer.EVERY_N, ConcurnasLexer.EXTENDS_N,
            ConcurnasLexer.FALSE_N, ConcurnasLexer.FINALLY_N, ConcurnasLexer.FLOAT_N,
            ConcurnasLexer.FOR_N, ConcurnasLexer.FROM_N,
            ConcurnasLexer.GLOBAL_N, ConcurnasLexer.GPUDEF_N, ConcurnasLexer.GPUKERNEL_N,
            ConcurnasLexer.IF_N, ConcurnasLexer. IMPORT_N, ConcurnasLexer.IN_N, ConcurnasLexer.INJECT,
            ConcurnasLexer.INT_N, ConcurnasLexer.IS_N, ConcurnasLexer.ISNOT_N, ConcurnasLexer.LAMBDA_N,
            ConcurnasLexer.LOCAL_N, ConcurnasLexer.LONG_N, ConcurnasLexer.LOOP_N, ConcurnasLexer.LAZY_N,
            ConcurnasLexer.MATCH_N, ConcurnasLexer.MOD_N,
            ConcurnasLexer.NEW_N, ConcurnasLexer.NODEFAULT_N, ConcurnasLexer.NULL_N, ConcurnasLexer.NOT_N,
            ConcurnasLexer.OF_N, ConcurnasLexer.ONCHANGE_N, ConcurnasLexer.OPEN_N,
            ConcurnasLexer.OUT_N, ConcurnasLexer.OVERRIDE_N, ConcurnasLexer.OR_N,
            ConcurnasLexer.PACKAGE, ConcurnasLexer.PARFOR_N, ConcurnasLexer.PARFORSYNC_N,
            ConcurnasLexer.POST_N, ConcurnasLexer.PRE_N, ConcurnasLexer.PROVIDE_N, ConcurnasLexer.PROVIDER_N,
            ConcurnasLexer.RETURN_N,
            ConcurnasLexer.SHARED_N, ConcurnasLexer.SHORT_N, ConcurnasLexer.SINGLE_N, ConcurnasLexer.SIZE_T_N,
            ConcurnasLexer.SIZEOF_N, ConcurnasLexer.SUPER_N, ConcurnasLexer.SYNC_N,
            ConcurnasLexer.THIS_N, ConcurnasLexer.THROW_N, ConcurnasLexer.TO_N, ConcurnasLexer.TRAIT_N,
            ConcurnasLexer.TRANS_N, ConcurnasLexer.TRANSIENT_N, ConcurnasLexer.TRUE_N,
            ConcurnasLexer.TRY_N, ConcurnasLexer.TYPEDEF_N,
            ConcurnasLexer.UNCHECKED_N, ConcurnasLexer.USING_N,
            ConcurnasLexer.VOID_N,
            ConcurnasLexer.WHILE_N, ConcurnasLexer.WITH_N -> KEYWORD

            ConcurnasLexer.SEMI_COLON -> SEMI_COLON

            ConcurnasLexer.STRING_ITMcit, ConcurnasLexer.STRING_ITMquot, ConcurnasLexer.REGEX_STRING_ITM -> STRING

            ConcurnasLexer.INT, ConcurnasLexer.DOUBLE, ConcurnasLexer.FLOAT, ConcurnasLexer.LONGINT -> NUMBER

            ConcurnasLexer.LINE_COMMENT -> LINE_COMMENT
            ConcurnasLexer.MULTILINE_COMMENT -> BLOCK_COMMENT

            ConcurnasLexer.NAME -> NAME

            else -> return EMPTY_KEYS
        })
    }
}