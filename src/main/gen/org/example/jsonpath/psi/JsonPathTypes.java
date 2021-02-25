// This is a generated file. Not intended for manual editing.
package org.example.jsonpath.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.example.jsonpath.psi.impl.*;

public interface JsonPathTypes {

  IElementType EVAL_SEGMENT = new JsonPathElementType("EVAL_SEGMENT");
  IElementType ID = new JsonPathElementType("ID");
  IElementType ID_SEGMENT = new JsonPathElementType("ID_SEGMENT");
  IElementType INDEXES_LIST = new JsonPathElementType("INDEXES_LIST");
  IElementType ROOT_SEGMENT = new JsonPathElementType("ROOT_SEGMENT");
  IElementType SEGMENT_EXPRESSION = new JsonPathElementType("SEGMENT_EXPRESSION");
  IElementType WILDCARD_SEGMENT = new JsonPathElementType("WILDCARD_SEGMENT");

  IElementType COMMA = new JsonPathTokenType(",");
  IElementType DOT = new JsonPathTokenType(".");
  IElementType EVAL_CONTEXT = new JsonPathTokenType("@");
  IElementType IDENTIFIER = new JsonPathTokenType("IDENTIFIER");
  IElementType LBRACKET = new JsonPathTokenType("[");
  IElementType NUMBER = new JsonPathTokenType("NUMBER");
  IElementType RBRACKET = new JsonPathTokenType("]");
  IElementType RECURSIVE_DESCENT = new JsonPathTokenType("..");
  IElementType ROOT_CONTEXT = new JsonPathTokenType("$");
  IElementType WILDCARD = new JsonPathTokenType("*");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == EVAL_SEGMENT) {
        return new JsonPathEvalSegmentImpl(node);
      }
      else if (type == ID) {
        return new JsonPathIdImpl(node);
      }
      else if (type == ID_SEGMENT) {
        return new JsonPathIdSegmentImpl(node);
      }
      else if (type == INDEXES_LIST) {
        return new JsonPathIndexesListImpl(node);
      }
      else if (type == ROOT_SEGMENT) {
        return new JsonPathRootSegmentImpl(node);
      }
      else if (type == SEGMENT_EXPRESSION) {
        return new JsonPathSegmentExpressionImpl(node);
      }
      else if (type == WILDCARD_SEGMENT) {
        return new JsonPathWildcardSegmentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
