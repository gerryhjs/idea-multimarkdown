/*
 * Copyright (c) 2015-2015 Vladimir Schneider <vladimir.schneider@gmail.com>
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.vladsch.idea.multimarkdown.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestPathInfo.class,
        TestFileInfo.class,
        TestLinkRef.class,
        TestLinkMatcher_MultiSub.class,
        TestLinkResolver_Basic_wiki_Home.class,
        TestLinkResolver_Basic_wiki_normal_file.class,
        TestLinkResolver_Basic_Readme.class,
        TestLinkResolver_Compl_Readme_LinkRef.class,
        TestLinkResolver_Compl_Readme_WikiLinkRef.class,
        TestLinkResolver_Compl_Readme_ImageLinkRef.class,
        TestLinkResolver_Compl_wiki_Home_LinkRef.class,
        TestLinkResolver_Compl_wiki_Home_WikiLinkRef_Completions.class,
        TestLinkResolver_Compl_wiki_Home_ImageLinkRef_Completions.class,
        TestLinkResolver_Compl_wiki_normal_file_LinkRef.class,
        TestLinkResolver_Compl_wiki_normal_file_WikiLinkRef_Completions.class,
        TestLinkResolver_Compl_wiki_normal_file_ImageLinkRef_Completions.class
})
public class UtilTestSuite {
}
