package org.sonar.custom.php;

import org.sonar.api.Plugin;

/**
 * Extension point to define a Sonar Plugin.
 */
public class CustomRulesPlugin implements Plugin {

    @Override
    public void define(Context context) {
        context.addExtension(CustomRules.class);
    }
}