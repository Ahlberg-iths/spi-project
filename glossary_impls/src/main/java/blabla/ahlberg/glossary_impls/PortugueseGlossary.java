package blabla.ahlberg.glossary_impls;

import blabla.ahlberg.glossary.Glossary;
import blabla.ahlberg.glossary.Language;

@Language("Portuguese")
public class PortugueseGlossary implements Glossary {

    @Override
    public String getGlossary() {
        return """
            Hello = Olá
            Yes = Sim
            No = Não
        """;
    }
}
