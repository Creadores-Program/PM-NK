package org.CreadoresProgram.PMNK;

import php.runtime.env.Environment;
import php.runtime.ext.core.classes.WrapClassLoader;
import php.runtime.reflection.ClassEntity;
import php.runtime.reflection.ModuleEntity;

import java.io.ByteArrayInputStream;
import java.util.Map;

import static php.runtime.annotation.Reflection.*;

@Name("PmmpClassLoader")
@Namespace("cn\\nukkit\\pmmp")
public class PmmpClassLoader extends WrapClassLoader {
  private Map<String, byte[]> clazzPhp;
  public PmmpClassLoader(Environment env, ClassEntity clazz) {
      super(env, clazz);
  }
  public PmmpClassLoader(Environment env, Map<String, byte[]> clazzPhp){
      super(env);
      this.clazzPhp = clazzPhp;
  }
  @Signature
  public void __construct() { }

  @Override
  @Signature
  public boolean loadClass(Environment env, String className) throws Throwable{
      String file = className.replace('\\', '/') + ".php";
      if (file.startsWith("\\") || file.startsWith("/")) {
          file = file.substring(1);
      }
      String fileSrc = "src/"+file;
      if (classSourceMap == null) {
          System.out.println("Map not registred");
          return false;
      }
      byte[] sourceCode = classSourceMap.get(className);
      if (sourceCode == null) {
          sourceCode = classSourceMap.get(file);
      }
      if (sourceCode == null) {
          sourceCode = classSourceMap.get(fileSrc);
      }
      if (sourceCode != null) {
          try {
              ModuleEntity module = compileFromBytes(env, className, sourceCode);
                
              if (module != null) {
                  module.include(env);
                  return true;
              }
          } catch (Exception e) {
              System.err.println("Error compiled: " + className);
              e.printStackTrace();
              return false;
          }
      }
      
      return false;
  }
  private ModuleEntity compileFromBytes(Environment env, String moduleName, byte[] sourceCode) throws Throwable {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(sourceCode);
            Context context = new Context(inputStream, moduleName, env.getDefaultCharset());
            
            AbstractCompiler compiler = env.scope.createCompiler(env, context);
            ModuleEntity module = compiler.compile(false);
            
            return module;
        } catch (Exception e) {
            System.err.println("Error in compile " + moduleName + ": " + e.getMessage());
            throw e;
        }
  }
}
