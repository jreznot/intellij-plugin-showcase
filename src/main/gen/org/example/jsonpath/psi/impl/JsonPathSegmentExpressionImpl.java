// This is a generated file. Not intended for manual editing.
package org.example.jsonpath.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.example.jsonpath.psi.JsonPathTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.example.jsonpath.psi.*;

public class JsonPathSegmentExpressionImpl extends ASTWrapperPsiElement implements JsonPathSegmentExpression {

  public JsonPathSegmentExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsonPathVisitor visitor) {
    visitor.visitSegmentExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsonPathVisitor) accept((JsonPathVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JsonPathIndexesList getIndexesList() {
    return findChildByClass(JsonPathIndexesList.class);
  }

  @Override
  @Nullable
  public JsonPathWildcardSegment getWildcardSegment() {
    return findChildByClass(JsonPathWildcardSegment.class);
  }

}
