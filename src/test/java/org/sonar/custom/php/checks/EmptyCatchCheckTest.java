package org.sonar.custom.php.checks;

import org.junit.Test;
import org.sonar.plugins.php.api.tests.PHPCheckTest;
import org.sonar.plugins.php.api.tests.PhpTestFile;

import java.io.File;

/**
 * Test class to test the check implementation.
 */
public class EmptyCatchCheckTest {
    @Test
    public void test() throws Exception {
        PHPCheckTest.check(new EmptyCatchCheck(), new PhpTestFile(new File("src/test/resources/checks/EmptyCatchCheck.php")));
    }
}