package com.example.myjstereocode.info;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiShortNamesCache;

import java.util.Iterator;
import java.util.Vector;

public class ProjectInformation {
  private int totalTypes = 0;
  private int totalMethods = 0;
  private Vector<Integer> methodsCounter = new Vector<Integer>();
  private double methodsMean;
  private double methodsStdDev;
  private Project project;

  public ProjectInformation(Project project) {
    this.project = project;
  }

  public void compute() {
    try {
      String[] allClassNames = PsiShortNamesCache.getInstance(project).getAllClassNames();
      for (String name: allClassNames) {
        PsiClass[] classesByName = PsiShortNamesCache.getInstance(project).getClassesByName(name, GlobalSearchScope.projectScope(project));
        for (PsiClass psiClass : classesByName) {
          if (!psiClass.isEnum() && !psiClass.isRecord() && !psiClass.isAnnotationType()) {
            ++this.totalTypes;
            this.methodsCounter.add(psiClass.getMethods().length);
            this.totalMethods += psiClass.getMethods().length;
          }
        }
      }

      if (this.methodsCounter.size() != 0) {
        this.methodsMean = this.totalMethods + 0.0 / this.methodsCounter.size();
        double sumOfSquareDifference = 0.0D;

        for (Iterator<Integer> var17 = this.methodsCounter.iterator(); var17.hasNext(); this.methodsStdDev = Math.sqrt(sumOfSquareDifference / (double) this.methodsCounter.size())) {
          Integer i = var17.next();
          sumOfSquareDifference += Math.pow((double) i - this.methodsMean, 2.0D);
        }
      } else {
        this.methodsMean = 0.0D;
        this.methodsStdDev = 0.0D;
      }
    } catch (Exception var14) {
      System.err.println("Oops! An error occurred when computing project information");
    }

  }

  public int getTotalTypes() {
    return this.totalTypes;
  }

  public Vector<Integer> getMethodsCounter() {
    return this.methodsCounter;
  }

  public double getMethodsMean() {
    return this.methodsMean;
  }

  public double getMethodsStdDev() {
    return this.methodsStdDev;
  }

  public String getName() {
    return this.project.getName();
  }
}

