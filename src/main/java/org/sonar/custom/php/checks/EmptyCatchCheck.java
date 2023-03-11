package org.sonar.custom.php.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.php.api.tree.lexical.SyntaxToken;
import org.sonar.plugins.php.api.tree.statement.CatchBlockTree;
import org.sonar.plugins.php.api.visitors.PHPVisitorCheck;

/**
 * Example of implementation of a check by extending {@link PHPVisitorCheck}.
 * PHPVisitorCheck provides methods to visit nodes of the Abstract Syntax Tree
 * that represents the source code.
 * <p>
 * Those methods can be overridden to process information
 * related to node and issue can be created via the context that can be
 * accessed through {@link PHPVisitorCheck#context()}.
 */
@Rule(
        key = EmptyCatchCheck.KEY,
        name = "Empty CATCH statement must have a comment to explain why the exception is not handled"
)
public class EmptyCatchCheck extends PHPVisitorCheck {

    public static final String KEY = "AC015";
    public static final String MESSAGE = "Empty CATCH statement must have a comment to explain why the exception is not handled";

    /**
     * Overriding method visit-catch statement
     * Checks for empty catch clause without a comment.
     */
    @Override
    public void visitCatchBlock(CatchBlockTree tree) {
        final String EmptyStatement = tree.toString();
        if (hasEmptyBody(tree)) {
            context().newIssue(this, tree, String.format(MESSAGE, EmptyStatement));
        }
        // super method must be called in order to visit function call node's children
        super.visitCatchBlock(tree);
    }

    private static boolean hasEmptyBody(CatchBlockTree tree) {
        SyntaxToken lastToken = tree.block().closeCurlyBraceToken();
        if (tree.block().statements().isEmpty()
                && tree.block().statements().size() == 0
                && lastToken.trivias().isEmpty()
        ) {
            return true;
        }
        return false;
    }
}