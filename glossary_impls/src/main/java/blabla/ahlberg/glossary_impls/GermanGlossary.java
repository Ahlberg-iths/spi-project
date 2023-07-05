package blabla.ahlberg.glossary_impls;

import blabla.ahlberg.glossary.Glossary;
import blabla.ahlberg.glossary.Language;

@Language("German")
public class GermanGlossary implements Glossary {

    @Override
    public String getGlossary() {
        return """
            Hello = Hallo
            Yes = Ja
            No = Nein
        """;
    }
}
