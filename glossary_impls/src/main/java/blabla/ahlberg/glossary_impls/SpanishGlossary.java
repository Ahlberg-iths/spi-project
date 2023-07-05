package blabla.ahlberg.glossary_impls;

import blabla.ahlberg.glossary.Glossary;
import blabla.ahlberg.glossary.Language;

@Language("Spanish")
public class SpanishGlossary implements Glossary {

    @Override
    public String getGlossary() {
        return """
            Hello = Hola
            Yes = Sí
            No = No
        """;
    }
}