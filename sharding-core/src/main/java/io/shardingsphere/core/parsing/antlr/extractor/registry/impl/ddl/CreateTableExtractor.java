/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.antlr.extractor.registry.impl.ddl;

import io.shardingsphere.core.parsing.antlr.extractor.SQLSegmentExtractor;
import io.shardingsphere.core.parsing.antlr.extractor.SQLStatementExtractor;
import io.shardingsphere.core.parsing.antlr.extractor.impl.ColumnDefinitionsExtractor;
import io.shardingsphere.core.parsing.antlr.extractor.impl.IndexNamesExtractor;
import io.shardingsphere.core.parsing.antlr.extractor.impl.OutlinePrimaryKeyExtractor;
import io.shardingsphere.core.parsing.antlr.extractor.impl.TableNamesExtractor;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Create table extractor.
 * 
 * @author duhongjun
 * @author zhangliang
 */
public final class CreateTableExtractor implements SQLStatementExtractor {
    
    private static final Collection<SQLSegmentExtractor> EXTRACTORS = new LinkedList<>();
    
    static {
        EXTRACTORS.add(new TableNamesExtractor());
        EXTRACTORS.add(new ColumnDefinitionsExtractor());
        EXTRACTORS.add(new IndexNamesExtractor());
        EXTRACTORS.add(new OutlinePrimaryKeyExtractor());
    }
    
    @Override
    public Collection<SQLSegmentExtractor> getExtractors() {
        return EXTRACTORS;
    }
}
