package org.sonar.custom.php;

import org.junit.Test;
import org.sonar.api.server.rule.RulesDefinition;

import static org.junit.Assert.assertEquals;

public class CustomRulesTest {

    @Test
    public void rules() {
        CustomRules rulesDefinition = new CustomRules();
        RulesDefinition.Context context = new RulesDefinition.Context();
        rulesDefinition.define(context);
        RulesDefinition.Repository repository = context.repository("custom");
        assertEquals(1, repository.rules().size());
    }
}