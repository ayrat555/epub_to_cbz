package com.ayrat555.epub_to_cbz.comicbook

import com.ayrat555.epub_to_cbz.comicbook.Factory
import com.ayrat555.epub_to_cbz.TestSupport
import com.ayrat555.epub_to_cbz.opf.OpfFetcher
import com.ayrat555.epub_to_cbz.opf.OpfParser
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class BuilderSpec: Spek({
    describe("create"){
        val comicbookFilePath = TestSupport.getFile("files/example.epub")
        val opfStream = OpfFetcher(comicbookFilePath).fetchStream()
        val opf = OpfParser(opfStream).parse()

        it("builds comicbook") {
            val comicbook = Factory(opf).create()

            assertEquals(9, comicbook.images.size)
        }
    }
})
