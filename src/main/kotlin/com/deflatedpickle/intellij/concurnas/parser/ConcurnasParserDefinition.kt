package com.deflatedpickle.intellij.concurnas.parser

import com.concurnas.compiler.ConcurnasLexer
import com.concurnas.compiler.ConcurnasParser
import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.deflatedpickle.intellij.concurnas.psi.ConcurnasPSIFileRoot
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class ConcurnasParserDefinition : ParserDefinition {
    companion object {
        val FILE = IFileElementType(ConcurnasLanguage)

        val NAME: TokenIElementType

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                    ConcurnasLanguage,
                    ConcurnasParser.tokenNames, ConcurnasParser.ruleNames
            )

            val tokenIElementTypes = PSIElementTypeFactory.getTokenIElementTypes(
                    ConcurnasLanguage
            )
            NAME = tokenIElementTypes[ConcurnasLexer.NAME]
        }

        val COMMENTS: TokenSet = createTokenSet(
                ConcurnasLanguage,
                ConcurnasLexer.LINE_COMMENT,
                ConcurnasLexer.MULTILINE_COMMENT
        )

        val WHITESPACE: TokenSet = createTokenSet(
                ConcurnasLanguage,
                ConcurnasLexer.WS,
                ConcurnasLexer.WS2
        )

        val STRING: TokenSet = createTokenSet(
                ConcurnasLanguage,
                ConcurnasLexer.STRING_ITMquot,
                ConcurnasLexer.STRING_ITMcit,
                ConcurnasLexer.REGEX_STRING_ITM
        )
    }

    override fun createLexer(project: Project?): Lexer = ANTLRLexerAdaptor(
            ConcurnasLanguage, ConcurnasLexer(null)
    )

    override fun createParser(project: Project?): PsiParser =
            object : ANTLRParserAdaptor(
                    ConcurnasLanguage,
                    ConcurnasParser(null)
            ) {
                override fun parse(
                        parser: Parser?,
                        root: IElementType?
                ): ParseTree {
                    val newParse = parser as ConcurnasParser
                    return if (root is IFileElementType) {
                        newParse.code()
                    } else {
                        newParse.line()
                    }
                }
            }

    override fun getWhitespaceTokens(): TokenSet = WHITESPACE
    override fun getCommentTokens(): TokenSet = COMMENTS
    override fun getStringLiteralElements(): TokenSet = STRING
    override fun getFileNodeType(): IFileElementType = FILE

    override fun spaceExistenceTypeBetweenTokens(
            left: ASTNode?, right: ASTNode?
    ): ParserDefinition.SpaceRequirements = ParserDefinition.SpaceRequirements.MAY

    override fun createFile(viewProvider: FileViewProvider): PsiFile =
            ConcurnasPSIFileRoot(viewProvider)

    override fun createElement(node: ASTNode): PsiElement {
        return if (node.elementType is TokenIElementType ||
                node.elementType !is RuleIElementType) {
            ANTLRPsiNode(node)
        } else {
            when ((node.elementType as RuleIElementType).ruleIndex) {
                else -> ANTLRPsiNode(node)
            }
        }
    }
}