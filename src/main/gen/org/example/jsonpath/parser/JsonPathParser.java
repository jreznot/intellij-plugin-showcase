// This is a generated file. Not intended for manual editing.
package org.example.jsonpath.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.example.jsonpath.psi.JsonPathTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class JsonPathParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // DOT segmentExpression+
  static boolean dotExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dotExpr")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && dotExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // segmentExpression+
  private static boolean dotExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dotExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = segmentExpression(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!segmentExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dotExpr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (RECURSIVE_DESCENT | DOT) (idSegment | wildcardSegment)
  static boolean dotSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dotSegment")) return false;
    if (!nextTokenIs(b, "", DOT, RECURSIVE_DESCENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dotSegment_0(b, l + 1);
    r = r && dotSegment_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RECURSIVE_DESCENT | DOT
  private static boolean dotSegment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dotSegment_0")) return false;
    boolean r;
    r = consumeToken(b, RECURSIVE_DESCENT);
    if (!r) r = consumeToken(b, DOT);
    return r;
  }

  // idSegment | wildcardSegment
  private static boolean dotSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dotSegment_1")) return false;
    boolean r;
    r = idSegment(b, l + 1);
    if (!r) r = wildcardSegment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // EVAL_CONTEXT segmentExpression*
  public static boolean evalSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "evalSegment")) return false;
    if (!nextTokenIs(b, EVAL_CONTEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EVAL_CONTEXT);
    r = r && evalSegment_1(b, l + 1);
    exit_section_(b, m, EVAL_SEGMENT, r);
    return r;
  }

  // segmentExpression*
  private static boolean evalSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "evalSegment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segmentExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "evalSegment_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // rootSegment | evalSegment | idSegment | wildcardSegment
  static boolean head_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "head_")) return false;
    boolean r;
    r = rootSegment(b, l + 1);
    if (!r) r = evalSegment(b, l + 1);
    if (!r) r = idSegment(b, l + 1);
    if (!r) r = wildcardSegment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, "<identifier>", IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID, "<identifier>");
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id segmentExpression*
  public static boolean idSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idSegment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id(b, l + 1);
    r = r && idSegment_1(b, l + 1);
    exit_section_(b, m, ID_SEGMENT, r);
    return r;
  }

  // segmentExpression*
  private static boolean idSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idSegment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segmentExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "idSegment_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NUMBER (COMMA NUMBER)*
  public static boolean indexesList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexesList")) return false;
    if (!nextTokenIs(b, "<indexes list>", NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDEXES_LIST, "<indexes list>");
    r = consumeToken(b, NUMBER);
    r = r && indexesList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA NUMBER)*
  private static boolean indexesList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexesList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!indexesList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "indexesList_1", c)) break;
    }
    return true;
  }

  // COMMA NUMBER
  private static boolean indexesList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexesList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // wildcardSegment |
  //   indexesList
  static boolean nestedExpression_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nestedExpression_")) return false;
    if (!nextTokenIs(b, "", NUMBER, WILDCARD)) return false;
    boolean r;
    r = wildcardSegment(b, l + 1);
    if (!r) r = indexesList(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // head_ segments_*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = head_(b, l + 1);
    r = r && root_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // segments_*
  private static boolean root_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segments_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ROOT_CONTEXT segmentExpression*
  public static boolean rootSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rootSegment")) return false;
    if (!nextTokenIs(b, ROOT_CONTEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROOT_CONTEXT);
    r = r && rootSegment_1(b, l + 1);
    exit_section_(b, m, ROOT_SEGMENT, r);
    return r;
  }

  // segmentExpression*
  private static boolean rootSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rootSegment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segmentExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rootSegment_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // RECURSIVE_DESCENT segmentExpression+
  static boolean scanExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scanExpr")) return false;
    if (!nextTokenIs(b, RECURSIVE_DESCENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RECURSIVE_DESCENT);
    r = r && scanExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // segmentExpression+
  private static boolean scanExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scanExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = segmentExpression(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!segmentExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scanExpr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET nestedExpression_ RBRACKET
  public static boolean segmentExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segmentExpression")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && nestedExpression_(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, SEGMENT_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // dotExpr | scanExpr | dotSegment
  static boolean segments_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segments_")) return false;
    if (!nextTokenIs(b, "", DOT, RECURSIVE_DESCENT)) return false;
    boolean r;
    r = dotExpr(b, l + 1);
    if (!r) r = scanExpr(b, l + 1);
    if (!r) r = dotSegment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // WILDCARD segmentExpression*
  public static boolean wildcardSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wildcardSegment")) return false;
    if (!nextTokenIs(b, "<*>", WILDCARD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WILDCARD_SEGMENT, "<*>");
    r = consumeToken(b, WILDCARD);
    p = r; // pin = 1
    r = r && wildcardSegment_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // segmentExpression*
  private static boolean wildcardSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wildcardSegment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segmentExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wildcardSegment_1", c)) break;
    }
    return true;
  }

}
