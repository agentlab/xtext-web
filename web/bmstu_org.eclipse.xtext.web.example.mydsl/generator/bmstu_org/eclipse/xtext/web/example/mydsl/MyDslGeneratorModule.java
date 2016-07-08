package bmstu_org.eclipse.xtext.web.example.mydsl;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;

public class MyDslGeneratorModule extends DefaultGeneratorModule {

	public Class<? extends XtextGeneratorNaming> bindNaming() {
		return MyDslGeneratorNaming.class;
	}

	public static class MyDslGeneratorNaming extends XtextGeneratorNaming {
		@Override
		public String getWebBasePackage(Grammar grammar) {
			if (grammar.getName().equals("org.eclipse.xtext.web.example.statemachine.Statemachine")) {
				return "org.eclipse.xtext.web.example.jetty";
			} else {
				return super.getWebBasePackage(grammar);
			}
		}
	}
}

