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
package org.jmesa.facade;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.jmesa.core.message.Messages;
import org.jmesa.core.message.MessagesFactory;
import org.jmesa.core.message.SpringMessages;
import org.jmesa.core.message.Struts2Messages;
import org.jmesa.web.HttpServletRequestSpringWebContext;
import org.jmesa.web.HttpServletRequestWebContext;
import org.jmesa.web.PortletRequestSpringWebContext;
import org.jmesa.web.PortletRequestWebContext;
import org.jmesa.web.SpringWebContext;
import org.jmesa.web.WebContext;
import org.springframework.context.i18n.LocaleContextHolder;
import com.opensymphony.xwork2.ActionContext;
import javax.servlet.http.HttpServletResponse;

/**
 * A factory to create TableFacade implementations.
 *
 * @since 2.2
 * @author Jeff Johnston
 *
 * @deprecated For internal use only. Use the new TableModel for building tables.
 */
@Deprecated
public class TableFacadeFactory {

    /**
     * @deprecated For internal use only. Use the new TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createTableFacade(String id, HttpServletRequest request) {
        TableFacade tableFacade = new TableFacadeImpl(id, request);
        return tableFacade;
    }

    /**
     * @deprecated For internal use only. Use the new TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createTableFacade(String id, HttpServletRequest request, HttpServletResponse response) {
        TableFacade tableFacade = new TableFacadeImpl(id, request, response);
        return tableFacade;
    }

    /**
     * @deprecated For internal use only. Use the new TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createTableFacade(String id, WebContext webContext) {
        TableFacade tableFacade = new TableFacadeImpl(id, null);
        tableFacade.setWebContext(webContext);
        return tableFacade;
    }

    /**
     * @deprecated For internal use only. Use the new TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createTableFacade(String id, WebContext webContext, HttpServletResponse response) {
        TableFacade tableFacade = new TableFacadeImpl(id, null, response);
        tableFacade.setWebContext(webContext);
        return tableFacade;
    }

    /**
     * @deprecated For internal use only. Use the new PortletTableModel for building tables.
     */
    @Deprecated
    public static TableFacade createPortletTableFacade(String id, PortletRequest request) {
        return createTableFacade(id, new PortletRequestWebContext(request));
    }

    /**
     * @deprecated For internal use only. Use the new SpringPortletTableModel for building tables.
     */
    @Deprecated
    public static TableFacade createSpringPortletTableFacade(String id, PortletRequest request) {
        SpringWebContext springWebContext = new PortletRequestSpringWebContext(request);
        return createSpringTableFacade(id, springWebContext);
    }

    /**
     * @deprecated For internal use only. Use the new SpringTableModel for building tables.
     */
    @Deprecated
    public static TableFacade createSpringTableFacade(String id, HttpServletRequest request) {
        SpringWebContext springWebContext = new HttpServletRequestSpringWebContext(request);
        return createSpringTableFacade(id, springWebContext);
    }

    /**
     * @deprecated For internal use only. Use the new SpringTableModel for building tables.
     */
    @Deprecated
    public static TableFacade createSpringTableFacade(String id, HttpServletRequest request, HttpServletResponse response) {
        SpringWebContext springWebContext = new HttpServletRequestSpringWebContext(request);
        return createSpringTableFacade(id, springWebContext, response);
    }

    /**
     * @deprecated For internal use only. Use the new SpringTableModel for building tables.
     */
    @Deprecated
    public static TableFacade createSpringTableFacade(String id, SpringWebContext springWebContext) {

        springWebContext.setLocale(LocaleContextHolder.getLocale());

        TableFacade tableFacade = createTableFacade(id, springWebContext);
        Messages messages = MessagesFactory.getMessages(springWebContext);
        SpringMessages springMessages = new SpringMessages(messages, springWebContext);
        tableFacade.setMessages(springMessages);
        return tableFacade;
    }

    /**
     * @deprecated For internal use only. Use the new SpringTableModel for building tables.
     */
    @Deprecated
    public static TableFacade createSpringTableFacade(String id, SpringWebContext springWebContext, HttpServletResponse response) {

        springWebContext.setLocale(LocaleContextHolder.getLocale());

        TableFacade tableFacade = createTableFacade(id, springWebContext, response);
        Messages messages = MessagesFactory.getMessages(springWebContext);
        SpringMessages springMessages = new SpringMessages(messages, springWebContext);
        tableFacade.setMessages(springMessages);
        return tableFacade;
    }

    /**
     * @deprecated For internal use only. Use the new Struts2TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createStruts2TableFacade(String id, HttpServletRequest request) {
        WebContext webContext = new HttpServletRequestWebContext(request);
        return createStruts2TableFacade(id, webContext);
    }

    /**
     * @deprecated For internal use only. Use the new Struts2TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createStruts2TableFacade(String id, HttpServletRequest request, HttpServletResponse response) {
        WebContext webContext = new HttpServletRequestWebContext(request);
        return createStruts2TableFacade(id, webContext, response);
    }

    /**
     * @deprecated For internal use only. Use the new Struts2TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createStruts2TableFacade(String id, WebContext webContext) {

        webContext.setLocale(ActionContext.getContext().getLocale());

        TableFacade tableFacade = createTableFacade(id, webContext);
        Messages messages = MessagesFactory.getMessages(webContext);
        Struts2Messages struts2Messages = new Struts2Messages(messages, webContext);
        tableFacade.setMessages(struts2Messages);
        return tableFacade;
    }

    /**
     * @deprecated For internal use only. Use the new Struts2TableModel for building tables.
     */
    @Deprecated
    public static TableFacade createStruts2TableFacade(String id, WebContext webContext, HttpServletResponse response) {

        webContext.setLocale(ActionContext.getContext().getLocale());

        TableFacade tableFacade = createTableFacade(id, webContext, response);
        Messages messages = MessagesFactory.getMessages(webContext);
        Struts2Messages struts2Messages = new Struts2Messages(messages, webContext);
        tableFacade.setMessages(struts2Messages);
        return tableFacade;
    }
}
