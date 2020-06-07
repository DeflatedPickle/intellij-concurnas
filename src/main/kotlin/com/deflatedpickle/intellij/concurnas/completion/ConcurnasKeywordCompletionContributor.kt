package com.deflatedpickle.intellij.concurnas.completion

import com.concurnas.compiler.ConcurnasParser
import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.deflatedpickle.intellij.concurnas.ConcurnasTokenTypes
import com.deflatedpickle.intellij.concurnas.psi.ConcurnasPSIFileRoot
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

class ConcurnasKeywordCompletionContributor : CompletionContributor() {
    init {
        // General keywords
        extend(
                CompletionType.BASIC,
                PlatformPatterns
                        // It won't let me use a specific element like ConcurnasParser#RULE_code
                        .psiElement()
                        .withLanguage(ConcurnasLanguage),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(
                            parameters: CompletionParameters,
                            context: ProcessingContext,
                            result: CompletionResultSet
                    ) {
                        result.addAllElements(
                                listOf(
                                        LookupElementBuilder.create("class"),
                                        LookupElementBuilder.create("def")
                                )
                        )
                    }
                }
        )
    }
}