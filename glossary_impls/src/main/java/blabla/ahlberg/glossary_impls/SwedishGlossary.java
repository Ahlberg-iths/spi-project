package blabla.ahlberg.glossary_impls;

import blabla.ahlberg.glossary.Glossary;
import blabla.ahlberg.glossary.Language;

@Language("Swedish")
public class SwedishGlossary implements Glossary {

    @Override
    public String getGlossary() {
        return """
            Hello = Hej
            Yes = Ja
            No = Nej
        """;
    }
}
