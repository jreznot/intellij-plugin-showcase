// This is a generated file. Not intended for manual editing.
package org.example.jsonpath.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class JsonPathVisitor extends PsiElementVisitor {

  public void visitEvalSegment(@NotNull JsonPathEvalSegment o) {
    visitPsiElement(o);
  }

  public void visitId(@NotNull JsonPathId o) {
    visitPsiElement(o);
  }

  public void visitIdSegment(@NotNull JsonPathIdSegment o) {
    visitPsiElement(o);
  }

  public void visitIndexesList(@NotNull JsonPathIndexesList o) {
    visitPsiElement(o);
  }

  public void visitRootSegment(@NotNull JsonPathRootSegment o) {
    visitPsiElement(o);
  }

  public void visitSegmentExpression(@NotNull JsonPathSegmentExpression o) {
    visitPsiElement(o);
  }

  public void visitWildcardSegment(@NotNull JsonPathWildcardSegment o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
