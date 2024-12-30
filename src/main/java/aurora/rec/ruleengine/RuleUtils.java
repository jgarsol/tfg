package aurora.rec.ruleengine;

import org.drools.core.rule.consequence.KnowledgeHelper;

/**
 * Utils class for the RuleEngine.
 * @author victor
 */
public class RuleUtils {
   public static void helper(final KnowledgeHelper drools){
      System.out.println("Rule triggered: " + drools.getRule().getName());
   }    
    
}
