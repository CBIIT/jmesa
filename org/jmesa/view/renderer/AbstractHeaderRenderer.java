/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.view.renderer;

import org.jmesa.view.AbstractContextSupport;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.ColumnSupport;
import org.jmesa.view.editor.HeaderEditor;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public abstract class AbstractHeaderRenderer extends AbstractContextSupport implements HeaderRenderer, ColumnSupport {
    private Column column;

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    /**
     * @deprecated Should get/set the value on the Column.
     */
    @Deprecated
    public HeaderEditor getHeaderEditor() {
        return getColumn().getHeaderEditor();
    }

    /**
     * @deprecated Should get/set the value on the Column.
     */
    @Deprecated
    public void setHeaderEditor(HeaderEditor headerEditor) {
        getColumn().setHeaderEditor(headerEditor);
    }
}
