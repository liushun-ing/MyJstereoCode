package com.example.action;

import com.example.myjstereocode.entry.StereotypeAssigner;
import com.example.myjstereocode.info.ProjectInformation;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class AssignStereotypeAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {
    // TODO: insert action logic here
    PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
    Project project = e.getData(CommonDataKeys.PROJECT);
    Caret caret = e.getData(CommonDataKeys.CARET);
    if (psiFile == null || caret == null || project == null || DumbService.getInstance(project).isDumb()) {
      return;
    }
    ProjectInformation projectInformation = new ProjectInformation(project);
    StereotypeAssigner stereotypeAssigner = new StereotypeAssigner();
    stereotypeAssigner.setParameters(projectInformation.getMethodsMean(), projectInformation.getMethodsStdDev());
    PsiElement element = psiFile.findElementAt(caret.getOffset());
    String s = "";
    if (element != null) {
      PsiField parentField = PsiTreeUtil.getParentOfType(element, PsiField.class);
      if (parentField != null) {
        s = stereotypeAssigner.assignStereotypes(parentField);
        System.out.println(parentField + " result: " + s);
        return;
      }
      PsiMethod parentMethod = PsiTreeUtil.getParentOfType(element, PsiMethod.class);
      if (parentMethod != null) {
//        parentMethod.accept(new JavaRecursiveElementVisitor() {
//
//          @Override
//          public void visitElement(@NotNull PsiElement element) {
//            super.visitElement(element);
//            System.out.println("-?: " + element);
//          }
//        });
        s = stereotypeAssigner.assignStereotypes(parentMethod);
        System.out.println(element + " result: " + s);
        return;
      }
      PsiClass parentClass = PsiTreeUtil.getParentOfType(element, PsiClass.class);
      if (parentClass != null) {
//        System.out.println("fields: " + Arrays.toString(parentClass.getFields()));
//        System.out.println("methods: " + Arrays.toString(parentClass.getMethods()));
        s = stereotypeAssigner.assignStereotypes(parentClass);
        System.out.println(element + " result: " + s);
        return;
      }
    }
  }
}
