/* Copyright (c) 2014 Brian Downs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.bdowns328.felix;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SettingsProcessor {

    private String configFile;

    /**
     * Constructor
     * @param settings Settings
     */
    public SettingsProcessor(Settings settings) {
        String configFile = settings.getLogFile();
    }

    /**
     * Process provided file into a properties object.
     * @return prop, Properties
     */
    private Properties processConfig() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(configFile);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return (prop);
    }
}
