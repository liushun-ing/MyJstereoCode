package com.example.myjstereocode.stereotypedresult;

import java.util.List;

import com.example.myjstereocode.stereotype.CodeStereotype;
import com.intellij.psi.PsiElement;

/**
 * 分配好的原型的元素的基类
 */
public interface StereotypedElement {
  PsiElement getElement();

  List<CodeStereotype> getStereotypes();

  List<StereotypedElement> getStereoSubElements();

  List<StereotypedElement> getStereoSubFields();

  String getStereotypesName();

  void findStereotypes();

  String getName();

}