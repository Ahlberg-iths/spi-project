module glossary_impls {
    requires glossary;
    exports blabla.ahlberg.glossary_impls;
    provides blabla.ahlberg.glossary.Glossary with blabla.ahlberg.glossary_impls.SpanishGlossary, blabla.ahlberg.glossary_impls.SwedishGlossary, blabla.ahlberg.glossary_impls.PortugueseGlossary, blabla.ahlberg.glossary_impls.GermanGlossary;
}
