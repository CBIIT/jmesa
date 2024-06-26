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
package org.jmesa.view;

import org.jmesa.view.component.Table;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public interface View {
    public Table getTable();

    public void setTable(Table table);

    /**
     * Great tool for debugging views by being able to look at the byte array.
     * 
     * @return The byte array that represents this view.
     * 
     * @deprecated This method has not turned out to be very useful and will be returned in a future release.
     */
    @Deprecated
    public byte[] getBytes();

    public Object render();
}
