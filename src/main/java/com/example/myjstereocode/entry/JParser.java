//package com.example.myjstereocode.entry;
//
//import com.intellij.psi.PsiCompiledElement;
//import com.intellij.psi.PsiElement;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//public class JParser {
//  private PsiCompiledElement unit;
//  private List<PsiElement> elements;
//  private PsiElement member;
//
//  public JParser(PsiCompiledElement unit) {
//    ASTParser parser = ASTParser.newParser(AST.JLS16);
//    parser.setKind(8);
//    parser.setSource(unit);
//    parser.setResolveBindings(true);
//    this.unit = (CompilationUnit) parser.createAST((IProgressMonitor) null);
//    this.elements = new ArrayList();
//  }
//
//  public JParser(PsiCompiledElement member) {
//    this(member. .getCompilationUnit());
//    this.member = member;
//
//  }
//
//  public void parse() {
//    if (this.member != null) {
//      if (this.member instanceof IType) {
//        this.elements.add(this.unit.findDeclaringNode(((IType) this.member).getKey()));
//      } else if (this.member instanceof IMethod) {
//        ASTParser parser = ASTParser.newParser(AST.JLS16);
//        parser.setProject(((IMethod) this.member).getJavaProject());
//        parser.setResolveBindings(true);
//        IBinding binding = parser.createBindings(new IJavaElement[]{(IMethod) this.member}, (IProgressMonitor) null)[0];
//        if (binding instanceof IMethodBinding) {
//          ASTNode method = this.unit.findDeclaringNode(((IMethodBinding) binding).getKey());
//          this.elements.add(method);
//        }
//      } else {
//        ASTParser parser = ASTParser.newParser(AST.JLS16);
//        parser.setProject(((IField) this.member).getJavaProject());
//        parser.setResolveBindings(true);
//        IBinding binding = parser.createBindings(new IJavaElement[]{(IField) this.member}, (IProgressMonitor) null)[0];
//        ASTNode field = this.unit.findDeclaringNode(binding.getKey());
//        this.elements.add(field);
//      }
//    } else {
//      Iterator var5 = this.unit.types().iterator();
//      while (var5.hasNext()) {
//        Object o = var5.next();
//        if (o instanceof TypeDeclaration) {
//          this.elements.add((TypeDeclaration) o);
//        }
//      }
//    }
//  }
//
//  public List<PsiElement> getElements() {
//    return this.elements;
//  }
//
//  public CompilationUnit getCompilationUnit() {
//    return this.unit;
//  }
//
//
//}
