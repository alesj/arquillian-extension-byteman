/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.extension.byteman.impl.common;

import java.util.Arrays;

import org.jboss.byteman.agent.submit.ScriptText;
import org.jboss.byteman.agent.submit.Submit;

/**
 * SumitUtil
 *
 * @author <a href="mailto:aslak@redhat.com">Aslak Knutsen</a>
 * @version $Revision: $
 */
public class SubmitUtil {
    public static void install(String key, String script, int port) {
        try {
            Submit submit = new Submit(Submit.DEFAULT_ADDRESS, port);
            submit.addScripts(Arrays.asList(new ScriptText(key, script)));
        } catch (Exception e) {
            throw new SubmitException("Could not uninstall script from file", e);
        }
    }

    public static void uninstall(String key, String script, int port) {
        try {
            Submit submit = new Submit(Submit.DEFAULT_ADDRESS, port);
            submit.deleteScripts(Arrays.asList(new ScriptText(key, script)));
        } catch (Exception e) {
            throw new SubmitException("Could not uninstall script from file", e);
        }
    }
}
