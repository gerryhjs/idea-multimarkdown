/*
 * Copyright (c) 2015-2015 Vladimir Schneider <vladimir.schneider@gmail.com>, all rights reserved.
 *
 * This code is private property of the copyright holder and cannot be used without
 * having obtained a license or prior written permission of the of the copyright holder.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package com.vladsch.idea.multimarkdown.util

import com.vladsch.idea.multimarkdown.TestUtils.*
import org.junit.Test

class TestLinkResolver_Compl_wiki_normal_file_WikiLinkRef_Completions {
    val projectResolver: LinkResolver.ProjectResolver = MarkdownTestData
    val containingFileRef = FileRef("/Users/vlad/src/MarkdownTest/MarkdownTest.wiki/normal-file.md")
    val resolver = GitHubLinkResolver(projectResolver, containingFileRef)

    /**
     * REMOTE or LOCAL URI
     */
    @Test
    fun test_LocalRemoteUri_With_png() {
        val linkRef = WikiLinkRef(containingFileRef, ".png", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.PREFER_LOCAL or LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiImageFiles.asLocalURI(), list.asFilePaths())
    }

    @Test
    fun test_LocalRemoteUri_With_kt() {
        val linkRef = WikiLinkRef(containingFileRef, ".kt", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.PREFER_LOCAL or LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiKotlinFiles.asLocalURI(), list.asFilePaths())
    }

    @Test
    fun test_LocalRemoteUri_With_md() {
        val linkRef = WikiLinkRef(containingFileRef, ".md", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.PREFER_LOCAL or LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownFiles.asLocalURI(), list.asFilePaths())
    }

    @Test
    fun test_LocalRemoteUri_NoExt() {
        val linkRef = WikiLinkRef(containingFileRef, "", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.PREFER_LOCAL or LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownFiles.asLocalURI(), list.asFilePaths())
    }

    /**
     * REMOTE URI
     */
    @Test
    fun test_RemoteUri_With_png() {
        val linkRef = WikiLinkRef(containingFileRef, ".png", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiImageRemoteFiles.asRemoteURI(), list.asFilePaths())
    }

    @Test
    fun test_RemoteUri_With_kt() {
        val linkRef = WikiLinkRef(containingFileRef, ".kt", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiKotlinFiles.asRemoteURI(), list.asFilePaths())
    }

    @Test
    fun test_RemoteUri_With_md() {
        val linkRef = WikiLinkRef(containingFileRef, ".md", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownRemoteFiles.asRemoteURI(), list.asFilePaths())
    }

    @Test
    fun test_RemoteUri_NoExt() {
        val linkRef = WikiLinkRef(containingFileRef, "", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownRemoteFiles.asRemoteURI(), list.asFilePaths())
    }

    /**
     * URI
     */
    @Test
    fun test_Uri_With_png() {
        val linkRef = WikiLinkRef(containingFileRef, ".png", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiImageFiles.asURI(), list.asFilePaths())
    }

    @Test
    fun test_Uri_With_kt() {
        val linkRef = WikiLinkRef(containingFileRef, ".kt", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiKotlinFiles.asURI(), list.asFilePaths())
    }

    @Test
    fun test_Uri_With_md() {
        val linkRef = WikiLinkRef(containingFileRef, ".md", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownFiles.asURI(), list.asFilePaths())
    }

    @Test
    fun test_Uri_NoExt() {
        val linkRef = WikiLinkRef(containingFileRef, "", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_URI or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownFiles.asURI(), list.asFilePaths())
    }

    /**
     * REMOTE
     *
     */

    @Test
    fun test_Remote_With_png() {
        val linkRef = WikiLinkRef(containingFileRef, ".png", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiImageRemoteFiles, list.asFilePaths())
    }

    @Test
    fun test_Remote_With_kt() {
        val linkRef = WikiLinkRef(containingFileRef, ".kt", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiKotlinFiles, list.asFilePaths())
    }

    @Test
    fun test_Remote_With_md() {
        val linkRef = WikiLinkRef(containingFileRef, ".md", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownRemoteFiles, list.asFilePaths())
    }

    @Test
    fun test_Remote_NoExt() {
        val linkRef = WikiLinkRef(containingFileRef, "", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.ONLY_REMOTE or LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownRemoteFiles, list.asFilePaths())
    }

    /**
     *
     * BASIC
     */
    @Test fun test_Basic_WithExt_png() {
        val linkRef = WikiLinkRef(containingFileRef, ".png", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiImageFiles, list.asFilePaths())
    }

    @Test fun test_Basic_WithExt_iml() {
        val linkRef = WikiLinkRef(containingFileRef, ".iml", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", EMPTY_LIST, list.asFilePaths())
    }

    @Test fun test_Basic_WithExt_kt() {
        val linkRef = WikiLinkRef(containingFileRef, ".kt", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiKotlinFiles, list.asFilePaths())
    }

    @Test fun test_Basic_WithExt_md() {
        val linkRef = WikiLinkRef(containingFileRef, ".md", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownFiles, list.asFilePaths())
    }

    @Test fun test_Basic_NoExt() {
        val linkRef = WikiLinkRef(containingFileRef, "", null, null)
        val list = resolver.multiResolve(linkRef, LinkResolver.LOOSE_MATCH)
        val matchText = resolver.getLastMatcher()?.linkLooseMatch

        compareOrderedLists("$matchText does not match\n", wikiMarkdownFiles, list.asFilePaths())
    }

}

