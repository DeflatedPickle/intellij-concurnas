package com.deflatedpickle.intellij.concurnas.file

import com.deflatedpickle.intellij.concurnas.ConcurnasIcons
import com.deflatedpickle.intellij.concurnas.ConcurnasLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object ConcurnasFileType : LanguageFileType(ConcurnasLanguage) {
    override fun getName(): String = "Concurnas"
    override fun getDescription(): String = "Concurnas language"
    override fun getDefaultExtension(): String = "conc"
    override fun getIcon(): Icon? = ConcurnasIcons.CONCURNAS
}