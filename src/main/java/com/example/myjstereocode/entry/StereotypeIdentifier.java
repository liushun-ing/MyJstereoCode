//package com.example.myjstereocode.entry;
//
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//
//import com.example.myjstereocode.stereotypedresult.StereotypedElement;
//import com.example.myjstereocode.stereotypedresult.StereotypedMethod;
//import com.example.myjstereocode.stereotypedresult.StereotypedType;
//import com.intellij.psi.PsiClass;
//import com.intellij.psi.PsiCompiledElement;
//import com.intellij.psi.PsiElement;
//import com.intellij.psi.PsiMethod;
//
//public class StereotypeIdentifier {
//  private static final String TypeDeclaration = null;
//  private JParser parser;
//  private List<StereotypedElement> stereotypedElements;
//  double methodsMean;
//  double methodsStdDev;
//
//  public StereotypeIdentifier() {
//    this.stereotypedElements = new LinkedList<StereotypedElement>();
//  }
//
//  public void setParameters(PsiCompiledElement unit, double methodsMean, double methodsStdDev) {
//    this.parser = new JParser(unit);
//    this.methodsMean = methodsMean;
//    this.methodsStdDev = methodsStdDev;
//  }
//
//  public void setParameters(PsiElement member, double methodsMean, double methodsStdDev) {
//    this.parser = new JParser(member);
//    this.methodsMean = methodsMean;
//    this.methodsStdDev = methodsStdDev;
//  }
//
//  public void identifyStereotypes() {
//    if (this.parser != null) {
//      this.parser.parse();
//      Iterator<?> var2 = this.parser.getElements().iterator();
//      while (var2.hasNext()) {
//        PsiElement element = (PsiElement) var2.next();
//        try {
//          Object stereoElement;
//          if (element instanceof PsiClass) {
//            stereoElement = new StereotypedType((PsiClass) element, this.methodsMean, this.methodsStdDev);
//          } else {
//            if (!(element instanceof PsiMethod)) {
//              continue;
//            }
//            stereoElement = new StereotypedMethod((PsiMethod) element);
//          }
//          ((StereotypedElement) stereoElement).findStereotypes();
//          this.stereotypedElements.add((StereotypedElement) stereoElement);
//        } catch (NullPointerException var4) {
//        }
//      }
//    }
//  }
//
//  public List<StereotypedElement> getStereotypedElements() {
//    return this.stereotypedElements;
//  }
//
//  public JParser getParser() {
//    return this.parser;
//  }
////
////    public String findMethodStereotype(String qualifiedMethodName) {
////        return this.findMethodStereotype(qualifiedMethodName, this.stereotypedElements);
////    }
////
////    private String findMethodStereotype(String qualifiedMethodName, List<StereotypedElement> elements) {
////        Iterator var4 = elements.iterator();
////
////        while(var4.hasNext()) {
////            StereotypedElement elem = (StereotypedElement)var4.next();
////            if (elem instanceof StereotypedType) {
////                return this.findMethodStereotype(qualifiedMethodName, elem.getStereoSubElements());
////            }
////
////            if (elem instanceof StereotypedMethod) {
////                String qName = ((StereotypedMethod)elem).getQualifiedName();
////                if (qName.equals(qualifiedMethodName)) {
////                    StringBuilder stereoString = new StringBuilder();
////                    Iterator var8 = elem.getStereotypes().iterator();
////
////                    while(var8.hasNext()) {
////                        CodeStereotype stereo = (CodeStereotype)var8.next();
////                        stereoString.append(stereo + " ");
////                    }
////
////                    return stereoString.toString().trim();
////                }
////            }
////        }
////
////        return null;
////    }
//}
