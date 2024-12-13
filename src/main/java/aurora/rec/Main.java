package aurora.rec;

//import aurora.rec.model.House;
//import aurora.rec.model.Person;
import aurora.rec.model.Hogar;

import aurora.rec.ruleengine.Engine;
import org.drools.core.rule.consequence.KnowledgeHelper;

/**
 * This is a demo for the rule-based system
 * @author Javier
 */
public class Main {
    
    public static void main(String args[])
    {
        System.out.println("This is the demo recommender system for the AURORA system");
        demo();
        
    }
    
    public static void demo()
    {
        //House casa = new House(1, "standard");
        //Person ana = new Person("Ana", "coal", 20199);
        Engine e = new Engine();
        //e.run(ana);
        //System.out.println(ana.getMessage());
        
    }
    
   public static void helper(final KnowledgeHelper drools){
      System.out.println("Rule triggered: " + drools.getRule().getName());
   }    
    
}
