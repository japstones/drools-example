package pe.japstones.drools;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.List;

/**
 * Created by Joel on 06/04/2017.
 */
public class Regalo {

    public void aplicarRegla(List<Compra> compra){
        final KnowledgeBase kbase = readKnowledgeBase();
        final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        compra.stream().forEach(ksession::insert);
        ksession.fireAllRules();
        compra.stream().filter(c -> c.getRegalo()!=null).forEach(System.out::println);
    }

    private KnowledgeBase readKnowledgeBase() {
        final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("reglas.drl"), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            for (KnowledgeBuilderError error : kbuilder.getErrors()) {
                System.err.println(error);
            }
                throw new IllegalArgumentException("Imposible crear knowledge con reglas.drl");
        }
        final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
}
