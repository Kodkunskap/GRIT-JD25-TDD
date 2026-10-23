package se.apiva;

import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.extension.*;

import java.util.List;
import java.util.stream.Stream;

public class TestInvocationProvider implements TestTemplateInvocationContextProvider {

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        return Stream.of(
                invocation("FastCalculator", new FastCalculator()),
                invocation("SafeCalculator", new SafeCalculator())
        );
    }

    private TestTemplateInvocationContext invocation(String name, Calculator calc) {

        TestTemplateInvocationContext obj = new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return name;
            }

            @Override
            public List<Extension> getAdditionalExtensions() {

                return List.of(
                        new ParameterResolver() {
                            @Override
                            public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return parameterContext.getParameter().getType().equals(Calculator.class);
                            }

                            @Override
                            public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return calc;
                            }
                        }
                );

            }
        };

        return obj;
    }


}
