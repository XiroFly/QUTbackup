import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class MutationTool {

    public static void main(String[] args) {
        // 指定要修改的类名
        String className = "OriginalClass";

        try {
            // 获取类池
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get(className);

            // 对类中的方法进行突变
            CtMethod[] methods = ctClass.getDeclaredMethods();
            for (CtMethod method : methods) {
                mutateBooleanExpressions(method);
                mutateArithmeticExpressions(method);
                deleteInstructionsInVoidMethods(method);
            }

            // 保存修改后的类
            ctClass.writeFile();
            System.out.println("Mutation completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 运行突变后的测试
        MutationTest.main(null);
    }

    // 突变布尔表达式
    private static void mutateBooleanExpressions(CtMethod method) throws CannotCompileException {
        method.instrument(new ExprEditor() {
            public void edit(MethodCall m) throws CannotCompileException {
                // 将条件指令的布尔表达式替换为 "true"
                m.replace("{ $_ = true; }");
            }
        });
    }

    // 突变算术表达式
    private static void mutateArithmeticExpressions(CtMethod method) throws CannotCompileException {
        method.instrument(new ExprEditor() {
            public void edit(MethodCall m) throws CannotCompileException {
                // 将算术表达式中的 + 改为 -
                if (m.getMethodName().equals("add")) {
                    m.replace("{ $_ = $1 - $2; }");
                }
            }
        });
    }

    // 删除void方法体中所有指令
    private static void deleteInstructionsInVoidMethods(CtMethod method) throws CannotCompileException, NotFoundException {
        if (CtClass.voidType.equals(method.getReturnType())) {
            method.setBody("{}");
        }
    }
}
