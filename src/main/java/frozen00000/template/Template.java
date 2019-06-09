package frozen00000.template;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class Template {

    private static final String METHOD_NAME_PLACEHOLDER = "@MethodName";
    private static final String CLASS_NAME_PLACEHOLDER = "@ClassName";

    public static void main(String[] args) throws IOException {
        String className = args[0];
        String methodName = String.valueOf(className.charAt(0)).toLowerCase() + className.substring(1);
        writeFile(Paths.get("./src/main/java/frozen00000/" + className + ".java"),
                Paths.get("src/main/resources/template/class.java.template"),
                className, methodName);
        writeFile(Paths.get("./src/test/java/frozen00000/" + className + "Test.java"),
                Paths.get("src/main/resources/template/testClass.java.template"),
                className, methodName);
        new File("src/test/resources/" + className + "Test.input").createNewFile();
        new File("src/test/resources/" + className + "Test.output").createNewFile();
    }

    private static void writeFile(Path targetPath, Path template, String className, String methodName) throws IOException {
        List<String> srcFile = Files.readAllLines(template)
                .stream().map(l -> l.replaceAll(METHOD_NAME_PLACEHOLDER, methodName)
                        .replaceAll(CLASS_NAME_PLACEHOLDER, className))
                .collect(Collectors.toList());

        Files.write(targetPath, srcFile, StandardOpenOption.CREATE_NEW);
    }

}
