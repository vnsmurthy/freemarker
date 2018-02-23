package com.vm.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class Main {

    public static void main(String[] args) throws Exception {


        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Main.class, "templates");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

 
        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "Consumable Data module");
        
        Student s1 = new Student(1, "Oscar", "Wilde");
        Score o1 = new Score("physics", 70);
        Score o2 = new Score("maths", 70);
        Score o3 = new Score("english", 100);
        
        List<Score> scores1 = new ArrayList<>(Arrays.asList(o1, o2, o3));
        s1.setExamScores(scores1);
        
        Student s2 = new Student(2, "Albert", "Einstein");
        Score o4 = new Score("physics", 100);
        Grader g1 = new Grader("Richard", "Feynman");
        Grader g2 = new Grader("Edith", "Piaf");
        o4.setGraders(Arrays.asList(g1, g2));
        
        Score o5 = new Score("maths", 100);
        Score o6 = new Score("english", 50);
        
        List<Score> scores2 = new ArrayList<>(Arrays.asList(o4, o5, o6));
        s2.setExamScores(scores2);
        
        Student s3 = new Student(3, "Neils", "Bohr");
        Score o7 = new Score("physics", 100);
        Score o8 = new Score("chemistry", 100);
        List<Score> scores3 = new ArrayList<>(Arrays.asList(o7, o8));
        s3.setExamScores(scores3);
 
        
        List<Student> students = new ArrayList<>(Arrays.asList(s1, s2, s3));
        
        input.put("students", students);
        

        // 2.2. Get the template

        Template template = cfg.getTemplate("consumable.ftl");

        // 2.3. Generate the output

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("c:\\temp\\output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }
}