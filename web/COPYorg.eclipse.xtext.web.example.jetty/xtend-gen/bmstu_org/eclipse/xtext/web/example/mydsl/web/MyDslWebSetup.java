/**
 * generated by Xtext 2.10.0
 */
package bmstu_org.eclipse.xtext.web.example.mydsl.web;

import bmstu_org.eclipse.xtext.web.example.mydsl.MyDslRuntimeModule;
import bmstu_org.eclipse.xtext.web.example.mydsl.MyDslStandaloneSetup;
import bmstu_org.eclipse.xtext.web.example.mydsl.web.MyDslWebModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.util.Modules;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class MyDslWebSetup extends MyDslStandaloneSetup {
  private final Provider<ExecutorService> executorServiceProvider;
  
  @Override
  public Injector createInjector() {
    final MyDslRuntimeModule runtimeModule = new MyDslRuntimeModule();
    final MyDslWebModule webModule = new MyDslWebModule(this.executorServiceProvider);
    Modules.OverriddenModuleBuilder _override = Modules.override(runtimeModule);
    Module _with = _override.with(webModule);
    return Guice.createInjector(_with);
  }
  
  public MyDslWebSetup(final Provider<ExecutorService> executorServiceProvider) {
    super();
    this.executorServiceProvider = executorServiceProvider;
  }
}
