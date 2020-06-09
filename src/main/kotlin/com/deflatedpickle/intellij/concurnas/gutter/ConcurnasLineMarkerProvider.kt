package com.deflatedpickle.intellij.concurnas.gutter

import com.deflatedpickle.intellij.concurnas.psi.subtree.ConcurnasPSIClassSubtree
import com.deflatedpickle.intellij.concurnas.psi.subtree.ConcurnasPSIFunctionSubtree
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement

class ConcurnasLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? =
            when (element) {
                // is ConcurnasPSIFileRoot ->
                //     LineMarkerInfo(
                //             element,
                //             element.textRange,
                //             AllIcons.Actions.Execute,
                //             { "" },
                //             { mouseEvent: MouseEvent,
                //               concurnasPSIFileRoot: ConcurnasPSIFileRoot ->
                //             },
                //             GutterIconRenderer.Alignment.RIGHT
                //     )
                is ConcurnasPSIClassSubtree ->
                    LineMarkerInfo(
                            element,
                            element.textRange,
                            AllIcons.Nodes.Class,
                            { "" },
                            null,
                            GutterIconRenderer.Alignment.RIGHT
                    )
                is ConcurnasPSIFunctionSubtree ->
                    LineMarkerInfo(
                            element,
                            element.parent.textRange,
                            AllIcons.Nodes.Function,
                            { "" },
                            null,
                            GutterIconRenderer.Alignment.RIGHT
                    )
                else -> null
            }
}