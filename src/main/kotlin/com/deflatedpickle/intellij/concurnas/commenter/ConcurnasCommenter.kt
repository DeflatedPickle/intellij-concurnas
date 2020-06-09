package com.deflatedpickle.intellij.concurnas.commenter

import com.intellij.lang.Commenter

class ConcurnasCommenter : Commenter {
    override fun getCommentedBlockCommentPrefix(): String? = "/**"
    override fun getCommentedBlockCommentSuffix(): String? = "*/"

    override fun getBlockCommentPrefix(): String? = "/*"
    override fun getBlockCommentSuffix(): String? = "*/"

    override fun getLineCommentPrefix(): String? = "//"
}