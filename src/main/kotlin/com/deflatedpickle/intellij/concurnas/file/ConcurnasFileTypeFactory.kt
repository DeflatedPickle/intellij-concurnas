package com.deflatedpickle.intellij.concurnas.file

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

class ConcurnasFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer): Unit =
            consumer.consume(ConcurnasFileType, ConcurnasFileType.defaultExtension)
}