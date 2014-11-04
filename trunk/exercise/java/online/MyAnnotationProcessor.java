import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes("ToBeTested")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class MyAnnotationProcessor extends AbstractProcessor
{
    private void note(String msg)
    {
        this.processingEnv.getMessager().printMessage(Kind.NOTE, msg);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
    {
        for (TypeElement te : annotations)
        {
            this.note("annotation: " + te.toString());
        }
        Set<? extends Element> elements = roundEnv.getRootElements();
        for (Element e : elements)
        {
            List<? extends Element> enclosedElems = e.getEnclosedElements();
            List<? extends ExecutableElement> ees = ElementFilter.methodsIn(enclosedElems);
            for (ExecutableElement ee : ees)
            {
                this.note("Executable Element Name: " + ee.getSimpleName());
                List<? extends AnnotationMirror> as = ee.getAnnotationMirrors();
                this.note(" as: " + as);
                for (AnnotationMirror am : as)
                {
                    Map<? extends ExecutableElement, ? extends AnnotationValue> map = am.getElementValues();
                    Set<? extends ExecutableElement> ks = map.keySet();
                    for (ExecutableElement k : ks)
                    {
                        AnnotationValue av = map.get(k);
                        this.note("----" + ee.getSimpleName() + "." + k.getSimpleName() + "=" + av.getValue());
                    }
                }
            }
        }
        return false;
    }
}