/*
 * generated by Xtext 2.10.0
 */
package bmstu_org.eclipse.xtext.web.example.mydsl.web

import bmstu_org.eclipse.xtext.web.example.mydsl.MyDslRuntimeModule
import bmstu_org.eclipse.xtext.web.example.mydsl.MyDslStandaloneSetup
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Provider
import com.google.inject.util.Modules
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
class MyDslWebSetup extends MyDslStandaloneSetup {
	
	val Provider<ExecutorService> executorServiceProvider;
	
	override Injector createInjector() {
		val runtimeModule = new MyDslRuntimeModule()
		val webModule = new MyDslWebModule(executorServiceProvider)
		return Guice.createInjector(Modules.override(runtimeModule).with(webModule))
	}
	
}
