package aurora.rec.ruleengine;

import org.drools.core.rule.consequence.KnowledgeHelper;

/**
 * Utils class for the RuleEngine.
 * @author Javier
 */
public class RuleUtils {
   //private static int contador = 0;
   public static void helper(final KnowledgeHelper drools){
      System.out.println("Rule triggered: " + drools.getRule().getName());
      //"Household ID: " + contador + ", 
      //contador++;
   }    
    
}
