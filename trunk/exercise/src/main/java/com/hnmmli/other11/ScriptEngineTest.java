package com.hnmmli.other11;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class ScriptEngineTest
{

    public static void main(String[] args)
    {
        System.out.println("--------------------------------");
        direct();
        System.out.println("--------------------------------");
        call();
    }

    private static void direct()
    {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");
        interpreter.exec("print days[1];");
    }

    private static void call()
    {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("G:\\eclipse\\workspace\\pyDevTest\\test\\snippet.py");
        PyFunction func = interpreter.get("adder", PyFunction.class);

        int a = 2010, b = 2;
        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("anwser = " + pyobj.toString());

    }
}
