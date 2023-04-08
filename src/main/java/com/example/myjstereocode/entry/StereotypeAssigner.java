package com.example.myjstereocode.entry;

import com.example.myjstereocode.stereotypedresult.StereotypedElement;
import com.example.myjstereocode.stereotypedresult.StereotypedField;
import com.example.myjstereocode.stereotypedresult.StereotypedMethod;
import com.example.myjstereocode.stereotypedresult.StereotypedType;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;

public class StereotypeAssigner {
  double methodsMean;
  double methodsStdDev;

  public StereotypeAssigner() {}

  public void setParameters(double methodsMean, double methodsStdDev) {
    this.methodsMean = methodsMean;
    this.methodsStdDev = methodsStdDev;
  }

  public String assignStereotypes(PsiElement psiElement) {
    try {
      StereotypedElement stereoElement = null;
      if (psiElement instanceof PsiField) {
        stereoElement = new StereotypedField((PsiField) psiElement);
      }
      if (psiElement instanceof PsiClass) {
        stereoElement = new StereotypedType((PsiClass) psiElement, this.methodsMean, this.methodsStdDev);
      } else if (psiElement instanceof PsiMethod) {
        stereoElement = new StereotypedMethod((PsiMethod) psiElement);
      }
      if (stereoElement != null) {
        stereoElement.findStereotypes();
        return stereoElement.getStereotypesName();
      }
    } catch (NullPointerException var4) {
      System.out.println("出错啦！" + var4.getMessage());
    }
    return "NULL";
  }
}
