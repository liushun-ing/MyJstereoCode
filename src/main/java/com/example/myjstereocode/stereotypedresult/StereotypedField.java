package com.example.myjstereocode.stereotypedresult;

import java.util.ArrayList;
import java.util.List;

import com.example.myjstereocode.stereotype.CodeStereotype;
import com.example.myjstereocode.stereotype.FieldStereoType;
import com.intellij.psi.PsiField;

/**
 * 分配好原型的FIELD
 */
public class StereotypedField implements StereotypedElement {
  private PsiField field;
  private FieldStereoType primaryStereotype;

  public StereotypedField(PsiField field) {
    this.field = field;
  }

  @Override
  public PsiField getElement() {
    return this.field;
  }

  @Override
  public List<CodeStereotype> getStereotypes() {
    ArrayList<CodeStereotype> stereotypes = new ArrayList<>();
    stereotypes.add(primaryStereotype);
    return stereotypes;
  }

  public String getStereotypesName() {
    return primaryStereotype.toString();
  }

  @Override
  public List<StereotypedElement> getStereoSubElements() {
    return new ArrayList<>();
  }

  @Override
  public void findStereotypes() {
    this.primaryStereotype = FieldStereoType.FIELD;
  }

  @Override
  public String getName() {
    return field.getName();
  }

  @Override
  public List<StereotypedElement> getStereoSubFields() {
    return null;
  }

}
